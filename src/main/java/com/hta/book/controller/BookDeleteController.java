package com.hta.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hta.book.repository.BookDto;
import com.hta.book.service.BookService;

@Controller
public class BookDeleteController {
	private BookService bookService;
	
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/delete.book", method=RequestMethod.GET)
	public String deletehandle(int book_num){
		System.out.println(book_num);
		bookService.bookdelete(book_num);
	
		return "redirect:success.book";
		
	}
	
	
}
