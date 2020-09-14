package com.example.SpringCourse.repository;

import com.example.SpringCourse.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
