package de.openaqua.ipsc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configureContentNegotiation(
		ContentNegotiationConfigurer configurer
	) {
		configurer
			.mediaType("csv", MediaType
				.parseMediaTypes("text/csv").get(0))
			.favorParameter(false)
			.favorPathExtension(true)
			.useRegisteredExtensionsOnly(true);
	}

	@Override
	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/api/**").allowedOrigins("*");
	}

}
