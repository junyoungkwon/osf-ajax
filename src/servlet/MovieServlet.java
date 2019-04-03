package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MovieService;
import service.impl.MovieServiceImpl;
import utils.Command;

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService movieService = new MovieServiceImpl();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = Command.getCmd(request);
		if("list".equals(cmd)) {
			request.setAttribute("list",movieService.selectMovieList());
			String url = "/views/movie/movie_list";
			Command.goPage(request, response, url);
			return;
		}else {
			try {
				int miNum = Integer.parseInt(cmd);
				request.setAttribute("movie", movieService.selectMovieByMiNum(miNum));
				RequestDispatcher rd = request.getRequestDispatcher("/views/movie/view");
				rd.forward(request, response);
				return;
			}catch( Exception e) {
				throw new ServletException("올바른 상세조회 값이 아닙니다.");
			}
		}
	}	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = Command.getCmd(request);
		if("insert".equals(cmd)) {
			HttpSession hs = request.getSession();
			if(hs.getAttribute("user")==null) {
				String url = "/";
				String msg = "로그인을 하세요.";
				Command.goResultPage(request,response,url,msg);
				return;
			}
			Map<String,String> movie = Command.getSingleMap(request);
			String msg = "등록이 실패하였습니다.";
			if(movieService.insertMovie(movie)==1) {
				msg = "등록이 성공하였습니다.";
				String url = "/movie/list";
				Command.goResultPage(request, response, url, msg);
				return;
			}
		}else if("delete".equals(cmd)) {
			HttpSession hs = request.getSession();
			if(hs.getAttribute("user")==null){
				String msg="로그인을 하세요.";
				String url = "/";
				Command.goResultPage(request, response, url, msg);
				return;
			}
			int miNum = Integer.parseInt(request.getParameter("mi_num"));
			String msg = "삭제에 실패하였습니다.";
			String url = "/movie/"+miNum;
			request.setAttribute("msg","삭제에 실패하였습니다. ");
			request.setAttribute("url","/movie"+miNum);
			if(movieService.deleteMovie(miNum)==1) {
				msg= "삭제에 성공하였습니다.";
				url = "/movie/list";
				Command.goResultPage(request, response, url, msg);
				return;
			}else {
				Command.goResultPage(request, response, url, msg);
				return;
			}
		}
	}
}