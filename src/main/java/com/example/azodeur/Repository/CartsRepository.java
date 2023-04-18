package com.example.azodeur.Repository;

import com.example.azodeur.entity.Carts;

import com.example.azodeur.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartsRepository extends JpaRepository<Carts, Integer> {

    Integer countByAzodeurId(String azodeurId);

//    Integer countByAzodeurIdAndProductNo(String azodeurId, Integer ProductNo);



}
