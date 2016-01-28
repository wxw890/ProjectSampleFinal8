package com.hta.book.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.hta.book.bookimgdao.BookImgDao;
import com.hta.book.repository.BookDto;
import com.hta.book.service.BookService;




@Controller
public class BookInputController {
	private BookService bookService;

	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	//book ����������
	@RequestMapping(value="/bookinput", method=RequestMethod.GET)
	public String bookinhandle(){
		
		return "bookinput";
		
	}
	
	//book 추가 메서드
	@RequestMapping(value="/bookinput", method=RequestMethod.POST)
	public String booksubmit(@ModelAttribute BookDto dto, HttpServletRequest req) throws IOException {
		try{
			MultipartFile file = dto.getUpFile();//uploadDto.getUpFile()의 type이 MultipartFile이므로 MultipartFile로 받아준다.
			/*
			String path = 
					WebUtils.getRealPath(req.getSession().getServletContext(), "/upload");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
					*/
			
			String path = req.getSession().getServletContext().getRealPath("/") + "/upload";
			BookImgDao uploadDao = new BookImgDao();
	
			uploadDao.writeFile(file, path, file.getOriginalFilename());
			dto.setBook_img(file.getOriginalFilename());
			
			
            try {
				bookService.bookinput(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
		catch (IOException e) {
                e.printStackTrace();
		}
		
		return "redirect:bookinput";//å �߰� �Ұ� ���� ��� ����ؼ� �ٽ� ���� �ȴ�.
		
	}
	
	//��ü ��� �����ֱ� 
	@RequestMapping("/success.book")
	public ModelAndView pageHandler(){
		ModelAndView mav = new ModelAndView("successbook");
		try {
			
			List list = bookService.getList();
			System.out.println("input size :"+list.size());
			mav.addObject("list", list);
		} catch (Exception err) {
			System.out.println("ListController:pageHandler():" + err);
		}
	
		return mav;
		
	}
	
	//���� ����� å ��� �����ֱ�
	@RequestMapping("/today.book")
	public ModelAndView pageHandler1(){
		ModelAndView mav = new ModelAndView("todaybook");
		try {
				
			List list = bookService.todayList();
				
			mav.addObject("list", list);
		} catch (Exception err) {
			System.out.println("ListController:pageHandler():" + err);
		}
	
		return mav;
			
	}
	
	
}
