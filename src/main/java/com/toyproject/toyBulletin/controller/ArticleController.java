package com.toyproject.toyBulletin.controller;

import com.toyproject.toyBulletin.service.ArticleService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
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
}
