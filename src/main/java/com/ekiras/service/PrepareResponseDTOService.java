package com.ekiras.service;

import com.ekiras.domain.Person;
import com.ekiras.util.response.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ekansh on 24/7/15.
 */
@Service
public class PrepareResponseDTOService {

    public ResponseDTO listPersons(Object rawData){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("persons",rawData);
        return new ResponseDTO(data,"person list successfully fetched");
    }

    public ResponseDTO getPerson(Object rawData){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("person",rawData);
        return new ResponseDTO(data,"person successfully fetched");
    }

    public ResponseDTO savePerson(Object rawData){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("person",rawData);
        return new ResponseDTO(data,"new person successfully saved");
    }

    public ResponseDTO updatePerson(Object rawData){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("person",rawData);
        return new ResponseDTO(data,"person data successfully updated");
    }

}
