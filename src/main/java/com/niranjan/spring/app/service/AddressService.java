package com.niranjan.spring.app.service;

import com.niranjan.spring.app.vo.Person;
import com.niranjan.spring.app.repo.AddressRepository;
import com.niranjan.spring.app.repo.PersonRepository;
import com.niranjan.spring.app.vo.Address;
import com.niranjan.spring.app.vo.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    public Address addAddress(AddressRequest addressRequest) {
        Person existingPerson = getPerson(addressRequest);
        if (existingPerson == null) {
            throw new RuntimeException("No matching person found!!!");
        }

        addressRequest.getAddress().setPerson(existingPerson);

        return addressRepository.save(addressRequest.getAddress());
    }

    public Address updateAddress(AddressRequest addressRequest) {
        Person existingPerson = getPerson(addressRequest);

        if (existingPerson == null) {
            throw new RuntimeException("No matching person found!!!");
        }

        Address existingAddress = addressRepository.findById(addressRequest.getAddress().getAddId()).orElse(null);

        if (existingAddress == null) {
            throw new RuntimeException("No matching address found for person!!!");
        }
        existingAddress.setStreet(addressRequest.getAddress().getStreet());
        existingAddress.setCity(addressRequest.getAddress().getCity());
        existingAddress.setState(addressRequest.getAddress().getState());
        existingAddress.setPostalCode(addressRequest.getAddress().getPostalCode());
        existingAddress.setPerson(existingPerson);
        return addressRepository.save(existingAddress);
    }

    public String deleteAddress(int id) {
        addressRepository.deleteById(id);
        return String.format("Address details removed for %d", id);
    }

    private Person getPerson(AddressRequest addressRequest) {
        int pid = addressRequest.getAddress().getPerson().getpId();
        return personRepository.findById(pid).orElse(null);
    }
}
