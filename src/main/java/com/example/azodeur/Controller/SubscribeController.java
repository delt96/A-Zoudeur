package com.example.azodeur.Controller;

import com.example.azodeur.Service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SubscribeController {
    @Autowired
    private SubscribeService service;

}
