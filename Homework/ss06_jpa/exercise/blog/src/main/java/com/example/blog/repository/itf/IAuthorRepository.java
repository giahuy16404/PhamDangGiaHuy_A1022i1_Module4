package com.example.blog.repository.itf;

import com.example.blog.model.User;
import com.example.blog.repository.QueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAuthorRepository extends JpaRepository<User,Integer> {
    @Query(value = QueryDb.SELECT_MAX_ID_AUTHOR,nativeQuery = true)
    int showMaxId();
}
