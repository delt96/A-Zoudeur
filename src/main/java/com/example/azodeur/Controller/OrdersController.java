package com.example.azodeur.Controller;

import com.example.azodeur.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService service;

    @GetMapping("/payment")
    public String payment(){
        return "/A-Zodeur_paymemt.html";
    }

    @PutMapping("/orders_insert")
    public ResponseEntity<?> orders_insert(){
//        if(service.orders_insert()>0 ){
            return ResponseEntity.ok("주문이 완료되었습니다.");
//        }else{
//            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("주문이 실패하였습니다.");
//        }

    }
}
