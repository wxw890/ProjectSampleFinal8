package com.hta.book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.book.repository.BookDto;

import com.hta.book.repository.BookandRentalDto;
import com.hta.book.repository.RentalInfoDto;
import com.hta.book.service.BookService;

@Controller
public class BookResExtensionController {
	private BookService bookService;
	
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/extension.book")
	public String extensionhandle(int book_num){
		
		bookService.bookextension(book_num);
	
		return "redirect:myrental.book";
		
	}
	
	//���� ���ó��
	@RequestMapping("/rescan.book")
	public String reshandle(int book_num, HttpSession session,int res_num){
		
		String member_email = (String)session.getAttribute("email");
		bookService.bookrescancel(book_num, member_email,res_num);
	
		return "redirect:myrental.book";
		
	}
	//���� �� �뿩ó��
	@RequestMapping("/resrental.book")
	public  ModelAndView resrentalhandle(@ModelAttribute RentalInfoDto infodto, BookDto dto,int book_num, BookandRentalDto joindto, HttpSession session, HttpServletRequest req
			){
		ModelAndView mav = new ModelAndView("redirect:myrental.book");
	
		
		String member_email = (String)session.getAttribute("email");
		session.setAttribute("member_email", member_email); //session�� �̸��ϰ� ����.
		infodto.setMember_email(member_email);
		infodto.setBook_num(book_num);

		bookService.bookresrental(dto, infodto,book_num);

		
		return mav;
		
		
	}
	
	
}
