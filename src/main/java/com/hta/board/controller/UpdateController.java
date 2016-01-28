package com.hta.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.board.repository.BoardDto;
import com.hta.board.service.BoardService;

@Controller
public class UpdateController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	//페이지 이동
		@RequestMapping(value="/update.board",  method=RequestMethod.GET)//GET방싱 이동, 예 href로 통해 이동
		public ModelAndView pageHandler(@RequestParam int b_seq) throws SQLException{
			ModelAndView mav = new ModelAndView("/board/update");
			System.out.println("업데이트로 이동!!!!"+b_seq);
			BoardDto dto = boardService.findBySeq(b_seq);
			mav.addObject("dto", dto);
			return mav; 
		}
		//구지 페이지 이동만하기때문에 modelanview를 쓸필요하는 없다. 데이터를 가지고 넘어가는 것이 아니기때문에...
		@RequestMapping(value="/update.board", method=RequestMethod.POST)//POST방식 이동, 예from로 통해 이동
		public String submitted(@ModelAttribute BoardDto dto, HttpSession session){//@ModelAttribute란
			System.out.println("글 업데이트 저장....");
			System.out.println("업데이트 히든으로 넘겨온 넘버값"+dto.getB_num());
			//System.out.println(dto.getB_title() +","+ dto.getB_content());
			String session_filename = (String)session.getAttribute("filename2");
			String session_filepath = (String)session.getAttribute("filepath2");
			dto.setFilename(session_filename);
			dto.setFilepath(session_filepath);
			try {
				System.out.println("파일 넘버 :"+dto.getB_num());
				System.out.println("파일 제목 :"+dto.getB_title());
				System.out.println("파일 이름 :"+dto.getFilename());
				System.out.println("파일 경로 :"+dto.getFilepath());
				boardService.update(dto);
				System.out.println("b_num값은?"+dto.getB_num());
				System.out.println("실행되니??"+ dto.getB_content());
			} catch (Exception err) {
				System.out.println("writeErrorMessage:"+ err);
			}
			System.out.println("아마도 되는듯");
			return "redirect:list.board";//"/WEB-INF/views/board/list.jsp";//dB를 거치지 않고 가기때문에 입력한 결과값이 보지 않고 나온다.
																			//이것을 해결하기위해 redirect:를 사용한다. 마치 클라이언트가 다시 서버에 요청한것 처럼...결과를 준다.
		}
		
}
