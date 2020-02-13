package de.openaqua.ipsc;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import de.openaqua.ipsc.beans.SerialGenerator;

@Component
public class JavaConfig {
	@Bean
	public SerialGenerator serialGenerator() {
		return new SerialGenerator("TEST", 40000);
	}

}
