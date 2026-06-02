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

import model.dao.MaterialDAO;
import model.entity.MaterialBean;

@WebServlet("/material-delete-result")
public class MaterialDeleteResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MaterialDeleteResultServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter()
				.append("Served at: ")
				.append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// エンコーディング
		request.setCharacterEncoding("UTF-8");

		// セッション取得
		HttpSession session = request.getSession();

		String user_id =
				(String)session.getAttribute("user_id");

		// 選択された材料名を取得
		String[] material_name =
				request.getParameterValues("material_name");

		MaterialDAO dao = new MaterialDAO();

		try {

			// 実際の削除処理
			for(String name : material_name) {

				MaterialBean material =
						new MaterialBean();

				material.setMaterial_name(name);
				material.setUser_id(user_id);

				dao.NewMaterialDelete(material);
			}

			// ユーザーが選択した材料数を表示用件数にする
			request.setAttribute(
					"cnt",
					material_name.length);

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

			request.setAttribute("cnt", 0);

		}

		RequestDispatcher rd =
				request.getRequestDispatcher(
						"material-delete-result.jsp");

		rd.forward(request, response);
	}
}