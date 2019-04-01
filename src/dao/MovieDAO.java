package dao;

import java.util.List;
import java.util.Map;

public interface MovieDAO {
	public List<Map<String, String>> selectMovieList();

	public Map<String, String> selectMovie(Map<String, String> user);

	public int insertMovie(Map<String, String> user);

	public int deleteMovie(Map<String, String> user);

	public int updateMovie(Map<String, String> user);
}
