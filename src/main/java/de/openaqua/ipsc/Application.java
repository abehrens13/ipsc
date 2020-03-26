package de.openaqua.ipsc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static final Log LOG = LogFactory.getLog(Application.class);

	public static void main(String... args) {
		LOG.debug("Application::main()");
		SpringApplication.run(Application.class, args);
	}
}
