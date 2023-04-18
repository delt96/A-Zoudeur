package com.example.azodeur.Service;

import com.example.azodeur.Repository.MemberRepository;
import com.example.azodeur.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository dao;

    public void signup (Member member){
        member.setStatus(1);
        dao.save(member);
    }
    public boolean idcheck(String azodeurId){

        return !dao.existsByAzodeurId(azodeurId);
    }
    //로그인
    public boolean login (String azodeurId ,String azodeurPw) {
        Member member =dao.findByAzodeurId(azodeurId);
        if (member == null) return false;
        return  member.getAzodeurPw().equals(azodeurPw);
    }
    public Member read (String azodeurId){
        return dao.findByAzodeurId(azodeurId);
    }
    public void delete(String azodeurId){
         dao.deleteById(azodeurId);
    }
    public void changeInfo(Member member){
        dao.save(member);
    }


}
