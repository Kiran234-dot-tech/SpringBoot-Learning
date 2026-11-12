package com.e_com.e_com_project.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private double price;
    private String description;
    private String brand;
    private String category;
    private int quantity;
    private boolean available;
    private String releaseDate;

    private String imageType;
    private String imageName;
    @Lob
    private byte[] imageData;
}
