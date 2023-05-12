package glebdyakovcompany.app.shop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<glebdyakovcompany.app.shop.models.OrderModel, Long> {
}
