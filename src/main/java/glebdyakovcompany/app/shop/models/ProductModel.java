package glebdyakovcompany.app.shop.models;

import javax.persistence.*;

@Entity
@Table(name="product_model")
public class ProductModel {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @Column
    public String name;
    
    @Column
    public int price;
    
    // public ProductModel(Long id, String name, int price){
    //     this.id = id;
    //     this.name = name;
    //     this.price = price;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setSpecialty(int price) {
        this.price = price;
    }
}
