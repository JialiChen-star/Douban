package Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Spliterator;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.omg.PortableInterceptor.Interceptor;

import DAO.*;
import DateBaseConnection.DateBaseconnection;
import Movies.*;
public class MovieBusiness {

	private static final String SELECT_TYPE="selete * from Movie where MT like '%?%'";
	private static final String SELECT_MOVIENAME="select * from Movie where MN like '%?%'";
	private static final String SELECT_LANGUAGE="select * from Movie where ML like '%?%'";
	private static final String SELECT_COUNTRY="select * from Movie where ACON like '%?%'";
	
	public static void AddMessage() throws Exception{//��Ӱ��Ϣ����
		Play play=new Play();
		Movie movie=new Movie();
		System.out.println("�����Ӱ��Ϣ������null�����õ�Ӱ����ϢΪ�գ�");
		Scanner in=new Scanner(System.in);
		System.out.print("�������Ӱ��ţ�");
		String movieid=in.next();
		movie.setMno(movieid);
		System.out.print("�������Ӱ������");
		movie.setMn(in.next());
		System.out.print("�������Ӱ������");
		movie.setMmn(in.next());
		System.out.print("�������Ӱ����");
		movie.setMt(in.next());
		System.out.print("�������Ӱ���ԣ�");
		movie.setMl(in.next());
		System.out.print("�������Ӱ��ӳʱ�䣺");
		movie.setUd(in.next());
		System.out.print("�������Ӱ��Ƭ������");
		movie.setACon(in.next());
		System.out.print("�������ӰƬ����");
		movie.setTL(in.next());
		System.out.print("�������Ӱ��飺");
		movie.setBri(in.next());
		System.out.print("������ӰͼƬ��");
		movie.setPic(in.next());
		MovieDAOFactory.getMoivesDAO().InsertMovie(movie);
		System.out.print("�������Ӱ������Ա ��š����ݽ�ɫ��ְ�ƣ������ݻ���ǣ����Կո��������");//��Ա���ݵ�Ӱ��
		String act=in.nextLine();
		String str[]=act.split(" ");
		play.setMno(movieid);
		play.setAno(str[0]); //��Ա���
		play.setPn(str[1]);	//���ݽ�ɫ
		play.setPro(str[2]);	//ְ�ƣ�����/��ǣ�
		MovieDAOFactory.getPlayDAO().InsertPlay(play);
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where ANO="+str);
		ResultSet rs=pstm.executeQuery();
		if(rs.next())//����Ա��Ϣ������
		{
			Actor actor=new Actor();
			System.out.println("����Ա������,������Ա����Ӹ���Ա��Ϣ");
			actor.setAno(str[0]);
			System.out.print("��������Ա����:");
			actor.setAn(in.next());
			System.out.print("��������Ա�Ա�:");
			actor.setAsex(in.next());
			System.out.print("��������Ա����:");
			actor.setAcon(in.next());
			System.out.print("��������Ա���:");
			actor.setAbri(in.nextLine());
			System.out.print("�������ԱͼƬ:");
			actor.setApic(in.next());
			System.out.print("��������Ա��������:");
			actor.setABrith(in.next());
			MovieDAOFactory.getActorDAO().InsertActor(actor);
		}
	}
	public static void Sereach() throws Exception{

		System.out.println("��������Ҫ��ѯ�ĵ�Ӱ��Ϣ��");
		System.out.println("����type����Ӱ���Ͳ���");
		System.out.println("����name����Ӱ������");
		System.out.println("����langue����Ӱ���Բ���");
		System.out.println("����country����Ӱ��Ƭ��������");
		Scanner in=new Scanner(System.in);
		String selete=in.next();
		List<Movie> movies=new ArrayList<Movie>();
		if(selete.equals("type"))
		{
			System.out.println("������Ҫ��������(ϲ�磬���������ɣ��ֲ������飬�ƻã�ս�����ഺ�����У���������ͨ������)��");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_TYPE);
		}
		else if(selete.equals("name"))
		{
			System.out.println("������Ҫ���ҵ�Ӱ����");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_MOVIENAME);
		}
		else if(selete.equals("languege"))
		{
			System.out.println("������Ҫ���ҵ�Ӱ���ԣ�");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_LANGUAGE);
		}
		else if(selete.equals("country"))
		{
			System.out.println("������Ҫ���ҵ�Ӱ��Ƭ���ң�");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_COUNTRY);
		}
		else
		{
			System.out.println("�������");
		}
		//Iterator<String> iter=movies.iterator();
		in.close();	
	}
}
