package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/user-update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
		// リクエストオブジェクトのエンコーディング方式の指定
    	request.setCharacterEncoding("UTF-8");
    	
		UserBean userBean = new UserBean();
		userBean.setUser_id(request.getParameter("User_id"));
		userBean.setUser_pass(request.getParameter("User_pass"));
		
		//DAOの作成
		UserDAO dao = new UserDAO();
		
		try {
			//DAOの利用
			dao.insert(userBean);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("user-update.jsp");
		rd.forward(request, response);
	}

}
