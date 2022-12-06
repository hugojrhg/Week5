package com.hugo.week5.controller;

import com.hugo.week5.model.Users;
import com.hugo.week5.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users")
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping(value = "/users/{email}")
    public Users getUsersByEmail(@PathVariable String email){
        return usersService.getUserByEmail(email);
    }

    @PostMapping(value = "/users")
    public Users createUser(@RequestBody Users user) throws Exception {
        return usersService.createUser(user);
    }

    @DeleteMapping(value = "/users/{email}")
    public void deleteUser(@PathVariable String email){
        usersService.deleteUser(email);
    }

    @PutMapping(value = "/users/{email}")
    public void updateUser(@RequestBody Users user, @PathVariable String email){
        usersService.updateUser(email, user);
    }

}
