package com.skni.workshopspring3.controller;


import com.skni.workshopspring3.dto.PersonResponse;
import com.skni.workshopspring3.repo.PersonRepository;
import com.skni.workshopspring3.repo.entity.Address;
import com.skni.workshopspring3.repo.entity.Person;
import com.skni.workshopspring3.service.PersonService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;
    private final ModelMapper modelMapper;

    @GetMapping("/person")
    public List<PersonResponse> getPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Optional<Person> result = personRepository.findById(id);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

}