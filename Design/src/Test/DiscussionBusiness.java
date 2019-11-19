package Test;
import Discussion.*;
import DAO.*;
import java.util.Date;
import java.util.Scanner;

public class DiscussionBusiness {

	public static void AddDiscussion() throws Exception{
		
		Scanner in=new Scanner(System.in);
		Member member=new Member();
		discussion discuss=new discussion();
		discuss.setDisno(in.next());//输入讨论组编号
		discuss.setUno(in.next());//讨论组长（用户编号）
		discuss.setDBri(in.next());//简介
		discuss.setDct(new Date(System.currentTimeMillis()));//创建时间
		discuss.setDisn(in.next());//简介
		member.setDisno(discuss.getDisno());
		member.setUno(discuss.getUno());
		DiscussionDAOFactory.getDiscussionDAO().InsertDiscussion(discuss);
		DiscussionDAOFactory.getMemberDAO().InsertMember(member);
		in.close();
	}
	
	public static void AddTopic()throws Exception{
		
		Scanner in=new Scanner(System.in);
		Topic topic=new Topic();	
		topic.setTono(in.next());	//话题编号
		topic.setTon(in.next());	//话题名
		topic.setUno(in.next());	//用户编号
		topic.setCont(in.next());	//话题内容
		topic.setTot(new Date(System.currentTimeMillis()));	//创建话题时间
		InitTopic inittopic=new InitTopic();
		inittopic.setTono(topic.getTono());
		inittopic.setUno(topic.getUno());
		DiscussionDAOFactory.getInitTopicDAO().InsertInitTopic(inittopic);
		DiscussionDAOFactory.getTopicDAO().InsertTopic(topic);
		in.close();
	}
	
	public static void AddRePlay()throws Exception{
		
		Scanner in=new Scanner(System.in);
		RePlay replay=new RePlay();		
		replay.setReno(in.next());	//回复或评论编号
		replay.setTono(in.next());	//话题编号
		replay.setUno(in.next());	//用户编号
		replay.setRcont(in.next());	//回复或评论内容
		replay.setRt(new Date(System.currentTimeMillis()));//回复或评论时间
		Comment comment=new Comment();
		comment.setReno(replay.getReno());
		comment.setTono(replay.getTono());
		Publish publish=new Publish();
		publish.setReno(replay.getReno());
		publish.setUno(replay.getUno());
		DiscussionDAOFactory.getPublishDAO().InsertPublish(publish);
		DiscussionDAOFactory.getCommnetDAO().InsertComment(comment);
		DiscussionDAOFactory.getRePlayDAO().InsertRePlay(replay);
		in.close();
	}
	
}
