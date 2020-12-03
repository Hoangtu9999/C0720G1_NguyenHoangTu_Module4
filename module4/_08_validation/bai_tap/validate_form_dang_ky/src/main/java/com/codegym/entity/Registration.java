package com.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @NotBlank(message = "Please do not leave it empty!")
    @Size(min = 5 , max = 45, message = "Length must be 5 and less than 45!")
    private String firstName;

    @Author
    @NotBlank(message = "Please do not leave it empty!")
    @Size(min = 5 , max = 45, message = "Length must be 5 and less than 45!")
    private String lastName;

    @NotBlank(message = "Please do not leave it empty!")
    @Pattern(regexp = "//d{9}", message = "Phone number must be 9 digits!")
    private String phoneNumber;

    @NotBlank(message = "Please do not leave it empty!")
    @Min(value = 18 , message = "The minimum age is 18!")
    private String age;

    @NotBlank(message = "Please do not leave it empty!")
    @Email(message = "Must be in the correct format xxx@.xxx!")
    private String email;
}
