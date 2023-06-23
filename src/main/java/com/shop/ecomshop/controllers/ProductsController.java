package com.shop.ecomshop.controllers;
import com.shop.ecomshop.exception.ResourceNotFoundException;
import com.shop.ecomshop.models.Products;
import com.shop.ecomshop.repositories.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productsApi")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("/products")
    public  List<Products> getAllProducts(){return productsRepository.findAll();}
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable(value = "id")Long productId) throws ResourceNotFoundException {
        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ::" +
                        " " + productId));
        return ResponseEntity.ok().body(products);
    }
    @PostMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Products createProduct(@Valid @RequestBody Products products) {
        return productsRepository.save(products);
    }
    @PutMapping ResponseEntity<Products> updateProduct(@PathVariable(value = "id") Long productId, @Valid @RequestBody Products productsDetails) throws ResourceNotFoundException {
        Products products =
                productsRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("product not found for this is" + " :: " + productId));
        //note that we update the data that is in the constructor
        //price, productName, description, imageUrl
        products.setPrice(productsDetails.getPrice());
        products.setProductName(productsDetails.getProductName());
        products.setDescription(productsDetails.getDescription());
        products.setImageUrl(productsDetails.getImageUrl());

        final Products updatedProduct = productsRepository.save(products);
        return  ResponseEntity.ok(updatedProduct);
    }
    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id")Long productId) throws ResourceNotFoundException {
        Products products = productsRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found for this " +
                        "id" + productId));
        productsRepository.delete(products);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }
}
