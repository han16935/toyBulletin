package com.toyproject.toyBulletin.controller;

import com.toyproject.toyBulletin.dao.MemberDao;
import com.toyproject.toyBulletin.entity.Member;
import com.toyproject.toyBulletin.repository.MemberRepository;
import com.toyproject.toyBulletin.service.JoinService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@AllArgsConstructor
public class JoinController {

    private JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberDao m, RedirectAttributes attributes) throws IllegalStateException {
        // Check if the data is appropriate (e.g., no duplicates)
        Member result = joinService.join(m);
        if (result != null) {
            // If the data is appropriate and the join is successful, return a success message
            return ResponseEntity.status(HttpStatus.OK).body("Welcome!");
        } else {
            // If the data is not appropriate, return an error message with an appropriate HTTP status code (e.g., 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(@RequestBody MemberDao m){
        /*
            1. JoinService의 login(MemberDao m) 호출 (m의 id, pw 매칭될 경우 true 반환)
            2. service의 login() 결과에 따라 ResponseEntity, body true or false return
         */
        Member result = joinService.login(m);
        if(result != null) return ResponseEntity.status(HttpStatus.OK).body(result);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
