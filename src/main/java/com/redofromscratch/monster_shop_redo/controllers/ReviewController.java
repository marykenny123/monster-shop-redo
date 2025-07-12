package com.redofromscratch.monster_shop_redo.controllers;

import com.redofromscratch.monster_shop_redo.models.Product;
import com.redofromscratch.monster_shop_redo.models.Review;
import com.redofromscratch.monster_shop_redo.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review newReview, Long productId) {
        Review createdReview = reviewService.addReview(newReview, productId);
        return new ResponseEntity<Review>(createdReview, HttpStatus.CREATED);
    }

    // READ BY PRODUCT ID
    @GetMapping("/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
// get all reviews by product id
    @GetMapping("/all-reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

}
