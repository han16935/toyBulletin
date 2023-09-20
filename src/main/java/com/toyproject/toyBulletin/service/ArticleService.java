package com.toyproject.toyBulletin.service;

import com.toyproject.toyBulletin.entity.Article;
import com.toyproject.toyBulletin.repository.ArticleRepository;
import com.toyproject.toyBulletin.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {
    private MemberRepository memberRepository;
    private ArticleRepository articleRepository;
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public boolean isValid(Long id) {
        if(memberRepository.findById(id).isPresent())
          return memberRepository.findById(id).get().getIsValid();
        else return false;
    }
}
