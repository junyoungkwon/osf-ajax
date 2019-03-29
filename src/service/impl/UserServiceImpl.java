package service.impl;

import java.util.List;
import java.util.Map;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO udao = new UserDAOImpl();
	@Override
	public List<Map<String, String>> selectUserList() {
		return udao.selectUserList();
	}

	@Override
	public Map<String, String> selectUser(Map<String, String> user) {
		return udao.selectUser(user);
	}

	@Override
	public int insertUser(Map<String, String> user) {
		return udao.insertUser(user);
	}

	@Override
	public int deleteUser(Map<String, String> user) {
		return udao.deleteUser(user);
	}

	@Override
	public int updateUser(Map<String, String> user) {
		return udao.updateUser(user);
	}

	@Override
	public int login(Map<String, String> user) {
		Map<String, String> userMap =udao.selectUser(user);
		if(userMap != null) {
			return 1;
		}
		return 0;
	}

}
