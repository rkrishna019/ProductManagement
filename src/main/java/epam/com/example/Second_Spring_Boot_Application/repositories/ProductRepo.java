package epam.com.example.Second_Spring_Boot_Application.repositories;

import epam.com.example.Second_Spring_Boot_Application.dto.ProductDto;
import epam.com.example.Second_Spring_Boot_Application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Query Method should be inside the repo class.

public interface ProductRepo extends JpaRepository<Product, Integer> {

    public Optional<Product> findByName(String name);



}

