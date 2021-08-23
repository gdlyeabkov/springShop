package glebdyakovcompany.app.shop.services.repositories;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import glebdyakovcompany.app.shop.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long> {

}