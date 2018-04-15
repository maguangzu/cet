package com.wq.evidance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wq.system.domain.Volenteer;

/**
 * Servlet implementation class volzhming
 */
@WebServlet("/volzhming.do")
public class volzhming extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Volenteer vol=(Volenteer) session.getAttribute("Constants.LOGIN_USER_KEY");
		request.setAttribute("vol", vol);
		request.getRequestDispatcher("volzhengming.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
