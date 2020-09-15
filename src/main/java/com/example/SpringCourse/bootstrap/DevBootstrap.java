package com.example.SpringCourse.bootstrap;


import com.example.SpringCourse.model.Author;
import com.example.SpringCourse.model.Book;
import com.example.SpringCourse.model.Publisher;
import com.example.SpringCourse.repository.AuthorRepository;
import com.example.SpringCourse.repository.BookRepository;
import com.example.SpringCourse.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        initData();
    }

    private void initData() {

        Publisher harperCollins = new Publisher();
        harperCollins.setName("Harper Collins");
        publisherRepository.save(harperCollins);
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher worx = new Publisher();
        worx.setName("Worx");
        publisherRepository.save(worx);
        //Rod
        Author rod = new Author("Rod", "Jonson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
