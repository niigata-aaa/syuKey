package servlet;

import java.io.IOException;

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
 * Servlet implementation class ExpiredDeleteResultServlet
 */
@WebServlet("/expired-delete-result-servlet")
public class ExpiredDeleteResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpiredDeleteResultServlet() {
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
	  protected void doPost(
	            HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {


		HttpSession session = request.getSession();
		MaterialBean material = (MaterialBean) session.getAttribute("material");
        
		 request.setCharacterEncoding("UTF-8");
		 int material_id = material.getMaterial_id();
		 
		 //int materialId =Integer.parseInt(request.getParameter("material_id"));


        MaterialDAO dao = new MaterialDAO();
		
		int processingNumber = 0;
		
		try {
            
            
			// DAOの利用
			processingNumber = dao.delete(material_id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("processingNumber", processingNumber);
		
		RequestDispatcher rd = request.getRequestDispatcher("expired-delete-result.jsp");
		rd.forward(request, response);
	}

}
