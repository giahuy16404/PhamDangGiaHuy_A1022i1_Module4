package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ScoringScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSco;
    private String name;
    @OneToMany(mappedBy = "scoringScale", cascade = CascadeType.ALL)
    private List<ImageOfTheDay> imagesOfTheDay;

    public ScoringScale(int idSco, String name, List<ImageOfTheDay> imagesOfTheDay) {
        this.idSco = idSco;
        this.name = name;
        this.imagesOfTheDay = imagesOfTheDay;
    }

    public ScoringScale() {
    }

    public int getIdSco() {
        return idSco;
    }

    public void setIdSco(int idSco) {
        this.idSco = idSco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageOfTheDay> getImagesOfTheDay() {
        return imagesOfTheDay;
    }

    public void setImagesOfTheDay(List<ImageOfTheDay> imagesOfTheDay) {
        this.imagesOfTheDay = imagesOfTheDay;
    }
}
