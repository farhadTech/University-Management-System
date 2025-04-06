package com.example.ums.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Enter first name: ")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Enter last name: ")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Enter email: ")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}$",
            message = "Password must include at least one uppercase letter, one number, and one special character"
    )
    @NotBlank(message = "Enter password: ")
    @Column(name = "password", nullable = false)
    @Size(
            min = 8, max = 30,
            message = "password should be greater than 8 and less than 30."
    )
    private String password;

    @Pattern(regexp = "^[1-9]{10}$", message = "Enter a valid 10-digit phone number")
    @NotBlank(message = "Enter phone number: ")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @NotBlank(message = "Enter address: ")
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "Enter city: ")
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "Enter state name:")
    @Column(name = "state", nullable = false)
    private String state;

    @NotBlank(message = "Enter zip code: ")
    @Column(name = "zip", nullable = false)
    private String zipCode;

    @Override
    public String toString() {
        return id + ", " + firstName + ", " + lastName + ", " + email + ", "
                + phone + ", " + address + ", " + city + ", " + state + ", " + zipCode;
    }
}
