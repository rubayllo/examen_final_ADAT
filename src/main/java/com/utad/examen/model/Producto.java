package com.utad.examen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ejemplo_examen")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Double stock;
}