package Test;
import Discussion.*;
import DAO.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DiscussionBusiness {

	private static final String DISCUSS_TEAM="select *from Discussion where DISNO=?";//����һ��С��
	private static final String TEAM_TOPIC="select * from Topic group by DISNO having (DISNO=?)";//����һ��С���е����л���
	private static final String USER_REPLAY="select * from RePlay group by UNO having (UNO=?)";//����һ���˵���������
	private static final String TOPIC_REPLAY="select * from RePlay group by TONO having (TONO=?)";//����һ���������������
	private static final String USER_TOPIC="select * from Topic where TONO=(select TONO from InitTopic group by UNO having UNO=?)";
	
	public static void AddDiscussion() throws Exception{
		
		Scanner in=new Scanner(System.in);
		Member member=new Member();
		discussion discuss=new discussion();
		String disno=in.next();
		discuss.setDisno(disno);//������������
		discuss.setUno(in.next());//�����鳤���û���ţ�
		discuss.setDBri(in.next());//���
		discuss.setDct(new Date(System.currentTimeMillis()));//����ʱ��
		discuss.setDisn(in.next());//���
		member.setDisno(discuss.getDisno());	//��С����д��С�����û�֮��ı���
		member.setUno(discuss.getUno());	//���û����д��С�����û�֮��ı���
		DiscussionDAOFactory.getDiscussionDAO().InsertDiscussion(discuss);
		DiscussionDAOFactory.getMemberDAO().InsertMember(member);
		in.close();
	}
	
	public static void AddTopic()throws Exception{
		
		Scanner in=new Scanner(System.in);
		Topic topic=new Topic();	
		String tono=in.next();
		topic.setTono(tono);	//������
		topic.setTon(in.next());	//������
		topic.setDisno(in.next()); 	//С����
		topic.setUno(in.next());	//�û����
		topic.setCont(in.next());	//��������
		topic.setTot(new Date(System.currentTimeMillis()));	//��������ʱ��
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
		replay.setReno(in.next());	//�ظ������۱��
		replay.setTono(in.next());	//������
		replay.setUno(in.next());	//�û����
		replay.setRcont(in.next());	//�ظ�����������
		replay.setRt(new Date(System.currentTimeMillis()));//�ظ�������ʱ��
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
