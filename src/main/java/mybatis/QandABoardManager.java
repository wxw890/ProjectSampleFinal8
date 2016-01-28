package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hta.QandAboard.repository.BoardDto;


//실제 boardMapper.xml과 sqlmapConfig.xml에서 설정한것을 실행하기위해 클래스 파일을 만들었다.

public class QandABoardManager {
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
	
	
	public static List getList(){ //반드시 public static 타입으로 만들어져야한다.
		List list = null;
		SqlSession session = sqlFactory.openSession();//세션별로 sql 작업할수 있도록 열어놓는것
		try{
		BoardDto dto = new BoardDto();
		System.out.println("매니져에서 dto는"+dto.getKeyField());
		list = session.selectList("getList2");//selectList메서드 외에 delete 등 메서드가 더있다. getList는 boardMapper.xml에서 설정한 select의 id이다.
											//즉, session.selectList("getList");는 dto 타입으로 DB에서 가져온 결과값을 가져온다. 거기에 list에 집어넣어서 BoardServiceImpl.java에서 getList()메서드를 불러 사용하면 끝이다.
		}
		catch(Exception err){
			System.out.println("getList에러"+err);
		}
		finally {
			session.close();
		}
		return list;
	}
	
	public static List findKeyword(BoardDto dto){
		List list = null;
		SqlSession session = sqlFactory.openSession();//세션별로 sql 작업할수 있도록 열어놓는것
		try{
		list = session.selectList("findKeyword2", dto);
		}
		catch(Exception err){
			System.out.println("findKeyword에러"+err);
		}
		finally {
			session.close();
		}
		return list;
	}
	
	public static void write(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		try{
		session.insert("write3", dto);//boardMapper.xml에 id가 write인 메서드에 dto를 param으로 넘겨준다.
		session.commit();//insert, update, delete는 commit()을 해줘야 완성이 된다.
		}
		catch(Exception err){
			System.out.println("write에러"+err);
		}
		finally {
			session.close();
		}
	}
	public static BoardDto finBySeq(int seq){
		BoardDto dto = new BoardDto();
		SqlSession session = sqlFactory.openSession();
		try{
			dto = session.selectOne("findBySeq2", seq);
		}
		catch(Exception err){
			System.out.println("finBySeq에러"+err);
		}
		finally {
			session.close();
		}
		return dto;
	}
	public static void delete(int seq){
		SqlSession session = sqlFactory.openSession();
		try{
		session.delete("delete2", seq);
		session.commit();
		}
		catch(Exception err){
			System.out.println("delete에러"+err);
		}
		finally {
			session.close();
		}
	}
	
	public static void update(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		try{
		//System.out.println("업데이트 최종내용"+dto.getB_content());
		session.update("update2", dto);
		session.commit();
		}
		catch(Exception err){
			System.out.println("update에러"+err);
		}
		finally {
			session.close();
		}
	}
	
	public static void Reply(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		try{
			
		session.insert("writeReply2", dto);
		session.commit();
		}
		catch(Exception err){
			System.out.println("Reply에러"+err);
		}
		finally {
			session.close();
		}
	}
	public static void PosUpdate(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		try{
		session.update("posupdate2", dto);
		session.commit();
		}
		catch(Exception err){
			System.out.println("PosUpdate에러"+err);
		}
		finally {
			session.close();
		}
	}
	
	public static void PosUpdateAll(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		try{
		session.update("posupdateall2", dto);
		session.commit();
		}
		catch(Exception err){
			System.out.println("PosUpdateAll에러"+err);
		}
		finally {
			session.close();
		}
	}
	
	public static void IncreaseCount(BoardDto dto){
		SqlSession session = sqlFactory.openSession();
		try{
		session.update("increasecount2", dto);
		session.commit();
		}
		catch(Exception err){
			System.out.println("IncreaseCount에러"+err);
		}
		finally {
			session.close();
		}
		
	}
}
