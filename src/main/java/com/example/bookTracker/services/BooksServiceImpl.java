package com.example.bookTracker.services;

import com.example.bookTracker.dtos.BooksDto;
import com.example.bookTracker.entities.Books;
import com.example.bookTracker.entities.User;
import com.example.bookTracker.repositories.BooksRepository;
import com.example.bookTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addBooks(BooksDto noteDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Books books = new Books(noteDto);
        userOptional.ifPresent(books::setUser);
        booksRepository.saveAndFlush(books);
    }

    @Override
    @Transactional
    public void deleteBooksById(Long booksId){
        Optional<Books> booksOptional = booksRepository.findById(booksId);
        booksOptional.ifPresent(books -> booksRepository.delete(books));
    }

    @Override
    @Transactional
    public void updateBooksById(BooksDto booksDto){
        Optional<Books> booksOptional = booksRepository.findById(booksDto.getId());
        booksOptional.ifPresent(books -> {
            books.setBody(booksDto.getBody());
            booksRepository.saveAndFlush(books);
        });
    }

    @Override
    public List<BooksDto> getAllBooksByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Books> booksList = (List<Books>) booksRepository.findAllByUserEquals(userOptional.get());
            return booksList.stream().map(books -> new BooksDto(books)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<BooksDto> getBooksById(Long booksId){
        Optional<Books> booksOptional = booksRepository.findById(booksId);
        if (booksOptional.isPresent()){
            return Optional.of(new BooksDto(booksOptional.get()));
        }
        return Optional.empty();
    }
}