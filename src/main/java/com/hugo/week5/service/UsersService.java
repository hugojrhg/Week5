package com.hugo.week5.service;

import com.hugo.week5.exception.UserAlreadyExistsException;
import com.hugo.week5.exception.UserNotFoundException;
import com.hugo.week5.model.Users;
import com.hugo.week5.model.UsersDTO;
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

    public UsersDTO getUserByEmail(String email) {

        validateIfUserExistsByEmail(email);

        Users user = usersRepository.findById(email).get();

        return new UsersDTO(user.getFirstName(), user.getLastName(), user.getPhoneNumber());

    }

    public Users createUser(Users user) throws UserAlreadyExistsException {

        if (usersRepository.existsById(user.getEmail())){
            throw new UserAlreadyExistsException(user.getEmail());
        }

        return usersRepository.save(user);

    }

    public void deleteUser(String email) {

        validateIfUserExistsByEmail(email);

        usersRepository.deleteById(email);

    }

    public void updateUser(String email, UsersDTO newUser) {

        validateIfUserExistsByEmail(email);

        Users oldUser = getUserByEmail(email).transformToUser();

        oldUser.setEmail(email);
        oldUser.setLastName(newUser.getLastName());
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setPhoneNumber(newUser.getPhoneNumber());

        usersRepository.save(oldUser);

    }

    public void validateIfUserExistsByEmail(String email){

        if (!usersRepository.existsById(email)){
            throw new UserNotFoundException(email);
        }

    }

}
