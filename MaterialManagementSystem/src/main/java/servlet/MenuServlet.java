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

import model.dao.UserDAO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu-servlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
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

		HttpSession session =
				request.getSession();




		if(session.getAttribute("user_id") != null) {

			UserDAO dao = new UserDAO();
			String name = (String) session.getAttribute("user_id");

			//ログインした人が会員か管理者か判定

			try {		
				if (dao.admin_flg_Check(name)) {
					//アドミンフラグ成功はMenuAdminServletへ
					url = "menu-admin";

				}else {
					//アドミンフラグ失敗はMenuNormalServletへ(パス；menu-normal)
					url = "menu-normal";

				}
			}catch(ClassNotFoundException|SQLException e){
				e.printStackTrace();
				{
				}

			}

		}else {
			//user_idがnullの人はログイン画面へ
			url = "login.html";
		}


		RequestDispatcher rd =
				request.getRequestDispatcher(url);

		rd.forward(request, response);
	}
}