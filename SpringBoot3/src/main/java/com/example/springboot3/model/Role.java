package com.example.springboot3.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Role {
    @Id
    @GeneratedValue
    private Long id;
}
