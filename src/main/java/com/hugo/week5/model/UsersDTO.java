package com.hugo.week5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Users transformToUser(){

        return new Users(this.firstName, this.lastName, this.phoneNumber);

    }

}
