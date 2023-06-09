package com.shop.ecomshop.repositories;
import com.shop.ecomshop.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
