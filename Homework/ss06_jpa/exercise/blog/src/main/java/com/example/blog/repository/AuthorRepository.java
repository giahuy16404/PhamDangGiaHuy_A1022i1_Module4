//package com.example.blog.repository;
//
//import com.example.blog.model.Author;
//import com.example.blog.repository.itf.IAuthorRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//public class AuthorRepository implements IAuthorRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    @Transactional
//    public boolean create(Author author) {
//        try{
//            entityManager.persist(author);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public int showMaxId() {
//        Query query = entityManager.createNativeQuery(QueryDb.SELECT_MAX_ID_AUTHOR);
//        return (int) query.getSingleResult();
//    }
//
//    @Override
//    public List<Author> findAll() {
//        return null;
//    }
//
//    @Override
//    public boolean edit(Author author) {
//        return false;
//    }
//
//    @Override
//    public boolean remove(int id) {
//        return false;
//    }
//}
