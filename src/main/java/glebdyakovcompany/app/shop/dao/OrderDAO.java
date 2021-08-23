package glebdyakovcompany.app.shop.dao;

import org.springframework.stereotype.Repository;

import glebdyakovcompany.app.shop.models.OrderModel;

@Repository
public class OrderDAO {
    
    public Iterable<OrderModel> orders;

    public Iterable<OrderModel> getAllOrders() {
        return this.orders;
    }

}
