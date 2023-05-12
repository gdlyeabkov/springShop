package glebdyakovcompany.app.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import glebdyakovcompany.app.shop.connections.Postgres;

@SpringBootApplication
@RestController
@Component
public class ShopApplication {

	public static void main(String[] args){
		SpringApplication.run(ShopApplication.class, args);
	}

}
