package glebdyakovcompany.app.shop.services.repositories;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import glebdyakovcompany.app.shop.dao.ProductDAO;
import glebdyakovcompany.app.shop.models.UserModel;
// import java.util.stream.Stream;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    // @Query("select user from UserModel where user.email = :email")
    // Stream findProductsOfUser(@Param("email") String email);
}
