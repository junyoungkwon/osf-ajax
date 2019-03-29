package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.UserDAO;
import db.DBCon;

public class UserDAOImpl implements UserDAO {
	private String insertUser = "insert into user_info"
			+" (ui_num, ui_name, ui_id, ui_pwd, ui_email)"
			+" values(seq_ui_num.nextval,?,?,?,?)";
	private String selectUserList = "select ui_num, ui_name, ui_id, ui_pwd, ui_email from user_info";
	private String selectUser = selectUserList + " where ui_id=? AND ui_pwd=?";
	private String deleteUser = "delete from user_info"
			+ " where ui_num=?";
	private String updateUser = "update user_info"
			+ " set(ui_name = ?, ui_id=?, ui_pwd=?, ui_email=?) "
			+ " where ui_num=?";
	
	@Override
	public int insertUser(Map<String, String> user) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(insertUser);
			ps.setString(1,user.get("uiName"));
			ps.setString(2,user.get("uiId"));
			ps.setString(3,user.get("uiPwd"));
			ps.setString(4,user.get("uiEmail"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.conClose();
		}
		return 0;
	}

	@Override
	public List<Map<String, String>> selectUserList() {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selectUserList);
			ResultSet rs = ps.executeQuery();
			List<Map<String, String>> userList = new ArrayList<>();
			while(rs.next()) {
				Map<String, String> userMap = new HashMap<>();
				userMap.put("uiNum", rs.getString("ui_num"));
				userMap.put("uiName", rs.getString("ui_name"));
				userMap.put("uiId", rs.getString("ui_id"));
				userMap.put("uiPwd", rs.getString("ui_pwd"));
				userMap.put("uiEmail", rs.getString("ui_email"));
				userList.add(userMap);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCon.conClose();
		}
		return null;
	}

	@Override
	public Map<String, String> selectUser(Map<String, String> user) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selectUser);
			ps.setString(1, user.get("uiId"));
			ps.setString(2, user.get("uiPwd"));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String> userMap = new HashMap<>();
				userMap.put("uiNum", rs.getString("ui_num"));
				userMap.put("uiName", rs.getString("ui_name"));
				userMap.put("uiId", rs.getString("ui_id"));
				userMap.put("uiPwd", rs.getString("ui_pwd"));
				userMap.put("uiEmail", rs.getString("ui_email"));
				return userMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.conClose();
		}
		return null;
	}

	@Override
	public int deleteUser(Map<String, String> user) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(deleteUser);
			ps.setString(1, user.get("ui_num"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.conClose();
		}
		return 0;
	}

	@Override
	public int updateUser(Map<String, String> user) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(updateUser);
			ps.setString(1, user.get("uiName"));
			ps.setString(2, user.get("uiId"));
			ps.setString(3, user.get("uiPwd"));
			ps.setString(4, user.get("uiEmail"));
			ps.setString(5, user.get("uiNum"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.conClose();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserDAO udao =new UserDAOImpl();
		Map<String, String> user = new HashMap<>();
		user.put("uiName", "김선민");
		user.put("uiId", "ksmsm12");
		user.put("uiPwd", "12345678");
		user.put("uiEmail", "tjsals116@naver.com");
		user.put("uiNum", "1");
		
		System.out.println(udao.selectUser(user));
	}
}
