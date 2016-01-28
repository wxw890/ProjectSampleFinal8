package com.hta.studyroom.service;

import java.sql.SQLException;
import java.util.List;

import com.hta.studyroom.repository.StudyroomDto;
//인터페이스
public interface StudyroomService {
	//전체 예약 목록 가져오기
	/*public List getRoomResList() throws SQLException;*/
	
	//특정 예약 목록 가져오기(읽기 기능)
	public List findByRes_num(String member_email) throws SQLException;
	
	//현재 예약 확인
	public StudyroomDto findBySameResurvation(StudyroomDto studyroomdto) throws SQLException;
	
	//예약 저장
	public void resWrite(StudyroomDto studyroomdto) throws SQLException;
	
	//예약 삭제
	public void resDelete(int reservation_num) throws SQLException;
	
	//회원의 예약 찾기
	public List Searchreservation(String date);
}
