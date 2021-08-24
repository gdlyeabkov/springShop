package glebdyakovcompany.app.shop.models;
// import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="user_model")
public class UserModel {
    
    @Id
    @Column
    public Long id;

    @Column
    public String email;
    
    @Column
    public String password;
    
    @Column
    public String name;
    
    @Column
    public int age;
    
    @Column
    public int moneys = 0;
    
    @Column
    public ArrayList<Map<String, Object>> productsInBucket;
    
    public UserModel(){
    }
    
    public UserModel(String email, String password, String name, int age, int moneys, ArrayList<Map<String, Object>> productsInBucket){
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.productsInBucket = productsInBucket;
    }

    public UserModel(Long id, String email, String password, String name, int age, int moneys, ArrayList<Map<String, Object>> productsInBucket){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.productsInBucket = productsInBucket;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoneys() {
        return moneys;
    }

    public void setMoneys(int moneys) {
        this.moneys = moneys;
    }

    public ArrayList<Map<String, Object>> getProductsInBucket() {
        return productsInBucket;
    }

    public void setProductsInBucket(ArrayList<Map<String, Object>> productsInBucket) {
        this.productsInBucket = productsInBucket;
    }

    @Override
    public String toString(){
        return "{\'id\'':\'"+ getId() + "\',\'email\':\'"+ getEmail() + "\',\'password\':\'"+ getPassword() + "\',\'name\':\'"+ getName() + "\',\'age\':\'"+ getAge() + "\',\'moneys\':\'"+ getMoneys() + "\',\'productsInBucket\':\'"+ "[]" + "\'}";
    }

}
