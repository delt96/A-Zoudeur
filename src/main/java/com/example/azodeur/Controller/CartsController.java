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
    private String azodeurId;

    //cart 불러오기 시작
    @PostMapping("/read_carts")
    public ResponseEntity<List<CartsList>> read_carts(HttpSession session){
        String azodeurId = (String)session.getAttribute("azodeurId");
        return ResponseEntity.ok(service.read_carts(azodeurId));
    }
    //cart 불러오기 끝

    //cart 저장 시작
    @PostMapping("/carts_save")
    public ResponseEntity<Carts> save_carts(@ModelAttribute Carts carts, HttpSession session){
        String azodeurId =(String)session.getAttribute("azodeurId");
        carts.setAzodeurId(azodeurId);
        return ResponseEntity.ok(service.carts_save(carts));
    }
    //cart 저장 끝

    //cart 삭제 시작
    @DeleteMapping("/carts_delete")
    public ResponseEntity<String> delete_carts(Integer cartsNo){
        service.delete(cartsNo);
        return ResponseEntity.ok("장바구니에서 삭제되었습니다.");
    }
    //cart 삭제 끝

    //cart 몇개인지 확인 시작
    @GetMapping("/readCount")
    public ResponseEntity<Integer> readCount(HttpSession session){
        String azodeurId =(String)session.getAttribute("azodeurId");
        return ResponseEntity.ok(service.readCount(azodeurId));
    }
    //cart 몇개인지 확인 끝

    //cart 물건 있는지 확인 시작
    @GetMapping("/readCartsNo")
    public ResponseEntity<Integer> readCartsNo(HttpSession session, Integer productNum){
        String azodeurId = (String)session.getAttribute("azodeurId");
        return ResponseEntity.ok(service.readCartsNo(azodeurId,productNum));
    }
    //cart 물건 있는지 확인 끝

    //cart 물건 갯수 수정 시작
    @PutMapping("/saveCount")
    public ResponseEntity<Carts> saveCount(Carts carts, HttpSession session){
        String azodeurId = (String)session.getAttribute("azodeurId");
        carts.setAzodeurId(azodeurId);
        return ResponseEntity.ok(service.saveCount(carts));
    }
    //cart 물건 갯수 수정 끝


}
