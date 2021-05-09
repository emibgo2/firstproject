package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity // DB가 해당 객체를 인식 가능
@Data
public class  Article {

    @Id // 대표값을 지정! like 주민등록번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 1,2,3, ... 자동 생성 어노테이션!
    @Column
    private String title;
    @Column
    private String content;

}
