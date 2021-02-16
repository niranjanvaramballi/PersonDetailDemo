package com.niranjan.spring.app.service;

import javax.transaction.Transactional;
import java.util.List;

import com.niranjan.spring.app.repo.AddressRepository;
import com.niranjan.spring.app.repo.PersonRepository;
import com.niranjan.spring.app.vo.Person;
import com.niranjan.spring.app.vo.Address;
import com.niranjan.spring.app.vo.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Person addPerson(PersonRequest personRequest) {
        return personRepository.save(personRequest.getPerson());
    }

    public Person updatePerson(PersonRequest personRequest) {
        Person existingPerson = personRepository.findById(personRequest.getPerson().getpId()).orElse(null);
        if (existingPerson == null) {
            throw new RuntimeException("No matching person!!!");
        }
        existingPerson.setFirstName(personRequest.getPerson().getFirstName());
        existingPerson.setLastName(personRequest.getPerson().getLastName());

        return personRepository.save(existingPerson);
    }

    @Transactional
    public String deletePerson(int id) throws EmptyResultDataAccessException {
        Person existingPerson = personRepository.findById(id).orElse(null);
        personRepository.deleteById(id);
        if (existingPerson == null) {
            throw new RuntimeException("No matching person found");
        }
        List<Address> addresses = getAddress(existingPerson);
        if (addresses != null) {
            for (Address address : addresses) {
                addressRepository.deleteById(address.getAddId());
            }
        }

        addressRepository.flush();
        personRepository.flush();
        return String.format("Person details %d removed..", id);
    }

    public String countPersons() {
        Iterable<Person> allPerson = personRepository.findAll();
        int count = 0;
        for (Person person : allPerson) {
            count++;
        }
        return String.format("Number of Persons count is %d", count);
    }

    public List<Person> listPersons() {
        return personRepository.findAll();
    }

    private List<Address> getAddress(Person existingPerson) {
        return addressRepository.findByPerson(existingPerson);
    }
}
