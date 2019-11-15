package Movies;

import java.util.List;

public interface EtcDAO {

	public void InsertEtc( Etc et)throws Exception;
	public void UpdateEtc( Etc et)throws Exception;
	public void DeleteEtc(String Eno)throws Exception;
	public  Etc getEtc(String Eno)throws Exception;
	public List<Etc> getEtcs(String sql)throws Exception;
}
