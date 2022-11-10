package com.example.bookTracker.dtos;

import com.example.bookTracker.entities.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDto implements Serializable {
    private Long id;
    private String body;

    public BooksDto(Books books) {
        if (books.getId() != null) {
            this.id = books.getId();
        }
        if (books.getBody() != null) {
            this.body = books.getBody();
        }
    }
}