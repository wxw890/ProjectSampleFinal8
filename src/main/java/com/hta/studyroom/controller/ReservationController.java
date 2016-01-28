package com.hta.studyroom.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.studyroom.repository.StudyroomDto;
import com.hta.studyroom.service.StudyroomService;
import com.hta.member.service.MemberService;


@Controller
public class ReservationController {
	private StudyroomService studyroomService;


	public void setStudyroomService(StudyroomService studyroomService) {
		this.studyroomService = studyroomService;
	}

	@RequestMapping(value = "/reservation.study", method=RequestMethod.GET)
	public ModelAndView form(HttpSession session){
		ModelAndView mav = new ModelAndView("/study_room/reservation/step1");
		String member_email = (String)session.getAttribute("email");
		if(member_email==null){
			ModelAndView mav2 = new ModelAndView("/member/login/loginForm");
			mav2.addObject("email", member_email);
			return mav2;
		}
		mav.addObject("email", member_email);
		System.out.println("step1 이동 ^^"+member_email );
		return mav;
		
	}
	
	
	@RequestMapping(value="/reservation2.study", method=RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute StudyroomDto studyroomdto, HttpSession session, HttpServletRequest req , HttpServletResponse resp){
		Calendar cal = Calendar.getInstance();//현재시각
		String nowyear = String.valueOf(cal.get(Calendar.YEAR));
		int nowmonth = cal.get(Calendar.MONTH)+1;
		int nowday = cal.get(Calendar.DAY_OF_MONTH);	
		System.out.println("현재시간은" + nowyear +" , "+ nowmonth +" , "+ nowday);
		
		System.out.println("dto에 저장된 날짜는"+studyroomdto.getReservation_date());
		if(studyroomdto.getReservation_date() == ""){
			System.out.println("step1이동~~~!!");
			ModelAndView mav4 = new ModelAndView("/study_room/reservation/step1");
			String NullValue = "컨트롤로 이동한 ";
			mav4.addObject("NullValueError", NullValue);
			return mav4;
		}
		
		
		
		//선택한 (문자형)날짜 정확한 (숫자)날짜로 변환시키기(charAt()-->0부터 시작)
		int month = studyroomdto.getReservation_date().charAt(6)-48;//월 숫자
		int firstday = (studyroomdto.getReservation_date().charAt(8)-48)*10;//날짜의 십자리 숫자를 만드는 수식
		int secondday = studyroomdto.getReservation_date().charAt(9)-48;//날짜 일자리 숫자 
		int sumday = (firstday + secondday);//선택한 정확한 날짜
		String year = studyroomdto.getReservation_date().substring(0, 4);//처음 인자 순서 값은 가져가고 마지막 인자 순서는 전에 인자순서를 가지고 온다.
		
		
		/*//Map 형식으로 저장하여 addAllObject()로 page에 볼낼 수있는데 이때 페이지에서 EL태그로 출력하는 방법는 그냥 key이름 값으로 불러서 쓸수 있다는데 나중에 해봐야겠다....
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("day", sumday);
		map.put("month", month);
		map.put("year", new Integer(year));
		System.out.println("Map들어가나욤??"+ map.get("year")+" , "+map.get("month")+ " , " +map.get("day"));
		*/
		
		List list = new ArrayList();
		list.add(year);//0
		list.add(month);//1
		list.add(sumday);//2
		System.out.println("list 출력 ㅅㅂ"+ list.get(0));
		System.out.println("월!!!!!!!!"+month);
		System.out.println("일!!!!!!!!"+firstday + " and " +secondday + " = " + sumday);
		System.out.println("년!!!!!!!!"+year);
		System.out.println("1예약 저장....");
		System.out.println("1확인"+studyroomdto.getMember_email());
		System.out.println("2확인"+studyroomdto.getReservation_date());
		System.out.println("3확인"+studyroomdto.getTable_num());
		System.out.println("4확인"+studyroomdto.getReservation_time());
		System.out.println("5확인"+studyroomdto.getClass());
		System.out.println("6확인"+studyroomdto.getMember_name());
		try {
			
				
					//계정을 세션에 저장.
				String memberEmail = (String)session.getAttribute("email");
					session.setAttribute("member_email", memberEmail); //session에 이메일값 저장.
					studyroomdto.setMember_email(memberEmail);
						
				String memberName = (String) session.getAttribute("name");
					session.setAttribute("member_name", memberName);
					studyroomdto.setMember_name(memberName);
						
				StudyroomDto dto = studyroomService.findBySameResurvation(studyroomdto);//같은 날짜에 예약있는지 찾는다.
				
				
				if(nowyear.equals(year) && nowmonth<month){//같은 년도에 현재 월보다 클때 무조건 입력을 한다.
							//if(nowday<=sumday){
								//System.out.println("1. write 시~~~~~~~~작!!!");
								//step1.jsp에서 전달받은 데이터를 스터디룸 좌석 예약 DB에 입력
								
							//}
							if(dto == null){//dto가 널이 아니라면 같은 날짜에 예약되어있는게 있다는 뜻
								System.out.println("1. write 시~~~~~~~~작!!!");
								studyroomService.resWrite(studyroomdto);
							}
							else{
								System.out.println("1-1. mav2 시~~~~~~~~작!!!");
								ModelAndView mav2 = new ModelAndView("/study_room/reservation/step1Error");
								mav2.addObject("list", list);//List 형식으로 보낼때
								//mav2.addAllObjects(map); //Map 형식으로 보낼때
								//mav2.addObject("month", month);//선택한 월
								//mav2.addObject("year", year);//선택한 년도
								//mav2.addObject("day", sumday);//선택한 정확날짜
								return mav2;
								
							}
				}
				else if(nowyear.equals(year) && nowmonth==month && nowday<=sumday){//같은 년도에 현재월가 같으며 현재 날짜보다 크거나 같을때 입력한다.
							
							if(dto == null){//dto가 널이 아니라면 같은 날짜에 예약되어있는게 있다는 뜻
							System.out.println("2. write 시~~~~~~~~작!!!");
							//step1.jsp에서 전달받은 데이터를 스터디룸 좌석 예약 DB에 입력
							studyroomService.resWrite(studyroomdto);
							}
							else{
								System.out.println("2-1. mav2 시~~~~~~~~작!!!");
								ModelAndView mav2 = new ModelAndView("/study_room/reservation/step1Error");
								mav2.addObject("list", list);//List 형식으로 보낼때
								//mav2.addAllObjects(map); //Map 형식으로 보낼때
								//mav2.addObject("month", month);//선택한 월
								//mav2.addObject("year", year);//선택한 년도
								//mav2.addObject("day", sumday);//선택한 정확날짜
								return mav2;
								
							}
				}
				else{
					System.out.println("2. mav2 시~~~~~~~~작!!!");
					ModelAndView mav2 = new ModelAndView("/study_room/reservation/step1Error");
					mav2.addObject("list", list);//List 형식으로 보낼때
					//mav2.addAllObjects(map); //Map 형식으로 보낼때
					//mav2.addObject("month", month);//선택한 월
					//mav2.addObject("year", year);//선택한 년도
					//mav2.addObject("day", sumday);//선택한 정확날짜
					return mav2;
					
				}
			
			
		}catch (Exception err) {
			
			System.out.println("스터디룸 좌석 예약 부분:"+ err);
			System.out.println("3. mav2 시~~~~~~~~작!!!");
			ModelAndView mav2 = new ModelAndView("/study_room/reservation/step1Error");
			mav2.addObject("list", list);//List 형식으로 보낼때
			//mav2.addAllObjects(map); //Map 형식으로 보낼때
			//mav2.addObject("month", month);//선택한 월
			//mav2.addObject("year", year);//선택한 년도
			//mav2.addObject("day", sumday);//선택한 정확날짜
			return mav2;
		}
		
		ModelAndView mav = new ModelAndView("/study_room/reservation/step2");
		mav.addObject("studyroomdto", studyroomdto);
		
		
		
		
		
		System.out.println("예약 저장....");
		System.out.println("1-2확인"+studyroomdto.getMember_email());
		System.out.println("2확인"+studyroomdto.getReservation_date());
		System.out.println("3확인"+studyroomdto.getTable_num());
		System.out.println("4확인"+studyroomdto.getReservation_time());
		System.out.println("5확인"+studyroomdto.getClass());
		System.out.println("6확인"+studyroomdto.getMember_name());
		System.out.println("6확인"+studyroomdto.getMember_name());
		return mav;
	}
	
	

}