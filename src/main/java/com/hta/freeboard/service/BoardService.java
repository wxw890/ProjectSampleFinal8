package com.hta.freeboard.service;

import java.sql.SQLException;
import java.util.List;

import com.hta.freeboard.repository.BoardDto;
//인터페이스
public interface BoardService {
	//전체 글 가져오기
	public List getList();
	
	public List findKeyword(BoardDto dto);
	
	//특정 글 가져오기(읽기 기능)
	public BoardDto findBySeq(int seq);
	
	//글 저장하기
	public void write(BoardDto dto);
	
	//글 수정하기
	public void update(BoardDto dto);
	
	//글 삭제하기
	public void delete(int seq);
	
	//리플달기
	public void Reply(BoardDto dto);
	
	//부모보다 높은 pos들 +1씩 증가(답글에 필요함)
	public void posupdate(BoardDto dto);
	
	//일반 글을추가시 자기 자신보다 큰 pos값을 가진 글들의 pos를 +1씩 증가(답글에 필요함)
	public void posupdateall(BoardDto dto);
	
	public void increaseCount(BoardDto dto);
}

