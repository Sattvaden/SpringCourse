package com.example.SpringCourse.repository;

import com.example.SpringCourse.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
