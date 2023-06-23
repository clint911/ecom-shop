package com.shop.ecomshop.controllers;

import com.shop.ecomshop.exception.ResourceNotFoundException;
import com.shop.ecomshop.models.Users;
import com.shop.ecomshop.repositories.UsersRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usersApi")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users")
    public List<Users> getAllUsers(){return usersRepository.findAll();}
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "id")Long userId)
       throws ResourceNotFoundException {
        Users users = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ::" +
                        " " + userId));
        return ResponseEntity.ok().body(users);
    }
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users createUser(@Valid @RequestBody Users users) {
        return usersRepository.save(users);
    }
    @PutMapping ResponseEntity<Users> updateUsers(@PathVariable(value = "id") Long userId,
                                                  @Valid @RequestBody Users usersDetails) throws ResourceNotFoundException {
        Users users = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this is" +
                        " :: " + userId));
        //username,email,password
   users.setUserName(usersDetails.getUserName());
   users.setEmail(usersDetails.getEmail());
   users.setPassword(usersDetails.getPassword());
   users.setAddress(usersDetails.getAddress());
   users.setCity(usersDetails.getCity());
   users.setCountry(usersDetails.getCountry());

   final Users updatedUsers = usersRepository.save(users);
   return ResponseEntity.ok(updatedUsers);
    }
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        Users users = usersRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found for this id" + userId));
        usersRepository.delete(users);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
