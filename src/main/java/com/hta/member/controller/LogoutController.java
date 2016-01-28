package com.hta.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hta.member.service.MemberService;

@Controller
public class LogoutController {
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	@RequestMapping("/logout.member")
	public String pageMove(HttpSession session){
		//session.setAttribute("name", null);
		session.invalidate();
		return "logout";
	}
}
