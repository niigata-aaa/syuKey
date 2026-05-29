package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaterialDeleteConfirmAdminServlet
 */
@WebServlet("/material-delete-confirm-admin")
public class MaterialDeleteConfirmAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialDeleteConfirmAdminServlet() {
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
		//リクエストのエンコーディング方式を指定
				request.setCharacterEncoding("UTF-8");

				//リクエストパラメータ取得
				String material_name = request.getParameter("material_name");
				
				request.setAttribute("material_name", material_name);
				RequestDispatcher rd = request.getRequestDispatcher("material-delete-confirm-admin.jsp");
				rd.forward(request, response);
			}
		}