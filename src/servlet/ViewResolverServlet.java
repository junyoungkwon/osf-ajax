package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewResolverServlet")
public class ViewResolverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Map<String, String>> normalList = new ArrayList<>();
	private List<Map<String, String>> photoList = new ArrayList<>();
	public ViewResolverServlet() {
		for(int i =1;i<=10;i++) {
			Map<String,String> normal = new HashMap<>();
			Map<String,String> photo = new HashMap<>();
			normal.put("num", i+"");
			photo.put("num", i+"");
			normal.put("title","일반" + i +"번째 제목");
			photo.put("title","일반" + i +"번째 제목");
			normalList.add(normal);
			photoList.add(photo);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = "/WEB-INF" + uri + ".jsp";
		String boardTitle =request.getParameter("board_title");
		
		if("사진".equals(boardTitle)) {
			request.setAttribute("list", photoList);
		}else {
			request.setAttribute("list", normalList);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}
}
