package com.iot.controller;

import com.iot.domain.Person;
import com.iot.service.PersonService;
import com.iot.service.PrepareResponseDTOService;
import com.iot.util.exception.MyException;
import com.iot.util.response.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ekansh on 24/7/15.
 */

@RestController
@RequestMapping(value = {"","/person"})
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PrepareResponseDTOService prepareResponseDTOService;


    @RequestMapping(value = {"/","list"}, method = RequestMethod.GET)
    public ResponseDTO list(Model model){
        return prepareResponseDTOService.listPersons(personService.list());
    }

    @RequestMapping(value = "/get/{id}")
    public ResponseDTO getPerson(@PathVariable Long id){
        return prepareResponseDTOService.listPersons(personService.findById(id));
    }

    @RequestMapping(value = {"/","save"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseDTO save(@RequestBody Person person){
    	System.out.println("Enter the Save method....");
    	person.setId(1L);
    	person.setEmail("heelo@ca.com");
    	person.setMobile("999999999");
    	person.setConfirmPassword("AMMARAO@01");
    	person.setName("Ammarao");
	person.setPassword("AMMARAO@01");
        return prepareResponseDTOService.savePerson(personService.save(person));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST, consumes = "application/json")
    public ResponseDTO update(@RequestBody Person person){
        return prepareResponseDTOService.updatePerson(personService.save(person));
    }

    @ExceptionHandler(MyException.class)
    public ResponseDTO catchException(MyException myException){
        return prepareResponseDTOService.error(myException.getMessage());
    }
}