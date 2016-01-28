package com.hta.book.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hta.book.repository.BookDto;
import com.hta.book.service.BookService;

@Controller
public class BookReturnController {
	private BookService bookService;
	
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/return.book", method=RequestMethod.GET)
	public String returnhandle(int book_num, HttpSession session,int rental_num){
		String member_email = (String)session.getAttribute("email");
		
		bookService.bookreturn(book_num,member_email,rental_num);
	
		return "redirect:myrental.book";
		
	}
	
	
}
