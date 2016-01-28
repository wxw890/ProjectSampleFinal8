package com.hta.studyroom.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hta.studyroom.repository.StudyroomDto;

import mybatis.StudyroomManager;


//이곳은 스터디룸 예약에 관련된 DB작업을  하는 클래스. StudyroomService interface를 상속받았다. Mybatis를 사용.
public class StudyroomServiceImpl implements StudyroomService {

	private JdbcTemplate JdbcTemplate;  //디비 연결 (스프링 JDBC 접근방법), 즉 

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {JdbcTemplate = jdbcTemplate;}
	// 여기들어간다.
	
	/*
	//예약 리스트 전체보기
	public List getRoomResList() throws SQLException {
		
		return StudyroomManager.getRoomResList();
	}*/
	
	//예약 쓰기 기능
	public void resWrite(StudyroomDto studyroomdto) throws SQLException {
		System.out.println("resWrite 임무 시작(같은거 있나 찾고있음)");
		//StudyroomDto dto = StudyroomManager.findBySameResurvation(studyroomdto);//현재 예약을 확인하고 없으면 null을 반환해서 밑에 if문에 걸리게할 계획이다.
		
		System.out.println("resWrite 임무 시작(같은거 있나 찾음 완료)");
		//if(dto == null){
			System.out.println("resWrite 임무중(집어 넣을려고함)");	
			StudyroomManager.resWrite(studyroomdto);//입력 부분
			System.out.println("resWrite 임무중(집어 넣었음)");
		//}
		System.out.println("resWrite 임무완료후 종료(결국 같은거 찾아서 못집어넣음)");
	}
	//현재 예약 확인
	public StudyroomDto findBySameResurvation(StudyroomDto studyroomdto) throws SQLException{
		return StudyroomManager.findBySameResurvation(studyroomdto);
	}
	
	//예약 내용 읽기
	public List findByRes_num(String member_email) throws SQLException {
			
		List list = StudyroomManager.findByRes_num(member_email);
		return list;
	}
		
	//예약 삭제 기능 - 차후 예약 취소쪽으로 생각
	public void resDelete(int reservation_num) throws SQLException {
		
		StudyroomManager.resDelete(reservation_num);
	}
	
	//회원의 예약 찾기
	public List Searchreservation(String date){
		List list = StudyroomManager.searchReservation(date);
		
		return list;
	}

}