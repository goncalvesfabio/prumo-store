package com.prumoitstore.order.repository;

import com.prumoitstore.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
