package pet.apipet.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"pet.apipet"})

public class ApipetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApipetApiApplication.class, args);
	}

}
