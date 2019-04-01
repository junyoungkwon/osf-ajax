package service;

import java.util.List;
import java.util.Map;

public interface UserService {

	public List<Map<String,String>> selectUserList();
	
	public Map<String, String> selectUser(Map<String,String> user);
	
	public int insertUser(Map<String, String> user);
	
	public int deleteUser(Map<String, String> user);
	
	public int updateUser(Map<String, String> user);
	
	public Map<String, String> login(Map<String, String> user);

	public Map<String, String> login(String uiId, String uiPwd);
	
	
}
