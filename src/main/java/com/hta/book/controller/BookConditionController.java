package com.hta.book.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hta.book.repository.ConditionDto;
import com.hta.book.service.BookService;

@Controller
public class BookConditionController {
	private BookService bookService;
	
	

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value="/condition.book", method=RequestMethod.GET)
	public String condition(){
		return "conditionbook";
		
	}
	
	@RequestMapping(value="/condition.book", method=RequestMethod.POST)
	public ModelAndView condition2(@ModelAttribute ConditionDto dto) throws SQLException{
			ModelAndView mav = new ModelAndView("bookrental");
			if(dto.getItem() != "" && dto.getValue() != "" && 
					dto.getSeconditem() == "" &&  dto.getSecondvalue() == "" &&  
					dto.getOp() == "" && 
					dto.getThirditem() == "" &&  dto.getThirdvalue() == "" && 
					dto.getSecondop() == ""){
			List list = bookService.condition1(dto);
			
			mav.addObject("list", list);
			}
			
			else if(dto.getItem() != "" && dto.getValue() != "" && 
					dto.getSeconditem() != "" &&  dto.getSecondvalue() != "" &&  
					dto.getOp() != "" && 
					dto.getThirditem() == "" &&  dto.getThirdvalue() == "" && 
					dto.getSecondop() == ""){
				List list = bookService.condition2(dto);
				
				mav.addObject("list", list);
			}
			else if(dto.getItem() != "" &&  dto.getValue() != "" && 
					dto.getSeconditem() != "" &&  dto.getSecondvalue() != "" &&  
					dto.getOp() != "" &&  dto.getThirditem() != "" &&  dto.getThirdvalue() != "" ||
					dto.getSecondop() != ""){
				
				List list = bookService.condition3(dto);

				mav.addObject("list", list);
			}
			
				
		
			
			return mav;
	}	
}
