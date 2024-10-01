package epam.com.example.Second_Spring_Boot_Application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_table")
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Long price;

    @Column(nullable =  false)
    String description;

    @Column(nullable = false)
    Integer quantity;

    @Column(nullable = false)
    String brand;

}
