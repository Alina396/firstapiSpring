package com.spring.firstapi.service;


import com.spring.firstapi.entity.Person;
import com.spring.firstapi.exception.NotFoundException;
import com.spring.firstapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    public Person addPerson(Person person)
    {
        personRepository.save(person);
        return person;
    }

    public List<Person> getAllPersons()
    {
        return personRepository.findAll();
    }

    public Person findPersonById(int id)
    {

        Optional<Person> person=personRepository.findById(id);
        if(!person.isPresent())
        {
            throw new NotFoundException("Person with id "+id+" does not exists!");
        }

        return person.get();
    }

    public Person updatePerson(Person person, int id)
    {

        Optional<Person> Opperson=personRepository.findById(id);
        if(!Opperson.isPresent())
        {
            throw new NotFoundException("Person with id "+id+" does not exists!");
        }
        person.setId(id);
        personRepository.save(person);
        return person;
    }

    public void deletePerson(int id)
    {
        Optional<Person> person=personRepository.findById(id);
        if(!person.isPresent())
        {
            throw new NotFoundException("Person with id "+id+" does not exists!");
        }
        personRepository.delete(person.get());
    }
}
