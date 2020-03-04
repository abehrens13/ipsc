package de.openaqua.ipsc;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import de.openaqua.ipsc.beans.SerialGenerator;
import de.openaqua.ipsc.landscape.Landscape;

@Component
public class JavaConfig {

	@Bean
	public SerialGenerator serialGenerator() {
		return new SerialGenerator("TEST", 40000);
	}

	@Bean
	public Landscape landscape() {
		Landscape ls = new Landscape();
		ls.initGermany();
		return ls;
	}

}
