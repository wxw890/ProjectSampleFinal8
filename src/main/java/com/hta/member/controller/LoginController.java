package com.hta.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hta.exception.IdPasswordNotMachingException;
import com.hta.member.repository.LoginCommand;
import com.hta.member.repository.Member;
import com.hta.member.service.MemberService;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;


//로그인 컨트롤러
@Controller
public class LoginController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/login.member")   
	public String form(LoginCommand loginCommand, @CookieValue(value="remember", required=false) Cookie cook){ //로그인 페이지 이동, 매개변수 LoginCommand를 선언한 이유는 email, password, rememberemail을 전달 받기 위해서이다...
						//Spring에서는 밑에 LoginCommand loginCommand과 지금 LoginCommand loginCommand은 같은 객체로 처리해준다.
						//@CookieValue(value="remember", required=false) Cookie cook이란 우선 밑에 쿠키 값을 읽어오는 역할을하는 annotation이다., required=false필수로 ,
		
		if(cook != null){//이메일이 쿠키에 저장되어있어서 null값이 아니면 
			loginCommand.setEmail(cook.getValue());//저장되어있는 cook의 이메일 정보를 이메일에 저장
		}
		
		return "login"; //bundleview사용 -->사용방법: bundleview.properties에 경로 및 사용할 이름을 적는다.(view-config.xml에 BundleViewResolver를 설정했다고 가정하에... )
	}
	
	@RequestMapping(value="/login.member", params={"command=submit"})//params={"command=submit"}이란 parame값을 통해 같은 요청에 대한 구분을 할수 있다.
	public String submit(LoginCommand loginCommand, HttpSession session, HttpServletResponse resp) throws Exception{ //로그인 페이지에서 입력된 값 수행
		try{															//HttpServletResponse는 사용자 쪽으로 넘겨줄려면
			resp.setContentType("text/html;charset=utf-8"); 
			
			String originalText = loginCommand.getPassword();//암호--->암호화안된 오리지날 암호
            String key = loginCommand.getEmail();//이메일 --->여기선 키값으로...
            String en = Encrypt( originalText, key);//암호화
            String de = Decrypt( en, key);//복호화
            loginCommand.setPassword(en);//암호화 암호 저장
            
            System.out.println( "Original Text is " + originalText);
            System.out.println( "Encrypted Text is " + en );
            System.out.println( "Decrypted Text is " + de );
			
			
			Member result = memberService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());//로그인할 이메일,비번 인증
			System.out.println("로그인:"+loginCommand.getEmail());
			if(result != null){ // 값이 null아닌경우
				session.setAttribute("name", result.getMember_name()); //이름을 seesion에 저장 누가 로그인 성공했는지 이름을 출력하기위해서...세션으로 넘겨서 index에서 사용하게위해서 EL태크로
				session.setAttribute("email", result.getMember_email());//패스워드 변경을 위해 이때 세션값에 email을 저장해야한다. email은 mybatis에서 비번 변경 업데이트의 기준이 되기때문에 필요함다.
				System.out.println("로그인시 메일출력:"+result.getMember_email());
				System.out.println("로그인시 이름출력:"+result.getMember_name());
			}
		}
		catch(IdPasswordNotMachingException err){
			PrintWriter out = resp.getWriter();     
			out.println("<script>alert('아이디와 비밀번호를 제대로 입력해주세요!');</script>");
			out.flush();
			return "login";
		}
		
		//여기서 이메일을 쿠키에 저장할 한다.(이메일 기억하기)
		Cookie rememberCook= new Cookie("remember", loginCommand.getEmail()); //쿠키를 remember이름으로 저장
		if(loginCommand.isRememberEmail()){//loginCommand 즉, dto에 isRememberEmail()사용한다.
			rememberCook.setMaxAge(60*60*24*30);//쿠키는 어제까지 저장할찌 지정해줘야한다. 지정안하면 접속이 끊어지는 순간 값이 사라진다.
		}
		else{
			rememberCook.setMaxAge(0);
		}
		resp.addCookie(rememberCook);//사용자 페이지에 보내준다.
		return "loginSuccess";
	}
	
		
	
	//암호화 소스부분
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
	 
}
