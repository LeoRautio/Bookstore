package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value= {"/","/booklist"})
	public String BookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
	
	// RESTful service to get all books
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}
	
	// RESTful service to get book by id
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
		return bookRepository.findById(bookId);
	}
	
	@RequestMapping(value="/add")
	public String AddBook(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }   
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String DeleteBook(@PathVariable("id") Long bookId ,Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String Edit(@PathVariable("id") Long bookId , Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
}
