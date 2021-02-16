package com.niranjan.spring.app.controller;

import com.niranjan.spring.app.service.AddressService;
import com.niranjan.spring.app.vo.Address;
import com.niranjan.spring.app.vo.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public Address addPerson(@RequestBody AddressRequest addressRequest) {
        return addressService.addAddress(addressRequest);
    }

    @PutMapping("/updateAddress")
    public Address updatePerson(@RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(addressRequest);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public String deletePerson(@PathVariable int id) {
        return addressService.deleteAddress(id);
    }
}
