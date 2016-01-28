package com.hta.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hta.book.service.BookService;

@Controller
public class BookManagerController {
	private BookService bookService;
	
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/manager.book")
	public ModelAndView pageHandler1(){
		ModelAndView mav = new ModelAndView("manager");
		try {
				
			List list = bookService.rantalinfoList();
			List lists = bookService.resbookList();
			
			mav.addObject("list", list);
			mav.addObject("lists", lists);
		} catch (Exception err) {
			System.out.println("ListController:pageHandler():" + err);
		}
	
		return mav;
			
	}
	
}
