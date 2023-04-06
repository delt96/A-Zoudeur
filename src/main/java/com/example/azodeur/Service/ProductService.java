package com.example.azodeur.Service;

import com.example.azodeur.Repository.ProductRepository;

import com.example.azodeur.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository dao;

    public List<Product> read(){
        return dao.findAll();
    }
    public Product read_quantity(Integer productno) {
        return dao.findByProductno(productno);
    }


}
