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

import model.dao.MaterialDAO;
import model.entity.MaterialBean;

/**
 * Servlet implementation class MaterialDeleteAdminServlet
 */
@WebServlet("/material-delete-admin")
public class MaterialDeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialDeleteAdminServlet() {
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
		List<MaterialBean> materialNameList = null;

		MaterialDAO dao = new MaterialDAO();

		try {
			materialNameList = dao.selectDeleteNameAdmin();
			request.setAttribute("materialNameList", materialNameList);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("material-delete-admin.jsp");
		rd.forward(request, response);
	}
}