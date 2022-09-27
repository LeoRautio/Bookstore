package com.example.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Action"));
			
			log.info("Add a few new books");
			bookRepository.save(new Book("Harry Potter", "J. K. Rowling", "1995", "29,95", "0747532745", categoryRepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Lord Of the Rings", "J. R. R. Tolkien","2014", "81.30", "9780007581146", categoryRepository.findByName("Fantasy").get(0)));
			bookRepository.save(new Book("Juoksuhaudantie", "Kari Hotakainen", "2017", "15.50", "9789510425855", categoryRepository.findByName("Drama").get(0)));
			
			
			log.info("find all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
	
	
}
