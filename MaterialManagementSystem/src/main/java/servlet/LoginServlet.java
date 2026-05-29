package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = null;

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();


		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");

		try {

			UserDAO dao = new UserDAO();

			if (dao.loginCheck(user_id, user_pass)) {

				url = "menu-servlet";

				session.setAttribute("user_id", user_id);

			} else {

				url = "login-failure.html";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			UserDAO dao = new UserDAO();

			dao.Update_date(user_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		

		}

		RequestDispatcher rd =
				request.getRequestDispatcher(url);

		rd.forward(request, response);
	}
}