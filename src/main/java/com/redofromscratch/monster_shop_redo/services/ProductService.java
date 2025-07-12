package com.redofromscratch.monster_shop_redo.services;

import com.redofromscratch.monster_shop_redo.models.Product;
import com.redofromscratch.monster_shop_redo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    //READ BY ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // UPDATE BY ID
    public boolean updateProduct(Long id, Product updatedDetails) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            return false;
        }
        Product existingProduct = productOptional.get();

        existingProduct.setName(updatedDetails.getName());
        existingProduct.setPrice(updatedDetails.getPrice());

        existingProduct.setImageUrl(updatedDetails.getImageUrl());
        existingProduct.setRating(updatedDetails.getRating());
        existingProduct.setReviewCount(updatedDetails.getReviewCount());
        existingProduct.setFeatured(updatedDetails.getFeatured());

        productRepository.save(existingProduct);
        return true;
    }


    //DELETE
    public boolean deleteProduct (Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

}
