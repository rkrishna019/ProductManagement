package epam.com.example.Second_Spring_Boot_Application.service;

import epam.com.example.Second_Spring_Boot_Application.model.Product;
import epam.com.example.Second_Spring_Boot_Application.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProduct(){
        return productRepo.findAll();
    }

    public Optional<Product> getById(Integer id){
        return productRepo.findById(id);
    }

    public Product updateProduct(Product product){

        Product exstingProduct = productRepo.findById(product.getId()).get();
        exstingProduct.setName(product.getName());
        exstingProduct.setPrice(product.getPrice());
        exstingProduct.setDescription(product.getDescription());
        exstingProduct.setQuantity(product.getQuantity());
        exstingProduct.setBrand(product.getBrand());

        Product updatedProduct = productRepo.save(exstingProduct);

        return updatedProduct;
    }

    public void deleteProduct(Integer id){
         productRepo.deleteById(id);
    }
}
