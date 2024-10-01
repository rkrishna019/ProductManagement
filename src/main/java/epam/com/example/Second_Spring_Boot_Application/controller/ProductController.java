package epam.com.example.Second_Spring_Boot_Application.controller;

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
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

    @GetMapping("allProducts")
    public ResponseEntity<List<Product>> getAllProduct(){

        List<Product>  allProduct = productService.getProduct();
        return new ResponseEntity<>(allProduct,HttpStatus.FOUND);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Integer product_id){

        Optional<Product> productOptional = productService.getById(product_id);
        return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer product_id, @RequestBody Product product){

        product.setId(product_id);
        Product updatedProduct = productService. updateProduct(product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer product_id){

        productService.deleteProduct(product_id);
        return new  ResponseEntity<>("Product is suceessfully deleted", HttpStatus.OK);

    }

}
