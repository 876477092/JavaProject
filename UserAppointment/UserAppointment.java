package hospital;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserAppointment {

	public String aid;//预约号
    public String id;//身份证号码
	public String name;//姓名
	public String sex;//‘男’或‘女’
	public String age 	;//年龄
	public String address;//地址
	public String phone;//电话
	public String aptime;//预约时间	
	public String dept;//预约的诊室
	public String valid;//1预约有效0无效
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
	
	String [] Users = new String[11] ;    
	Users[0]='A'+Getsubtime();	
	System.out.println("请输入身份证号码");
	Users[1]=in.next();
	System.out.println("请输入姓名");
	Users[2]=in.next();
	System.out.println("请输入性别");
	Users[3]=in.next();
	System.out.println("请输入年龄");
	Users[4]=in.next();
	System.out.println("请输入地址");
	Users[5]=in.next();
	System.out.println("请输入电话");
	Users[6]=in.next();
	System.out.println("请输入预约时间");
	Users[7]=in.next();
	System.out.println("请输入预约的诊室");
	Users[8]=in.next();
	Users[9]="1";
	Users[10]=Getsubtime();
	HospitalDatabase db=null;
	db.AddUsers(Users);
}

     
	
}
