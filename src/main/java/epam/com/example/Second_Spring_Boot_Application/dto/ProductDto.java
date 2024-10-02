package epam.com.example.Second_Spring_Boot_Application.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private Integer id;
    private String name;
    private Long price;
    private String description;
    private Integer quantity;
    private String brand;

}
