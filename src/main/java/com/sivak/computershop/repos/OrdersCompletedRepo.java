package com.sivak.computershop.repos;

import com.sivak.computershop.entities.OrdersCompleted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersCompletedRepo extends JpaRepository<OrdersCompleted, Long> {

}
