package com.toyproject.toyBulletin.service;

import com.toyproject.toyBulletin.entity.Article;
import com.toyproject.toyBulletin.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    private ArticleRepository articleRepository;
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
