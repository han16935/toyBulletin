package com.toyproject.toyBulletin.service;

import com.toyproject.toyBulletin.dao.ArticleDto;
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

    public void save(ArticleDto articleDto) {
        articleRepository.save(new Article(
                memberRepository.findById(articleDto.getAuthor()).orElseThrow(
                        ()-> new IllegalArgumentException("해당 회원은 존재하지 않습니다!")
                ),
                articleDto.getTitle(),
                articleDto.getContent()
        ));
    }
}
