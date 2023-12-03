package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookStore.entity.MyBookList;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {

    // You can add custom query methods here if needed

}
