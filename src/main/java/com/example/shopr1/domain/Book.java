package com.example.shopr1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "GENRE")
public abstract class Book extends Article {


    private String isbn;
    private int pages;
    private String author;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
//@Builder
//    protected Book(Long id, String title, Double price, String supplierId, String author, String isbn, int pages ){
//        super(id, title, price, supplierId);
//        this.author = author;
//        this.pages = pages;
//        this.isbn = isbn;
//
//    }

}

