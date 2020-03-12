package de.openaqua.ipsc.restcontroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public abstract class IIpscController<T> {
	Logger LOG = LoggerFactory.getLogger(IIpscController.class);

	@GetMapping("/")
	public List<T> index() {
		LOG.info("GET /");
		return getRepository().findAll();

	}

	@GetMapping("/byId/{id}")
	public Optional<T> byId(@PathVariable final String id) {
		LOG.info("GET /byId/{id}");
		return getRepository().findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delObject(@PathVariable final String id) {
		LOG.info("DELETE /delete/{id}");
		getRepository().deleteById(id);
	}

	@GetMapping("/new")
	public T newObject() {
		LOG.info("GET /new");
		return getNew();
	}

	@PatchMapping("/save")
	public T patchObject(@RequestBody T c) {
		LOG.info("PATCH /save");
		return getRepository().save(c);
	}

	@SuppressWarnings("unused")
	private IIpscController() {
		super();
	}

	private MongoRepository<T, String> repository;
	public IIpscController(MongoRepository<T, String> repository) {
		super();
		this.repository = repository;
	}

	public MongoRepository<T, String> getRepository() {
		return this.repository;
	}

	abstract protected T getNew();

}