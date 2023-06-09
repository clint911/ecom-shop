package com.shop.ecomshop.repositories;
import com.shop.ecomshop.models.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface ReviewsRepository  extends JpaRepository<Reviews, Long>{
}
