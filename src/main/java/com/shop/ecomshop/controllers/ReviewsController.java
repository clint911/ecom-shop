package com.shop.ecomshop.controllers;

import com.shop.ecomshop.exception.ResourceNotFoundException;
import com.shop.ecomshop.models.Reviews;
import com.shop.ecomshop.repositories.ReviewsRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/reviewsApi")
public class ReviewsController {
    @Autowired
    private ReviewsRepository reviewsRepository;

    @GetMapping("/reviews")
    public List<Reviews> getAllReviews(){return reviewsRepository.findAll();}
    @GetMapping("/reviews/{id}")
    public  ResponseEntity<Reviews> getReviewsById(@PathVariable(value = "id")Long reviewId) throws ResourceNotFoundException {
        Reviews reviews =
                reviewsRepository.findById(reviewId).orElseThrow(()-> new ResourceNotFoundException("Review not found for this::" + reviewId));
        return ResponseEntity.ok().body(reviews);
    }
    @PostMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
        public Reviews createReview(@Valid @RequestBody Reviews reviews) {
        return reviewsRepository.save(reviews);
    }
    @PutMapping ResponseEntity<Reviews> updateReviews(@PathVariable(value = "id") Long reviewId, @Valid @RequestBody Reviews reviewsDetails) throws ResourceNotFoundException { Reviews reviews = reviewsRepository.findById(reviewId).orElseThrow(()->new ResourceNotFoundException("Review not found for this :: " + reviewId));
        //contents of the review constructor
      /*  long productId, long userId, long productRating, String textContent,
                String dateOfReview
                */
        reviews.setProductId(reviewsDetails.getProductId());
        reviews.setUserId(reviewsDetails.getUserId());
        reviews.setProductRating(reviewsDetails.getProductRating());
        reviews.setTextContent(reviewsDetails.getTextContent());
        reviews.setDateOfReview(reviewsDetails.getDateOfReview());

        final Reviews updatedReviews = reviewsRepository.save(reviews);
        return  ResponseEntity.ok().body(updatedReviews);
    }
    @DeleteMapping("/reviews/{id}")
    public Map<String, Boolean> deleteReview(@PathVariable(value = "id") Long reviewId) throws ResourceNotFoundException {
        Reviews reviews =
                reviewsRepository.findById(reviewId).orElseThrow(()-> new ResourceNotFoundException("Review not found for this id" + reviewId));
        reviewsRepository.delete(reviews);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }
}
