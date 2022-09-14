package com.example.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Add a few new books");
			repository.save(new Book("Harry Potter", "J. K. Rowling", "1995", "29,95", "0747532745"));
			repository.save(new Book("Lord Of the Rings", "J. R. R. Tolkien","2014", "81.30", "9780007581146"));
			
			log.info("find all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
	
	
}
