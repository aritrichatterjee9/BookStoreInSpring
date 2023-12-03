package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

import org.springframework.ui.Model;

import java.util.List; // Fix the import statement for List

@Controller
public class BookController {
    
    @Autowired
    private BookService service;
    
    @Autowired
    private MyBookListService myBookService;
    
    @GetMapping("/")    
    public String home() {
        return "home";
    }
    
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister" ;
    }
    
    @GetMapping("/available_books")
    public ModelAndView getAllBooks() {
        List<Book> list = service.getAllBook();
//        ModelAndView m = new ModelAndView();
//        m.setViewName("bookList");
//        m.addObject("book", list);
//
//        return m;
        
        return new ModelAndView("bookList","book",list);
    }
    
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books" ;
    }
    
    @GetMapping("/myBooks")
    public String getMyBooks(Model model) {
        
    	List<MyBookList>list = myBookService.getAllMyBooks();
    	model.addAttribute("book", list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
    	
    	Book b= service.getBookById(id);
    	MyBookList mb= new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    	myBookService.saveMyBook(mb);
    	return "redirect:/myBooks";
    	
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        // Retrieve the book based on the given id
//        Book book = service.getBookById(id);
        
        // Add the book to the model
     //   model.addAttribute("book", book);
        
        // Return the view for editing the book
    	
    	Book b= service.getBookById(id);
    	model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
          	
    	service.deleteById(id);    	
        return "redirect:/available_books";
    }
    
    
}
