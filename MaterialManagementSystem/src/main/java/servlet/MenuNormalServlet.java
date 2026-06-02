package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class MenuNormalServlet
 */
@WebServlet("/menu-normal")
public class MenuNormalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuNormalServlet() {
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
		

		if(session.getAttribute("user_id") != null) {
			MaterialDAO materialDAO = new MaterialDAO();
			List<MaterialBean> materialList = new ArrayList<MaterialBean>();
			List<MaterialBean> expiredList = new ArrayList<MaterialBean>();
			
			try {
				materialList = materialDAO.selectAll();
				//System.out.println(materialList.size() + "と" +materialLimitList.size());
				expiredList = materialDAO.selectAllLimit();

			} catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("materialList", materialList);
			request.setAttribute("expiredList", expiredList);
			
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request,response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request,response);
		}
	}

}
