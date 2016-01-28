package com.hta.board.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.hta.board.repository.BoardDto;
import com.hta.board.repository.UploadDto;

import com.hta.board.service.BoardService;
import com.hta.book.repository.BookandRentalDto;

@Controller
public class UploadController {
	private MultipartResolver files;
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	


	

	@RequestMapping(value="/upload.spring", method=RequestMethod.POST)
	public ModelAndView firstSubmitHandler(@ModelAttribute UploadDto uploadDto, HttpServletRequest req, HttpSession session) throws IOException{
		ModelAndView mav = new ModelAndView("/board/write");
		//String title = req.getParameter("title");
		//System.out.println("뭐냐"+title);

		String filePath = uploadDto.getFiles().getName();
		String fileName = uploadDto.getFiles().getOriginalFilename();
		long fileSize = uploadDto.getFiles().getSize(); 
		System.out.println("업로드파일"+fileName);
		System.out.println("1업로드파일경로"+filePath);
		//String path = 
				//WebUtils.getRealPath(req.getSession().getServletContext(), "/Uploadimages/");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
		//System.out.println("2업로드파일경로"+path);
		
		Set pathset = req.getSession().getServletContext().getResourcePaths("/");//다른 경로 확인 방법인것같다.
		System.out.println("2-1. 실제 경로"+ pathset);
		String pdfPath = req.getSession().getServletContext().getRealPath("/");//실제 경로를 찾아준다. 즉, req.getSession().getServletContext().getRealPath()이라는 뜻은
																		//   workspace/프로젝트폴더명/src/main/webapp을 뜻한다.
																		// 그리고 "/images/Uploadimages/"이란 webapp+/images/Uploadimages/를 붙인다는 뜻이다. 
		
		String savePath = pdfPath + "images/Uploadimages/";
		
		System.out.println("2-2. 실제 경로"+ pdfPath);
		System.out.println("2-3. 실제 경로"+ savePath);
		File file = new File(savePath+uploadDto.getFiles().getOriginalFilename());//전체 실제경로 + 파일이름
		System.out.println("3.업로드 파일경로"+ file.getPath());
		
		String path2="images/Uploadimages/";//실제 경로(전체 경로를 사용하지 않는 이유는 jsp에서 img로 출력할때 전체경로로는 출력이 안되기 때문이다.)
		session.setAttribute("filename", fileName);
		session.setAttribute("filepath", path2);
		
		try{
			uploadDto.getFiles().transferTo(file);//경로부분에 저장
			mav.addObject("path", path2);
			mav.addObject("name", fileName);
		}catch(IllegalStateException e1){
			e1.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		return mav;
		
		
		/*
		MultipartFile file = uploadDto.getUpFile();//uploadDto.getUpFile()의 type이 MultipartFile이므로 MultipartFile로 받아준다.
		System.out.println(uploadDto.getUpFile().getOriginalFilename());
		String path = 
			WebUtils.getRealPath(req.getSession().getServletContext(), "/upload");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
		System.out.println("파일경로:"+path);
		UploadDao uploadDao = new UploadDao();
	
		
		boardService.writeFile(file, path, file.getOriginalFilename());//실제 파일 업로드를 시켜주는 부분
		*/
		
	}
	
	

	@RequestMapping(value="/upload2.spring", method=RequestMethod.POST)
	public ModelAndView secondSubmitHandler(@ModelAttribute UploadDto uploadDto,@ModelAttribute BoardDto dto, HttpServletRequest req, HttpSession session) throws IOException{
		ModelAndView mav = new ModelAndView("/board/update");
		//String title = req.getParameter("title");
		//System.out.println("뭐냐"+title);
		
		String filePath = uploadDto.getFiles().getName();
		String fileName = uploadDto.getFiles().getOriginalFilename();
		long fileSize = uploadDto.getFiles().getSize(); 
		System.out.println("upload2.spring 업로드파일"+fileName);
		System.out.println("1업로드파일경로"+filePath);
		System.out.println("업로드 dto 넘버"+dto.getB_num());
		BoardDto dto1 = boardService.findBySeq(dto.getB_num());
		mav.addObject("dto", dto1);
		//String path = 
				//WebUtils.getRealPath(req.getSession().getServletContext(), "/Uploadimages/");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
		//System.out.println("2업로드파일경로"+path);
		
		Set pathset = req.getSession().getServletContext().getResourcePaths("/");//다른 경로 확인 방법인것같다.
		System.out.println("2-1. 실제 경로"+ pathset);
		String pdfPath = req.getSession().getServletContext().getRealPath("/");//실제 경로를 찾아준다. 즉, req.getSession().getServletContext().getRealPath()이라는 뜻은
																		//   workspace/프로젝트폴더명/src/main/webapp을 뜻한다.
																		// 그리고 "/images/Uploadimages/"이란 webapp+/images/Uploadimages/를 붙인다는 뜻이다. 
		
		String savePath = pdfPath + "images/Uploadimages/";
		
		System.out.println("2-2. 실제 경로"+ pdfPath);
		System.out.println("2-3. 실제 경로"+ savePath);
		File file = new File(savePath+uploadDto.getFiles().getOriginalFilename());//전체 실제경로 + 파일이름
		System.out.println("3.업로드 파일경로"+ file.getPath());
		
		String path2="images/Uploadimages/";//실제 경로(전체 경로를 사용하지 않는 이유는 jsp에서 img로 출력할때 전체경로로는 출력이 안되기 때문이다.)
		session.setAttribute("filename2", fileName);
		session.setAttribute("filepath2", path2);
		
		try{
			uploadDto.getFiles().transferTo(file);//경로부분에 저장
			mav.addObject("path", path2);
			mav.addObject("name", fileName);
		}catch(IllegalStateException e1){
			e1.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		return mav;
		
		
		/*
		MultipartFile file = uploadDto.getUpFile();//uploadDto.getUpFile()의 type이 MultipartFile이므로 MultipartFile로 받아준다.
		System.out.println(uploadDto.getUpFile().getOriginalFilename());
		String path = 
			WebUtils.getRealPath(req.getSession().getServletContext(), "/upload");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
		System.out.println("파일경로:"+path);
		UploadDao uploadDao = new UploadDao();
	
		
		boardService.writeFile(file, path, file.getOriginalFilename());//실제 파일 업로드를 시켜주는 부분
		*/
		
	}
	
}
