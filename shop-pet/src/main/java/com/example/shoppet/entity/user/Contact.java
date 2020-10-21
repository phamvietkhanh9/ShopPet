package com.example.shoppet.entity.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contact" )
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String message;

}