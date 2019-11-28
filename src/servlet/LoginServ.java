package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.LoginDAO;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/AoPratform/login")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("安川さんが作った【ログイン】ページのURLをはっつける");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDAO = new LoginDAO();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//ログイン判定
		Account successUser = loginDAO.findByLogin(id, pass);
		
		if(successUser != null) {
			response.sendRedirect("安川さんが作った【ログインOK】ページのURLをはっつける");
		}else {
			response.sendRedirect("安川さんが作った【ログインNG】ページのURLをはっつける");
		}
		
	}

}
