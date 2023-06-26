package com.repository;

import com.model.Blog;
import com.repository.itf.IBlogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Controller
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean create(Blog blog) {
        try {
            entityManager.persist(blog);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> list;
        TypedQuery<Blog> query = (TypedQuery<Blog>) entityManager.createNativeQuery(QueryDb.SELECT_ALL_BLOG, Blog.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public List<Blog> findBlogOnDay() {
        List<Blog> list;
        TypedQuery<Blog> query = (TypedQuery<Blog>) entityManager.createNativeQuery(QueryDb.SELECT_BLOG_ON_DAY, Blog.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public List<Blog> findBlogTopView() {
        List<Blog> list;
        TypedQuery<Blog> query = (TypedQuery<Blog>) entityManager.createNativeQuery(QueryDb.SELECT_BLOG_TOP_VIEW, Blog.class);
        list = query.getResultList();
        return list;
    }

    @Override
    @Transactional
    public boolean addView(int id) {
        try {
            Query query = entityManager.createNativeQuery(QueryDb.ADD_VIEW);
            query.setParameter(1, id);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Blog> findById(int id) {
        List<Blog> list;
        TypedQuery<Blog> query = (TypedQuery<Blog>) entityManager.createNativeQuery(QueryDb.SELECT_BLOG_BY_ID, Blog.class);
        query.setParameter(1, id);
        list = query.getResultList();
        return list;
    }

    @Override
    @Transactional
    public boolean addLike(int id) {
        try {
            Query query = entityManager.createNativeQuery(QueryDb.ADD_LIKE);
            query.setParameter(1, id);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
