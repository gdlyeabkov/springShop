package glebdyakovcompany.app.shop.dao;

import org.springframework.stereotype.Repository;

import glebdyakovcompany.app.shop.models.ProductModel;

@Repository
public class ProductDAO {
    
    public Iterable<ProductModel> products;

    public Iterable<ProductModel> getAllProducts() {
        return this.products;
    }

}
