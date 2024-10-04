package epam.com.example.Second_Spring_Boot_Application.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    @NotNull(message = "Product id must not be null or empty")
    private Integer id;

    @NotNull(message = "Product name must not be null or empty")
    private String name;

    @NotNull(message = "Product price must not be null or empty")
    private Long price;

    @NotNull(message = "Product description must not be null or empty")
    private String description;

    @NotNull(message = "Product Quantity must not be null or empty")
    private Integer quantity;

    @NotNull(message = "Product brand name must not be null or empty")
    private String brand;

}
