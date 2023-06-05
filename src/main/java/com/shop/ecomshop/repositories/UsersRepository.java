package com.shop.ecomshop.repositories;
import com.shop.ecomshop.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends  JpaRepository<Users, Long> {
}
