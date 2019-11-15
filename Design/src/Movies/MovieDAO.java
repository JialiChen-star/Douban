package Movies;

import java.util.List;

public interface MovieDAO {
	public void InsertMovie(Movie mo)throws Exception;
	public void UpdateMovie(Movie mo)throws Exception;
	public void DeleteMovie(String Mno)throws Exception;
	public Movie getMovie(String Mno)throws Exception;
	public List<Movie> GetMovies(String sql)throws Exception;
}
