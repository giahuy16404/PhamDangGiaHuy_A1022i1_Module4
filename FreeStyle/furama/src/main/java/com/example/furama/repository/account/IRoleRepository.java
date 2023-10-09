package com.example.furama.repository.account;

import com.example.furama.model.account.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<AppRole, Long> {
    @Query(value = QueryDbAccount.GET_ROLE_BY_USER, nativeQuery = true)
    List<String> getRoleByUser(@Param("id") long id);
}
