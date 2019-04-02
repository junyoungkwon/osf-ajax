package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.MovieService;
import service.impl.MovieServiceImpl;
import utils.Command;

@WebServlet("/MovieSerlvet")
public class AJAXMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService ms = new MovieServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = Command.getCmd(request);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		if ("list".equals(cmd)) {
			PrintWriter pw = response.getWriter();
			pw.println(gson.toJson(ms.selectMovieList()));
			
		} else {
			try {
				int miNum = Integer.parseInt(cmd);
				PrintWriter pw = response.getWriter();
				pw.println(gson.toJson(ms.selectMovieByMiNum(miNum)));
			} catch (Exception e) {
				throw new ServletException("올바른 상세조회 값이 아닙니다.");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = Command.getCmd(request);

		if ("insert".equals(cmd)) {
			HttpSession hs = request.getSession();
			if (hs.getAttribute("user") == null) {
				Command.goResultPage(request, response, "/", "로그인하세요");
				return;
			}

			Map<String, String> movie = Command.getSingleMap(request);
			String msg = "영화등록실패!";
			String url = "/movie/list";

			request.setAttribute("msg", "영화등록실패!");
			if (ms.insertMovie(movie) == 1) {
				request.setAttribute("msg", "영화등록성공!");
			}
			request.setAttribute("url", "/movie/list");
			RequestDispatcher rd = request.getRequestDispatcher("/views/msg/result");
			rd.forward(request, response);
		} else if ("delete".equals(cmd)) {
			HttpSession hs = request.getSession();
			if (hs.getAttribute("user") == null) {
				request.setAttribute("msg", "로그인하세요");
				request.setAttribute("url", "/");
				RequestDispatcher rd = request.getRequestDispatcher("/viwes/movie/view");
				rd.forward(request, response);
				return;
			}
			int miNum = Integer.parseInt(request.getParameter("mi_num"));
			request.setAttribute("msg", "삭제에 실패하였습니다.");
			request.setAttribute("url", "/movie/" + miNum);
			if (ms.deleteMovie(miNum) == 1) {
				request.setAttribute("msg", "삭제에 성공하였습니다.");
				request.setAttribute("url", "/movie/" + miNum);
			}

		}
	}
}