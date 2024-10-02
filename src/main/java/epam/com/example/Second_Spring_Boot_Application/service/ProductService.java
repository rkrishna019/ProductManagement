package epam.com.example.Second_Spring_Boot_Application.service;

import epam.com.example.Second_Spring_Boot_Application.dto.ProductDto;
import epam.com.example.Second_Spring_Boot_Application.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {



    public ProductDto saveProduct(ProductDto productDto);
    public List<ProductDto> getProduct();

    public ProductDto getById(Integer id);

    public ProductDto updateProduct(ProductDto productDto);

    public void deleteProduct(Integer id);
}
