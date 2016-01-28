package com.hta.QandAboard.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.QandAboard.repository.BoardDto;
import com.hta.QandAboard.service.BoardService;

@Controller
public class ReadController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/read.board2")
	public ModelAndView PageMove(HttpSession session, @RequestParam int b_seq) throws SQLException{//int b_seq는 @requestParameter를 이용한것
		ModelAndView mav = new ModelAndView("/QandAboard/read");
		BoardDto dto = boardService.findBySeq(b_seq);
		
		String content = dto.getB_content();//글 내용 불러오기
		content = content.replace("\r\n","<br>");//글의 엔터(\r)를 <br>로 변환
		dto.setB_content(content);//변환된 내용을 다시 집어넣음
		
		System.out.println("1. 카운터증가 실행되니??");
		System.out.println("선택한 글 아이디:"+dto.getB_writer());
		String email = (String)session.getAttribute("email");//로그인된 이메일(아이디)값인 세션값가져오기
		
		if(dto.getB_writer().equals(email)){
			ModelAndView mav2 = new ModelAndView("/QandAboard/member_read");
			boardService.increaseCount(dto);
			mav2.addObject("dto", dto);
			return mav2;
		}
		boardService.increaseCount(dto);
		mav.addObject("dto",dto);
		return mav;
	}
}