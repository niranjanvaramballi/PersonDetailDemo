package com.niranjan.spring.app.vo;

public class AddressRequest {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "address=" + address +
                '}';
    }
}
