package com.hta.member.service;

import java.sql.SQLException;

import com.hta.board.repository.BoardDto;
import com.hta.member.repository.Member;

public interface MemberService {

		//글 저장하기
		public void write(Member dto) throws SQLException;
		
		public Member selectByEmail(String email);//같은 이메일인지 검증
		
		public Member authenticate(String email, String password);//로그인 인증
		
		public void pwChage(String email, String password, String newpassword, String newpasswordcomf);//비밀번호 변경
		
	
			
}
