package com.atl.academy.lesson30.controllers;

import com.atl.academy.lesson30.exceptions.RecordNotFoundException;
import com.atl.academy.lesson30.models.User;
import com.atl.academy.lesson30.services.UsersService;
import org.hibernate.type.SerializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(usersService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        Optional<User> user = usersService.getById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("User is not found");
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User newUser) {
        User user = usersService.save(newUser);
        if (user == null) {
            throw new SerializationException("User is not saved!", new Exception());
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }
}