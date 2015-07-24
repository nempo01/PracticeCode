package com.ekiras.controller;

import com.ekiras.domain.Person;
import com.ekiras.service.PersonService;
import com.ekiras.service.PrepareResponseDTOService;
import com.ekiras.util.exception.MyException;
import com.ekiras.util.response.ResponseDTO;
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

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = "application/json")
    public ResponseDTO save(@RequestBody Person person){
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