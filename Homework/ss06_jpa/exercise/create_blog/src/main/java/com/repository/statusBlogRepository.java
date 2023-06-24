package com.repository;

import com.model.StatusBlog;
import com.repository.itf.IStatusBlogRepository;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Controller
public class statusBlogRepository implements IStatusBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public boolean create(StatusBlog statusBlog) {
        try{
            entityManager.persist(statusBlog);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
