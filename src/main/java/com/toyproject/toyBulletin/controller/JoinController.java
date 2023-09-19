package com.toyproject.toyBulletin.controller;

import com.toyproject.toyBulletin.dao.MemberDao;
import com.toyproject.toyBulletin.entity.Member;
import com.toyproject.toyBulletin.repository.MemberRepository;
import com.toyproject.toyBulletin.service.JoinService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor
@Slf4j
public class JoinController {

    private JoinService joinService;
    private MemberRepository memberRepository;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberDao m, RedirectAttributes attributes) throws IllegalStateException {
        // Check if the data is appropriate (e.g., no duplicates)
            Member result = joinService.join(m);
        log.info(result.toString());
        if (result != null) {
            // If the data is appropriate and the join is successful, return a success message
            return ResponseEntity.status(HttpStatus.OK).body("Welcome!");
        } else {
            // If the data is not appropriate, return an error message with an appropriate HTTP status code (e.g., 400 Bad Request)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody MemberDao m){
        /*
            1. JoinService의 login(MemberDao m) 호출
            2.
         */
        boolean result = joinService.login(m);
        if(result == true) return ResponseEntity.status(HttpStatus.OK).body(true);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
}
