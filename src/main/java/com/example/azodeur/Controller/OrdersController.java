package com.example.azodeur.Controller;

import com.example.azodeur.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService service;


}
