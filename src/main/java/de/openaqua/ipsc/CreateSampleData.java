package de.openaqua.ipsc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.openaqua.ipsc.config.SampleCreator;

@SpringBootApplication
public class CreateSampleData implements CommandLineRunner {

	@Autowired
	SampleCreator sampleCreator;

  public static void main2(String[] args) {
		SpringApplication.run(CreateSampleData.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
	  sampleCreator.createSampleData();
	  
  }
}