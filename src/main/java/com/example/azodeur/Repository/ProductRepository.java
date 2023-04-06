package com.example.azodeur.Repository;

import com.example.azodeur.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findByProductno(Integer productno) ;

}
