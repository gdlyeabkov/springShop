package glebdyakovcompany.app.shop.services.repositories;

wimport org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import glebdyakovcompany.app.shop.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
}
