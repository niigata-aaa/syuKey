package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MaterialDAO;

/**
 * Servlet implementation class MaterialRegistServlet
 */
@WebServlet("/material-regist")
public class MaterialRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaterialRegistServlet() {
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
		// TODO Auto-generated method stub
		HttpSession	session = request.getSession();
		session.setAttribute("user_id", "h-sasa");
		if(session.getAttribute("user_id") != null) {
			MaterialDAO materialDAO = new MaterialDAO();
			List<String> nameList=null;
			List<String> unitList=null;
			
			try {
				nameList = materialDAO.selectNameList();
				unitList = materialDAO.selectAllUnit();
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("nameList", nameList);
			request.setAttribute("unitList", unitList);

			RequestDispatcher rd = request.getRequestDispatcher("material-regist.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
