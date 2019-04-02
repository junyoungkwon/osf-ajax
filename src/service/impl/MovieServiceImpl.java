package service.impl;

import java.util.List;
import java.util.Map;

import dao.MovieDAO;
import dao.impl.MovieDAOImpl;

public class MovieServiceImpl implements service.MovieService {
	MovieDAO movieDAO = new MovieDAOImpl();

	@Override
	public List<Map<String, String>> selectMovieList() {
		return movieDAO.selectMovieList();
	}

	@Override
	public int insertMovie(Map<String, String> movie) {
		return movieDAO.insertMovie(movie);
	}

	@Override
	public Map<String, String> selectMovieByMiNum(int miNum) {
		return movieDAO.selectMovieByMiNum(miNum);
	}

	@Override
	public int deleteMovie(int miNum) {
		return movieDAO.deleteMovie(miNum);
	}
}
