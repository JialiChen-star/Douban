package DAO;
import Discussion.*;
public class DiscussionDAOFactory {
	public static DiscussionDAO getDiscussionDAO() {
		return new DiscussionDAOImpl();
	}
	public static RePlayDAO getRePlayDAO() {
		return new RePlayDAOImpl();
	}
	public static TopicDAO getTopicDAO() {
		return new TopicDAOImpl();
	}	
	public static TalkDAO getTalkDAO() {
		return new TalkDAOImpl();
	}
	public static MemberDAO getMemberDAO() {
		return new MemberDAOImpl();
	}
	public static InitTopicDAO getInitTopicDAO(){
		return new InitTopicDAOImpl();
		}
	public static PublishDAO getPublishDAO() {
		return new PublishDAOImpl();
	}
	public static Comment getCommnet() {
		return new Comment();
	}
}
