package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleController {


    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결!
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PutMapping("/articles")
    public Article putArticle(Article form) {
        return articleRepository.save(form);
    }

    @PostMapping("/articles")
    public Article postArticle(Article form) {
        return articleRepository.save(form);
    }

    @DeleteMapping("/articles")
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    // id로 DB 데이터 확인
    @GetMapping("/articles")
    public Article getArticle(int id) {
        return articleRepository.findById(id).orElse(null);
        // 값이 있을때는 id를 리턴하고 없으면 null 을 리턴
    }


    // DB의 모든 목록 확인
    @GetMapping("/articles/list")
    public List<Article> getArticelList() {
        return (List<Article>) articleRepository.findAll();
    }

    @GetMapping("/articles/content")
    public List<Article>  getArticel(String content) {
        return (List<Article>)  articleRepository.findByContent(content);
    }
}
