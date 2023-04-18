package com.example.azodeur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "CARTS_NO",
        sequenceName = "CARTS_NO",
        initialValue = 1,
        allocationSize = 1
)
@DynamicUpdate
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARTS_NO")
    @Column(name = "CARTS_NO")
    private Integer cartsNo;
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "product_no")
    private Product productList ;
    private String azodeurId;
}
