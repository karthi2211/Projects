package Diving;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
		String a=request.getParameter("reg");
		File file=new File(request.getParameter("upload"));
		InputStream is=new FileInputStream(file);
		File file1=new File(request.getParameter("id"));
		InputStream iss=new FileInputStream(file1);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/driving","root","");
		    String qry="update school set address=?,id=? where regno=?";
		    PreparedStatement pre=con.prepareStatement(qry);
		    pre.setBinaryStream(1, is);
		    pre.setBinaryStream(2, iss);
		    pre.setString(3,a);
		    int ack=pre.executeUpdate();
		    RequestDispatcher dis=request.getRequestDispatcher("EditEnroll.jsp");
			if(ack!=0)
			{
				request.setAttribute("info", "Document Updated");
			}
			else
			{
				request.setAttribute("info", "Document not Updated");
			}
			dis.forward(request, response);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
