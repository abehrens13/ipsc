package de.openaqua.ipsc.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/healthcheck")
public class HealthCheckController {
	private Logger log = LoggerFactory.getLogger(HealthCheckController.class);

	@GetMapping
	public String getTestResult() {
		log.info("GET /api/healthcheck");
		return "ok";
	}

}