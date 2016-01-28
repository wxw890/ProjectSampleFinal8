package com.hta.freeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hta.freeboard.repository.BoardDto;
import com.hta.freeboard.service.BoardService;

@Controller
public class DeleteController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	//구지 페이지 이동만하기때문에 modelanview를 쓸필요하는 없다. 데이터를 가지고 넘어가는 것이 아니기때문에...
		@RequestMapping("/delete.board1")//POST방식 이동, 예from로 통해 이동
		public String  submitted(int b_seq){//@ModelAttribute란
			//System.out.println("글 저장....");
			//System.out.println(dto.getB_title() +","+ dto.getB_content());
			try {
				boardService.delete(b_seq);
			} catch (Exception err) {
				System.out.println("writeErrorMessage:"+ err);
			}
			return "redirect:list.board1?bool="+false;//"/WEB-INF/views/board/list.jsp";//dB를 거치지 않고 가기때문에 입력한 결과값이 보지 않고 나온다.
																			//이것을 해결하기위해 redirect:를 사용한다. 마치 클라이언트가 다시 서버에 요청한것 처럼...결과를 준다.
		}
	
}
