package com.shop.ecomshop.models;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    //properties
    private long productId;
    private long price;
    private String productName;
    private String description;
    private String imageUrl;
//default no-args constructor for creating first instance of this class in the database
    public Products(){}
    //constructor with args for creating a single product
    public  Products(long price, String productName, String description, String imageUrl) {
        this.price = price;
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getProductId() {
      return productId;
    }
    public void  setProductId(long productId) {
        this.productId = productId;
    }
    @Column(name = "price", nullable = false)
    public long getPrice(){
        return  price;
    }
    public  void  setPrice(long price) {
        this.price = price;
    }
    @Column(name = "product_name", nullable = false)
    public  String getProductName(){
        return  productName;
    }
    public  void  setProductName(String productName) {
        this.productName = productName;
    }
    @Column(name = "description", nullable = false)
    public String getDescription(){
        return  description;
    }
    public void  setDescription(String description) {
        this.description = description;
    }
    @Column(name = "image_url", nullable = false)
    public  String getImageUrl() {
        return  imageUrl;
    }
    public  void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    //if doesn't work, check the UsersControllers for some comments I added from them
    // employee controllers
    //long price, String productName, String description, String imageUrl
    @Override
    public String toString() {
        return "Products [id=" + productId + ", price=" + price + ", productName=" + productName + ", description" + description + ", imageUrl" + imageUrl + "]";
    }


}
