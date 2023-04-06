package com.example.azodeur.Controller;


import com.example.azodeur.Service.ProductService;

import com.example.azodeur.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product_read")
    public  @ModelAttribute ResponseEntity<List<Product>> read(){
        List<Product> productAll = service.read();
        return ResponseEntity.ok(productAll);
    }
    @GetMapping("/quantity_read")
    public ResponseEntity<Integer> read_quantity(Integer productno){
        Product product = service.read_quantity(productno);
        return ResponseEntity.ok(product.getProductquantity());
    }


}
