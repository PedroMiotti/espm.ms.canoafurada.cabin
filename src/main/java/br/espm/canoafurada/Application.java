package br.espm.canoafurada;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	@Value("${server.port}")
	static String PORT;

	private static final Logger logger =
			LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		logger.debug("Application running on port: " + PORT);
		SpringApplication.run(Application.class, args);
	}

}
