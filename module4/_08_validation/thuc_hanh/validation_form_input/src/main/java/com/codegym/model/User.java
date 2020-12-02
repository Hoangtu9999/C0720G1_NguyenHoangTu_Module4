package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotEmpty
    @Size(min = 2 , max = 30)
    private String name;

    @Min(18)
    private int age;
}
