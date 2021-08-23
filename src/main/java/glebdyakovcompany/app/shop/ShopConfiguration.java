package glebdyakovcompany.app.shop;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import glebdyakovcompany.app.shop.services.repositories.ProductRepository;
import glebdyakovcompany.app.shop.models.ProductModel;
import glebdyakovcompany.app.shop.services.ProductService;

@Configuration
@ComponentScan("glebdyakovcompany.app.shop")
@EntityScan(basePackageClasses = ProductModel.class)
public class ShopConfiguration {
}
