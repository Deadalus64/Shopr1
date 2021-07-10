package com.example.shopr1.domain;

import lombok.Data;

import javax.persistence.*;


@MappedSuperclass
@Data
public abstract class Article {


    private String title;
    private Double price;
    @Column(insertable = false, updatable = false)
//    private String type;
    private String supplierId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected Article(){


    }


    public Article( Long id, String title, Double price, String supplierId) {
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
        this.id = id;
    }
/*
    public Article(String title, Double price, String type, String supplierId, Long id) {
    }*/
}
