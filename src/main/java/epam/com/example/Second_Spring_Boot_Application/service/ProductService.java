package epam.com.example.Second_Spring_Boot_Application.service;

import epam.com.example.Second_Spring_Boot_Application.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {



    public  Product saveProduct(Product product);
    public List<Product> getProduct();

    public Optional<Product> getById(Integer id);

    public Product updateProduct(Product product);

    public void deleteProduct(Integer id);
}
