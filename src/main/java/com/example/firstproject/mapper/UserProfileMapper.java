package com.example.firstproject.mapper;

import com.example.firstproject.controller.ArticleController;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserProfileMapper {
    @Select("SELECT * FROM UserProfile WHERE id=${id}")
    ArticleController getArticle(@Param("id") String id);
}
