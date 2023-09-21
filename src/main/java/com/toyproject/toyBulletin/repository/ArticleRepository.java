package com.toyproject.toyBulletin.repository;

import com.toyproject.toyBulletin.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM ARTICLE WHERE CONTENT LIKE %:searchWord%", nativeQuery=true)
    List<Article> getSearchResult(@Param("searchWord") String searchWord);
}
