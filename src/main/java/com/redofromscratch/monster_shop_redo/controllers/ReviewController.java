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
    public ResponseEntity<Review> addReview(@RequestBody Review newReview) {
        Review createdReview = reviewService.addReview(newReview);
        return new ResponseEntity<Review>(createdReview, HttpStatus.CREATED);
    }

    // READ BY PRODUCT ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Review>> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // get all reviews
    @GetMapping("/all-reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

}
