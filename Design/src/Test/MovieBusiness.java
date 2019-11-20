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
	public static void AddMovieMessage() throws Exception{//电影信息插入
		
		Movie movie=new Movie();
//		System.out.println("输入电影信息（输入null则代表该电影此信息为空）");
//		System.out.print("请输入电影编号：");
		String movieid=in.next();
		movie.setMno(movieid);
//		System.out.print("请输入电影姓名：");
		movie.setMn(in.next());
//		System.out.print("请输入电影又名：");
		movie.setMmn(in.next());
//		System.out.print("请输入电影类型");
		movie.setMt(in.next());
//		System.out.print("请输入电影语言：");
		movie.setMl(in.next());
//		System.out.print("请输入电影上映时间：");
		movie.setUd(in.next());
//		System.out.print("请输入电影制片地区：");
		movie.setACon(in.next());
//		System.out.print("请输入电影片长：");
		movie.setTL(in.next());
//		System.out.print("请输入电影简介：");
		movie.setBri(in.next());
//		System.out.print("请插入电影图片：");
		movie.setPic(in.next());
		MovieDAOFactory.getMoivesDAO().InsertMovie(movie);
		AddActor(movieid);
		AddDirector(movieid);
		AddEtc(movieid);
		
	}
	
	public static void AddActor(String movieid) throws Exception{
		
	//	Scanner in=new Scanner(System.in);
//		System.out.print("请输入电影参演演员 编号、饰演角色及职称（即主演或配角）：");//演员参演电影表
		Play play=new Play();
		play.setMno(movieid);
		play.setAno(in.next()); //演员编号
		play.setPn(in.next());	//饰演角色
		play.setPro(in.next());	//职称（主演/配角）
		MovieDAOFactory.getPlayDAO().InsertPlay(play);
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where ANO=?");
		pstm.setString(1, play.getAno());
		ResultSet rs=pstm.executeQuery();
		if(!rs.next())//若演员信息不存在
		{
			Actor actor=new Actor();
//			System.out.println("该演员不存在,请向演员表添加该演员信息");
			actor.setAno(play.getAno());
//			System.out.print("请输入演员姓名:");
			actor.setAn(in.next());
//			System.out.print("请输入演员性别:");
			actor.setAsex(in.next());
//			System.out.print("请输入演员国籍:");
			actor.setAcon(in.next());
//			System.out.print("请输入演员简介:");
			actor.setAbri(in.next());
//			System.out.print("请插入演员图片:");
			actor.setApic(in.next());
//			System.out.print("请输入演员出生日期:");
			actor.setABrith(in.next());
			MovieDAOFactory.getActorDAO().InsertActor(actor);
		}	
	}
	
	public static void AddDirector(String movieid) throws Exception{
		
		Direct direct=new Direct();
//		System.out.println("请输入导演编号：");
		DateBaseconnection db=new DateBaseconnection();
		direct.setDno(in.next());
		direct.setMno(movieid);
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where DNO=?");
		pstm.setString(1, direct.getDno());
		ResultSet rs=pstm.executeQuery();
		if(!rs.next())
		{
//			System.out.println("该演员不存在,请向演员表添加该演员信息");
			Director director=new Director();
			director.setDno(direct.getDno());
//			System.out.print("请输入导演姓名:");
			director.setDn(in.next());
//			System.out.print("请输入演员性别:");
			director.setDsex(in.next());
//			System.out.print("请输入演员国籍:");
			director.setDcon(in.next());
//			System.out.print("请输入演员出生日期:");
			director.setDBrith(in.next());
//			System.out.print("请输入演员简介:");
			director.setDbri(in.next());
//			System.out.print("请插入演员图片:");
			director.setDpic(in.next());
			MovieDAOFactory.getDirectorDAO().InsertDirector(director);
		}
		MovieDAOFactory.getDirectDAO().InsertDirect(direct);
		
	}
	
	public static void AddEtc(String movieid) throws Exception{
	
//		System.out.println("请输入编剧编号：");
		String str=null;
		str=in.next();
		Edit edit=new Edit();
		DateBaseconnection db=new DateBaseconnection();
		PreparedStatement pstm=db.getConnection().prepareStatement("select * from Actors where DNO=?");
		pstm.setString(1, str);
		ResultSet rs=pstm.executeQuery();
		if(!rs.next())
		{
//			System.out.println("该编剧不存在，,请向演员表添加该编剧信息");
			Etc etc=new Etc();
			etc.setEno(str);
//			System.out.print("请输入编剧姓名:");
			etc.setEn(in.next());
//			System.out.print("请输入编剧性别:");
			etc.setEsex(in.next());
//			System.out.print("请输入编剧国籍:");
			etc.setEcon(in.next());
//			System.out.print("请输入编剧出生日期:");
			etc.setEBrith(in.next());
//			System.out.print("请输入编剧简介:");
			etc.setEbri(in.next());
//			System.out.print("请插入编剧图片:");
			etc.setEpic(in.next());
			MovieDAOFactory.getEtcDAO().InsertEtc(etc);
		}
		edit.setEno(str);
		edit.setMno(movieid);
		MovieDAOFactory.getEditDAO().InsertEdit(edit);	
	}
	
	public static List<Movie> Sereach() throws Exception{//演员信息的输入

//		System.out.println("请输入想要查询的电影信息：");
//		System.out.println("输入type按电影类型查找");
//		System.out.println("输入name按电影名查找");
//		System.out.println("输入langue按电影语言查找");
//		System.out.println("输入country按电影制片地区查找");
		
		String selete=in.next();
//		List<Movie> movies=new ArrayList<Movie>();
		if(selete.equals("type"))
		{
//			System.out.println("请输入要查找类型(喜剧，动作，悬疑，恐怖，爱情，科幻，战争，青春，都市，武侠，卡通，仙侠)：");
			 return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_TYPE);
		}
		else if(selete.equals("name"))
		{
//			System.out.println("请输入要查找电影名：");
			return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_MOVIENAME);
		}
		else if(selete.equals("languege"))
		{
//			System.out.println("请输入要查找电影语言：");
			return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_LANGUAGE);
		}
		else if(selete.equals("country"))
		{
//			System.out.println("请输入要查找电影制片国家：");
			return MovieDAOFactory.getMoivesDAO().GetMovies(SELECT_COUNTRY);
		}
		else
		{
//			System.out.println("输入错误！");
			return null;
		}	
	}
		
	public static void insertdirector(Director di) throws Exception{
		
		Director director=new Director();
//		System.out.println("请输入导演编号");
		director.setDno(in.next());
//		System.out.print("请输入导演姓名:");
		director.setDn(in.next());
//		System.out.print("请输入演员性别:");
		director.setDsex(in.next());
//		System.out.print("请输入演员国籍:");
		director.setDcon(in.next());
//		System.out.print("请输入演员出生日期:");
		director.setDBrith(in.next());
//		System.out.print("请输入演员简介:");
		director.setDbri(in.next());
//		System.out.print("请插入演员图片:");
		director.setDpic(in.next());
		MovieDAOFactory.getDirectorDAO().InsertDirector(director);
	}

	public static void insertactor(Actor actor)throws Exception
	{
//		Scanner in=new Scanner(System.in);
//		System.out.println("请输入演员编号：");
		actor.setAno(in.next());
//		System.out.print("请输入演员姓名:");
		actor.setAn(in.next());
//		System.out.print("请输入演员性别:");
		actor.setAsex(in.next());
//		System.out.print("请输入演员国籍:");
		actor.setAcon(in.next());
//		System.out.print("请输入演员简介:");
		actor.setAbri(in.next());
//		System.out.print("请插入演员图片:");
		actor.setApic(in.next());
//		System.out.print("请输入演员出生日期:");
		actor.setABrith(in.next());
		MovieDAOFactory.getActorDAO().InsertActor(actor);
	}

	public static void insertetc(Etc etc) throws Exception{
		
//		Scanner in=new Scanner(System.in);
		etc.setEno(in.next());
//		System.out.print("请输入编剧姓名:");
		etc.setEn(in.next());
//		System.out.print("请输入编剧性别:");
		etc.setEsex(in.next());
//		System.out.print("请输入编剧国籍:");
		etc.setEcon(in.next());
//		System.out.print("请输入编剧出生日期:");
		etc.setEBrith(in.next());
//		System.out.print("请输入编剧简介:");
		etc.setEbri(in.next());
//		System.out.print("请插入编剧图片:");
		etc.setEpic(in.next());
		MovieDAOFactory.getEtcDAO().InsertEtc(etc);
	}
}





