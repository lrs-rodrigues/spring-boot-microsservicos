package com.lrsrodrigues.address.repositories;

import com.lrsrodrigues.address.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findByOwnerId(Integer ownerId);

}
