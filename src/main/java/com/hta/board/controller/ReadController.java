package com.hta.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.board.repository.BoardDto;
import com.hta.board.service.BoardService;

@Controller
public class ReadController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/read.board")
	public ModelAndView PageMove(HttpSession session, @RequestParam int b_seq) throws SQLException{//int b_seq는 @requestParameter를 이용한것
		ModelAndView mav = new ModelAndView("/board/read");
		BoardDto dto = boardService.findBySeq(b_seq);
		
		
		
		System.out.println("1. 카운터증가 실행되니??");
		System.out.println("선택한 글 아이디:"+dto.getB_writer()); //쓸때 이미 이메일로 저장되어있다.
		String email = (String)session.getAttribute("email");//로그인된 이메일(아이디)값인 세션값가져오기
		
		if(dto.getB_writer().equals(email)){
			ModelAndView mav2 = new ModelAndView("/board/member_read");
			boardService.increaseCount(dto);
			mav2.addObject("dto", dto);
			System.out.println("1*****읽어들이는 이미지 파일이름"+dto.getFilename());
			System.out.println("1*****읽어들이는 이미지 파일경로"+dto.getFilepath());
			mav2.addObject("filename", dto.getFilename());
			mav2.addObject("filepath", dto.getFilepath());
			return mav2;
		}
		System.out.println("2*****읽어들이는 이미지 파일이름"+dto.getFilename());
		System.out.println("2*****읽어들이는 이미지 파일경로"+dto.getFilepath());
		mav.addObject("filename", dto.getFilename());
		mav.addObject("filepath", dto.getFilepath());
		boardService.increaseCount(dto);
		mav.addObject("dto",dto);
		return mav;
	}
}