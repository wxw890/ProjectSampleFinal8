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
public class BookResController {
	private BookService bookService;
	
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/res.book", method=RequestMethod.GET)
	public String reshandle(@ModelAttribute BookResDto resdto, HttpSession session, int book_num){
		

		String member_email = (String)session.getAttribute("email");
		session.setAttribute("member_email", member_email);
		resdto.setMember_email(member_email);
		resdto.setBook_num(book_num);
		bookService.bookres(book_num, resdto, member_email);
	
		return "redirect:myrental.book";
		
	}
	
	
}
