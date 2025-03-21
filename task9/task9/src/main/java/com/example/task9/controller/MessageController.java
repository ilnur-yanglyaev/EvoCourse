package com.example.task9.controller;

import com.example.task9.dto.Message;
import com.example.task9.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private List<Message> messages = new ArrayList<>() {{
        add(new Message(1, "Hello World", "This is the first message.", LocalDateTime.now()));
        add(new Message(2, "Spring Boot", "Learning Spring Boot is fun!", LocalDateTime.now()));
        add(new Message(3, "REST API", "Building REST APIs with Java.", LocalDateTime.now()));
        add(new Message(4, "Java", "Java is a versatile programming language.", LocalDateTime.now()));
        add(new Message(5, "Postman", "Postman is great for testing APIs.", LocalDateTime.now()));
    }};


    @GetMapping("/message")
    public ResponseEntity<List<Message>> getAllMessages() {
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
//    @GetMapping("/message")
//    public Iterable<Person> getAllMessages() {
//        return messages;
//    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id) {
        Message message = findMessageById(id);
        if (message != null) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/message/{id}")
//    public Optional<Message> findMessageById(@PathVariable int id) {
//        return messages.stream().filter(p -> p.getId() == id).findFirst();
//    }


    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        Message existingMessage = findMessageById(id);
        if (existingMessage != null) {
            messages.set(messages.indexOf(existingMessage),message);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(addMessage(message), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p->p.getId()==id);
    }

    private Message findMessageById(int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }
}
