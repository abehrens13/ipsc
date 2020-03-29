package de.openaqua.ipsc.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import de.openaqua.ipsc.entities.IDocument;

@RestController
/**
 * 
 * @param <T>
 * 
 * 
 *            Rules: PUT: Create new or Save an Update
 * 
 *            PATCH: Save an Update, but the Patch contains the differences
 *            only!
 * 
 *            DELETE: Delete
 * 
 *            GET: Get something...
 * 
 *            https://www.javaguides.net/2018/11/spring-getmapping-postmapping-putmapping-deletemapping-patchmapping.html
 * 
 */
public abstract class AbstractIpscController<T extends IDocument> {
	private Logger log = LoggerFactory.getLogger(AbstractIpscController.class);

	protected T voidtestObjectId(final String id, final T c) {
		if (id == null || c == null || c.getId() == null) {
			throw new ResourceNotFoundException("illegal parameters for " + id);
		}
		if (!c.getId().equals(id)) {
			throw new ResourceNotFoundException("id doesnt match object id " + id);
		}

		Optional<T> test = getRepository().findById(id);
		if (!test.isPresent()) {
			throw new ResourceNotFoundException("Not found " + id);
		}
		if (!test.get().getId().equals(id)) {
			throw new ResourceNotFoundException("Lookup id doesnt match resource id " + id);
		}
		return test.get();
	}

	/**
	 * Overwrites an existing object
	 * 
	 * @param c
	 * @return
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<T> put(@PathVariable(value = "id") String id, @Valid @RequestBody T c) {
		log.info("PUT existing Object with id {} ", id);
		voidtestObjectId(id, c);
		return ResponseEntity.ok(getRepository().save(c));
	}

	/**
	 * Creates a new object
	 * 
	 * @param c
	 * @return
	 */
	@PutMapping()
	@Transactional
	public ResponseEntity<T> put(final @Valid @RequestBody T c) {
		log.info("PUT new Object");
		if (c.getId() == null || c.getId().isEmpty()) {
			log.info("PUT new Object");
			T out = getRepository().save(c);
			log.debug("new object created {}", out.getId());
			return ResponseEntity.ok(out);

		}
		throw new ResourceNotFoundException("ObjectId already exists " + c.getId());
	}

	/**
	 * Modifies an existing object
	 * 
	 */
	@PatchMapping("/{id}")
	@Transactional
	public abstract ResponseEntity<T> patch(@PathVariable(value = "id") final String id, final @Valid @RequestBody T c);

	/**
	 * delete an existing object
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	@Transactional
	public Map<String, Boolean> delete(@PathVariable(value = "id") final String id) {
		log.info("DELETE {}", id);

		Optional<T> test = getRepository().findById(id);
		if (!test.isPresent()) {
			throw new ResourceNotFoundException("Not found " + id);
		}
		if (!test.get().getId().equals(id)) {
			throw new ResourceNotFoundException("Lookup id doesnt match resource id " + id);
		}
		getRepository().deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping()
	public List<T> index() {
		log.info("GET /");
		return getRepository().findAll();

	}

	@GetMapping("/{id}")
	public ResponseEntity<T> byId(@PathVariable final String id) {
		log.info("GET /{}", id);
		Optional<T> out = getRepository().findById(id);
		if (!out.isPresent()) {
			throw new ResourceNotFoundException("no resource found for id " + id);
		}
		return ResponseEntity.ok(out.get());
	}

	@GetMapping("/new")
	public T newObject() {
		log.info("GET /new");
		return getNew();
	}

	@SuppressWarnings("unused")
	private AbstractIpscController() {
		super();
	}

	private MongoRepository<T, String> repository;

	public AbstractIpscController(MongoRepository<T, String> repository) {
		super();
		this.repository = repository;
	}

	public MongoRepository<T, String> getRepository() {
		return this.repository;
	}

	protected abstract T getNew();

}