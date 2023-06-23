package com.service;

import com.model.ImageOfTheDay;
import com.model.ScoringScale;
import com.repository.IImageOfTheDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageOfTheDayService implements IImageOfTheDayService {
    @Autowired
    private IImageOfTheDayRepository iImageOfTheDayRepository;

    @Override
    public List<ImageOfTheDay> findAll() {
        return iImageOfTheDayRepository.findAll();
    }

    @Override
    public boolean add(ImageOfTheDay imageOfTheDay) {
        try {
            iImageOfTheDayRepository.add(imageOfTheDay);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean likeComment(Long id) {
        return iImageOfTheDayRepository.likeComment(id);
    }

    @Override
    public List<ScoringScale> finAllScoringScale() {
        return iImageOfTheDayRepository.finAllScoringScale();
    }
}
