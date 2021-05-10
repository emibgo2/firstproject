package com.example.firstproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FirstController {

    // properties에 있는 hello.message 설정 부분에 대한 내용을 값으로 갖는다.
    @Value("${hello.message: 반갑습니다}")
    // properties에 hello.message 설정이 없으면 반갑습니다가 value로 들어감 :으로 디폴트 값 설정
    private String helloMessage;

    @Value("${hello.countries}")
    private List<String> countries;

    @Value("#{${hello.account}}")
    // 기존의 ${} 형태로 묶어주면 그냥 스트링형태로 인식하기 때문에
    // #{${}} 형태로 묶어주어야 맵형식(딕셔너리) 형태로 가능
    private Map<String,String> account;

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "이지원");
        return "goodbye";
    }

    @GetMapping("/hello")
    public String getHello() {
        return helloMessage+" "+ countries+"  name:"+ account.get("name")+" password: "+account.get("password");
    }


    @GetMapping("/hi") // URL과 mustache 파일을 맵핑해준다고 생각하면됨, hi가 웹브라우저의 URL
    public String niceToMeetYou(Model model) { // Model 객체 생성
        model.addAttribute("username", "이지원");
        // Model 생성과 해당 모델에 대한 변수 이름 변수 값을 지정해서 보내줌
        return "greetings"; // templates/greetings.mustache -> 알아서 브라우저로 전송
    }
}

