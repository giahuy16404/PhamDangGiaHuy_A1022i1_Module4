package com.service;

import com.model.ImageOfTheDay;
import com.model.ScoringScale;

import java.util.List;

public interface IImageOfTheDayService {
    List<ImageOfTheDay> findAll();

    boolean add(ImageOfTheDay imageOfTheDay);

    boolean likeComment(Long id);
    List<ScoringScale> finAllScoringScale();

}
