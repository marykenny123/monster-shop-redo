package com.redofromscratch.monster_shop_redo.services;

import com.redofromscratch.monster_shop_redo.models.Product;
import com.redofromscratch.monster_shop_redo.models.Review;
import com.redofromscratch.monster_shop_redo.repositories.ReviewRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReviewService {

    public final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //CREATE
    public Review addReview(Review newReview) {
        return reviewRepository.save(newReview);
    }

    //READ BY PRODUCT ID
    public List<Review> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findAllByProductId(productId);
//        System.out.println("Pulled from repo: " + reviews.size()); // test
        return reviews;
    }

    // to see get all reviews
    //READ (ALL)
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }


}
