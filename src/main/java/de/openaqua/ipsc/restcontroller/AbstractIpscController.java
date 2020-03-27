package de.openaqua.ipsc.restcontroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractIpscController<T> {
	Logger log = LoggerFactory.getLogger(AbstractIpscController.class);

	@GetMapping("/")
	public List<T> index() {
		log.info("GET /");
		return getRepository().findAll();

	}

	@GetMapping("/byId/{id}")
	public Optional<T> byId(@PathVariable final String id) {
		log.info("GET /byId/{}", id);
		return getRepository().findById(id);

	}

	@Transactional
	@DeleteMapping("/delete/{id}")
	public void delObject(@PathVariable final String id) {
		log.info("DELETE /delete/{id}");
		getRepository().deleteById(id);
	}

	@GetMapping("/new")
	public T newObject() {
		log.info("GET /new");
		return getNew();
	}

	@Transactional
	@PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
	public T createNewObject(@RequestBody T c) {
		log.info("POST /new");
		return getRepository().save(c);
	}

	@Transactional
	@PatchMapping("/save")
	public T patchObject(@RequestBody T c) {
		log.info("PATCH /save");
		return getRepository().save(c);
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