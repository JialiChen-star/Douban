package DAO;
import Movies.*;
public class MovieDAOFactory {
	public static MovieDAO getMoivesDAO() {		
		return new MovieDAOImpl();
	}
	public static ActorDAO getActorDAO() {
		return new ActorDAOImpl();
	}
	public static DirectorDAO getDirectorDAO() {
		return new DirectorDAOImpl();
	}
	public static EtcDAO getEtcDAO() {
		return new EtcDAOImpl();
	}
	public static PlayDAO getPlayDAO() {
		return new PlayDAOImpl();
	}
	public static DirectDAO getDirectDAO() {
		return new DirectDAOImpl();
	}
	public static EditDAO getEditDAO() {
		return new EditDAOImpl();
	}
}
