package dao;

import java.util.List;
import java.util.Map;

public interface MovieDAO {
	public List<Map<String, String>> selectMovieList();

	public Map<String, String> selectMovie(Map<String, String> movie);

	public int insertMovie(Map<String, String> movie);

	public int deleteMovie(Map<String, String> movie);

	public int updateMovie(Map<String, String> movie);
}
