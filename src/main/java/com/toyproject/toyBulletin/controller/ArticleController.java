package com.toyproject.toyBulletin.controller;

import com.toyproject.toyBulletin.dao.ArticleDto;
import com.toyproject.toyBulletin.service.ArticleService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Slf4j
public class ArticleController {

    private ArticleService articleService;

    @GetMapping("/articles")
    public String getArticles(@RequestParam Long id, Model model, HttpServletResponse response){
        if(!articleService.isValid(id)) {
            response.setHeader("Location", "http://localhost:8080");
            response.setStatus(401); // HTTP 401 Found
            return null; // No need to return a template name
        }
        model.addAttribute("id", id);
        model.addAttribute("articles", articleService.getAllArticles());
        return "/article/articles";
    }

    @GetMapping("/article/create")
    public String goToCreateArticle(@RequestParam Long id, Model model){
        model.addAttribute("id", id);
        return "/article/createArticle";
    }
    @PostMapping("/article/create")
    public String createArticle(@RequestParam Long id, ArticleDto articleDto){
        log.info(articleDto.toString());
        articleService.save(articleDto);
        return "redirect:/articles?id=" + id;
    }

    @GetMapping("/article/update")
    public String isValidUpdate(@RequestParam Long id,
                                @RequestParam Long article_id,
                                Model model,
                                HttpServletResponse response){

        if(!articleService.isValidUpdateDelete(id, article_id)){
            response.setHeader("Location", "http://localhost:8080");
            response.setStatus(401); // HTTP 401 Found
            return null; // No need to return a template name
        }
        model.addAttribute("id", id);
        model.addAttribute("article", articleService.getArticle(article_id));
        return "/article/updateArticle";
    }

    @PostMapping("/article/update")
    public String updateArticle(@RequestParam Long id,
                                @RequestParam Long article_id,
                                ArticleDto articleDto){
        log.info(articleDto.toString());
        articleService.update(articleDto, article_id);
        return "redirect:/articles?id=" + id;
    }
}
