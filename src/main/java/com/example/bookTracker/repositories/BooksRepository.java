package com.example.bookTracker.repositories;


import com.example.bookTracker.entities.Books;
import com.example.bookTracker.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findAllByUserEquals(User user);

}