package com.example.task10.controller;

import com.example.task10.dto.Message;
import com.example.task10.dto.Person;
import com.example.task10.repository.PersonRepository;
import com.example.task10.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return service.getAllPersons();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return service.findPersonById(id);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        return service.addPerson(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person) {
        Person updatedPerson = service.updatePerson(id, person);
        if (updatedPerson != null) {
            return ResponseEntity.ok(updatedPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/person/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        try {
            service.deletePerson(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }





    @GetMapping("/person/{p_id}/message")
    public List<Message> getMessagesForPerson(@PathVariable int p_id) {
        return service.getMessagesForPerson(p_id);
    }

    @GetMapping("/person/{p_id}/message/{m_id}")
    public Optional<Message> getMessageForPerson(@PathVariable int p_id,@PathVariable int m_id) {
        return service.getMessageForPerson(p_id,m_id);
    }




    @PostMapping("/person/{id}/message")
    public ResponseEntity<Person> addMessage(@PathVariable int id, @RequestBody Message message) {
        try {
            Person person = service.addMeesageToPerson(id, message);
            return ResponseEntity.ok(person);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @DeleteMapping("/person/{p_id}/message/{m_id}")
    public ResponseEntity<String> deleteMessage(@PathVariable int p_id,@PathVariable int m_id) {
        try {
            service.deleteMessageForPerson(p_id, m_id);
            return ResponseEntity.ok("deleted");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}