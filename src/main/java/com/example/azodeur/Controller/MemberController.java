package com.example.azodeur.Controller;

import com.example.azodeur.Service.MemberService;
import com.example.azodeur.entity.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@Controller
public class MemberController {
    @Autowired
    private MemberService service;

    //회원가입시 아이디가 같을 경우 에러 시작
    @GetMapping("/id_check")
    public ResponseEntity<String> idcheck(String azodeurId ){
        boolean result =service.idcheck(azodeurId);
        if(result)
            return ResponseEntity.ok("사용가능한 아이디입니다.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(("아이디가 사용중입니다."));
    }
    //회원가입시 아이디가 같을 경우 에러 끝

    // 회원가입 시작
    @PostMapping("/create")
    public ResponseEntity<String> signup (@ModelAttribute Member member){
        service.signup(member);
        return ResponseEntity.ok("회원가입 성공");
    }
    // 회원가입 끝

    //로그인 여부 확인 시작
    @GetMapping("is_login")
    public ResponseEntity<Boolean> isLogin(HttpSession session){
        if(session.getAttribute("azodeurId")== null)
            return ResponseEntity.ok(false);
        return ResponseEntity.ok(true);
    }
    //로그인 여부 확인 끝

    //로그인 시작
    @PostMapping("/login")
    public ResponseEntity<String> login(String azodeurId, String azodeurPw, HttpSession session){
        boolean loginStatus =service.login(azodeurId, azodeurPw);
        if(loginStatus ==true) {
            session.setAttribute("azodeurId", azodeurId);
            return ResponseEntity.ok("로그인 성공");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("로그인 실패");
    }
    //로그인 끝

    //로그아웃 시작
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
    //로그아웃 끝

    //유저 읽어오기 시작
    @GetMapping("/read")
    public ResponseEntity<Member> userInfo(HttpSession session) {
        String azodeurId = (String)session.getAttribute("azodeurId");
        Member member = service.read(azodeurId);
        return ResponseEntity.ok(member);
    }
    //유저 읽어오기 끝

    //회원탈퇴 시작
    @DeleteMapping("/delete")
    public ResponseEntity<String> withdrawal (HttpSession session){
        String azodeurId = (String)session.getAttribute("azodeurId");
        service.delete(azodeurId);
        session.invalidate();
        return ResponseEntity.ok("회원탈퇴가 성공적으로 완료되었습니다.");
    }
    //회원탈퇴 끝

    //비밀번호 확인 시작
    @PostMapping("/pass_check")
    public ResponseEntity<String> pass_check(HttpSession session ,String azodeurPw){
        String azodeurId = (String)session.getAttribute("azodeurId");
        Member member =service.read(azodeurId);
        if(member.getAzodeurPw() == azodeurPw){
            return ResponseEntity.ok("비밀번호가 확인되었습니다.");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("비밀번호가 맞지 않습니다.");
    }
    //비밀번호 확인 끝

    //유저 정보 변경 시작
    @PutMapping("/changeInfo")
    public ResponseEntity<String> changeInfo(@ModelAttribute Member member){
        service.changeInfo(member);
        return ResponseEntity.ok("고객님의 정보를 성공적으로 변경하였습니다.");
    }
    //유저 정보 변경 끝


}
