package com.example.shopr1.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue(value = "LP")
//@Table(uniqueConstraints =@UniqueConstraint(columnNames = {"title", "performer"}))
@NoArgsConstructor
@AllArgsConstructor
public class Lp extends Article{
    private String performer;
    @Enumerated(EnumType.STRING)
    private LpGenre lpGenre;


//    @Builder
//    protected Lp(Long id, String title, Double price, String supplierId, String performer, LpGenre lpGenre){
//        super(id, title, price, supplierId);
//        this.performer = performer;
//        this.lpGenre = lpGenre;
//    }
}
