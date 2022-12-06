package com.hugo.week5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class Users {

    @Id
    @Email
    private String email;
    @Column(length = 50)
    @NotNull
    private String firstName;
    @Column(length = 50)
    @NotNull
    private String lastName;
    @Column
    @Pattern(regexp = "[+]503 \\d{8}|[+]503 \\d{4} \\d{4}")
    private String phoneNumber;

}
