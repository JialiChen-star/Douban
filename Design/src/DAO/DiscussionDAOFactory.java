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
}
