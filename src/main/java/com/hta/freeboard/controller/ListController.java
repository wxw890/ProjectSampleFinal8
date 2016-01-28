package com.hta.freeboard.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.freeboard.repository.BoardDto;
import com.hta.freeboard.service.BoardService;
import com.hta.member.repository.LoginCommand;
//DB로부터 가져온값을 list에게 넘겨줘야한다.
//BoardServiceImpl를 
@Controller
public class ListController{
	private BoardService boardService;
	private final static int numPerPage = 5;//페이지 당 리스트 수
	private final static int pagePerBlock = 3;//페이지 몇개로 묶을지
	public void setBoardService(BoardService boardService) {//여기에 들어간다.
		this.boardService = boardService;
	}
	
	@RequestMapping("/list.board1")
	public ModelAndView pageHandler(HttpSession session, @ModelAttribute BoardDto dto, HttpServletRequest req, HttpServletResponse resp, @RequestParam boolean bool) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView("/freeboard/list");
		String keyWord = req.getParameter("keyWord"); //keyWord와 keyField값을 가져온다.
		String keyField = req.getParameter("keyField");
		System.out.println("freeboard list Get방식");
		dto.setKeyField(keyField);//dto에 집어넣는다.
		dto.setKeyWord(keyWord);
		String session_email = (String) session.getAttribute("email");
		System.out.println("무엇이 무엇이???"+dto.getB_content());
		System.out.println("****로그인된 아이디는??"+session_email);
		
		req.setAttribute("dto", dto);//jsp에 사용하기위해 request로 저장해둔다.
		
		List list = null;
		try {
			
				if(bool==true){//bool이 true일때 index에 bool과 list를 보낸다. 즉, 공지사항을위한 부분
					ModelAndView mav2 = new ModelAndView("index");
					list = boardService.getList();
					bool=false;//bool을 flase값을 이때 줘야 index에서 다시 listController로 가는 무한루프가 안일어난다. 즉, 한번의 실행을 위해서 필요함
					mav2.addObject("list", list);
					mav2.addObject("bool", bool);
					System.out.println("index로 가는거 먹힌다.!!!!!!!!!!!!!!!!!!!!");
					return mav2;
				}
			
			
				
				if(keyWord == null){//키워드 검색 값이 없을시
					System.out.println("getList실행!!!!!!!!!");
					list = boardService.getList();//getList()함수가 list 결과값을 가지고 온다.
					mav.addObject("email", session_email);
					mav.addObject("list", list);
					
					
				}
				else{//키워드 검색 값이 있을시
					System.out.println("findKeyword실행!!!!!!!!!");
					list = boardService.findKeyword(dto);//키워드 검색 찾기
					mav.addObject("email", session_email);
					mav.addObject("list", list);
				}
			
		
		
		}
		catch(Exception err){
			if(list == null || list.isEmpty()){
				System.out.println("list가 null이면 실행 부탁드립니다.");
				mav.addObject("email", session_email);
				mav.addObject("list", null);
				
			}
			
			System.out.println("First ListController:pageHandler():" + err);
			
		}
		return mav;
	}
	
	
	
	
	
	
	
	@RequestMapping("/list.board11")
	public ModelAndView pageHand(HttpSession session, @ModelAttribute BoardDto dto, HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException{
		req.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView("/freeboard/list");
		String keyWord = req.getParameter("keyWord"); //keyWord와 keyField값을 가져온다.
		String keyField = req.getParameter("keyField");
		System.out.println("freeboard list Get방식");
		dto.setKeyField(keyField);//dto에 집어넣는다.
		dto.setKeyWord(keyWord);
		String session_email = (String) session.getAttribute("email");
		System.out.println("무엇이 무엇이???"+dto.getB_content());
		System.out.println("****로그인된 아이디는??"+session_email);
		
		req.setAttribute("dto", dto);//jsp에 사용하기위해 request로 저장해둔다.
		
		List list = null;
		try {
			
			
				
				if(keyWord == null){//키워드 검색 값이 없을시
					System.out.println("getList실행!!!!!!!!!");
					list = boardService.getList();//getList()함수가 list 결과값을 가지고 온다.
					mav.addObject("email", session_email);
					mav.addObject("list", list);
					
					
				}
				else{//키워드 검색 값이 있을시
					System.out.println("findKeyword실행!!!!!!!!!");
					list = boardService.findKeyword(dto);//키워드 검색 찾기
					mav.addObject("email", session_email);
					mav.addObject("list", list);
				}
			
		
		
		}
		catch(Exception err){
			if(list == null || list.isEmpty()){
				System.out.println("list가 null이면 실행 부탁드립니다.");
				mav.addObject("email", session_email);
				mav.addObject("list", null);
				
			}
			
			System.out.println("First ListController:pageHandler():" + err);
			
		}
		return mav;
	}
	
	
	
	
	
}
