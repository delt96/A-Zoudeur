package com.example.azodeur.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    private Integer productno;
    private String productname;
    private Integer productcost;
    private Integer productquantity;
    private String perfumer;
    private String imageno;
    private String image;

}
