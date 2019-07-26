package com.sivak.computershop.repos;

import com.sivak.computershop.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Long> {

}
