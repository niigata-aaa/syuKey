package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.HistoryDAO;
import model.dao.MaterialDAO;
import model.entity.MaterialBean;

/**
 * Servlet implementation class MaterialUpdateResultServlet
 */
@WebServlet("/material-update-result")
public class MaterialUpdateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialUpdateResultServlet() {
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
	//@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		String[] nameList = request.getParameterValues("material_names");
		List<String> names = new ArrayList<>();

		if (nameList != null) {
		    for (String n : nameList) {
		        if (n != null && !n.isEmpty()) {
		            names.add(n);
		        }
		    }
		}
		
		String[] amountsStr = request.getParameterValues("material_amounts");
		List<Integer> amounts = new ArrayList<>();

		if (amountsStr != null) {
		    for (String s : amountsStr) {
		        if (s != null && !s.isEmpty()) {
		            amounts.add(Integer.parseInt(s));
		        }
		    }
		}
		
		String url = request.getParameter("recipe_url");
		String sweets_name = request.getParameter("sweets_name");
		String comment = request.getParameter("comment");
		String image_name = request.getParameter("fileName");
		String image_path = request.getParameter("filePath");
		String contentType = request.getParameter("contentType");
		List<String> msg = new ArrayList<String>();
		
		int count = 0;
		MaterialDAO materialDAO = new MaterialDAO();
		HistoryDAO historyDAO = new HistoryDAO();
		List<String> msgList = new ArrayList<String>();
		
		
		try {
			
			for(int i=0;i<names.size();i++) {
				int total_amount = materialDAO.getTotalAmount(names.get(i));
				if((total_amount - amounts.get(i)) >= 0) {
					List<MaterialBean> listForUpdate = new ArrayList<MaterialBean>();
					listForUpdate = materialDAO.selectToUpdate(names.get(i));
					int sub = 0;
					if((listForUpdate.get(0).getAmount() - amounts.get(i)) >= 0) {
						if((listForUpdate.get(0).getAmount() - amounts.get(i)) == 0) {
							msg.add(names.get(i) + "を1つ使い切りました！");
						}
						sub = listForUpdate.get(0).getAmount() - amounts.get(i);
						listForUpdate.get(0).setAmount(sub);
					} else {
						amounts.set(i,amounts.get(i) - listForUpdate.get(0).getAmount());
						listForUpdate.get(0).setAmount(0);
						sub = listForUpdate.get(1).getAmount() - amounts.get(i);
						listForUpdate.get(1).setAmount(sub);
						msg.add(names.get(i) + "を1つ使い切りました！");
					}
					count += materialDAO.update(listForUpdate);
					//materialDAOのSQL文どうしようかな。
					
				} else {
					msgList.add(names.get(i) + "の在庫が足りませんでした。");
					
				}
				
			}
			
			
			if(!(sweets_name == null || sweets_name.isEmpty())) {
				int historycnt = count;
				count += historyDAO.insert(user_id,url,sweets_name,comment, image_name,image_path,contentType);
				if(historycnt == count) {
					msgList.add("履歴の更新に失敗しました。");
				}
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("msg",msg);
		request.setAttribute("errmsg", msgList);
		
		
		if(count != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("material-update-result.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("material-update-failure.jsp");
			rd.forward(request, response);
		}
	}

}
