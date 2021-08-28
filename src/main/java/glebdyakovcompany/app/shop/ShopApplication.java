package glebdyakovcompany.app.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import org.json.JSONObject;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Optional;

import glebdyakovcompany.app.shop.connections.Postgres;

@SpringBootApplication
@RestController
@Component
public class ShopApplication {

	public static void main(String[] args){
		SpringApplication.run(ShopApplication.class, args);
	}

}
