package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class President {
    public String id;//���ұ��
	public String name;//��������
	public int mnum;//���ҵ��¹Һ���
	public int dnum;//���ҵ���Һ���
	public float mincome;//���ҵ�������
	public float dincome;//���ҵ�������
	
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
   				System.out.print(" ���ұ�ţ�"+rs.getString("id"));
   				System.out.print(" ����ȫ����"+rs.getString("name"));
   				System.out.print(" ���ҵ��¹Һ�����"+rs.getInt("mnum"));
   				System.out.print(" ���ҵ���Һ�����"+rs.getInt("dnum"));
   				System.out.print(" ���ҵ������룺"+rs.getFloat("mincome"));
   				System.out.print(" ���ҵ������룺"+rs.getFloat("dincome"));
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
