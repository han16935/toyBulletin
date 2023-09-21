package com.toyproject.toyBulletin.service;

import com.toyproject.toyBulletin.dao.ArticleDto;
import com.toyproject.toyBulletin.entity.Article;
import com.toyproject.toyBulletin.repository.ArticleRepository;
import com.toyproject.toyBulletin.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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

    public void update(ArticleDto articleDto, Long articleId){
        // articleDto - author id, title, content 저장
        Article article = new Article(articleId,
                memberRepository.findById(articleDto.getAuthor()).orElseThrow(
                        ()-> new IllegalArgumentException("해당 회원은 존재하지 않습니다!")
                ),
                articleDto.getTitle(),
                articleDto.getContent()
        );

        Article articleFromDb = articleRepository.findById(articleId).get();
        log.info(article.toString());
        log.info(articleFromDb.toString());
        if(articleFromDb != null) articleRepository.save(article);
    }
    public boolean isValidUpdateDelete(Long id, Long articleId) {
        return (memberRepository.findById(id).isPresent()
                && memberRepository.findById(id).get().getIsValid()
                && articleRepository.findById(articleId).isPresent()
                && articleRepository.findById(articleId).get().getAuthor()
                    == memberRepository.findById(id).get());
    }

    public Article getArticle(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물은 존재하지 않습니다!")
        );
    }

    public void delete(Long article_id) {
        articleRepository.delete(articleRepository.findById(article_id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시물은 존재하지 않습니다!")
        ));
    }
}
