package com.niranjan.spring.app.controller;

import java.util.List;

import com.niranjan.spring.app.service.PersonService;
import com.niranjan.spring.app.vo.Person;
import com.niranjan.spring.app.vo.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody PersonRequest personRequest) {
        return personService.addPerson(personRequest);
    }

    @PutMapping("/updatePerson")
    public Person updatePerson(@RequestBody PersonRequest personRequest) {
        return personService.updatePerson(personRequest);
    }

    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/countPersons")
    public String countPersons() {
        return personService.countPersons();
    }

    @GetMapping("listPersons")
    public List<Person> listPersons() {
        return personService.listPersons();
    }
}
