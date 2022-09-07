package com.example.Bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private Integer year;
	private String isbn;
	private float price;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year=year;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setYear(String isbn) {
		this.isbn=isbn;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price=price;
	}
	
	
}
