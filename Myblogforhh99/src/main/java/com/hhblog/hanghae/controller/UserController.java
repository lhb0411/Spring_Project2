package com.hhblog.hanghae.controller;

import com.hhblog.hanghae.domain.SignupRequestDto;
import com.hhblog.hanghae.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지 // thymleaf에 의해 login string만 내려주면 login.html을 찾아 보여줌
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 로그인 실패시 나오는 페이지
    @GetMapping("/user/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }


    // 회원 가입 요청 처리 & 중복및 오류체크
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto, Model model) {
        try {
            userService.registerUser(requestDto);
        }catch (IllegalArgumentException e){
            System.out.println(e);
            model.addAttribute("message", e.getMessage());
            return "signup";
        }
        return "redirect:/user/login";
    }


    //카카오
    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(String code) {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);

        return "redirect:/";
        }
}