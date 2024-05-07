package EComm.SW.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    private String quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name= "category_name")
    private Category category;

}