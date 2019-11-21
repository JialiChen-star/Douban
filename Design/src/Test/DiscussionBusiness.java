package Test;
import Discussion.*;
import DAO.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DiscussionBusiness {

	private static final String DISCUSS_TEAM="select *from Discussion where DISNO=?";//查找一个小组
	private static final String TEAM_TOPIC="select * from Topic group by DISNO having (DISNO=?)";//查找一个小组中的所有话题
	private static final String USER_REPLAY="select * from RePlay group by UNO having (UNO=?)";//查找一个人的所有评论
	private static final String TOPIC_REPLAY="select * from RePlay group by TONO having (TONO=?)";//查找一个话题的所有评论
	private static final String USER_TOPIC="select * from Topic where TONO=(select TONO from InitTopic group by UNO having UNO=?)";
	
	public static void AddDiscussion() throws Exception{
		
		Scanner in=new Scanner(System.in);
		Member member=new Member();
		discussion discuss=new discussion();
		String disno=in.next();
		discuss.setDisno(disno);//输入讨论组编号
		discuss.setUno(in.next());//讨论组长（用户编号）
		discuss.setDBri(in.next());//简介
		discuss.setDct(new Date(System.currentTimeMillis()));//创建时间
		discuss.setDisn(in.next());//简介
		member.setDisno(discuss.getDisno());	//将小组编号写入小组与用户之间的表中
		member.setUno(discuss.getUno());	//将用户编号写入小组与用户之间的表中
		DiscussionDAOFactory.getDiscussionDAO().InsertDiscussion(discuss);
		DiscussionDAOFactory.getMemberDAO().InsertMember(member);
		in.close();
	}
	
	public static void AddTopic()throws Exception{
		
		Scanner in=new Scanner(System.in);
		Topic topic=new Topic();	
		String tono=in.next();
		topic.setTono(tono);	//话题编号
		topic.setTon(in.next());	//话题名
		topic.setDisno(in.next()); 	//小组编号
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
	
	public static List<discussion> Searchdiscussion() throws Exception{
		return DiscussionDAOFactory.getDiscussionDAO().getDiscussions(DISCUSS_TEAM);
	}
	
	public static List<RePlay> SearchUserreplay() throws Exception{
		return DiscussionDAOFactory.getRePlayDAO().getRePlays(USER_REPLAY);
	}
	
	public static List<RePlay> SearchTopicreplay() throws Exception{
		return DiscussionDAOFactory.getRePlayDAO().getRePlays(USER_TOPIC);
	}
	
	public static List<Topic> SearchUsertopic() throws Exception{
		return DiscussionDAOFactory.getTopicDAO().getTopics(USER_TOPIC);
	}
	
	public static List<Topic> SearchTeamtopic() throws Exception{
		return DiscussionDAOFactory.getTopicDAO().getTopics(TEAM_TOPIC);
	}
}
