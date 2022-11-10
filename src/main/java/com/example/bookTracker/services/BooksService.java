package com.example.bookTracker.services;

import com.example.bookTracker.dtos.BooksDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface BooksService {
    @Transactional
    void addBooks(BooksDto booksDto, Long userId);

    @Transactional
    void deleteBooksById(Long booksId);

    @Transactional
    void updateBooksById(BooksDto booksDto);

    List<BooksDto> getAllBooksByUserId(Long userId);

    Optional<BooksDto> getBooksById(Long bookId);
}
