package de.openaqua.ipsc.landscape;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/landscape")
public class LandscapeController {
	private static final Log LOG = LogFactory.getLog(LandscapeController.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	Landscape landscape;

	@Autowired
	CityFactory cityFactory;

	public LandscapeController() {
		LOG.debug("Init Landscape Controller");
	}

	@GetMapping("/")
	public Iterator<Edge> index() {
		LOG.info("GET api/landscape/");
		return landscape.getAll();
	}

	@GetMapping("/cities")
	public Iterator<City> getCities() {
		LOG.info("GET api/landscape/cities");
		return cityFactory.getCities();
	}

}
