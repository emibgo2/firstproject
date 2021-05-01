package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "이지원");
        return "goodbye";
    }

    @GetMapping("/hi") // URL과 mustache 파일을 맵핑해준다고 생각하면됨, hi가 웹브라우저의 URL
    public String niceToMeetYou(Model model) { // Model 객체 생성
        model.addAttribute("username", "이지원");
        // Model 생성과 해당 모델에 대한 변수 이름 변수 값을 지정해서 보내줌
        return "greetings"; // templates/greetings.mustache -> 알아서 브라우저로 전송
    }
}

