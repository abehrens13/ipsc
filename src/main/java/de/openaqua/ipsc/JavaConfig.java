package de.openaqua.ipsc;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import de.openaqua.ipsc.beans.SerialGenerator;

@Component
public class JavaConfig {

	/**
	 * Return (and create) a MongoDB Transaction Manager.
	 * 
	 * @param dbFactory
	 * @return
	 */
	//TODO: Transactional Manager for MongoDB seems to be broken...
	//@Bean
	//MongoTransactionManager txManager(MongoDbFactory dbFactory) {
	//	return new MongoTransactionManager(dbFactory);
	//}

	@Bean
	public SerialGenerator serialGenerator() {
		return new SerialGenerator("TEST", 40000);
	}

}
