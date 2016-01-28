package com.hta.QandAboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hta.QandAboard.repository.BoardDto;
import com.hta.QandAboard.service.BoardService;

@Controller
public class ReplyController {
private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	@RequestMapping("/reply.board2")
	public ModelAndView ReplyPageMove(@RequestParam int b_seq){
		ModelAndView mav = new ModelAndView("/QandAboard/Reply");
		BoardDto dto = boardService.findBySeq(b_seq);
		
		mav.addObject("dto",dto);
		return mav;
	}
	//리플 처리를 하고 view 페이지에 리스트를 출력해야한다. 우선 dto를 히든으로 보내져서 값이 온다.여기서 기준 b_num
	@RequestMapping(value="/reply.board2", method=RequestMethod.POST)
	public String ReplyWriter(@ModelAttribute BoardDto rdto){//rdto는 답글 dto이다. 하지만 여기에 부모글에 대한 b_num도 가지고있다.
		BoardDto dto=boardService.findBySeq(rdto.getB_num());//여기서 b_num을 통해 부모글의 dto를 찾아서 dto에 저장하낟.
		boardService.posupdate(dto);//부모글보다 큰 pos글들을 찾아서 +1업데이트
		rdto.setPos(dto.getPos());
		rdto.setDepth(dto.getDepth());
		//rdto.setB_num(dto.getB_num());
		System.out.println("1 reply 부모 넘버와 내용"+dto.getB_num()+","+ dto.getB_content());
		System.out.println("1 reply 자식 넘버와 내용"+rdto.getB_num()+","+ rdto.getB_content());
		System.out.println("2 reply 부모 pos, depth!!!"+dto.getPos()+","+dto.getDepth());
		System.out.println("2 reply 자식 pos, depth!!!"+rdto.getPos()+","+rdto.getDepth());
		boardService.Reply(rdto);
		return "redirect:list.board2";
	}
}
