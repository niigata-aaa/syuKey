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

import model.dao.HistoryDAO;
import model.entity.HistoryBean;

/**
 * Servlet implementation class HistoryDetailServlet
 */
@WebServlet("/history-detail")
public class HistoryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryDetailServlet() {
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
		String user_id = (String)session.getAttribute("user_id");
		request.setCharacterEncoding("UTF-8");
		if(user_id != null) {
			
			String name = (String)request.getParameter("sweets_name");
			
			String makedDate = (String)request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date sqlDate = null;
			
			try {
				java.util.Date utilDate = sdf.parse(makedDate);
				sqlDate = new java.sql.Date(utilDate.getTime());
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			HistoryDAO historyDAO = new HistoryDAO();
			HistoryBean historyDetail = new HistoryBean();
			
			try {
				historyDetail = historyDAO.getDetail(user_id, name,sqlDate);
				
				
			}catch(SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("historyDetail", historyDetail);
			
			RequestDispatcher rd = request.getRequestDispatcher("history-detail.jsp");
			rd.forward(request, response);
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
