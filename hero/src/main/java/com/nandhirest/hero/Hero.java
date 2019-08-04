package com.voizfonica.webapp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String heroName;
    private String heroMovie;

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroMovie() {
        return heroMovie;
    }

    public void setHeroMovie(String heroMovie) {
        this.heroMovie = heroMovie;
    }
}
