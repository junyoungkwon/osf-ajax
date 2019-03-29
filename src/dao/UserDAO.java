package dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {
	
	public List<Map<String,String>> selectUserList();
	
	public Map<String, String> selectUser(Map<String,String> user);
	
	public int insertUser(Map<String, String> user);
	
	public int deleteUser(Map<String, String> user);
	
	public int updateUser(Map<String, String> user);
	
	
	
	
}