package com.niranjan.spring.app.repo;

import java.util.List;

import com.niranjan.spring.app.vo.Person;
import com.niranjan.spring.app.vo.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByPerson(Person existingPerson);
}
