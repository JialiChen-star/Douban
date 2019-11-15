package Discussion;

import java.util.List;

public interface MemberDAO {
	public void InsertMember(Member me)throws Exception;
	public void DeleteMember(String Disno,String Uno)throws Exception;
	public List<Member> GetMember(String sql)throws Exception;
}
