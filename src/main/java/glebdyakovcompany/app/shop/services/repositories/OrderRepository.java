package glebdyakovcompany.app.shop.services.repositories;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<glebdyakovcompany.app.shop.models.OrderModel, Long> {
    
    // @Query(value = "insert into OrderModel (ownerName, price) VALUES (:ownerName, :price)", nativeQuery = true)
    // void createOrder(@Param("ownerName") String ownerName, @Param("price") int price);
}
