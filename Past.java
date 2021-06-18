package Diving;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modern.Driving;

/**
 * Servlet implementation class Past
 */
@WebServlet("/Past")
public class Past extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Past() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file,filee;
		InputStream is,iss;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/driving","root","");
			String qry="select * from school where status=true";
			PreparedStatement ps=con.prepareStatement(qry);
			ResultSet rs=ps.executeQuery();
			List<Driving> lot=new Vector<Driving>();
			Driving D;
			while(rs.next())
			{
				D=new Driving();
				D.setRegno(rs.getInt("regno"));
				D.setName(rs.getString("name"));
				D.setType(rs.getString("type"));
				D.setDateofjoin(rs.getString("datejoin"));
				D.setBgroup(rs.getString("bgroup"));
				//D.setAddress(is=(InputStream)rs.getBinaryStream("address"));
				is=(InputStream)rs.getBinaryStream("address");
				file=new File("C:\\Users\\ELCOT\\Downloads\\Blob\\"+rs.getString("name")+"-address.jpg");
				byte[] tmp=new byte[is.available()];
				is.read(tmp);
				FileOutputStream fos=new FileOutputStream(file);
				fos.write(tmp);
				D.setAddress(file.getName());
				//D.setId(iss=(InputStream)rs.getBinaryStream("id"));
				iss=(InputStream)rs.getBinaryStream("id");
				filee=new File("C:\\Users\\ELCOT\\Downloads\\Blob\\"+rs.getString("name")+"-id.jpg");
				byte[] tmpp=new byte[iss.available()];
				iss.read(tmpp);
				FileOutputStream foss=new FileOutputStream(filee);
				foss.write(tmpp);
				lot.add(D);
				fos.close();
				is.close();
				foss.close();
				iss.close();
				D.setId(filee.getName());
				System.out.println("File Downloaded Successfully");
			}
			RequestDispatcher dis=request.getRequestDispatcher("Past.jsp");
			request.setAttribute("all", lot);
			dis.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
