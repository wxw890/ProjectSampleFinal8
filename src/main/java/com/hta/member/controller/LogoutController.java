package com.hta.member.controller;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hta.member.service.MemberService;

@Controller
public class LogoutController {
	private MemberService memberService;
	private static Hashtable<String, String> loginUsers = new Hashtable();
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping("/logout.member")
	public String pageMove(HttpSession session){
		session.setAttribute("name", null);
		loginUsers = (Hashtable<String, String>) session.getAttribute("loginUsersall");//session으로 list와 hashtable값을 가져오면 과부화가 일어난다.
		String key = (String) session.getAttribute("email");                           //그렇게 때문에 다른 방법을 생각해봐야한다. requser등...(현재 시간이 없는 관계로 session으로 불러옴...)
		System.out.println("1.로그아웃"+key);
		//loginUsers.get(key);
		System.out.println("로그아웃하면 저장된 키값 유지?"+loginUsers.get(key));
		loginUsers.remove(key);
		session.invalidate();
		return "logout";
	}
}
