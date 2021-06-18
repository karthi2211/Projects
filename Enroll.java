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
 * Servlet implementation class Enroll
 */
@WebServlet("/Enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll() {
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
		String a=request.getParameter("name");
		String b=request.getParameter("type");
		File file=new File(request.getParameter("upload"));
		InputStream is=new FileInputStream(file);
		File file1=new File(request.getParameter("id"));
		InputStream iss=new FileInputStream(file1);
		String c=request.getParameter("date");
		String d=request.getParameter("bg");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/driving","root","");
			String qry="insert into school(name,type,address,id,datejoin,bgroup) values(?,?,?,?,?,?)";
			PreparedStatement pre=con.prepareStatement(qry);
			pre.setString(1, a);pre.setString(2, b);pre.setBinaryStream(3, is);
			pre.setBinaryStream(4, iss);pre.setString(5, c);pre.setString(6,d);
			int res=pre.executeUpdate();
			RequestDispatcher dis=request.getRequestDispatcher("Enroll.jsp");
			if(res!=0)
			{
				request.setAttribute("info", "Record Added");
			}
			else
			{
				request.setAttribute("info", "Record not Added");
			}
			dis.forward(request, response);
		}catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}

}
