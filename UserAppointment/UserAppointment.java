package hospital;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserAppointment {

	public String aid;//ԤԼ��
    public String id;//���֤����
	public String name;//����
	public String sex;//���С���Ů��
	public String age 	;//����
	public String address;//��ַ
	public String phone;//�绰
	public String aptime;//ԤԼʱ��	
	public String dept;//ԤԼ������
	public String valid;//1ԤԼ��Ч0��Ч
	public static String subtime;//�ύԤԼ��ʱ��
	
	public static String Getsubtime()
	{
		long l=System.currentTimeMillis();
		Date date=new Date(l);
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    subtime=format.format(date);
	    return subtime;
	}
		 
public static void AddUserAppointment() {  //�����û� ԤԼ��Ϣ 
	Scanner in=new Scanner(System.in);
	
	String [] Users = new String[11] ;    
	Users[0]='A'+Getsubtime();	
	System.out.println("���������֤����");
	Users[1]=in.next();
	System.out.println("����������");
	Users[2]=in.next();
	System.out.println("�������Ա�");
	Users[3]=in.next();
	System.out.println("����������");
	Users[4]=in.next();
	System.out.println("�������ַ");
	Users[5]=in.next();
	System.out.println("������绰");
	Users[6]=in.next();
	System.out.println("������ԤԼʱ��");
	Users[7]=in.next();
	System.out.println("������ԤԼ������");
	Users[8]=in.next();
	Users[9]="1";
	Users[10]=Getsubtime();
	HospitalDatabase db=null;
	db.AddUsers(Users);
}

     
	
}
