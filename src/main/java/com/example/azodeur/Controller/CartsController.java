package com.example.azodeur.Controller;

import com.example.azodeur.Dto.CartsList;
import com.example.azodeur.Service.CartsService;
import com.example.azodeur.entity.Carts;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartsController {
    @Autowired
    private CartsService service;

    @PostMapping("/read_carts")
    public ResponseEntity<List<CartsList>> read_carts(HttpSession session){
        String azodeurId = (String)session.getAttribute("azodeurId");
        return ResponseEntity.ok(service.read_carts(azodeurId));
    }
    @PostMapping("/carts_save")
    public ResponseEntity<Carts> save_carts(@ModelAttribute Carts carts, HttpSession session){
        String azodeurId =(String)session.getAttribute("azodeurId");
        carts.setAzodeurId(azodeurId);
        return ResponseEntity.ok(service.carts_save(carts));
    }
    @DeleteMapping("/carts_delete")
    public ResponseEntity<String> delete_carts(Integer cartsNo){
        service.delete(cartsNo);
        return ResponseEntity.ok("장바구니에서 삭제되었습니다.");
    }
    @GetMapping("/readCount")
    public ResponseEntity<Integer> readCount(HttpSession session){
        String azodeurId =(String)session.getAttribute("azodeurId");
        return ResponseEntity.ok(service.readCount(azodeurId));
    }
    @GetMapping("/readCartsNo")
    public ResponseEntity<Integer> readCartsNo(HttpSession session, String productNum){
        String azodeurId = (String)session.getAttribute("azodeurId");
        return ResponseEntity.ok(service.readCartsNo(azodeurId,productNum));
    }

    @PutMapping("/saveCount")
    public ResponseEntity<Carts> saveCount(Carts carts, HttpSession session){
        String azodeurId = (String)session.getAttribute("azodeurId");
        carts.setAzodeurId(azodeurId);
        return ResponseEntity.ok(service.saveCount(carts));
    }
//    public ResponseEntity<Integer> updateCarts(HttpSession session ,Carts carts){
//        String azodeurId = (String)session.getAttribute("azodeurId");
//        return ResponseEntity.ok(service.updateCarts(carts));
//    }

}
