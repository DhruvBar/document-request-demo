package com.example.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
