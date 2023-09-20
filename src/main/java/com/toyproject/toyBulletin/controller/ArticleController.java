package com.toyproject.toyBulletin.controller;

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
    public String getArticles(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("articles", articleService.getAllArticles());
        return "/articles";
    }
}
