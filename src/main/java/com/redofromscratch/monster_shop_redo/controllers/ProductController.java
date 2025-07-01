package com.redofromscratch.monster_shop_redo.controllers;

import com.redofromscratch.monster_shop_redo.models.Product;
import com.redofromscratch.monster_shop_redo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping("api/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    // READ ALL
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> requestedProduct = productService.getProductById(id);
        if (requestedProduct.isPresent()) {
            return new ResponseEntity<Product>(requestedProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE BY ID
    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        boolean wasUpdated = productService.updateProduct(id, updatedProduct);
        if (!wasUpdated) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }



//    codigo service product by id para tener a mano
//    public Optional<Product> getProductById(Long id) {
//        return productRepository.findById(id);
//    }


}
