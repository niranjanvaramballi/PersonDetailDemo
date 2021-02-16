package com.niranjan.spring.app.vo;

public class PersonRequest {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Request{" +
                "person=" + person +
                '}';
    }
}
