package com.prumoitstore.order.repository;

import com.prumoitstore.order.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
