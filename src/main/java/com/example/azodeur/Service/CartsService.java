package com.example.azodeur.Service;


import com.example.azodeur.Dto.CartsList;
import com.example.azodeur.Repository.CartsRepository;
import com.example.azodeur.entity.Carts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartsService {

    @Autowired
    private CartsRepository dao;

    public List<CartsList> read_carts(String userId){
        List<Carts> cart = dao.findCartsDto(userId);
        List<CartsList> cartsLists =new ArrayList<CartsList>();
        for(int i= 0;i<cart.size();i++){
            cartsLists.add(new CartsList());
            cartsLists.get(i).setCartsNo(cart.get(i).getCartsNo());
            cartsLists.get(i).setCount(cart.get(i).getCount());
            cartsLists.get(i).setProduct_no(cart.get(i).getProductList().getProductno());
            cartsLists.get(i).setAzodeurId(cart.get(i).getAzodeurId());
            cartsLists.get(i).setProductname(cart.get(i).getProductList().getProductname());
            cartsLists.get(i).setProductcost(cart.get(i).getProductList().getProductcost());
            cartsLists.get(i).setProductquantity(cart.get(i).getProductList().getProductquantity());
            cartsLists.get(i).setPerfumer(cart.get(i).getProductList().getPerfumer());
            cartsLists.get(i).setImage(cart.get(i).getProductList().getImage());
        }
        return cartsLists;
    }
    public Carts carts_save(Carts cart){
        return dao.save(cart);
    }
    public void delete(Integer cartsNo){
        dao.deleteById(cartsNo);
    }

    public Integer readCount(String azodeurId) {
       return dao.countByAzodeurId(azodeurId);
    }
    public Integer readCartsNo(String azodeurId, String productNum){
       return dao.countByAzodeurIdAndProductNum(azodeurId, productNum);
    }
    public Carts saveCount(Carts carts){
        return dao.save(carts);
    }

}
