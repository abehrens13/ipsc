package de.openaqua.ipsc.landscape;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/landscape")
public class LandscapeController {
	private static final Log LOG = LogFactory.getLog(LandscapeController.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	Landscape landscape;

	public LandscapeController() {
		LOG.debug("Init Landscape Controller");
	}

	@RequestMapping(method = RequestMethod.GET)
	@GetMapping("/")
	public Iterable<Edge> index() {
		LOG.info("GET api/landscape/");
		return landscape.getAll();
	}

	@GetMapping("/findRoute/{from}/{to}")
	public Iterator<Edge> delCompetition(@PathVariable final String from, @PathVariable final String to) {
		LOG.debug("GET api/landscape/findRoute/{from}/{to}");
		return landscape.getRoute(from, to);
	}

}
