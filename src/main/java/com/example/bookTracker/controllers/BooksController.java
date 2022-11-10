package com.example.bookTracker.controllers;

import com.example.bookTracker.dtos.BooksDto;
import com.example.bookTracker.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("/user/{userId}")
    public List<BooksDto> getBooksByUser(@PathVariable Long userId) {
        return booksService.getAllBooksByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addBooks(@RequestBody BooksDto booksDto, @PathVariable Long userId) {
        booksService.addBooks(booksDto, userId);
    }
    @DeleteMapping("/{bookId}")
    public void deleteBooksById(@PathVariable Long bookId) {
        booksService.deleteBooksById(bookId);
    }

    @PutMapping
    public void updateBooks(@RequestBody BooksDto booksDto) {
        booksService.updateBooksById(booksDto);
    }

    @GetMapping("/{bookId}")
    public Optional<BooksDto> getBooksById(@PathVariable Long bookId) {
        return booksService.getBooksById(bookId);
    }

}