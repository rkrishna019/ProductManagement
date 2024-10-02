package epam.com.example.Second_Spring_Boot_Application.controller;

import epam.com.example.Second_Spring_Boot_Application.Mapper.ProductMapper;
import epam.com.example.Second_Spring_Boot_Application.dto.ProductDto;
import epam.com.example.Second_Spring_Boot_Application.model.Product;
import epam.com.example.Second_Spring_Boot_Application.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){

        ProductDto savedProduct = productService.saveProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

    @GetMapping("allProducts")
    public ResponseEntity<List<ProductDto>> getAllProduct(){

        List<ProductDto>  allProduct = productService.getProduct();
        return new ResponseEntity<>(allProduct,HttpStatus.FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Integer product_id){

        ProductDto product = productService.getById(product_id);
        return new ResponseEntity<>(product,HttpStatus.OK);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Integer product_id, @RequestBody ProductDto product){

        product.setId(product_id);
        ProductDto updatedProduct = productService. updateProduct(product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer product_id){

        productService.deleteProduct(product_id);
        return new  ResponseEntity<>("Product is suceessfully deleted", HttpStatus.OK);

    }

}
