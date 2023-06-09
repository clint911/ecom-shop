package com.shop.ecomshop.models;
import jakarta.persistence.*;
@Entity
@Table(name = "orders")
public class Orders {
    private  long orderId;
    private long userId;//foreign key

    private long noOfProducts;
    private long totalPrice;
    private String orderStatus;//TODO:will be refactored to an enum class
    private String date;//TODO:cross check if its best this way or can be refactored
    private String productsOrdered;//TODO: Refactor to an array or sth of the sort
    //default no args constructor to create our orders table as an empty table but with
    // template
    public Orders() {}
    //constructor with args that give it instruction how to create an individual product
    public  Orders(long noOfProducts, long totalPrice, String orderStatus, String date,
                   String productsOrdered) {
        this.noOfProducts = noOfProducts;
        this.totalPrice  = totalPrice;
        this.orderStatus = orderStatus;
        this.date = date;
        this.productsOrdered = productsOrdered;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  long getOrderId(){
        return  orderId;
    }
    public  void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    @Column(name = "no_of_products", nullable = false)
    public  long getNoOfProducts() {
        return noOfProducts;
    }
    public void setNoOfProducts(long noOfProducts) {
        this.noOfProducts = noOfProducts;
    }
   @Column(name = "total_price", nullable = false)
   public long getTotalPrice() {
        return  totalPrice;
   }
   public  void  setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
   }
   @Column(name = "order_status", nullable = false)
   public  String getOrderStatus() {
        return  orderStatus;
   }
   public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
   }
   @Column(name = "order_date", nullable = false)
    public String getDate(){
        return  date;
   }
   public  void  setDate(String date) {
        this.date = date;
   }
   //TODO: in the products ordered you will list the id of each product to avoid creating
   // complex unnecessary relationships
   @Column(name = "products_ordered", nullable = false)
    public String getProductsOrdered(){return  productsOrdered;}
    public void setProductsOrdered(String productsOrdered){this.productsOrdered =
            productsOrdered;}
   //if does not work check Users class kindly
}
