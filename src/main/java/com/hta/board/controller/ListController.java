package com.hta.board.controller;

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

import com.hta.board.repository.BoardDto;
import com.hta.board.service.BoardService;
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
	
	@RequestMapping("/list.board")
	public ModelAndView pageHandler(HttpSession session, @ModelAttribute BoardDto dto, HttpServletRequest req, HttpServletResponse resp){
		
		ModelAndView mav = new ModelAndView("/board/list");
		String keyWord = req.getParameter("keyWord"); //keyWord와 keyField값을 가져온다.
		String keyField = req.getParameter("keyField");
		System.out.println("list Get방식");
		dto.setKeyField(keyField);//dto에 집어넣는다.
		dto.setKeyWord(keyWord);
		String session_email = (String) session.getAttribute("email");
		System.out.println("무엇이 무엇이???"+dto.getB_content());
		System.out.println("****로그인된 아이디는??"+session_email);
		
		req.setAttribute("dto", dto);//jsp에 사용하기위해 request로 저장해둔다.
		
		try {
			List list;
			
			if(session_email != null){//로그인되어있을시
				
				if(keyWord == null){
					System.out.println("getList실행!!!!!!!!!");
					list = boardService.getList();//getList()함수가 list 결과값을 가지고 온다.
					mav.addObject("list", list);
				}
				else{
					System.out.println("findKeyword실행!!!!!!!!!");
					list = boardService.findKeyword(dto);
					mav.addObject("list", list);
				}
			}
			else{//로그인이 안되어있을시
				System.out.println("리스트 실행이요!!!!!!!!");
				ModelAndView mav2 = new ModelAndView("/member/login/loginForm");
				mav2.addObject("email1", session_email);
				return mav2;
			}
		
		}
		catch(Exception err){
			System.out.println("First ListController:pageHandler():" + err);
		}
		return mav;
	}
	
}
