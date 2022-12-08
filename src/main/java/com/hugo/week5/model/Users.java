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
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USERS")
public class Users {

    @Id
    @Email
    private String email;
    @Column
    @Length(max = 50, message = "")
    @NotNull(message = "First Name can't be null")
    private String firstName;
    @Column
    @Length(max = 50, message = "")
    @NotNull(message = "Last Name can't be null")
    private String lastName;
    @Column
    @Pattern(regexp = "[+]503 \\d{8}|[+]503 \\d{4} \\d{4}", message =
            "The Phone Number needs to follow the pattern: [+]503 \\d{8}|[+]503 \\d{4} \\d{4}")
    private String phoneNumber;

    public Users(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}
