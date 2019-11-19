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
		discuss.setDisno(in.next());//������������
		discuss.setUno(in.next());//�����鳤���û���ţ�
		discuss.setDBri(in.next());//���
		discuss.setDct(new Date(System.currentTimeMillis()));//����ʱ��
		discuss.setDisn(in.next());//���
		member.setDisno(discuss.getDisno());
		member.setUno(discuss.getUno());
		DiscussionDAOFactory.getDiscussionDAO().InsertDiscussion(discuss);
		DiscussionDAOFactory.getMemberDAO().InsertMember(member);
		in.close();
	}
	
	public static void AddTopic()throws Exception{
		
		Scanner in=new Scanner(System.in);
		Topic topic=new Topic();	
		topic.setTono(in.next());	//������
		topic.setTon(in.next());	//������
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
	
}
