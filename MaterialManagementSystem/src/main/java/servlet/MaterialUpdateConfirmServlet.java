package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class MaterialUpdateConfirmServlet
 */
@WebServlet("/material-update-confirm")

@MultipartConfig

public class MaterialUpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaterialUpdateConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession	session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		if(session.getAttribute("user_id") != null) {
			request.setCharacterEncoding("UTF-8");
			String[] material_names = request.getParameterValues("material_name");
			String[] material_amounts = request.getParameterValues("amount");
			List<String> nameList = new ArrayList<String>();
			List<Integer> amountList = new ArrayList<Integer>();
			

			//System.out.println(material_amounts);
			String recipe_url = request.getParameter("recipe_url");
			String sweets_name = request.getParameter("sweets_name");
			String comment = request.getParameter("comment");
			String submitted  = "";
			String contentType = "";
			System.out.println(material_amounts);
			if(material_names != null && material_amounts != null) {
				for(int i=0;i<material_amounts.length;i++) {
					if((!material_names[i].trim().isEmpty()) && (!material_amounts[i].trim().isEmpty())) {
						//System.out.println(material_amounts.length);
						//System.out.println(material_amounts[i]);
						nameList.add(material_names[i]);
						amountList.add(Integer.parseInt(material_amounts[i]));
					}
				}
			} 
			
			if( !(sweets_name == null || sweets_name.isEmpty())) {
				Part part = request.getPart("history_image");

				submitted = Paths.get(part.getSubmittedFileName())
				                         .getFileName()
				                         .toString();
				contentType = part.getContentType();
				
				//System.out.println("contentType:" + contentType);
				String uploadDir = getServletContext().getRealPath("/history-image");

				File dir = new File(uploadDir);
				if (!dir.exists()) {
				    dir.mkdirs();
				}

				String filePath = uploadDir + File.separator + submitted;

				// 保存
				part.write(filePath);

				// 次のServletへ渡す
				request.setAttribute("fileName", submitted);
				request.setAttribute("filePath", filePath);
				request.setAttribute("contentType", contentType);
			}
			request.setAttribute("material_names", nameList);
			request.setAttribute("material_amounts",amountList );
			request.setAttribute("recipe_url", recipe_url);
			request.setAttribute("sweets_name", sweets_name);
			request.setAttribute("comment", comment);
			
			

			RequestDispatcher rd = request.getRequestDispatcher("material-update-confirm.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

}
