package com.hta.QandAboard.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate; //jdbcTemplate을 import하면 mybatis에서 쓸필요가없어서 소스부분을 지우면 import부분때문에 db접근에 mybatis와 jdbcTemplate간에 충돌이 일어나는 것같다.... 
													 
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.hta.QandAboard.repository.BoardDto;

import mybatis.QandABoardManager;

//이곳이 DB관련 데이터를 수정, 삭제, 입력, 등의 기능을 하는 클래스이다. DB관련 작업은 여기서 한다.--->mybatis를 사용하면 코드에서 이렇게 DB관련 작업을 필요없게 만든다.
public class BoardServiceImpl implements BoardService {
	/*
	private JdbcTemplate JdbcTemplate;//디비 연결 (스프링 JDBC 접근방법), 즉 
	
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {// 여기들어간다.
		JdbcTemplate = jdbcTemplate;
	}*/

	public List getList(){//리스트 전체 보기 기능
		/*
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("aaaa");
		list.add("aaaaaaa");
		list.add("aaaaaaaaa");
		*/
		/*//mybatis의 이용이로 생략가능
		String sql = "select * from tblSpringBoard order by b_seq desc";//desc는 내림차순
		List<BoardDto> list = new ArrayList<BoardDto>();//<>는 제네릭스 표현방식 즉, list와 ArrayList 안에 담을수 있는 자료형은 BoardDto클래스 타입뿐이라는 뜻이다.
		//여기서 Dto에 list들을 집어넣는다.
		*/
		/*RowMapper rowmap = new RowMapper(){//RowMapper는 ResultSet의 레코드와 객체를 매핑 시키는 역할(결과값을 DB에 받아와서 그것을 뿌려주는 역할)

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {//오버라이딩(무명클래스로 만듬:클래스 없이 클래스를 만든경우)
				BoardDto dto = new BoardDto();
				dto.setB_content(rs.getString("b_content"));
				dto.setB_hitcount(rs.getInt("b_hitcount"));
				dto.setB_password(rs.getString("b_password"));
				dto.setB_regdate(rs.getString("b_regdate"));
				dto.setB_seq(rs.getInt("b_seq"));
				dto.setB_title(rs.getString("b_title"));
				dto.setB_writer(rs.getString("b_writer"));
				return dto;
			}
			
		};*/
		/*//mybatis의 이용이로 생략가능
		list = JdbcTemplate.query(sql, new RowMapperImpl());//rowmap는 리스트 결과를 매핑한것
		return list;*/
		
		return QandABoardManager.getList();//mybatis를 이용하면 이한줄이면 끝난다. 즉, BoardManager.java 클래스의 메서드를 가져온것이다.
	}
	/*
	class RowMapperImpl implements RowMapper{//getList()와 findBySeq(int seq)에 RowMapper를 똑같이 사용되므로 이것을 줄여주기위해 클래스를 만듬
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {//오버라이딩(무명클래스로 만듬:클래스 없이 클래스를 만든경우)
			BoardDto dto = new BoardDto();
			dto.setB_content(rs.getString("b_content"));
			dto.setB_hitcount(rs.getInt("b_hitcount"));
			dto.setB_password(rs.getString("b_password"));
			dto.setB_regdate(rs.getString("b_regdate"));
			dto.setB_seq(rs.getInt("b_seq"));
			dto.setB_title(rs.getString("b_title"));
			dto.setB_writer(rs.getString("b_writer"));
			return dto;
		}
	}*/
	public BoardDto findBySeq(int seq){//읽기 기능
		// TODO Auto-generated method stub
		/*
		String sql="select * from tblSpringBoard where b_seq="+seq; //글번호는 중요 정보가 아니므로 이렇게 사용해도 용인될듯
		RowMapperImpl rowmapper = new RowMapperImpl();//이렇게도 가능한듯...
		BoardDto dto = JdbcTemplate.queryForObject(sql, rowmapper);//queryForObject는 결과 값을 딱하나만 가져올수 있게하는 메서드, RowMapper란 DB로 부터 결과값을 받아와 넘겨주는 역할 
																   // 즉, 여기서는 dto에게 결과값을 넘겨주는 역할을 하고있다.
																	//ResultSetExtractor와 RowMapper가 있는데 ResultSetExtractor는 반복적으로 돌려주지 못하고 RowMapper는 반복적으로 돌려줄수 있다.
																	//그래서 ResultSetExtractor는 하나의 레코드가 있을때 사용하는게 유리하고 RowMapper는 여러게의 레코드를 사용할때 유리하다.
		
		System.out.println(dto.getB_title());
		return dto;*/
		return new QandABoardManager().finBySeq(seq);
	}

	public void write(BoardDto dto){//쓰기기능
		// TODO Auto-generated method stub
		/*//mybatis로 인해 생략됨
		String sql="insert into tblSpringBoard(b_title, b_content, b_writer,"+
		"b_regdate, b_hitcount, b_password) values(?,?,?,now(),0,?)";
		//파라미터 넘기는 방법 : 
		//1, object[]로 넘기는 방법(쉽고 간단하며 사용하기 편하다. 하지만 파라미터 재사용 못함)  
		//2,preparestatementsetter라는 인터페이스를 사용(파리미터 재사용이 가능)
		
		//JdbcTemplate.update(sql, new WriteParams(dto));//PreparedStatementSetter을 사용할때
		Object[] values = new Object[]{dto.getB_title(), dto.getB_content(), dto.getB_writer(), dto.getB_password()};
		JdbcTemplate.update(sql, values);//Object[]를 사용할때*/
		
		QandABoardManager.write(dto);//mybatis로 사용
		
	}
	/*class WriteParams implements PreparedStatementSetter{ //파라미터를 처리하기 위해서 PreparedStatementSetter 인터페이스 사용(파라미터를 재활용하기위해서씀)
		private BoardDto dto;
		
		public WriteParams(BoardDto dto){
			this.dto = dto;
		}
		public void setValues(PreparedStatement pstmt) throws SQLException {//PreparedStatement로 데이터를 묶어줄수 있다.
			pstmt.setString(1, dto.getB_title());
			pstmt.setString(2, dto.getB_content());
			pstmt.setString(3, dto.getB_writer());
			pstmt.setString(4, dto.getB_password());
			
			
		}
		
	}*/

	public void update(BoardDto dto){
		/*
		String sql = "update tblSpringBoard set b_title=?, b_content=? where b_seq=?";
		
		Object[] values = new Object[]{dto.getB_title(), dto.getB_content(), dto.getB_seq()};
		System.out.println("모야:"+dto.getB_title());
		JdbcTemplate.update(sql, values);*/
		QandABoardManager.update(dto);

	}

	public void delete(int seq){
		/*
		String sql = "delete from tblSpringBoard where b_seq=?";
		Object[] values = new Object[]{seq};
		JdbcTemplate.update(sql, values);*/
		QandABoardManager.delete(seq);

	}
	public void Reply(BoardDto dto) {
		
		QandABoardManager.Reply(dto);
		
	}
	public void posupdate(BoardDto dto) {
		// TODO Auto-generated method stub
		QandABoardManager.PosUpdate(dto);
	}
	public void posupdateall(BoardDto dto) {
		// TODO Auto-generated method stub
		QandABoardManager.PosUpdateAll(dto);
	}
	public void increaseCount(BoardDto dto) {
		// TODO Auto-generated method stub
		System.out.println("2. 카운터증가 실행되니??");
		QandABoardManager.IncreaseCount(dto);
	}

	public List findKeyword(BoardDto dto) {
		// TODO Auto-generated method stub
		return QandABoardManager.findKeyword(dto);
	}
	

}
