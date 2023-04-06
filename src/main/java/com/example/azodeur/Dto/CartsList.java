package com.example.azodeur.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartsList {

     private Integer cartsNo;

     private Integer count;

     private Integer product_no;

     private String productname;

     private Integer productcost;

     private Integer productquantity;

     private String perfumer;

     private String image;

     private String imageno;

     private String azodeurId;
}
