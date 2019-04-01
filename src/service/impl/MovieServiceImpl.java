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

}

