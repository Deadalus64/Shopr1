package com.example.shopr1.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "Book_Fiction")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class BookFiction extends Book {
    private String description;
    @Enumerated(EnumType.STRING)

    private BookGenre bookGenre;



//    @Builder
//
//    public BookFiction(Long id, String title, Double price, String supplierId, String author, String isbn, int pages){
//        super(id, title, price, supplierId, author, isbn, pages);
//
//        this.bookGenre = bookGenre;
//        this.description = description;
//
//    }
}