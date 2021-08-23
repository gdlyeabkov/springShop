package glebdyakovcompany.app.shop.models;
import javax.persistence.*;

@Table(name="order_model")
@Entity
public class OrderModel {
    
    @Id
    @Column
    public Long id;
    
    @Column
    public String ownerName;
    
    @Column
    public int price;
    
    // public OrderModel(Long id, String ownerName, int price){
    //     this.id = id;
    //     this.ownerName = ownerName;
    //     this.price = price;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getPrice() {
        return price;
    }

    public void setSpecialty(int price) {
        this.price = price;
    }
}
