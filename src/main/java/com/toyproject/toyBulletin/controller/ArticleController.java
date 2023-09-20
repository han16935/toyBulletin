package com.toyproject.toyBulletin.controller;

import com.toyproject.toyBulletin.service.ArticleService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class ArticleController {

    private ArticleService articleService;

    @GetMapping("/{id}/articles")
    public String getArticles(@PathVariable Long id, Model model, HttpServletResponse response){
        if(!articleService.isValid(id)) {
            response.setHeader("Location", "http://localhost:8080");
            response.setStatus(401); // HTTP 401 Found
            return null; // No need to return a template name
        }
        model.addAttribute("id", id);
        model.addAttribute("articles", articleService.getAllArticles());
        return "/articles";
    }
}
