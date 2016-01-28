package com.hta.freeboard.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.freeboard.repository.BoardDto;
import com.hta.freeboard.service.BoardService;

@Controller
public class ReadController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/read.board1")
	public ModelAndView PageMove(HttpSession session, @RequestParam int b_seq) throws SQLException{//int b_seq는 @requestParameter를 이용한것
		ModelAndView mav = new ModelAndView("/freeboard/read");
		BoardDto dto = boardService.findBySeq(b_seq);
		System.out.println("freeboard 1. 카운터증가 실행되니??");
		System.out.println("선택한 글 아이디:"+dto.getB_writer());
		String email = (String)session.getAttribute("email");//로그인된 이메일(아이디)값인 세션값가져오기
		
		if(email == null){//회원가입 안했을시 null 값을 equals()로 비교하면 NullpointException 에러가 뜬다 그래서 ==기호로 표시해야 에러가안남
			boardService.increaseCount(dto);
			mav.addObject("dto",dto);
			return mav;
		}else if(email.equals("admin@hta.co.kr")){//관리자 아이디로 로그인했을시
			ModelAndView mav2 = new ModelAndView("/freeboard/member_read");
			boardService.increaseCount(dto);
			mav2.addObject("dto", dto);
			return mav2;
		}
		boardService.increaseCount(dto);
		mav.addObject("dto",dto);
		return mav;
	}
}