package com.example.azodeur.Repository;

import com.example.azodeur.entity.Carts;

import com.example.azodeur.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartsRepository extends JpaRepository<Carts, Integer> {

    @Query(value = "SELECT NVL(c.CARTS_NO,'') CARTS_NO, \n" +
            "       NVL(c.COUNT, '') COUNT , \n" +
            "       NVL(C.PRODUCT_NUM ,'') PRODUCT_NUM, \n" +
            "       NVL(p.PRODUCTNAME,'')  PRODUCTNAME, \n" +
            "       NVL(p.PRODUCTCOST,'')  PRODUCTCOST, \n" +
            "       NVL(p.productquantity,'')  PRODUCTQUANTITY , \n" +
            "       NVL(p.perfumer ,'') PERFUMER , \n" +
            "       NVL(p.image,'') IMAGE , \n" +
            "       NVL(P.IMAGENO ,'') IMAGENO , \n" +
            "       NVL(c.azodeur_id,'') AZODEUR_ID, \n" +
            "       NVL(p.PRODUCTNO ,'') PRODUCTNO \n" +
            "  FROM carts C ,PRODUCT P , MEMBER M \n" +
            " WHERE C.PRODUCT_NUM = P.PRODUCTNO  \n" +
            "   AND C.AZODEUR_ID = m.AZODEUR_ID \n" +
            "   AND C.AZODEUR_ID = ?  ", nativeQuery = true)
    List<Carts> findCartsDto(String azodeurId);

    Integer countByAzodeurId(String azodeurId);

    Integer countByAzodeurIdAndProductNum(String azodeurId, String ProductNum);



}
