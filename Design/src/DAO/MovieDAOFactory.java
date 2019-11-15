package DAO;
import Movies.*;
public class MovieDAOFactory {
	
	public static Movie getMoivesDAO() {
		
		return new Movie();
	}
	public static Actor getActorDAO() {
		return new Actor();
	}
	public static Director getDirectorDAO() {
		return new Director();
	}
	public static Etc getEtcDAO() {
		return new Etc();
	}
	public static Play getPlayDAO() {
		return new Play();
	}
}
