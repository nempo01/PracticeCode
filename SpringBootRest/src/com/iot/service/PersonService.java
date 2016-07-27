package com.iot.service;

import com.iot.dao.PersonDAO;
import com.iot.domain.Person;
import com.iot.repository.PersonRepository;
import com.iot.util.exception.InvalidPersonIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ekansh on 13/7/15.
 */
@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private PersonRepository personRepository;

    public Object list(){
        return personRepository.findAll();
    }

    public Person findById(Long id){
        Person person =  personRepository.findOne(id);
        if(person == null)
            throw new InvalidPersonIdException();
        return person;
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public Person update(Person personNew){
        Person personOld = personRepository.findOne(personNew.getId());
        if(personOld == null)
            throw new InvalidPersonIdException();
        personOld.setMobile(personNew.getMobile());
        personOld.setName(personNew.getName());
        return personRepository.save(personOld);
    }
}
