package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MovieDAO;
import db.DBCon;

public class MovieDAOImpl implements MovieDAO {
	private String selectMovieList = "select mi_num, mi_name, mi_year, mi_national, mi_vendor, mi_director from movie_info";
	private String insertMovie = "insert into movie_info values(seq_mi_num.nextval,?,?,?,?,?)";

	public int insertMovie(Map<String, String> movie) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(insertMovie);
			ps.setString(1, movie.get("mi_name"));
			ps.setString(2, movie.get("mi_year"));
			ps.setString(3, movie.get("mi_national"));
			ps.setString(4, movie.get("mi_vendor"));
			ps.setString(5, movie.get("mi_director"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Map<String, String>> selectMovieList() {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selectMovieList);
			ResultSet rs = ps.executeQuery();
			List<Map<String, String>> movieList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> movie = new HashMap<>();
				movie.put("mi_num", rs.getString("mi_name"));
				movie.put("mi_name", rs.getString("mi_name"));
				movie.put("mi_year", rs.getString("mi_year"));
				movie.put("mi_national", rs.getString("mi_national"));
				movie.put("mi_vendor", rs.getString("mi_vendor"));
				movie.put("mi_director", rs.getString("mi_director"));
				movieList.add(movie);
			}
			return movieList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

//	private String selectMovie = selectMovieList + " where mi_num=? AND mi_name=?";
//	private String insertMovie = "insert int movie_list"
//			+ " (mi_num, mi_name, mi_year, mi_national, mi_vendor, mi_director)"
//			+ " values(seq_ui_num.nextval,?,?,?,?,?)";
//	private String deleteMovie = "delete from movie_list where mi_num=?";
//	private String updateMoive = "update movie_list set(mi_name=?, mi_year=?, mi_national=?, mi_vendor=?, mi_director=? where mi_num=?";


	@Override
	public Map<String, String> selectMovie(Map<String, String> user) {

		return null;
	}

	@Override
	public int deleteMovie(Map<String, String> user) {

		return 0;
	}

	@Override
	public int updateMovie(Map<String, String> user) {

		return 0;
	}

}
