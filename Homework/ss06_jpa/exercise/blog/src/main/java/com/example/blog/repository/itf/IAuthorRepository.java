package com.example.blog.repository.itf;

import com.example.blog.model.Author;
import com.example.blog.repository.QueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface IAuthorRepository extends JpaRepository<Author,Integer> {
    @Query(value = QueryDb.SELECT_MAX_ID_AUTHOR,nativeQuery = true)
    int showMaxId();
}
