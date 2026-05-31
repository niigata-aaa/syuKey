package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MaterialDAO;
import model.entity.MaterialBean;

/**
 * Servlet implementation class MaterialRegistResultServlet
 */
@WebServlet("/material-regist-result")
public class MaterialRegistResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialRegistResultServlet() {
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String material_name = request.getParameter("material_name");
		int material_amount = Integer.parseInt(request.getParameter("material_amount"));
		
		String material_limit = request.getParameter("material_limit");
		
		int cnt = 0;
		String url = "";
		
		
		MaterialBean materialBean = new MaterialBean();
		materialBean.setAmount(material_amount);
		materialBean.setMaterial_name(material_name);
		materialBean.setLimits(material_limit);
		materialBean.setUser_id((String)session.getAttribute("user_id"));
		
		MaterialDAO materialDAO = new MaterialDAO();
		
		try {
			cnt = materialDAO.regist(materialBean);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(cnt != 0) {
			url = "material-regist-result.jsp";
		} else {
			url = "material-regist-failure.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
