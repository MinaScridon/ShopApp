package com.demoApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "description", nullable = false)
    private String description;

    @Column(name= "price", nullable = false)
    private double price;

    @Column(name= "category", nullable = false)
    private String category;

    @Column(name = "imagePath")
    private String imagePath;


}
