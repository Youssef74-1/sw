package EComm.SW.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_name")
    private String name;


    @Column(name="description")
    private String description;


    @Override
    public String toString() {
        return "Category [name=" + name + ", description=" + description + "]";
    }







}