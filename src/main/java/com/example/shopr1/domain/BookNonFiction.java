package com.example.shopr1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "Book_Non_Fiction")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class BookNonFiction extends Book{
    @Enumerated(EnumType.STRING)
    private BookSubject bookSubject;

//    @Builder
//    public BookNonFiction(Long id, String title, Double price, String supplierId, String author, String isbn, int pages ){
//        super(id, title, price, supplierId, author, isbn, pages);
//        this.subject = subject;
//    }

}
