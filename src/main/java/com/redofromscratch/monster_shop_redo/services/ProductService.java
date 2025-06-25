package com.redofromscratch.monster_shop_redo.services;

import com.redofromscratch.monster_shop_redo.models.Product;
import com.redofromscratch.monster_shop_redo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //CREATE
    public void addProduct(Product newProduct) {
        productRepository.save(newProduct);
    }

    //READ (ALL)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //READ BY falta arreglar y falta en controller
//    public Product getProductById(Long id) {
//        return productRepository.findById(id);
//    }

    //UPDATE

    //DELETE
}
