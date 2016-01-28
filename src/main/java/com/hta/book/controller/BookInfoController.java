package com.hta.book.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.board.repository.BoardDto;
import com.hta.board.service.BoardService;
import com.hta.book.repository.BookDto;
import com.hta.book.repository.BookandRentalDto;
import com.hta.book.service.BookService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
public class BookInfoController {
	private BookService bookService;
	
	

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}



	@RequestMapping("/bookinfo")
	public ModelAndView changehandle(@RequestParam int book_num, HttpSession session, BookandRentalDto joindto){
		ModelAndView mav = new ModelAndView("bookinfo");
	
		BookDto dto = bookService.findBynum(book_num);
		
		List list = bookService.samelist(dto.getBook_title());
		
		
		mav.addObject("dto", dto);
		mav.addObject("list", list);
		String member_email = (String)session.getAttribute("email");
		session.setAttribute("member_email", member_email); //session에 이메일값 저장.
		joindto.setMember_email(member_email);
		
		List renlist = bookService.mylist(joindto);
		List reslist = bookService.myreslist(joindto);
		
		int ren = renlist.size();
		int res = reslist.size();
	
		mav.addObject("renlimit", ren);
		mav.addObject("reslimit", res);
		//대여중복처리
		int disbook = 0;
		for(int i=0; i<list.size(); i++){
			for(int j=0; j<renlist.size(); j++){
				dto = (BookDto)list.get(i);
			
				
				String inputbook = dto.getBook_title();
				BookandRentalDto bordto = (BookandRentalDto)renlist.get(j);
				
				
				String book_title = bordto.getBook_title();
				
				if(dto.getBook_title().equals(bordto.getBook_title())){
					disbook = 1;
					mav.addObject("disbook",  disbook);
					return mav;
				}
				else{
					disbook = 0;
				}
				
				mav.addObject("disbook",  disbook);
				
			}
		}
		//예약 중복처리
		int resbook = 0;
		for(int i=0; i<list.size(); i++){
			for(int j=0; j<reslist.size(); j++){
				dto = (BookDto)list.get(i);
			
				
				String inputbook = dto.getBook_title();
				BookandRentalDto bordto = (BookandRentalDto)reslist.get(j);
				

				
				
				
				
				String book_title = bordto.getBook_title();
				
				if(dto.getBook_title().equals(bordto.getBook_title())){
					resbook = 1;
					mav.addObject("resbook",  resbook);
					return mav;
				}
				else{
					resbook = 0;
				}
				
				mav.addObject("resbook",  resbook);
				
			}
		}
		
		
		
		return mav;
	}
}
		

