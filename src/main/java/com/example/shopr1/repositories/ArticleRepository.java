package com.example.shopr1.repositories;

import com.example.shopr1.domain.Article;
import com.example.shopr1.domain.Book;
import com.example.shopr1.domain.Game;
import com.example.shopr1.domain.Lp;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Article article) {
        entityManager.persist(article);
    }

    public Article findById(Long id, Class<? extends Article> type) {
        return entityManager.find(type, id);
    }

    public java.util.List<Article> findAll() {
        java.util.List<Article> articles = new ArrayList<>();
        articles.addAll(entityManager.createQuery("select g from Game g", Game.class).getResultList());
        articles.addAll(entityManager.createQuery("select l from Lp l", Lp.class).getResultList());
        articles.addAll(entityManager.createQuery("select b from Book b", Book.class).getResultList());
        return articles;
    }

    public List<Book> findAllBooks() {
        List<Book> book = entityManager.createQuery("select b from Book b", Book.class).getResultList();

        return book;
    }

    public List<Game> findAllGame() {
        return entityManager.createQuery("select g from Game g", Game.class).getResultList();
    }

    public List<Lp> findAllLp() {
        return entityManager.createQuery("select l from Lp l", Lp.class).getResultList();
    }
}

