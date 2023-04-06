package com.example.azodeur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "SQE_order_no",
        sequenceName = "SQE_order_no",
        initialValue = 1,
        allocationSize = 1
)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQE_order_no")
    private Integer orderno;
    private Integer productno;
    private String AzodeurId;
    private Date ordaerdate;
    private Integer totalcost;
    private Integer count;
}
