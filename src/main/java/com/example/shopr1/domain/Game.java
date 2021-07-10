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
@Entity
@Data
@DiscriminatorValue(value = "GAME")
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title", "publisher"})publisher)
@NoArgsConstructor
@AllArgsConstructor

public class Game extends Article {

    private String publisher;
    private int minAge;
    @Enumerated(EnumType.STRING)
    private GameGenre gameGenre;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public GameGenre getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(GameGenre gameGenre) {
        this.gameGenre = gameGenre;
    }
/*    @Builder
    protected Game(Long id, String title, Double price, String supplierId, String publisher, int minAge, GameGenre gameGenre) {
        super(id, title, price, supplierId);
        this.publisher = publisher;
        this.minAge = minAge;
        this.gameGenre = gameGenre;
    }*/
}





