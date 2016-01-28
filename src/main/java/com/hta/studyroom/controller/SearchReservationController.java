package com.hta.studyroom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hta.studyroom.repository.StudyroomDto;
import com.hta.studyroom.service.StudyroomService;

@Controller
public class SearchReservationController {
	private StudyroomService studyroomService;
	
	public void setStudyroomService(StudyroomService studyroomService) {
		this.studyroomService = studyroomService;
	}
	@RequestMapping("/reservation.search")
	public ModelAndView SearchList(HttpSession session, String date){
		ModelAndView mav = new ModelAndView("/study_room/reservation/step1");
		//계정을 세션에 저장.
		String member_email = (String)session.getAttribute("email");
		System.out.println("가져온 날짜는"+date);
		
		int month = date.charAt(6)-48;//월 숫자
		int firstday = (date.charAt(8)-48)*10;//날짜의 십자리 숫자를 만드는 수식
		int secondday = date.charAt(9)-48;//날짜 일자리 숫자 
		int sumday = (firstday + secondday);//선택한 정확한 날짜
		String year = date.substring(0, 4);//처음 인자 순서 값은 가져가고 마지막 인자 순서는 전에 인자순서를 가지고 온다.
		System.out.println("월!!!!!!!!"+month);
		System.out.println("일!!!!!!!!"+firstday + " and " +secondday + " = " + sumday);
		System.out.println("년!!!!!!!!"+year);
		
		List list=null;
		
		//System.out.println("session에 저장한 email가져옵니까?"+member_email);
		System.out.println("1.서치컨트롤 list 실행!!!");
			list=studyroomService.Searchreservation(date);
			System.out.println("2.서치컨트롤 list 실행!!!");
			mav.addObject("list5", list);
			
		
		
		
		return mav;
			
			
	}
}
