package epam.com.example.Second_Spring_Boot_Application.service;

import epam.com.example.Second_Spring_Boot_Application.Mapper.ProductMapper;
import epam.com.example.Second_Spring_Boot_Application.dto.ProductDto;
import epam.com.example.Second_Spring_Boot_Application.model.Product;
import epam.com.example.Second_Spring_Boot_Application.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        // Convert this ProductDto to JPA entity to save the product in DataBase.

       // Product product  = ProductMapper.mapToProduct(productDto);
        Product product = modelMapper.map(productDto,Product.class);
        Product savedProduct =  productRepo.save(product);

// COnvert JPA entity into ProductDto
      //  ProductDto savedProductDto = ProductMapper.mapToDto(savedProduct);
        ProductDto savedProductDto = modelMapper.map(savedProduct,ProductDto.class);
        return savedProductDto;
    }

    public List<ProductDto> getProduct(){
        List<Product> list = productRepo.findAll();

        List<ProductDto> listDto = new ArrayList<ProductDto>();
       // listDto =  list.stream().map(ProductMapper :: mapToDto).collect(Collectors.toList());
        listDto = list.stream().map((products) -> modelMapper.map(products,ProductDto.class)).collect(Collectors.toList());
        return listDto;
    }

    public ProductDto getById(Integer id){
        Optional<Product> optionalProduct =  productRepo.findById(id);
        Product product = optionalProduct.get();
       // return ProductMapper.mapToDto(product);
        return modelMapper.map(product,ProductDto.class);
    }

    public ProductDto updateProduct(ProductDto product){

        Product exstingProduct = productRepo.findById(product.getId()).get();

        exstingProduct.setName(product.getName());
        exstingProduct.setPrice(product.getPrice());
        exstingProduct.setDescription(product.getDescription());
        exstingProduct.setQuantity(product.getQuantity());
        exstingProduct.setBrand(product.getBrand());

        Product updatedProduct = productRepo.save(exstingProduct);

       // return ProductMapper.mapToDto(updatedProduct);
        return modelMapper.map(updatedProduct,ProductDto.class);
    }

    public void deleteProduct(Integer id){
         productRepo.deleteById(id);
    }
}
