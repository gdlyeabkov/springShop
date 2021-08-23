package glebdyakovcompany.app.shop.services;

import glebdyakovcompany.app.shop.models.ProductModel;
import java.util.List;

import org.springframework.stereotype.Component;

public interface IProductService {
    List<ProductModel> findAll();
}
