package com.vz.order;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication
@ComponentScan("com.vz.order")
@EnableJpaRepositories("com.vz.order.model")
@EntityScan("com.vz.order.model")
public class OrderApplication {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(OrderApplication.class);
	public OrderApplication(){}
	/*public OrderApplication() {
		startup();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	public void startup() {
		LOGGER.info("Starting OrderApplication ...");
	}
}
