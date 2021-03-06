package com.example.SpringCourse.controller;

import com.example.SpringCourse.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
}
