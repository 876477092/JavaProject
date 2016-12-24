package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class President {
    public String id;//科室编号
	public String name;//科室名称
	public int mnum;//科室当月挂号数
	public int dnum;//科室当天挂号数
	public float mincome;//科室当月收入
	public float dincome;//科室当天收入
	
	public static void LookDept(){
		Connection con=null;
           try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
           Statement st=null;
           try {
			 st=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
           String sql="select * from Dept ";
   		ResultSet rs=null;
   		
   		
   		
   		try {
   			rs=st.executeQuery(sql);
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   		try {
   			while(rs.next()){
   				System.out.print(" 科室编号："+rs.getString("id"));
   				System.out.print(" 科室全名："+rs.getString("name"));
   				System.out.print(" 科室当月挂号数："+rs.getInt("mnum"));
   				System.out.print(" 科室当天挂号数："+rs.getInt("dnum"));
   				System.out.print(" 科室当月收入："+rs.getFloat("mincome"));
   				System.out.print(" 科室当天收入："+rs.getFloat("dincome"));
   				System.out.println();
   			}
   		} catch (SQLException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
   		
   		try {
   			rs.close();
   			st.close();
   			con.close();
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
	}
}
