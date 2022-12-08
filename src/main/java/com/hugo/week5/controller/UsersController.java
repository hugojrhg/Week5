package com.hugo.week5.controller;

import com.hugo.week5.exception.UserAlreadyExistsException;
import com.hugo.week5.model.Users;
import com.hugo.week5.model.UsersDTO;
import com.hugo.week5.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<Object> getUsersByEmail(@PathVariable String email) {

        return new ResponseEntity<>(usersService.getUserByEmail(email), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody Users user) throws UserAlreadyExistsException {

        if (usersService.createUser(user) != null) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Object> deleteUser(@Valid @PathVariable String email) {

        usersService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UsersDTO user, @PathVariable String email) {

        usersService.updateUser(email, user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
