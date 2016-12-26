import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Canvas;
import javax.swing.JTextArea;

public class UserAp extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAp frame = new UserAp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	   
	/**
	 * Create the frame.
	 */
	public UserAp() {
		setTitle("网上预约 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000,600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(0, 0, 984, 561);
		contentPane.add(panel);
		
		ImageIcon bg=new ImageIcon("src/UserApbg.png");
		panel.setLayout(null);
		JLabel jl=new JLabel(bg);
		jl.setBounds(0, 0, 984, 121);
		panel.add(jl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(161, 120, 823, 441);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		
	
	
	     JButton btnNewButton = new JButton("预约挂号");
	     btnNewButton.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent arg0) {
	     		panel_1.removeAll();
	     		panel_1.repaint();
	     		
	     		ImageIcon bg2=new ImageIcon("src/apimage.png");
	    		JLabel jl2=new JLabel(bg2);
	    		jl2.setBounds(332, 25, 210, 85);
	    		panel_1.add(jl2);
	    		
	    		JLabel lblNewLabel = new JLabel("姓名");
	    		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
	    		lblNewLabel.setBounds(133, 164, 92, 15);
	    		panel_1.add(lblNewLabel);
	    		
	    		JLabel label = new JLabel("身份证号");
	    		label.setFont(new Font("Dialog", Font.PLAIN, 16));
	    		label.setBounds(133, 279, 92, 15);
	    		panel_1.add(label);
	    		
	    		JLabel label_1 = new JLabel("性别");
	    		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
	    		label_1.setBounds(133, 202, 92, 15);
	    		panel_1.add(label_1);
	    		
	    		JLabel label_2 = new JLabel("年龄");
	    		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
	    		label_2.setBounds(133, 240, 92, 15);
	    		panel_1.add(label_2);
	    		
	    		JLabel label_3 = new JLabel("预约科室");
	    		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
	    		label_3.setBounds(481, 160, 92, 15);
	    		panel_1.add(label_3);
	    		
	    		JLabel label_4 = new JLabel("选择预约时间:");
	    		label_4.setFont(new Font("Dialog", Font.PLAIN, 16));
	    		label_4.setBounds(481, 202, 154, 15);
	    		panel_1.add(label_4);
	    		textField = new JTextField();
	    		textField.setBounds(216, 162, 98, 21);
	    		panel_1.add(textField);
	    		textField.setColumns(10);
	    		
	    		textField_2 = new JTextField();
	    		textField_2.setColumns(10);
	    		textField_2.setBounds(216, 238, 98, 21);
	    		panel_1.add(textField_2);
	    		
	    		textField_3 = new JTextField();
	    		textField_3.setColumns(10);
	    		textField_3.setBounds(216, 277, 179, 21);
	    		panel_1.add(textField_3);
	    		
	    		final JComboBox comboBox = new JComboBox();
	    		comboBox.setBackground(Color.WHITE);
	    		comboBox.setBounds(216, 198, 98, 22);
	    		panel_1.add(comboBox);
	    		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
	    		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男","女" }));
	    		
	    		
	    		final JComboBox dept = new JComboBox();
	    		dept.setFont(new Font("宋体", Font.PLAIN, 16));
	    		dept.setBackground(Color.WHITE);
	    		dept.setBounds(564, 158, 179, 21);
	    		panel_1.add(dept);
	    		ArrayList<String> list = new ArrayList<String>();
	    		ResultSet rs=SQL.executeQuery("select * from Dept");
	    		try {
	    			while(rs.next()){
	    				
	    			  list.add(rs.getString("id")+" "+rs.getString("name"));
	    			  }
	    			}
	    			catch (Exception e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    			SQL.close();
	    		String[] s=new String[list.size()];
	    		for(int i=0;i<list.size();i++)
	    			s[i]=(String)list.get(i);
	    	
	    	     dept.setModel(new DefaultComboBoxModel(s));
	    	     
	    	     JComboBox comboBox_1 = new JComboBox();
	    	     comboBox_1.setFont(new Font("宋体", Font.PLAIN, 16));
	    	     comboBox_1.setBackground(Color.WHITE);
	    	     comboBox_1.setBounds(525, 234, 154, 21);
	    	 	 String[] date=new String[7];
	    	 	 Calendar curr = Calendar.getInstance();
	    		for(int i=0;i<7;i++)
	    		{
	    			 
	    	          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
	    			
	    		        curr.add(Calendar.DATE, 1);
	    		       date[i]=sdf.format(curr.getTime());  
	    		}
	    		comboBox_1.setModel(new DefaultComboBoxModel(date));
	    	     panel_1.add(comboBox_1);
	    	     
	    	     JComboBox comboBox_2 = new JComboBox();
	    	     comboBox_2.setFont(new Font("宋体", Font.PLAIN, 16));
	    	     comboBox_2.setBounds(525, 273, 72, 21);
	    	     String[] t=new String[9];
	    		for(int i=0;i<9;i++)
	    		{
	    			 
	    	        t[i]=String.valueOf(i+8)+":00";  
	    		}
	    		comboBox_2.setModel(new DefaultComboBoxModel(t));
	    	     panel_1.add(comboBox_2);
	    	     
	    	     JLabel label_5 = new JLabel("日期");
	    	     label_5.setFont(new Font("Dialog", Font.PLAIN, 16));
	    	     label_5.setBounds(481, 240, 92, 15);
	    	     panel_1.add(label_5);
	    	     
	    	     JLabel label_6 = new JLabel("时间");
	    	     label_6.setFont(new Font("Dialog", Font.PLAIN, 16));
	    	     label_6.setBounds(481, 279, 92, 15);
	    	     panel_1.add(label_6);
	    	     
	    	     JButton btnNewButton_1 = new JButton("提  交");
	    	     btnNewButton_1.addActionListener(new ActionListener() {
	    		     	public void actionPerformed(ActionEvent e) {
	    		     		if(textField.getText().trim().equals("")||textField_2.getText().trim().equals("")||textField_3.getText().trim().equals(""))
	    		     			JOptionPane.showMessageDialog(null, "您的个人信息还没有填写完整。");
	    		     		else{
	    		     		 String name=textField.getText().trim(); 
	    		     		 String age=textField_2.getText().trim();
	    		     		 String id=textField_3.getText().trim();
	    		     		 String sex=comboBox.getSelectedItem().toString().trim();
	    		     		 String deptid=dept.getSelectedItem().toString().substring(0, 5);
	    		     		 String aptime=comboBox_1.getSelectedItem()+" "+comboBox_2.getSelectedItem()+":00";
	    		     		Date now=new Date(System.currentTimeMillis());
	    		     		 Date date = new Date();   
	    		
	    		             DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    		             try {   
	    		                 date = sdf.parse(aptime);   
	    		 
	    		             } catch (Exception e1) {   
	    		                 e1.printStackTrace();   
	    		             }  
	    		             if(now.after(date))
	    		            	 JOptionPane.showMessageDialog(null,"预约时间不能早于当前时间");
	    		             else{
	    		            	 String aid=this.computeAID();
	    		            	 
	    		                    Timestamp ts = new Timestamp(System.currentTimeMillis());   
	    		            	       
	    		                    try {   
	    		                        ts = Timestamp.valueOf(aptime);   
	    		                
	    		                    } catch (Exception e1) {   
	    		                        e1.printStackTrace();   
	    		                    }  
	    	
	    					    
	    					   
	    		            	 String sql="insert into UserAppointment(aid,id,name,sex,age,deptid,aptime,valid) values('"+aid+"','"+id+"','"+name+"','"+sex+"','"+age+"','"+deptid+"','"+aptime+"',1)";
	    		            	 if(SQL.executeUpdate(sql)==-1)
	    		            	  JOptionPane.showMessageDialog(null, "抱歉，您的信息暂时无法提交。");
	    		            	 else{
	    		            		 JOptionPane.showMessageDialog(null, "提交成功！请您于"+comboBox_1.getSelectedItem()+"当天"+comboBox_2.getSelectedItem()+"前来完成现场挂号。");
	    		            		 dispose();
	    		            		 Welcome p=new Welcome();
	    		            		 p.setVisible(true);
	    		            		 
	    		            	 }
	    		            	 
	    		             }
	    		     		}
	    		     		
	    		     		
	    		     		
	    		     		
	    		     	}

						private String computeAID() {
							// TODO Auto-generated method stub
							 Random rm = new Random();  
							    double pross = (1 + rm.nextDouble()) * Math.pow(10, 4);  
							    
							    String lastfive = String.valueOf((int)pross);   
							    Calendar c = Calendar.getInstance();
							    int y=c.get(Calendar.YEAR);
							    y=y%10+((y/10)%10)*10;
							    int m=c.get(Calendar.MONTH)+1;
							    int d=c.get(Calendar.DAY_OF_MONTH);
							    String aid="A"+String.valueOf(y)+String.valueOf(m)+String.valueOf(d)+lastfive;
							    return aid;
						}
	    		     });
	    	     btnNewButton_1.setBackground(new Color(51, 153, 255));
	    	     btnNewButton_1.setForeground(new Color(255, 255, 255));
	    	     btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
	    	     btnNewButton_1.setBounds(384, 358, 118, 32);
	    	     panel_1.add(btnNewButton_1);
	    	     
	     	}
	     });
	     btnNewButton.setForeground(new Color(255, 255, 255));
	     btnNewButton.setBackground(new Color(0, 153, 255));
	     btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
	     btnNewButton.setBounds(34, 241, 93, 23);
	     panel.add(btnNewButton);
	     
	     JButton button = new JButton("预约须知");
	     button.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		panel_1.removeAll();
	     		panel_1.repaint();
	     		textField_1 = new JTextField();
	    		textField_1.setFont(new Font("宋体", Font.BOLD, 20));
	    		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	    		textField_1.setForeground(new Color(255, 255, 255));
	    		textField_1.setText("预约须知");
	    		textField_1.setBackground(new Color(51, 204, 102));
	    		textField_1.setEditable(false);
	    		textField_1.setBounds(377, 35, 136, 42);
	    		panel_1.add(textField_1);
	    		textField_1.setColumns(10);
	    		
	    		JLabel lblNewLabel_1 = new JLabel("一.预约实名制：");
	    		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
	    		lblNewLabel_1.setBounds(53, 104, 188, 24);
	    		panel_1.add(lblNewLabel_1);
	    		
	    		JTextArea txtrid = new JTextArea();
	    		txtrid.setFont(new Font("宋体", Font.PLAIN, 16));
	    		txtrid.setEditable(false);
	    		txtrid.setText("    网上预约挂号采取实名制预约，请您如实填写就诊人员的真实姓名、身份证号、性别、年龄等有效基本信息。");
	    		txtrid.setLineWrap(true);
	    		txtrid.setBounds(86, 138, 647, 52);
	    		panel_1.add(txtrid);
	    		
	    		JLabel label_7 = new JLabel("二.预约时间范围：");
	    		label_7.setFont(new Font("宋体", Font.BOLD, 20));
	    		label_7.setBounds(53, 194, 188, 24);
	    		panel_1.add(label_7);
	    		
	    		JTextArea textArea_1 = new JTextArea();
	    		textArea_1.setText("1.您可以预约7天内各科室的号源。");
	    		textArea_1.setLineWrap(true);
	    		textArea_1.setFont(new Font("宋体", Font.PLAIN, 16));
	    		textArea_1.setEditable(false);
	    		textArea_1.setBounds(86, 224, 647, 24);
	    		panel_1.add(textArea_1);
	    		
	    		JTextArea textArea = new JTextArea();
	    		textArea.setText("2.每天的预约时间范围为：8:00至16:00");
	    		textArea.setLineWrap(true);
	    		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
	    		textArea.setEditable(false);
	    		textArea.setBounds(86, 258, 647, 24);
	    		panel_1.add(textArea);
	    		
	    		JLabel label_8 = new JLabel("三.预约取号：");
	    		label_8.setFont(new Font("宋体", Font.BOLD, 20));
	    		label_8.setBounds(53, 292, 188, 24);
	    		panel_1.add(label_8);
	    		
	    		JTextArea textArea_2 = new JTextArea();
	    		textArea_2.setText("    预约成功后，请患者于就诊当日携带有效证件、预约号到医院挂号窗口验证预约信息（核对与预约登记实名信息一致的本人有效证件和预约号）和取号，如验证不符则医院不能提供相应的诊疗服务。");
	    		textArea_2.setLineWrap(true);
	    		textArea_2.setFont(new Font("宋体", Font.PLAIN, 16));
	    		textArea_2.setEditable(false);
	    		textArea_2.setBounds(86, 326, 647, 80);
	    		panel_1.add(textArea_2);
	     	}
	     });
	     button.setForeground(new Color(255, 255, 255));
	     button.setBackground(new Color(0, 153, 255));
	     button.setFont(new Font("宋体", Font.PLAIN, 12));
	     button.setBounds(34, 287, 93, 23);
	     panel.add(button);
	     
	     JButton button_1 = new JButton("返回首页");
	     button_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		dispose();
	     		Welcome p=new Welcome();
	     		p.setVisible(true);
	     	}
	     });
	     button_1.setForeground(new Color(255, 255, 255));
	     button_1.setBackground(new Color(0, 153, 255));
	     button_1.setFont(new Font("宋体", Font.PLAIN, 12));
	     button_1.setBounds(34, 336, 93, 23);
	     panel.add(button_1);
	     
	     btnNewButton.doClick();
}
	
	
	
}
