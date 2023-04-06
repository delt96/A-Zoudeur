package com.example.azodeur.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Member {
    private String userName;
    @Id
    private String azodeurId;
    private String azodeurPw;
    private LocalDate birthday;
    private Integer gender;
    private String email;
    private String address;

}
