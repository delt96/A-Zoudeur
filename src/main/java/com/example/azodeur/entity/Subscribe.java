package com.example.azodeur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(
        name = "SQE_subscribeNo",
        sequenceName = "SQE_subscribeNo",
        initialValue = 1,
        allocationSize = 1
)
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQE_subscribeNo")
    private Integer subscribeNo;
    private Date subscribeDate;
    private String azodeurId;
    private Long subscribeStatus;
    private String selectOdeur;

}