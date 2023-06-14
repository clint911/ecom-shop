package com.shop.ecomshop.models;
import jakarta.persistence.*;

@Entity
@Table(name = "product_reviews")
public class Reviews {
    //properties
    private long reviewId;
    private long productId;//id of product being reviewed
    private long userId;//id of user sending the damn review
    private long productRating;//out of 5, you can make it stars in your css
    private String textContent;//actual review content
    private String dateOfReview;//date of review
    //creating Reviews table without any data
    public  Reviews(){}
    //creating a single review and adding the data to the table
    public  Reviews(long productId, long userId, long productRating, String textContent,
                    String dateOfReview) {
        this.productId = productId;
        this.userId = userId;
        this.productRating = productRating;
        this.textContent = textContent;
        this.dateOfReview = dateOfReview;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getReviewId() {return  reviewId;}
    public void  setReviewId(long reviewId){this.reviewId = reviewId;}
    @Column(name = "product_id", nullable = false)
    public long getProductId(){return productId;}
    public void setProductId(long productId){this.productId = productId;}
    @Column(name = "user_id", nullable = false)
    public long getUserId(){return userId;}
    public void setUserId(long userId){this.userId = userId;}
    @Column(name = "product_rating", nullable = false)
    public long getProductRating(){return  productRating;}
    public void setProductRating(long productRating){this.productId = productRating;}
    @Column(name = "text_content", nullable = false)
    public String getTextContent() {return  textContent;}
    public void setTextContent(String textContent) {this.textContent = textContent;}
    @Column(name = "date_of_review",nullable = false)
    public String getDateOfReview(){return  dateOfReview;}
    public void setDateOfReview(String dateOfReview) {this.dateOfReview = dateOfReview;}
    //if err check user class
    @Override
    public String toString() {
        return "Reviews [id=" + reviewId + ", productId=" + productId + ", userId=" + userId + ", productRating=" + productRating + ", textContent=" + textContent + ", dateOfReview=" + dateOfReview + "]";
    }
}
