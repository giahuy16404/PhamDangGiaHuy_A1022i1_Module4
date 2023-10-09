package com.example.furama.repository.account;


import com.example.furama.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<AppUser,Long> {
    @Query(value = QueryDbAccount.SELECT_ACCOUNT_BY_USERNAME,nativeQuery = true)
    AppUser getAccountByUsername(@Param("name") String name);


}
