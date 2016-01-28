package com.hta.book.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hta.member.repository.Member;
import com.hta.board.repository.BoardDto;
import com.hta.book.repository.BookDto;

import com.hta.book.repository.BookResDto;
import com.hta.book.repository.BookandRentalDto;
import com.hta.book.repository.ConditionDto;

import com.hta.book.repository.RentalInfoDto;
import com.hta.exception.IdPasswordNotMachingException;

import mybatis.BoardManager;
import mybatis.BookManager;
import mybatis.MemberManager;

public class BookServiceImpl implements BookService {

	public void bookinput(BookDto dto) throws SQLException {
		BookManager.bookinput(dto);
		
	
		
	}
	
	// å ����Ʈ ��ü �����ֱ�
	public List getList() throws SQLException{
		return BookManager.getList();
		
	}
	
	// �� �԰�¥ ���ò��� �����ֱ�
	public List todayList() throws SQLException{
		return BookManager.todayList();
		
	}
	
	//�� ����
	public BookDto findBynum(int book_num) {
		BookDto dto = new BookManager().finBynum(book_num);
		return dto;
	}
	
	//�ۻ���
	public void bookdelete(int book_num) {
	
		BookManager.deletebook(book_num);
	}
	
	//�� ����
	public void updatebook(BookDto dto) {
		BookManager.updatebook(dto);
		
	}

	//���� å������ ����Ʈ�� �ϳ��� �������� �ϴ� �� ���
	public List samelist(String book_title) {
		return BookManager.samelist(book_title);
	}
	
	//å ���ǰ˻�
	public List condition1(ConditionDto dto) {
		return BookManager.condition1(dto);
	}
	
	//å ���ǰ˻�
	public List condition2(ConditionDto dto) {
		return BookManager.condition2(dto);
	}
	
	//å ���ǰ˻�
	public List condition3(ConditionDto dto) {
		return BookManager.condition3(dto);
	}
	
	//����� å �뿩
	public void bookrental(BookDto dto,RentalInfoDto infodto,int book_num) {
	
		BookManager.rentalbook(dto, infodto, book_num);
		
	}
	
	//����� å �뿩 ����Ʈ
	public List mylist( BookandRentalDto joindto) {
		// TODO Auto-generated method stub
		return BookManager.mylist(joindto);
	}
	
	//����� å �ݳ� 
	public void bookreturn(int book_num, String member_email,int rental_num) {
		BookManager.bookreturn(book_num, member_email,rental_num);
		
	}
	
	//����� å ����
	public void bookres(int book_num, BookResDto resdto,String member_email) {
		BookManager.bookres(book_num, resdto,member_email);
		
	}
	
	//����� å ���� ����Ʈ
	public List myreslist(BookandRentalDto joindto) {
		// TODO Auto-generated method stub
		return BookManager.myreslist(joindto);
	}
	
	//å ���� 
	public void bookextension(int book_num) {
		BookManager.bookextension(book_num);
		
	}
	
	//å ���� ���
	public void bookrescancel(int book_num,String member_email,int res_num) {
		BookManager.bookrescancel(book_num,member_email,res_num);
		
	}
	
	//������ ���� ��� 
	public void bookrestodaycancel() {
		BookManager.bookrestodaycancel();
		
	}
	
	//�����ڿ��� �������� ��ü �뿩 å ����Ʈ
	public List rantalinfoList(){
		// TODO Auto-generated method stub
		return BookManager.rantalinfolist();
	}
	
	//�����ڿ��� �������� ��ü ���� å ����Ʈ
	public List resbookList() {
		// TODO Auto-generated method stub
		return BookManager.resbooklist();
	}
	
	//����ڰ� ���� �Ŀ� å�� �뿩
	public void bookresrental(BookDto dto, RentalInfoDto infodto, int book_num) {
		BookManager.resrentalbook(dto, infodto, book_num);
		
	}

	public List memorylist(BookandRentalDto joindto) {
		// TODO Auto-generated method stub
		return BookManager.memorylist(joindto);
	}
	
	
	
	
	

}
