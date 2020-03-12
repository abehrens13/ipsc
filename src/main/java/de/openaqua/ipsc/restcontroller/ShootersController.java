package de.openaqua.ipsc.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Shooter;
import de.openaqua.ipsc.reps.ShootersRepository;

@RestController
@RequestMapping(path = "/api/shooters")
public class ShootersController extends IIpscController<Shooter> {

	public ShootersController(ShootersRepository repository) {
		super(repository);

	}

	@Override
	protected Shooter getNew() {
		return new Shooter();
	}

}