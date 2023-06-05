package com.shop.ecomshop.models;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    //properties
    private long userId;

    private String email;
    private String userName;
    private String password;
    private String address;//can be deleted later
    private String city;
    private String country;
    //created at field skipped that I don't think is useful

    //default constructor
    public  Users() {}
    //overridden constructor with email,username & password
    public Users(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    //setters and getters for the given properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getUserId() {return userId;}
    public  void setUserId(long userId) {this.userId = userId;}
    @Column(name = "email", nullable = false)
    public String getEmail(){return  email;}
    public void setEmail(String email){this.email = email;}
    @Column(name = "user_name", nullable = false)
    public String getUserName(){return  userName;}
    public void setUserName(String userName){this.userName = userName;}
    @Column(name = "password", nullable = false)
    public String getPassword(){return  password;}
    public void setPassword(String password){this.password = password;}
    @Column(name = "address", nullable = false)
    public String getAddress(){return  address;}
    public void setAddress(String address){this.address = address;}
    @Column(name = "city", nullable = false)
    public String getCity(){return  city;}
    public void setCity(String city){this.city = city;}
    @Column(name = "country", nullable = false)
    public String getCountry(){return country;}
    public void setCountry(String country){this.country = country;}

    //I saw an ovverride somewhere, if shit doesn't work look for the employees models file
    // and try sth similar
}
