package Diving;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String u=request.getParameter("user");
		String p=request.getParameter("pass");
		HttpSession ses=request.getSession();
		if(u.equalsIgnoreCase("karthi")&&p.equalsIgnoreCase("salem"))
				{
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			request.setAttribute("msg","Login Successfully");
			rd.forward(request, response);
				}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			request.setAttribute("info","username/password incorrect");
			rd.forward(request, response);
		}
	}

}
