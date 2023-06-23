package com.repository;

import com.model.ImageOfTheDay;
import com.model.ScoringScale;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface IImageOfTheDayRepository {
    List<ImageOfTheDay> findAll();

    List<ScoringScale> finAllScoringScale();

    boolean add(ImageOfTheDay imageOfTheDay);

    boolean likeComment(Long id);
}
