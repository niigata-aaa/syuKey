package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.HistoryDAO;
import model.entity.HistoryBean;

/**
 * Servlet implementation class ShowImageServlet
 */
@WebServlet("/show-image")
public class ShowImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		HistoryDAO dao = new HistoryDAO();
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null;
		
		try {
			java.util.Date utilDate = sdf.parse(date);
			sqlDate = new java.sql.Date(utilDate.getTime());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {

            HistoryBean image = dao.getDetail(user_id,name,sqlDate);

            if (image == null) {
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            response.setContentType(
                    image.getContentType());

            response.setContentLength(
                    image.getImage_data().length);

            OutputStream out =
                    response.getOutputStream();

            out.write(image.getImage_data());
            out.flush();

        } catch (Exception e) {
            throw new ServletException(e);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
