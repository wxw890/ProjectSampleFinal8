package com.hta.book.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hta.board.repository.BoardDto;
import com.hta.board.service.BoardService;
import com.hta.book.bookimgdao.BookImgDao;
import com.hta.book.repository.BookDto;
import com.hta.book.service.BookService;

@Controller
public class BookUpdateController {
   private BookService bookService;
   
   

   public void setBookService(BookService bookService) {
      this.bookService = bookService;
   }



   @RequestMapping(value="/bookupdate", method=RequestMethod.GET)
   public ModelAndView changehandle(@RequestParam int book_num){
      ModelAndView mav = new ModelAndView("bookupdate");
      BookDto dto = bookService.findBynum(book_num);
      
      mav.addObject("dto", dto);
      return mav;
      
   }
   @RequestMapping(value="/bookupdate", method=RequestMethod.POST)
   public String submitted(@ModelAttribute BookDto dto){
      try{
         MultipartFile file = dto.getUpFile();//uploadDto.getUpFile()의 type이 MultipartFile이므로 MultipartFile로 받아준다.
         /*
         String path = 
               WebUtils.getRealPath(req.getSession().getServletContext(), "/upload");//WebUtils.getRealPath는 실제 경로를 전달해준다. 즉, upload폴더의 위치를 알아 낼수 있다.
               */
         
     	String path = "F:/springWorkSpace/ProjectSample2-master/src/main/webapp/upload";
         BookImgDao uploadDao = new BookImgDao();
         
         uploadDao.writeFile(file, path, file.getOriginalFilename());
         dto.setBook_img(file.getOriginalFilename());
         try {
            bookService.updatebook(dto);
         
         } catch (Exception err) {
            System.out.println("writeErrorMessage:"+ err);
         }
       } 
      catch (IOException e) {
                    e.printStackTrace();
      }
      
      return "redirect:success.book";
   }
   
   
   
}