package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MovieService;
import service.impl.MovieServiceImpl;

@WebServlet("/MovieSerlvet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MovieService ms = new MovieServiceImpl(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri= request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		if(idx==0) {
			throw new ServletException("원하는 서비스가 부정확합니다."); // 500 에러 내용	
		}else {
			String cmd = uri.substring(idx+1); 
			if("list".equals(cmd)) {
				request.setAttribute("list",ms.selectMovieList());
				RequestDispatcher rd = request.getRequestDispatcher("/views/movie/movie_list"); //view servlet 들렸다감
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		if(idx==0) {
			throw new ServletException("원하는 서비스가 부정확합니다.");
		}else {
			String cmd = uri.substring(idx+1);
			if("insert".equals(cmd)) {
				Map<String,String> movie = new HashMap<>();
				movie.put("mi_name", request.getParameter("mi_name"));
				movie.put("mi_year", request.getParameter("mi_year"));
				movie.put("mi_national", request.getParameter("mi_national"));
				movie.put("mi_vendor", request.getParameter("mi_vendor"));
				movie.put("mi_director", request.getParameter("mi_director"));
				System.out.println(movie);
			}
		}
	}

}
