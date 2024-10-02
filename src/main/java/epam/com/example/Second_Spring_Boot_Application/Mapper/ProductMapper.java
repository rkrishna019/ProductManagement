package epam.com.example.Second_Spring_Boot_Application.Mapper;

import epam.com.example.Second_Spring_Boot_Application.dto.ProductDto;
import epam.com.example.Second_Spring_Boot_Application.model.Product;

public class ProductMapper {

    public static ProductDto mapToDto(Product product){

        ProductDto savedProductDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getQuantity(),
                product.getBrand()
        );
        return savedProductDto;

    }

    public static Product mapToProduct(ProductDto productDto){

        Product savedProduct = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getQuantity(),
                productDto.getBrand()
        );
        return savedProduct;
    }
}
