package com.repository;

import com.model.ImageOfTheDay;
import com.model.ScoringScale;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImageOfTheDayRepository implements IImageOfTheDayRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ImageOfTheDay> findAll() {
        List<ImageOfTheDay> list;
        TypedQuery<ImageOfTheDay> query = (TypedQuery<ImageOfTheDay>) entityManager.createNativeQuery(QueryDB.FIND_ALL, ImageOfTheDay.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public List<ScoringScale> finAllScoringScale() {
        List<ScoringScale> list;
        TypedQuery<ScoringScale> query = (TypedQuery<ScoringScale>) entityManager.createNativeQuery(QueryDB.FIND_ALL_ScoringScale, ScoringScale.class);
        list = query.getResultList();
        return list;
    }

    @Override
    @Transactional
    public boolean add(ImageOfTheDay imageOfTheDay) {
        try {
            entityManager.persist(imageOfTheDay);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean likeComment(Long id) {
        try {
            Query query = entityManager.createNativeQuery(QueryDB.LIKE_COMMENT);
            query.setParameter(1, id);
            int updatedRows = query.executeUpdate();
            return updatedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
