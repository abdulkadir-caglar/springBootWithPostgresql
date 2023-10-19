package com.caglar.postgresqldemo.repository;

import com.caglar.postgresqldemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
