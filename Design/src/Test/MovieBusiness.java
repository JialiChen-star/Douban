package Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;
import DAO.*;
import DateBaseConnection.DateBaseconnection;
import Movies.*;
public class MovieBusiness {

	private static final String SELECT_TYPE="select * from Movie where MT like '%'+?+'%'";
	private static final String SELECT_MOVIENAME="select * from Movie where MN like '%'+?+'%'";
	private static final String SELECT_LANGUAGE="select * from Movie where ML like '%'+?+'%'";
	private static final String SELECT_COUNTRY="select * from Movie where ACON like '%'+?+'%'";
	static Scanner in=new Scanner(System.in);
	public static void AddMovieMessage() throws Exception{//��Ӱ��Ϣ����
		
		Movie movie=new Movie();
//		System.out.println("�����Ӱ��Ϣ������null�����õ�Ӱ����ϢΪ�գ�");
//		System.out.print("�������Ӱ��ţ�");
		String movieid=in.next();
		movie.setMno(movieid);
//		System.out.print("�������Ӱ������");
		movie.setMn(in.next());
//		System.out.print("�������Ӱ������");
		movie.setMmn(in.next());
//		System.out.print("�������Ӱ����");
		movie.setMt(in.next());
//		System.out.print("�������Ӱ���ԣ�");
		movie.setMl(in.next());
//		System.out.print("�������Ӱ��ӳʱ�䣺");
		movie.setUd(in.next());
//		System.out.print("�������Ӱ��Ƭ������");
		movie.setACon(in.next());
//		System.out.print("�������ӰƬ����");
		movie.setTL(in.next());
//		System.out.print("�������Ӱ��飺");
		movie.setBri(in.next());
//		System.out.print("������ӰͼƬ��");
		movie.setPic(in.next());
		MovieDAOFactory.getMoivesDAO().InsertMovie(movie);
		AddActor(movieid);
		AddDirector(movieid);
		AddEtc(movieid);
		
	}
	
	public static void AddActor(String movieid) throws Exception{
		
	//	Scanner in=new Scanner(System.in);
//		System.out.print("�������Ӱ������Ա ��š����ݽ�ɫ��ְ�ƣ������ݻ���ǣ���");//��Ա���ݵ�Ӱ��
		Play play=new Play();
		play.setMno(movieid);
		play.setAno(in.next()); //��Ա���
		play.setPn(in.next());	//���ݽ�ɫ
		play.setPro(in.next());	//ְ�ƣ�����/��ǣ�
		MovieDAOFactory.getPlayDAO().InsertPlay(play);
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where ANO=?");
		pstm.setString(1, play.getAno());
		ResultSet rs=pstm.executeQuery();
		if(!rs.next())//����Ա��Ϣ������
		{
			Actor actor=new Actor();
//			System.out.println("����Ա������,������Ա����Ӹ���Ա��Ϣ");
			actor.setAno(play.getAno());
//			System.out.print("��������Ա����:");
			actor.setAn(in.next());
//			System.out.print("��������Ա�Ա�:");
			actor.setAsex(in.next());
//			System.out.print("��������Ա����:");
			actor.setAcon(in.next());
//			System.out.print("��������Ա���:");
			actor.setAbri(in.next());
//			System.out.print("�������ԱͼƬ:");
			actor.setApic(in.next());
//			System.out.print("��������Ա��������:");
			actor.setABrith(in.next());
			MovieDAOFactory.getActorDAO().InsertActor(actor);
		}	
	}
	
	public static void AddDirector(String movieid) throws Exception{
		
		Direct direct=new Direct();
//		System.out.println("�����뵼�ݱ�ţ�");
		DateBaseconnection db=new DateBaseconnection();
		direct.setDno(in.next());
		direct.setMno(movieid);
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where DNO=?");
		pstm.setString(1, direct.getDno());
		ResultSet rs=pstm.executeQuery();
		if(!rs.next())
		{
//			System.out.println("����Ա������,������Ա����Ӹ���Ա��Ϣ");
			Director director=new Director();
			director.setDno(direct.getDno());
//			System.out.print("�����뵼������:");
			director.setDn(in.next());
//			System.out.print("��������Ա�Ա�:");
			director.setDsex(in.next());
//			System.out.print("��������Ա����:");
			director.setDcon(in.next());
//			System.out.print("��������Ա��������:");
			director.setDBrith(in.next());
//			System.out.print("��������Ա���:");
			director.setDbri(in.next());
//			System.out.print("�������ԱͼƬ:");
			director.setDpic(in.next());
			MovieDAOFactory.getDirectorDAO().InsertDirector(director);
		}
		MovieDAOFactory.getDirectDAO().InsertDirect(direct);
		
	}
	
