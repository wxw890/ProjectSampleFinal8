package com.hta.book.controller;

import java.util.List;

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
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@Controller
public class RentalBookController {
	private BookService bookService;
	 
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/rental.book")
	public  ModelAndView rentalhandle(@ModelAttribute RentalInfoDto infodto, BookDto dto,int book_num, BookandRentalDto joindto, HttpSession session, HttpServletRequest req
			 ){
		ModelAndView mav = new ModelAndView("redirect:myrental.book");
		String book_title = req.getParameter("book_title");
		System.out.println("rentalcontroller:"+book_num);
		String member_email = (String)session.getAttribute("email");
		session.setAttribute("member_email", member_email); //session�� �̸��ϰ� ����.
		infodto.setMember_email(member_email);
		infodto.setBook_num(book_num);
	
		bookService.bookrental(dto, infodto,book_num);

		
		return mav;
		
		
	}
	
	
	
	
	@RequestMapping("/myrental.book")
	public ModelAndView mylist(@ModelAttribute BookandRentalDto joindto, HttpSession session, HttpServletRequest req){
		ModelAndView mav = new ModelAndView("myrental");
		String member_email = (String)session.getAttribute("email");
		session.setAttribute("member_email", member_email); //session�� �̸��ϰ� ����.
		joindto.setMember_email(member_email);
		
		List list = bookService.mylist(joindto);
		List lists = bookService.myreslist(joindto);
		List memorylist = bookService.memorylist(joindto);
		
		int renlist = list.size();
		
		mav.addObject("renlist", renlist);
		int java = 0;
		int db = 0;
		int jsp = 0;
		int spring = 0;
		int android = 0;
		for(int i=0; i<memorylist.size(); i++){
			BookandRentalDto bordto = (BookandRentalDto)memorylist.get(i);
			String genre = bordto.getBook_genre();
			
			
			if(genre.equals("JAVA")){
				 java++;
			}
			else if(genre.equals("DB")){
				db++;
			}
			else if(genre.equals("JSP")){
				jsp++;
			}
			else if(genre.equals("Spring")){
				spring++;
			}
			else if(genre.equals("Android")){
				android++;
			}
			
			
			mav.addObject("java", java);
			mav.addObject("db", db);
			mav.addObject("jsp", jsp);
			mav.addObject("spring", spring);
			mav.addObject("android", android);
		}
	
		
		
		mav.addObject("list", list);
		mav.addObject("lists", lists);
		
		return mav;
		
	}

	
}
