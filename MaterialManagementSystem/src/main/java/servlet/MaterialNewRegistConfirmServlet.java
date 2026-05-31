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
import model.entity.MaterialBean;

/**
 * Servlet implementation class MaterialNewRegistConfirmServlet
 */
@WebServlet("/material-newregist-confirm")
public class MaterialNewRegistConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialNewRegistConfirmServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id != null) {
			
			MaterialDAO materialDAO = new MaterialDAO();
			List<MaterialBean> material = null;
			int unit_id = Integer.parseInt(request.getParameter("unit"));
			String unit_name = "";
			
			try {
				material = materialDAO.selectAllUnit();
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			for(int i=0;i<material.size();i++) {
				if(unit_id == material.get(i).getUnit_id()) {
					unit_name = material.get(i).getMaterial_unit();
				}
			}

			request.setAttribute("material_name",(String)request.getParameter("material_name"));
			request.setAttribute("material_limit",(String)request.getParameter("material_limit"));
			request.setAttribute("amount",(String)request.getParameter("amount"));
			request.setAttribute("unit_name", unit_name);
			request.setAttribute("unit_id", String.valueOf(unit_id));
			
			
			RequestDispatcher rd = request.getRequestDispatcher("material-newregist-confirm.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
