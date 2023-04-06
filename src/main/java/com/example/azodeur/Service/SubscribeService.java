package com.example.azodeur.Service;

import com.example.azodeur.Repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {
    @Autowired
    private SubscribeRepository dao ;

}
