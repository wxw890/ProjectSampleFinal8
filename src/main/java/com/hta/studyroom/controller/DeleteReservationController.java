package com.hta.studyroom.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.studyroom.repository.StudyroomDto;
import com.hta.studyroom.service.StudyroomService;

@Controller
public class DeleteReservationController {
	
	private StudyroomService studyroomService;
	
	public void setStudyroomService(StudyroomService studyroomService) {
		this.studyroomService = studyroomService;
	}
	@RequestMapping("/reservation1.delete")
	public ModelAndView pageMoveDelete(StudyroomDto dto, HttpSession session){//마이페이지 리스트 출력부분
		ModelAndView mav = new ModelAndView("/study_room/reservation/myreservation");
		List list = null;
		String member_email = (String)session.getAttribute("email");
		String member_name = (String)session.getAttribute("name");
		try {
			list = studyroomService.findByRes_num(member_email);
			mav.addObject("list5", list);
			mav.addObject("name", member_name);

		} catch (Exception err) {
			// TODO Auto-generated catch block
			System.out.println("삭제페이지 이동 에러"+err);
		}
		return mav;
	}
	@RequestMapping(value="/reservation.delete", method=RequestMethod.GET)
	public String delete(StudyroomDto dto, @RequestParam int reservation_num){//마이페이지 삭제부분
		System.out.println("1. 삭제할 예약 넘버:"+reservation_num);
		System.out.println("2. dto 삭제할 예약 넘버:"+dto.getReservation_num());
		try {
			studyroomService.resDelete(reservation_num);
		} catch (SQLException err) {
			System.out.println("삭제 부분에서 에러"+ err);
		}
		return "redirect:reservation1.delete";
	}
	
}
