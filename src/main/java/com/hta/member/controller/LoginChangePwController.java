package com.hta.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hta.exception.IdPasswordNotMachingException;
import com.hta.member.repository.LoginChangePwCommand;
import com.hta.member.repository.LoginCommand;
import com.hta.member.repository.Member;
import com.hta.member.service.MemberService;




import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 

@Controller
public class LoginChangePwController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping("/loginchange.member")//단순 비번 변경 페이지 페이지 이동
	public String loginChagePageMove(){
		return "loginchage";
	}
	@RequestMapping(value="/loginchange.member", params={"command2=submit2"})
	public String loginChagePW(LoginChangePwCommand loginchangepwcommand, HttpSession session, HttpServletResponse response) throws Exception{
	try{
		 response.setContentType("text/html;charset=utf-8");       
		 System.out.println("1 session값:"+session.getAttribute("name"));
		 String email= (String) session.getAttribute("email");
		 System.out.println("2 session값:"+email);
		 
		
		 String originalText = loginchangepwcommand.getPasswordcomf();
		 String newOriginalText = loginchangepwcommand.getNewpassword();
		 String newOriginalTextComf = loginchangepwcommand.getNewpasswordcomf();
         String key = email;
         String en = Encrypt( originalText, key);//오리지날 암호--->암호화
         String newEn = Encrypt(newOriginalText, key);//새암호 --->암호화
         String newEnComf =  Encrypt(newOriginalTextComf, key);//새암호 확인 --->암호화
         String de = Decrypt( en, key);//복호화
        
         loginchangepwcommand.setPasswordcomf(en);
         loginchangepwcommand.setNewpassword(newEn);
         loginchangepwcommand.setNewpasswordcomf(newEnComf);
         
         System.out.println( "Original Text is " + originalText);
         System.out.println( "Encrypted Text is " + en );
         System.out.println( "Decrypted Text is " + de );
		
		
		
		memberService.pwChage(email, loginchangepwcommand.getPasswordcomf(), loginchangepwcommand.getNewpassword(), loginchangepwcommand.getNewpasswordcomf());
		
	}
	catch(IdPasswordNotMachingException err){
		
		PrintWriter out = response.getWriter();     
		out.println("<script>alert('비밀번호를 확인해주세요!');</script>");
		out.flush();
		return "loginchage";
	}
	System.out.print("1 으아!!!여기까지는 오냐?>?");
	return "loginChangeSuc";
  }
	
	
	 //복호화
	 public static String Decrypt(String text, String key) throws Exception
     {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               byte[] keyBytes= new byte[16];
               byte[] b= key.getBytes("UTF-8");
               int len= b.length;
               if (len > keyBytes.length) len = keyBytes.length;
               System.arraycopy(b, 0, keyBytes, 0, len);
               SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
               IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
               cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);

               BASE64Decoder decoder = new BASE64Decoder();
               byte [] results = cipher.doFinal(decoder.decodeBuffer(text));
               return new String(results,"UTF-8");
     }
	 //암호화
     public static String Encrypt(String text, String key) throws Exception
     {
               Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
               byte[] keyBytes= new byte[16];
               byte[] b= key.getBytes("UTF-8");
               int len= b.length;
               if (len > keyBytes.length) len = keyBytes.length;
               System.arraycopy(b, 0, keyBytes, 0, len);
               SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
               IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
               cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

               byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
               BASE64Encoder encoder = new BASE64Encoder();
               return encoder.encode(results);
     }
}
