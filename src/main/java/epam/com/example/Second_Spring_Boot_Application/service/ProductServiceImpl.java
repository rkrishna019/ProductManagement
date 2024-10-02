package epam.com.example.Second_Spring_Boot_Application.service;

import epam.com.example.Second_Spring_Boot_Application.Mapper.ProductMapper;
import epam.com.example.Second_Spring_Boot_Application.dto.ProductDto;
import epam.com.example.Second_Spring_Boot_Application.model.Product;
import epam.com.example.Second_Spring_Boot_Application.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        // Convert this ProductDto to JPA entity to save the product in DataBase.

        Product product  = ProductMapper.mapToProduct(productDto);
        Product savedProduct =  productRepo.save(product);

// COnvert JPA entity into ProductDto
        ProductDto savedProductDto = ProductMapper.mapToDto(savedProduct);

        return savedProductDto;
    }

    public List<ProductDto> getProduct(){
        List<Product> list = productRepo.findAll();

        List<ProductDto> listDto = new ArrayList<ProductDto>();
        listDto =  list.stream().map(ProductMapper :: mapToDto).collect(Collectors.toList());
        return listDto;
    }

    public ProductDto getById(Integer id){
        Optional<Product> optionalProduct =  productRepo.findById(id);
        Product product = optionalProduct.get();
        return ProductMapper.mapToDto(product);
    }

    public ProductDto updateProduct(ProductDto product){

        Product exstingProduct = productRepo.findById(product.getId()).get();

        exstingProduct.setName(product.getName());
        exstingProduct.setPrice(product.getPrice());
        exstingProduct.setDescription(product.getDescription());
        exstingProduct.setQuantity(product.getQuantity());
        exstingProduct.setBrand(product.getBrand());

        Product updatedProduct = productRepo.save(exstingProduct);

        return ProductMapper.mapToDto(updatedProduct);
    }

    public void deleteProduct(Integer id){
         productRepo.deleteById(id);
    }
}
