package com.example.shopr1.services;

import com.example.shopr1.domain.Article;
import com.example.shopr1.domain.Book;
import com.example.shopr1.domain.Game;
import com.example.shopr1.domain.Lp;
import com.example.shopr1.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return articleRepository.findAllBooks();
    }

    public List<Game> findAllGames() {
        return articleRepository.findAllGame();
    }

    public List<Lp> findAllLps() {
        return articleRepository.findAllLp();
    }
}