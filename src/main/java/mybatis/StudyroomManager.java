package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hta.freeboard.repository.BoardDto;
import com.hta.studyroom.repository.StudyroomDto;


//실제 StudyroomMapper.xml과 sqlmapConfig.xml에서 설정한것을 실행하기위해 클래스 파일을 만들었다.

public class StudyroomManager {
	private static SqlSessionFactory sqlFactory;
	static{
		try{//가장 기본적으로 처리될 일
			Reader reader = Resources.getResourceAsReader("mybatis/sqlmapConfig.xml");
			sqlFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch(IOException err){
			throw new RuntimeException("SqlSessionFactory 인스턴스 생성 실패!!!");
		}
	}
	/*
	public static List getRoomResList(){ //반드시 public static 타입으로 만들어져야한다.
		List reservation_list = null;
		SqlSession session = sqlFactory.openSession();//세션별로 sql 작업할수 있도록 열어놓는것
		reservation_list = session.selectList("getRoomResList");//selectList메서드 외에 delete 등 메서드가 더있다. getRoomResList는  StudyroomMapper.xml에서 설정한 select의 id이다.
		//즉, session.selectList("getList");는 dto 타입으로 DB에서 가져온 결과값을 가져온다. 거기에 reservation_list에 집어넣어서 StudyroomServiceImpl.java에서 getRoomResList()메서드를 불러 사용하면 끝이다.
		return reservation_list;
	}*/
	public static List searchReservation(String date){
		List list = null;
		SqlSession session = sqlFactory.openSession();//세션별로 sql 작업할수 있도록 열어놓는것
		StudyroomDto dto = new StudyroomDto();
		System.out.println("Manager까지 가져온 날짜는 "+date);
		dto.setReservation_date(date);
		System.out.println("Manager까지 가져온 날짜는  dto값"+dto.getReservation_date());
		try{
			list = session.selectList("searchReservation", date);
			if(list == null){
				System.out.println("NULLLLLLLLL!!!!");
			}
		}catch(Exception err){
			System.out.println("searchReservation"+err);
			System.out.println("2매니져에서 dto는"+list.get(0));
		}
		return list;
	}
	public static void resWrite(StudyroomDto studyroomdto){
		System.out.println("<resWrite>");
		System.out.println("Manager table num : "+ studyroomdto.getTable_num());
		System.out.println("Manager email : "+ studyroomdto.getMember_email());
		System.out.println("Manager name : "+ studyroomdto.getMember_name());
		System.out.println("Manager reservation : "+ studyroomdto.getReservation_date());
		System.out.println("Manager reservattion num : "+ studyroomdto.getReservation_num());
		System.out.println("Manager time : "+ studyroomdto.getReservation_time());
		SqlSession session = sqlFactory.openSession();
		try{
		session.insert("resWrite", studyroomdto);//stutyroomMapper.xml에 id가 resWrite인 메서드에 studyroomdto를 파라미터 값으로 넘겨준다.
		session.commit();//insert, update, delete는  commit()을 해줘야 완성이 된다.
		}
		catch(Exception err){
			System.out.println("resWrite"+ err);
		}
		finally {
			session.close();
		}
		
	}
	public static List findByRes_num(String member_email){
		SqlSession session = sqlFactory.openSession();
		List list = null;
		try{
		list = session.selectList("findByRes_num", member_email);
		}
		catch(Exception err){
			System.out.println("findByRes_num"+ err);
		}
		finally {
			session.close();
		}
		return list;
	}
	public static StudyroomDto findBySameResurvation(StudyroomDto studyroomdto){
		System.out.println("<1.findBySameResurvation>");
		System.out.println("Manager table num : "+ studyroomdto.getTable_num());
		System.out.println("Manager email : "+ studyroomdto.getMember_email());
		System.out.println("Manager name : "+ studyroomdto.getMember_name());
		System.out.println("Manager reservation : "+ studyroomdto.getReservation_date());
		System.out.println("Manager reservattion num : "+ studyroomdto.getReservation_num());
		System.out.println("Manager time : "+ studyroomdto.getReservation_time());
		StudyroomDto studyroomdto2 = new StudyroomDto();
		SqlSession session = sqlFactory.openSession();
		try{
		 studyroomdto2 = session.selectOne("findBySameResurvation", studyroomdto);
		}
		catch(Exception err){
			System.out.println("findBySameResurvation"+ err);
		}
		finally {
			session.close();
		}
		return studyroomdto2;
	}
	
	public static void resDelete(int reservation_num){
		SqlSession session = sqlFactory.openSession();
		try{
		session.delete("resDelete", reservation_num);
		System.out.println("스터디 삭제 매니저까지오는 넘버값!!!"+reservation_num);
		session.commit();
		}
		catch(Exception err){
			System.out.println("resDelete"+ err);
		}
		finally {
			session.close();
		}
	}
	
	
}