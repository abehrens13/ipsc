package de.openaqua.ipsc.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.openaqua.ipsc.entities.Weapon;
import de.openaqua.ipsc.reps.WeaponsRepository;

@RestController
@RequestMapping(path = "/api/weapons")
public class WeaponsController extends IIpscController<Weapon> {
	Logger LOG = LoggerFactory.getLogger(WeaponsController.class);

	public WeaponsController(WeaponsRepository repository) {
		super(repository);

	}

	@Override
	protected Weapon getNew() {
		return new Weapon();
	}

}