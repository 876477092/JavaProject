import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Admin {
	//private static JTextField txtTest;

	//public static void main(String[] args) {
	//	Admin yd = new Admin();
	//}
	public Admin() {
		// TODO Auto-generated method stub
		JFrame yfFrame = new JFrame();
		yfFrame.setTitle("管理");
		yfFrame.getContentPane().setBackground(Color.gray);
		yfFrame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setLocation(0, 40);
		panel_1.setSize(1000, 500);
		yfFrame.getContentPane().add(panel_1,BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		//修改备用
		//JPanel panel = new JPanel();
		//panel.setBackground(SystemColor.window);
		//panel.setBounds(175, 25, 800, 450);
		//panel_1.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 540, 1000, 60);
		yfFrame.getContentPane().add(panel_2,BorderLayout.SOUTH);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 0, 1000, 40);
		yfFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("人员管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//刷新页面（重绘Panel）
				panel_1.removeAll();
				panel_1.repaint();
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.window);
				panel.setBounds(160, 25, 800, 450);
				panel_1.add(panel);
				//账号管理
				JButton btnNewButton_3 = new JButton("医生账号");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//医生账号管理
					}
				});
				btnNewButton_3.setBounds(15, 25, 98, 26);
				panel_1.add(btnNewButton_3);
				
				JButton btnNewButton_4 = new JButton("药师账号");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//药师账号管理
					}
				});
				btnNewButton_4.setBounds(15, 63, 98, 26);
				panel_1.add(btnNewButton_4);
				
				JButton btnNewButton_5 = new JButton("挂号收费");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//挂号收费账号管理
					}
				});
				btnNewButton_5.setBounds(15, 101, 98, 26);
				panel_1.add(btnNewButton_5);
			}
		});
		btnNewButton.setBounds(10, 5, 100, 25);
		btnNewButton.setBackground(SystemColor.menu);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("药库管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//刷新页面（重绘Panel）
				panel_1.removeAll();
				panel_1.repaint();
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.window);
				panel.setBounds(160, 25, 800, 450);
				panel_1.add(panel);
				//药库管理
				JButton btnNewButton_3 = new JButton("增加药品");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//增加药品
					}
				});
				btnNewButton_3.setBounds(15, 25, 98, 26);
				panel_1.add(btnNewButton_3);
				
			}
		});
		btnNewButton_1.setBounds(230, 5, 100, 25);
		btnNewButton_1.setBackground(SystemColor.menu);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("收费项目管理");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//刷新页面（重绘Panel）
				panel_1.removeAll();
				panel_1.repaint();
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.window);
				panel.setBounds(160, 25, 800, 450);
				panel_1.add(panel);
				//收费信息
				JButton btnNewButton_3 = new JButton("挂号收费");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//挂号收费
					}
				});
				btnNewButton_3.setBounds(15, 25, 98, 26);
				panel_1.add(btnNewButton_3);
				
				JButton btnNewButton_1 = new JButton("药房收费");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//药房收费
					}
				});
				btnNewButton_1.setBounds(15, 63, 98, 26);
				panel_1.add(btnNewButton_1);
				
				JButton btnNewButton_5 = new JButton("医师收费");
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//医师收费
					}
				});
				btnNewButton_5.setBounds(15, 101, 98, 26);
				panel_1.add(btnNewButton_5);
			}
		});
		btnNewButton_2.setBounds(340, 5, 125, 25);
		btnNewButton_2.setBackground(SystemColor.menu);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("科室管理");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//刷新页面（重绘Panel）
				panel_1.removeAll();
				panel_1.repaint();
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.window);
				panel.setBounds(160, 25, 800, 450);
				panel_1.add(panel);
				
				JButton btnNewButton_3 = new JButton("新增科室");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//增加科室
					}
				});
				btnNewButton_3.setBounds(15, 25, 98, 26);
				panel_1.add(btnNewButton_3);
				
			}
		});
		btnNewButton_5.setBackground(SystemColor.menu);
		btnNewButton_5.setBounds(120, 5, 100, 25);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("注销");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//注销处理事件
			}
		});
		btnNewButton_6.setBounds(880, 6, 95, 25);
		panel_3.add(btnNewButton_6);
		
		yfFrame.setBounds(100,100,1000,600);
		yfFrame.setResizable(false);
		yfFrame.setBackground(Color.GRAY);
		yfFrame.setVisible(true);

	}
}
