package com.hta.board.controller;

import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hta.board.repository.BoardDto;
import com.hta.board.service.BoardService;
//write.jsp로 이동하는 작업, DB로 입력하는 작업, 즉, 두가지의 작업이 있으므로 메서드도 2개가 필요하다.
@Controller
public class WriteController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {//여기에 들어간다.
		this.boardService = boardService;
	}
	//페이지 이동
	@RequestMapping(value="/write.board",  method=RequestMethod.GET)//GET방싱 이동, 예 href로 통해 이동
	public String pageHandler(){
		return "/board/write"; 
	}
	//구지 페이지 이동만하기때문에 modelanview를 쓸필요하는 없다. 데이터를 가지고 넘어가는 것이 아니기때문에...
	@RequestMapping(value="/write.board", method=RequestMethod.POST)//POST방식 이동, 예from로 통해 이동
	public String  submitted(@ModelAttribute BoardDto dto, HttpSession session){//@ModelAttribute란
		//System.out.println("글 저장....");
		//System.out.println(dto.getB_title() +","+ dto.getB_content());
		//String session_name = (String)session.getAttribute("name");//로그인 이름 불러오기
		String session_email = (String)session.getAttribute("email");
		String session_filename = (String)session.getAttribute("filename");//UploadConroller.java에서 session으로 저장한 filename과 filepath를 불러온다.
		String session_filepath = (String)session.getAttribute("filepath");
		
		dto.setFilename(session_filename);
		dto.setFilepath(session_filepath);
		
		session.setAttribute("filename", null);//session값을 다시 null 로해줘야 이미지를 업로드를 하지 않은 글에 그전에 업로드한 이미지의 이름과 경로가 적용되지 않는다.
		session.setAttribute("filepath", null);
		
		System.out.println("글번호"+dto.getB_num());
		System.out.println("글내용"+dto.getB_count());
		System.out.println("글타이틀"+dto.getB_title());
		System.out.println("글파일 이름"+dto.getFilename());
		System.out.println("글파일 경로"+dto.getFilepath());
		
		dto.setB_writer(session_email);//작성자에 이름 집어넣기
		
		try {
			boardService.posupdateall(dto);
			boardService.write(dto);
		} catch (Exception err) {
			System.out.println("writeErrorMessage:"+ err);
		}
		return "redirect:list.board";//"/WEB-INF/views/board/list.jsp";//dB를 거치지 않고 가기때문에 입력한 결과값이 보지 않고 나온다.
																		//이것을 해결하기위해 redirect:를 사용한다. 마치 클라이언트가 다시 서버에 요청한것 처럼...결과를 준다.
	}
	
}