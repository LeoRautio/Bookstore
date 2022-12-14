package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= {"/","/booklist"})
	public String BookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/add")
	public String AddBook(Model model) {
		model.addAttribute("book",new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }   
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String DeleteBook(@PathVariable("id") Long bookId ,Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String Edit(@PathVariable("id") Long bookId , Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}
	
}
