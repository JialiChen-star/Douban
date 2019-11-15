package DAO;
import Discussion.*;
public class DiscussionDAOFactory {
	public static discussion getDiscussionDAO() {
		return new discussion();
	}
	public static RePlay getRePlayDAO() {
		return new RePlay();
	}
	public static Topic getTopicDAO() {
		return new Topic();
	}	
	public static Talk getTalkDAO() {
		return new Talk();
	}
	public static Member getMemberDAO() {
		return new Member();
	}
	public static InitTopic getInitTopicDAO(){
		return new InitTopic();
		}
	public static Publish getPublishDAO() {
		return new Publish();
	}
	public static Comment getCommnet() {
		return new Comment();
	}
}
