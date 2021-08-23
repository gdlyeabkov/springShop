package glebdyakovcompany.app.shop.services;

import glebdyakovcompany.app.shop.models.ProductModel;
import glebdyakovcompany.app.shop.services.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
@Transactional
public class ProductService implements IProductService {
    
    @Autowired(required = false)
    public ProductRepository productService;

    @Override
    public List<ProductModel> findAll() {

        return (List<ProductModel>) productService.findAll();
    }

}
