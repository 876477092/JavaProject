package hospital;
import java.sql.*;


public class HospitalDatabase {
	public static void AddUsers(String a[],int x,int y){
		Connection con=null;
		//加载数据库驱动程序
           try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           //建立数据库连接
           try {
			con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=Hospital","sa","sa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           Statement st=null;
		//if(con!=null)System.out.println("连接成功！");
           try {
			 st=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String sql = "insert into UserAppointment values('"+a[0]+"','"+a[1]+"','"+a[2]+"','"+a[3]+"',x,'"+a[4]+"','"+a[5]+"','"+a[6]+"','"+a[7]+"',y,'"+a[8]+"')";	
       	try {
       		st.executeUpdate(sql);
       	} catch (SQLException e) {
       		// TODO Auto-generated catch block
       		e.printStackTrace();
       	}
        System.out.println("成功");
       	try {
    		st.close();
    		con.close();
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}


		

	}
}