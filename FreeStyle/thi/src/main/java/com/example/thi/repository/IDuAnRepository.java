package com.example.thi.repository;

import com.example.thi.model.DuAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDuAnRepository extends JpaRepository<DuAn,Long> {

    @Query(value = com.example.thi.util.Query.FIND_DU_AN_PAGE_AND_SEARCH,nativeQuery = true)
    Page<DuAn> findPageAndSearch(Pageable pageable, @Param("valueSearch") String valueSearch);


}
