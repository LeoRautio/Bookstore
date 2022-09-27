package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String price;
	private String isbn;
	// had to change the variable for year into Finnish because it didn't work otherwise
	// Was stuck for so long, and it was not creating the table cause of a Syntax error
	private String vuosi;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	public Book() {}
	
	public Book(String title, String author, String vuosi, String price, String isbn, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.vuosi = vuosi;
		this.price = price;
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public String getVuosi() {
		return vuosi;
	}

	public void setVuosi(String vuosi) {
		this.vuosi = vuosi;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null) {
			return "Book [id= " + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
					+ ", year=" + vuosi + ", category=" + this.getCategory() + "]";
		} else {
			return "Book [id= " + id + "title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
					+ ", year=" + vuosi + "]";
		}
		
	}

	
	
}
