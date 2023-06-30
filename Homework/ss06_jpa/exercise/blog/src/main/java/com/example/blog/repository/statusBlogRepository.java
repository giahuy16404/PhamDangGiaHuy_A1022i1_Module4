//package com.example.blog.repository;
//
//import com.example.blog.model.StatusBlog;
//import com.example.blog.repository.itf.IStatusBlogRepository;
//import org.springframework.stereotype.Controller;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//
//@Controller
//public class statusBlogRepository implements IStatusBlogRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    @Transactional
//    public boolean create(StatusBlog statusBlog) {
//        try{
//            entityManager.persist(statusBlog);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int showMaxId() {
//        Query query = entityManager.createNativeQuery(QueryDb.SELECT_MAX_ID_STATUS_BLOG);
//        return (int) query.getSingleResult();
//    }
//}
