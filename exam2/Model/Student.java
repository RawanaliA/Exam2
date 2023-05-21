package com.example.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "The id should not be empty")
    private  int id;
    @NotEmpty(message = "The Name should not be empty")
    private String name;
    @NotNull(message = "The age should not be empty")
    private int age;
    @NotNull(message = "The major should not be empty")
    private String major;
}
