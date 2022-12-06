package com.hugo.week5.service;

import com.hugo.week5.model.Users;
import com.hugo.week5.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserByEmail(String email) {

        if (usersRepository.findById(email).isPresent()) {
            return usersRepository.findById(email).get();
        }
        return null;

    }

    public Users createUser(Users user) throws Exception {
        if (usersRepository.existsById(user.getEmail())){
            throw new Exception("The user already exists with the given email account");
        }
        return usersRepository.save(user);
    }

    public void deleteUser(String email) {
        usersRepository.deleteById(email);
    }

    public void updateUser(String email, Users newUser) {

        Users oldUser = getUserByEmail(email);

        oldUser.setLastName(newUser.getLastName());
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setPhoneNumber(newUser.getPhoneNumber());

        usersRepository.save(oldUser);

    }

}
