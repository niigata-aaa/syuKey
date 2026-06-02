package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.MaterialBean;

/**
 * Servlet implementation class MaterialRegistConfirm
 */
@WebServlet("/material-regist-confirm")
public class MaterialRegistConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaterialRegistConfirm() {
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
		String user_id = (String)session.getAttribute("user_id");
		request.setCharacterEncoding("UTF-8");
		if(user_id != null) {
			String material_name = request.getParameter("material_name");
			String material_limit = request.getParameter("material_limit");
			int material_amount = Integer.parseInt(request.getParameter("material_amount"));
			String material_unit = request.getParameter("unit");
			
			MaterialBean materialBean = new MaterialBean();
			
			materialBean.setAmount(material_amount);
			materialBean.setLimits(material_limit);
			materialBean.setMaterial_name(material_name);
			materialBean.setMaterial_unit(material_unit);
			materialBean.setUser_id(user_id);

			request.setAttribute("materialBean", materialBean);
			
			RequestDispatcher rd = request.getRequestDispatcher("material-regist-confirm.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
