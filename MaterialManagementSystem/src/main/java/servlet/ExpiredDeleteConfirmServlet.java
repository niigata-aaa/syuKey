package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class ExpiredDeleteConfirmServlet
 */
@WebServlet("/expired-delete-confirm-servlet")
public class ExpiredDeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpiredDeleteConfirmServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		 

		 try {
			 String material_name = (String)request.getParameter("material_name");
			 String material_limit = (String) request.getParameter("material_limit");
			 Date limit_date = null;
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 
			 try {
					limit_date = sdf.parse(material_limit);
					
				} catch(Exception e) {
					e.printStackTrace();
				}

			 
			 MaterialDAO dao = new MaterialDAO();
			 MaterialBean material = dao.select(material_name, limit_date);

				// セッションオブジェクトの取得
				HttpSession session = request.getSession();

				// セッションスコープへの属性の設定
				session.setAttribute("material", material);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("expired-delete-confirm.jsp");
		rd.forward(request, response);
		
		
		
	}
		
	}