	public static void AddEtc(String movieid) throws Exception{
	
//		System.out.println("���������ţ�");
		String str=null;
		str=in.next();
		Edit edit=new Edit();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where DNO=?");
		pstm.setString(1, str);
		ResultSet rs=pstm.executeQuery();
		if(!rs.next())
		{
//			System.out.println("�ñ�粻���ڣ�,������Ա����Ӹñ����Ϣ");
			Etc etc=new Etc();
			etc.setEno(str);
//			System.out.print("������������:");
			etc.setEn(in.next());
//			System.out.print("���������Ա�:");
			etc.setEsex(in.next());
//			System.out.print("�����������:");
			etc.setEcon(in.next());
//			System.out.print("���������������:");
			etc.setEBrith(in.next());
//			System.out.print("����������:");
			etc.setEbri(in.next());
//			System.out.print("�������ͼƬ:");
			etc.setEpic(in.next());
			MovieDAOFactory.getEtcDAO().InsertEtc(etc);
		}
		edit.setEno(str);
		edit.setMno(movieid);
		MovieDAOFactory.getEditDAO().InsertEdit(edit);	
	}
	
	public static List<Movie> Sereach() throws Exception{//��Ա��Ϣ������

//		System.out.println("��������Ҫ��ѯ�ĵ�Ӱ��Ϣ��");
//		System.out.println("����type����Ӱ���Ͳ���");
//		System.out.println("����name����Ӱ������");
//		System.out.println("����langue����Ӱ���Բ���");
//		System.out.println("����country����Ӱ��Ƭ��������");
		
		String selete=in.next();
//		List<Movie> movies=new ArrayList<Movie>();
		if(selete.equals("type"))
		{
//			System.out.println("������Ҫ��������(ϲ�磬���������ɣ��ֲ������飬�ƻã�ս�����ഺ�����У���������ͨ������)��");
			 return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_TYPE);
		}
		else if(selete.equals("name"))
		{
//			System.out.println("������Ҫ���ҵ�Ӱ����");
			return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_MOVIENAME);
		}
		else if(selete.equals("languege"))
		{
//			System.out.println("������Ҫ���ҵ�Ӱ���ԣ�");
			return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_LANGUAGE);
		}
		else if(selete.equals("country"))
		{
//			System.out.println("������Ҫ���ҵ�Ӱ��Ƭ���ң�");
			return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_COUNTRY);
		}
		else
		{
//			System.out.println("�������");
			return null;
		}	
	}
		
	public static void insertdirector(Director di) throws Exception{
		
		Director director=new Director();
//		System.out.println("�����뵼�ݱ��");
		director.setDno(in.next());
//		System.out.print("�����뵼������:");
		director.setDn(in.next());
//		System.out.print("��������Ա�Ա�:");
		director.setDsex(in.next());
//		System.out.print("��������Ա����:");
		director.setDcon(in.next());
//		System.out.print("��������Ա��������:");
		director.setDBrith(in.next());
//		System.out.print("��������Ա���:");
		director.setDbri(in.next());
//		System.out.print("�������ԱͼƬ:");
		director.setDpic(in.next());
		MovieDAOFactory.getDirectorDAO().InsertDirector(director);
	}

	public static void insertactor(Actor actor)throws Exception
	{
//		Scanner in=new Scanner(System.in);
//		System.out.println("��������Ա��ţ�");
		actor.setAno(in.next());
//		System.out.print("��������Ա����:");
		actor.setAn(in.next());
//		System.out.print("��������Ա�Ա�:");
		actor.setAsex(in.next());
//		System.out.print("��������Ա����:");
		actor.setAcon(in.next());
//		System.out.print("��������Ա���:");
		actor.setAbri(in.next());
//		System.out.print("�������ԱͼƬ:");
		actor.setApic(in.next());
//		System.out.print("��������Ա��������:");
		actor.setABrith(in.next());
		MovieDAOFactory.getActorDAO().InsertActor(actor);
	}

	public static void insertetc(Etc etc) throws Exception{
		
//		Scanner in=new Scanner(System.in);
		etc.setEno(in.next());
//		System.out.print("������������:");
		etc.setEn(in.next());
//		System.out.print("���������Ա�:");
		etc.setEsex(in.next());
//		System.out.print("�����������:");
		etc.setEcon(in.next());
//		System.out.print("���������������:");
		etc.setEBrith(in.next());
//		System.out.print("����������:");
		etc.setEbri(in.next());
//		System.out.print("�������ͼƬ:");
		etc.setEpic(in.next());
		MovieDAOFactory.getEtcDAO().InsertEtc(etc);
	}
}





