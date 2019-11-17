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
	
	public static void AddMessage() throws Exception{//电影信息插入
		Play play=new Play();
		Movie movie=new Movie();
		System.out.println("输入电影信息（输入null则代表该电影此信息为空）");
		Scanner in=new Scanner(System.in);
		System.out.print("请输入电影编号：");
		String movieid=in.next();
		movie.setMno(movieid);
		System.out.print("请输入电影姓名：");
		movie.setMn(in.next());
		System.out.print("请输入电影又名：");
		movie.setMmn(in.next());
		System.out.print("请输入电影类型");
		movie.setMt(in.next());
		System.out.print("请输入电影语言：");
		movie.setMl(in.next());
		System.out.print("请输入电影上映时间：");
		movie.setUd(in.next());
		System.out.print("请输入电影制片地区：");
		movie.setACon(in.next());
		System.out.print("请输入电影片长：");
		movie.setTL(in.next());
		System.out.print("请输入电影简介：");
		movie.setBri(in.next());
		System.out.print("请插入电影图片：");
		movie.setPic(in.next());
		MovieDAOFactory.getMoivesDAO().InsertMovie(movie);
		System.out.print("请输入电影参演演员 编号、饰演角色及职称（即主演或配角）（以空格隔开）：");//演员参演电影表
		String act=in.nextLine();
		String str[]=act.split(" ");
		play.setMno(movieid);
		play.setAno(str[0]); //演员编号
		play.setPn(str[1]);	//饰演角色
		play.setPro(str[2]);	//职称（主演/配角）
		MovieDAOFactory.getPlayDAO().InsertPlay(play);
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where ANO="+str);
		ResultSet rs=pstm.executeQuery();
		if(rs.next())//若演员信息不存在
		{
			Actor actor=new Actor();
			System.out.println("该演员不存在,请向演员表添加该演员信息");
			actor.setAno(str[0]);
			System.out.print("请输入演员姓名:");
			actor.setAn(in.next());
			System.out.print("请输入演员性别:");
			actor.setAsex(in.next());
			System.out.print("请输入演员国籍:");
			actor.setAcon(in.next());
			System.out.print("请输入演员简介:");
			actor.setAbri(in.nextLine());
			System.out.print("请插入演员图片:");
			actor.setApic(in.next());
			System.out.print("请输入演员出生日期:");
			actor.setABrith(in.next());
			MovieDAOFactory.getActorDAO().InsertActor(actor);
		}
	}
	public static void Sereach() throws Exception{

		System.out.println("请输入想要查询的电影信息：");
		System.out.println("输入type按电影类型查找");
		System.out.println("输入name按电影名查找");
		System.out.println("输入langue按电影语言查找");
		System.out.println("输入country按电影制片地区查找");
		Scanner in=new Scanner(System.in);
		String selete=in.next();
		List<Movie> movies=new ArrayList<Movie>();
		if(selete.equals("type"))
		{
			System.out.println("请输入要查找类型(喜剧，动作，悬疑，恐怖，爱情，科幻，战争，青春，都市，武侠，卡通，仙侠)：");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_TYPE);
		}
		else if(selete.equals("name"))
		{
			System.out.println("请输入要查找电影名：");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_MOVIENAME);
		}
		else if(selete.equals("languege"))
		{
			System.out.println("请输入要查找电影语言：");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_LANGUAGE);
		}
		else if(selete.equals("country"))
		{
			System.out.println("请输入要查找电影制片国家：");
			movies=MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_COUNTRY);
		}
		else
		{
			System.out.println("输入错误！");
		}
		//Iterator<String> iter=movies.iterator();
		in.close();	
	}
}
