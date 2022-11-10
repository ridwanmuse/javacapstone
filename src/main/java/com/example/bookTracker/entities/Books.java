package com.example.bookTracker.entities;

import com.example.bookTracker.dtos.BooksDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
@Entity
@Table(name="Books")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String body;

    @ManyToOne
    @JsonBackReference
    private User user;

    public Books(BooksDto booksDto){
        if (booksDto.getBody() != null){
            this.body = booksDto.getBody();
        }
    }
}
