package com.toyproject.toyBulletin.controller;

import com.toyproject.toyBulletin.dto.MemberDto;
import com.toyproject.toyBulletin.entity.Member;
import com.toyproject.toyBulletin.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {

    private MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberDto m, RedirectAttributes attributes) throws IllegalStateException {
        // Check if the data is appropriate (e.g., no duplicates)
        Member result = memberService.join(m);
        if (result != null) {
            // If the data is appropriate and the join is successful, return a success message
            return ResponseEntity.status(HttpStatus.OK).body("Welcome!");
        } else {
            // If the data is not appropriate, return an error message with an appropriate HTTP status code (e.g., 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody MemberDto m){
        /*
            1. JoinService의 login(MemberDao m) 호출 (m의 id, pw 매칭될 경우 true 반환)
            2. service의 login() 결과에 따라 ResponseEntity, body true or false return
         */
        Member result = memberService.login(m);
        if(result != null) return ResponseEntity.status(HttpStatus.OK).body(result);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Member> logout(@RequestBody HashMap<String, Long> data){
        Long id = data.get("id");
        Member result = memberService.logout(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/member-out")
    public ResponseEntity<Boolean> memberOut(@RequestBody MemberDto m){
        log.info("id : " + m.getId() + " pw : " + m.getPw());
        return null;
    }
}
