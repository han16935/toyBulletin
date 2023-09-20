package com.toyproject.toyBulletin.service;

import com.toyproject.toyBulletin.entity.Article;
import com.toyproject.toyBulletin.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ArticleService {
    private ArticleRepository articleRepository;
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
