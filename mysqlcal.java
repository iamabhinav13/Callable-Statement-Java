import java.util.*;
import java.sql.*;
public class mysqlcal
{
	public static void main(String args[])
	{
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","mysql");
		Statement stmt=con.createStatement();
		CallableStatement cs=con.prepareCall("{call addes(?,?)}");
		cs.setInt(1,2);
		cs.setString(2,"Heet");
		int i=cs.executeUpdate();
		ResultSet rs=stmt.executeQuery("select * from student");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
}