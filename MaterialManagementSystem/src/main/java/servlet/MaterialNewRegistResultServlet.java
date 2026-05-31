package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MaterialDAO;

/**
 * Servlet implementation class MaterialNewRegistResultServlet
 */
@WebServlet("/material-newregist-result")
public class MaterialNewRegistResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialNewRegistResultServlet() {
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
			
			String materialName  = request.getParameter("material_name");
		    String materialLimit = request.getParameter("material_limit");
		    int amount        = Integer.parseInt(request.getParameter("amount"));
		    int unitId        = Integer.parseInt(request.getParameter("unit_id"));
		    int cnt = 0;
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date sqlDate = null;
			
			try {
				java.util.Date utilDate = sdf.parse(materialLimit);
				sqlDate = new java.sql.Date(utilDate.getTime());
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			MaterialDAO materialDAO = new MaterialDAO();
			
			try {
				cnt = materialDAO.insert(materialName,sqlDate,amount,unitId,user_id);
				
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			request.setAttribute("cnt", cnt);
			RequestDispatcher rd = request.getRequestDispatcher("material-newregist-result.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
