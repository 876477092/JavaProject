package hospital;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserAppointment {

	public String aid;//预约号
    public String id;//身份证号码
	public String name;//姓名
	public String sex;//‘男’或‘女’
	public int age 	;//年龄
	public String address;//地址
	public String phone;//电话
	public String aptime;//预约时间	
	public String dept;//预约的诊室
	public int valid;//1预约有效0无效
	public static String subtime;//提交预约的时间
	
	public static String Getsubtime()
	{
		long l=System.currentTimeMillis();
		Date date=new Date(l);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    subtime=format.format(date);
	    return subtime;
	}
		 
public static void AddUserAppointment() {  //增加用户 预约信息 
	Scanner in=new Scanner(System.in);
	int x,y;
	String [] Users = new String[11] ;    
	Users[0]='A'+Getsubtime();	
	System.out.println("请输入身份证号码");
	Users[1]=in.next();
	System.out.println("请输入姓名");
	Users[2]=in.next();
	System.out.println("请输入性别");
	Users[3]=in.next();
	System.out.println("请输入年龄");
	x=in.nextInt();
	System.out.println("请输入地址");
	Users[4]=in.next();
	System.out.println("请输入电话");
	Users[5]=in.next();
	System.out.println("请输入预约时间");
	Users[6]=in.next();
	System.out.println("请输入预约的诊室");
	Users[7]=in.next();
	y=1;
	Users[8]=Getsubtime();
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
    String sql = "insert into UserAppointment values('"+Users[0]+"','"+Users[1]+"','"+Users[2]+"','"+Users[3]+"',"+x+",'"+Users[4]+"','"+Users[5]+"','"+Users[6]+"','"+Users[7]+"',"+y+",'"+Users[8]+"')";	
   	try {
   		st.executeUpdate(sql);
   	} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
    //System.out.println("成功");
   	try {
		st.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

     
	
}
