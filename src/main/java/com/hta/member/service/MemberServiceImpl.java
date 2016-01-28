package com.hta.member.service;

import java.sql.SQLException;

import com.hta.member.repository.Member;
import com.hta.exception.IdPasswordNotMachingException;

import mybatis.MemberManager;

public class MemberServiceImpl implements MemberService {

	public void write(Member dto) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("이름 값:"+dto.getMember_name());
		MemberManager.write2(dto);
	}
	
	public Member selectByEmail(String email) {
		
		return MemberManager.selectByEmail(email); //주입된 이메일 값 전달
	}

	public Member authenticate(String email, String password) {// 다가져가는게 좋다.
		// TODO Auto-generated method stub
		Member dto = MemberManager.selectByEmail(email);//dto는 여기서 모든 정보를 가져오고 있다.
		
		if(dto == null){//입력한 email에 관한 정보가 DB에 없을 경우
			throw new IdPasswordNotMachingException(); //
		}
		
		if(!dto.matchPassword(password)){
			throw new IdPasswordNotMachingException();
		}
		
		return dto;
	}

	public void pwChage(String email, String passwordcomf, String newpassword, String newpasswordcomf) {//비밀변경 서비스부분
		//sql문으로 db를 찾을때 기준이 되어줄 email(로그인시 미리 세션에 저장된 email이다.)과 변경 페이지에서 사용자로부터 받은 passwordcomf(기존 비밀번호), 
		//newpassword(새비밀번호), newpasswordcomf(새비밀번호 확인)를 매개변수로 받아온다.
		System.out.println("새비밀번호:"+newpassword);
		System.out.println("새비밀번호확인:"+newpasswordcomf);
		System.out.println("1로그인 ServiceImpl:"+ email);
		Member dto = MemberManager.selectByEmail(email);//이메일로 변경할 회원 정보를 찾아서 Member dto에 저장한다.
		
		if(dto == null){//즉, 회원정보가 없을때
			throw new IdPasswordNotMachingException();
		}
		
		if(!dto.matchPassword(passwordcomf)){//비밀번호가 안맞을때
			System.out.println("비밀번호가 안맞을때");
			throw new IdPasswordNotMachingException();
		}
		
		if(!newpassword.equals(newpasswordcomf)){//새 비밀번호와 새 비밀번호 확인이 안맞을때
			System.out.println("새 비밀번호와 새 비밀번호 확인이 안맞을때");
			throw new IdPasswordNotMachingException();
		}
		if(dto.matchPassword(passwordcomf)){//비번이 맞으면
			dto.setMember_password(newpassword);//새로운 비번 입력한다.
			System.out.println("****변경된 비번:"+dto.getMember_password());
			MemberManager.update5(dto);
		}
			
		//return dto;
	}
	

}
