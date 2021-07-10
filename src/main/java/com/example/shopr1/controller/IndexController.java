package com.example.shopr1.controller;

import com.example.shopr1.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/getAllBooks")
    public String getAllBooks(Model model) {
        model.addAttribute("books", articleService.findAllBooks());
        return "Books";
    }
    @GetMapping("/getAllGames")
    public String getAllGames(Model model) {
        model.addAttribute("games", articleService.findAllGames());
        return "Games";

    }
    @GetMapping("/getAllLps")
    public String getAllLps(Model model) {
        model.addAttribute("lps", articleService.findAllLps());
        return "Lp";

    }
}