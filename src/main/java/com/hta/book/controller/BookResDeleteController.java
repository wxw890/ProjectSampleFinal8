package com.hta.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hta.book.repository.BookDto;
import com.hta.book.repository.BookResDto;
import com.hta.book.repository.BookandRentalDto;
import com.hta.book.service.BookService;

@Controller
public class BookResDeleteController {
	private BookService bookService;
	
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/resbookcancel.book", method=RequestMethod.GET)
	public String reshandle(){
	
		bookService.bookrestodaycancel();
		
		return "redirect:manager.book";

	}
}
