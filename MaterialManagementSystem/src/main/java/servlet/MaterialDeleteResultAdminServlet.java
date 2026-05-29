package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MaterialDAO;
import model.entity.MaterialBean;

/**
 * Servlet implementation class MaterialDeleteResultAdminServlet
 */
@WebServlet("/material-delete-result-admin")
public class MaterialDeleteResultAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialDeleteResultAdminServlet() {
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

				int cnt = 0;

				//リクエストパラメータ取得
				MaterialBean material = new MaterialBean();
				material.setMaterial_name(request.getParameter("material_name"));

				MaterialDAO dao = new MaterialDAO();
				try {
					cnt = dao.NewMaterialDelete(material);
					request.setAttribute("cnt", cnt);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println(cnt);
				RequestDispatcher rd = request.getRequestDispatcher("material-delete-result-admin.jsp");
				rd.forward(request, response);
			}
		}