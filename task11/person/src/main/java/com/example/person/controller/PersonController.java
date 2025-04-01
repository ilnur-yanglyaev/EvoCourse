package com.example.person.controller;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        Optional<Person> existingPerson = repository.findById(person.getId());

        if (existingPerson.isPresent()) {
            return new ResponseEntity<>(existingPerson.get(), HttpStatus.BAD_REQUEST);
        } else {
            Person savedPerson = repository.save(person);
            return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
        }
    }

}