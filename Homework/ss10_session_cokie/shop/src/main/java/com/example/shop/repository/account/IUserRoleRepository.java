package com.example.shop.repository.account;

import com.example.shop.model.account.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
    @Query(value = QueryDbAccount.SELECT_USER_ROLE, nativeQuery = true)
    Page<UserRole> findAll(Pageable pageable);

    @Query(value = QueryDbAccount.FIND_BY_NAME_USER,nativeQuery = true)
    Page<UserRole> findByName(Pageable pageable,@Param("name") String name);


}

