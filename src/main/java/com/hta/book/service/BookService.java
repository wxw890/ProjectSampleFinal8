package com.hta.book.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.hta.board.repository.BoardDto;
import com.hta.book.repository.BookDto;

import com.hta.book.repository.BookResDto;
import com.hta.book.repository.BookandRentalDto;
import com.hta.book.repository.ConditionDto;
import com.hta.book.repository.RentalInfoDto;


public interface BookService {

		//å �߰�
		public void bookinput(BookDto dto) throws SQLException;
		//��ü ��¸���Ʈ
		public List getList() throws SQLException;
		//å����
		public BookDto findBynum(int book_num);
		//���ó�¥�� ���
		public List todayList() throws SQLException;
		//����
		public void bookdelete(int book_num);
		//����
		public void updatebook(BookDto dto);
		//���ǰ˻�
		public List samelist(String book_title);
		//���ǰ˻�1
		public List condition1(ConditionDto dto);
		//���ǰ˻�2
		public List condition2(ConditionDto dto);
		//���ǰ˻�3
		public List condition3(ConditionDto dto);
		//å �뿩
		public void bookrental(BookDto dto, RentalInfoDto infodto, int book_num);
		//å �뿩 ����Ʈ
		public List mylist(BookandRentalDto joindto);
		//å �ݳ�
		public void bookreturn(int book_num,String member_email,int rental_num);
		//å ����
		public void bookres(int book_num, BookResDto resdto,String member_email);
		//å ���� ����Ʈ
		public List myreslist(BookandRentalDto joindto);
		//å ����
		public void bookextension(int book_num);
		//å ���� ���
		public void bookrescancel(int book_num,String member_email,int res_num);
		//������ ���� ���
		public void bookrestodaycancel();
		//������ �뿩 ����Ʈ
		public List rantalinfoList();
		//������ ���� ����Ʈ
		public List resbookList();
		//����ڰ� å ���� �Ŀ� �뿩
		public void bookresrental(BookDto dto, RentalInfoDto infodto, int book_num);
		
		public List memorylist(BookandRentalDto joindto);
		

		
		
		
}