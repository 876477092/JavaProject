import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
	private String id;
	private String pwd;
	private String name;
	private String sex;
	private int age;
	private String phone;
	private String deptid;
	private int state;
	private static int mnum;
	private  int dnum ;
	private static float mincome;
	private float dincome;
	private String list;
	private User user=null;
	private SQL sql;
	ResultSet rs;
	
	public Doctor(String id,SQL sql){
		ResultSet rs=sql.executeQuery("select * from doctor where id="+id+"' ");
        try {
			this.id=rs.getString(1);
			this.pwd=rs.getString(2);
	        this.name=rs.getString(3);
	        this.sex=rs.getString(4);
	        this.age=rs.getInt(5);
	        this.phone=rs.getString(6);
	        this.deptid=rs.getString(7);
	        this.state=0;//初始化当天队列
	        this.mnum=rs.getInt(9);
	        this.dnum=0;//初始化当天就诊人数
	        this.mincome=rs.getFloat(11);
	        this.dincome=0;//初始化当天坑钱记录
	        this.list=list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}
	
	public boolean newUser() throws SQLException{
    	String Userid;
    	if(list!=null){
    		Userid=list.substring(0, 10);
    		rs=sql.executeQuery("select * from UserMedicalHistory where mid='"+Userid+"'");
    		user=new User();
    		createNewUser(user,rs);
    		state=sql.executeQuery("select *from Doctor where id='"+id+"'").getInt("state");
    		state--;
    		sql.executeUpdate("update Doctor set state="+state+" where id='"+id+"'");
    		return true;
    	}else{
    		return false;
    	}
    }
	public String seacherSpec(String name){
		String spec=null;
	    rs=sql.executeQuery("select spec from Medicine where name='"+name+"'");
	    try {
			spec=rs.getString("spec");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("找不到规格");
		}
	    return spec;
	    
	}
	
	 public void createNewUser(User user ,ResultSet rs){
		  try {
			user.setMID(rs.getString(0));
			user.setID(rs.getString(1));
			user.setName(rs.getString(2));
			user.setSex(rs.getString(3));
			user.setAge(rs.getInt(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	 
	 public String[] seacherMed(String s) throws SQLException  {//根据拼音码查询药品名字
		 String[] name=null;
		 rs=sql.executeQuery("select name from Medicine where quickname = "+s+"'");
		 if(!rs.next()){
			 rs=sql.executeQuery("select name from Medicine where name = "+s+"'");
		 }
		 try {
			name=new String[rs.getFetchSize()];
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查无此药，rs.size不能为0");
		}
		 
		 if(rs.next()){
			 for(int i=0;i<rs.getFetchSize();i++){
				 name[i]=rs.getString("name");
			 }
		 }
		 return name;
		
	 }
	 
	 public String seacherMedspec(String s) throws SQLException{
		 String spec;
		 rs=sql.executeQuery("select spec from Medicine where name='"+s+"'");
		 spec=rs.getString(0);
		 return spec;
	 }
	 
	 public String seacherChargeitem(String s){
		 String a=null;
		 rs=sql.executeQuery("select name from Chargeitem where quickname='"+s+"'");
		 try {
			if(!rs.next()){
				 rs=sql.executeQuery("select name from Chargeitem where name='"+s+"'");
			}
			a=rs.getString("name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    System.out.println("查无此项目");
		}
		 return a;
	 }
	 
	 public boolean finish(String id,String desc,String diag,String med,String Chargeitem,float money){
		 int x=sql.executeUpdate("update UserMedicalHistory set desc='"+desc+"',med'"+med+
				 "',Chargeitem"+Chargeitem+"' where id='"+id+"'");
		 list=list.substring(11);
		 dnum++;
		 dincome=dincome+money;
		 list=list.substring(11);
		 int y=sql.executeUpdate("update Doctor set list='"+list+"',dnum'"+dnum+
				 "', dincome"+ dincome+"' where id='"+this.id+"'");
		if(x!=-1&&y!=-1){
			System.out.println("提交成功！");
			return true;
		}else{
			return false;
		}	 
	 }
	 
	 public String[] seacherUser(){		
		 String list1=list;
		 int length=list.getBytes().length/7;
		 String a[]=new String[length];
		 while(list1!=null){
			 rs=sql.executeQuery("select name from UserMedicalHistory where mid='"+list1.substring(0,10)+"'");
			 try {
				a[0]=rs.getString("name");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			   System.out.println("查无队列！");
			}
			 list1=list1.substring(11);
		 }
		 return a; 
	 }
	 
	public void doctorOut(){
		state=-1;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public static int getMnum() {
		return mnum;
	}

	public static void setMnum(int mnum) {
		Doctor.mnum = mnum;
	}

	public int getDnum() {
		return dnum;
	}

	public void setDnum(int dnum) {
		this.dnum = dnum;
	}

	public static float getMincome() {
		return mincome;
	}

	public static void setMincome(float mincome) {
		Doctor.mincome = mincome;
	}

	public float getDincome() {
		return dincome;
	}

	public void setDincome(float dincome) {
		this.dincome = dincome;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SQL getSql() {
		return sql;
	}

	public void setSql(SQL sql) {
		this.sql = sql;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	 
	 
	 
	 
	 
	 
}
