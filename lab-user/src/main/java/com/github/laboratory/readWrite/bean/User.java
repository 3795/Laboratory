package com.github.laboratory.readWrite.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
