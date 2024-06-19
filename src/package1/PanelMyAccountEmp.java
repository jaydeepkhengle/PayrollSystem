package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import java.beans.PropertyChangeListener;
import java.rmi.server.UID;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Insets;

public class PanelMyAccountEmp extends JPanel  {
	
	private Connection con;
	String uid ,passwordStr,Name,gender,address,state,city ,pincode,mobile,Degree,Designation,Department,Bank,email,Salary,Usertype,deduction ,allowance ,salary ;
	private JTextField txtLeaveStatus;
	private JTextField salarytextField;
	private JTextField allowancetextField;
	private JTextField deductiontextField;

	public  PanelMyAccountEmp() {


		setBounds(0, 0, 1255, 656);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1255, 47);
		panel.setBackground(new Color(255, 0, 0));add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("My Account");
		lblNewLabel .setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel .setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel .setForeground(Color.WHITE);
		lblNewLabel .setBackground(Color.WHITE);
		lblNewLabel .setBounds(505, 0, 210, 38);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 420, 246, 134);
		panel_1.setBackground(new Color(46, 61, 176,255));
		add(panel_1);
		panel_1.setLayout(null);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 42, 246, 2);
		panel_1.add(separator_2);

		JLabel lblNewLabel_1 = new JLabel("Leave Status");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 246, 41);
		panel_1.add(lblNewLabel_1);

		txtLeaveStatus = new JTextField();
		txtLeaveStatus.setEditable(false);
		txtLeaveStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeaveStatus.setBackground(new Color(46, 61, 176,255));
		txtLeaveStatus.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtLeaveStatus.setForeground(Color.WHITE);
		txtLeaveStatus.setBorder(null);
		txtLeaveStatus.setBounds(10, 53, 226, 71);
		panel_1.add(txtLeaveStatus);
		txtLeaveStatus.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(661, 420, 246, 134);
		panel_2.setBackground(new Color(46, 61, 176,255));
		add(panel_2);
		panel_2.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 41, 246, 2);
		panel_2.add(separator_1);

		JLabel lblNewLabel_3 = new JLabel("Allowances");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 0, 246, 41);

		panel_2.add(lblNewLabel_3);

		allowancetextField = new JTextField();
		allowancetextField.setEditable(false);
		allowancetextField.setHorizontalAlignment(SwingConstants.CENTER);
		allowancetextField.setForeground(Color.WHITE);
		allowancetextField.setFont(new Font("Arial Black", Font.PLAIN, 19));
		allowancetextField.setColumns(10);
		allowancetextField.setBorder(null);
		allowancetextField.setBackground(new Color(46, 61, 176));
		allowancetextField.setBounds(56, 53, 149, 71);
		panel_2.add(allowancetextField);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(333, 420, 252, 134);
		panel_3.setBackground(new Color(46, 61, 176,255));
		add(panel_3);
		panel_3.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 252, 2);
		panel_3.add(separator);

		JLabel lblNewLabel_2 = new JLabel("Last Salary");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 252, 44);
		panel_3.add(lblNewLabel_2);

		salarytextField = new JTextField();
		salarytextField.setEditable(false);
		salarytextField.setHorizontalAlignment(SwingConstants.CENTER);
		salarytextField.setForeground(Color.WHITE);
		salarytextField.setFont(new Font("Arial Black", Font.PLAIN, 19));
		salarytextField.setColumns(10);
		salarytextField.setBorder(null);
		salarytextField.setBackground(new Color(46, 61, 176));
		salarytextField.setBounds(28, 53, 199, 71);
		panel_3.add(salarytextField);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(978, 420, 252, 134);
		panel_4.setBackground(new Color(46, 61, 176,255));
		add(panel_4);
		panel_4.setLayout(null);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 42, 252, 2);
		panel_4.add(separator_3);

		JLabel lblNewLabel_4 = new JLabel("Total Deduction");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 0, 252, 41);

		panel_4.add(lblNewLabel_4);

		deductiontextField = new JTextField();
		deductiontextField.setEditable(false);
		deductiontextField.setHorizontalAlignment(SwingConstants.CENTER);
		deductiontextField.setForeground(Color.WHITE);
		deductiontextField.setFont(new Font("Arial Black", Font.PLAIN, 19));
		deductiontextField.setColumns(10);
		deductiontextField.setBorder(null);
		deductiontextField.setBackground(new Color(46, 61, 176));
		deductiontextField.setBounds(55, 53, 149, 71);
		panel_4.add(deductiontextField);

		JLabel lblNewLabel_5 = new JLabel("Name :");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(25, 74, 93, 31);
		add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("Department :");
		lblNewLabel_5_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(25, 140, 151, 31);
		add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Mobile No :");
		lblNewLabel_5_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_5_1_1.setBounds(25, 204, 127, 31);
		add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_1_2 = new JLabel("City :");
		lblNewLabel_5_1_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_5_1_2.setBounds(683, 74, 127, 31);
		add(lblNewLabel_5_1_2);

		JLabel Labelemail = new JLabel("Email :");
		Labelemail.setFont(new Font("Arial Black", Font.PLAIN, 20));
		Labelemail.setBounds(683, 140, 127, 31);
		add(Labelemail);

		JLabel lblNewLabel_5_1_4 = new JLabel("Designation :");
		lblNewLabel_5_1_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_5_1_4.setBounds(683, 204, 167, 31);
		add(lblNewLabel_5_1_4);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(0, 631, 1255, 25);
		add(panel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(451, 0, 353, 20);
		panel_1_1.add(lblNewLabel_2_1);
		
		JLabel txtName = new JLabel("");
		txtName.setForeground(new Color(0, 0, 255));
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtName.setBounds(222, 74, 368, 31);
		add(txtName);
		
		JLabel txtDepartment = new JLabel("");
		txtDepartment.setForeground(new Color(0, 0, 255));
		txtDepartment.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtDepartment.setBounds(224, 140, 368, 31);
		add(txtDepartment);
		
		JLabel txtMobile = new JLabel("");
		txtMobile.setForeground(new Color(0, 0, 255));
		txtMobile.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtMobile.setBounds(222, 204, 368, 31);
		add(txtMobile);
		
		JLabel txtCity = new JLabel("");
		txtCity.setForeground(new Color(0, 0, 255));
		txtCity.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtCity.setBounds(860, 74, 368, 31);
		add(txtCity);
		
		JLabel txtEmailId = new JLabel("");
		txtEmailId.setForeground(new Color(0, 0, 255));
		txtEmailId.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtEmailId.setBounds(860, 140, 368, 31);
		add(txtEmailId);
		
		JLabel txtDesignation = new JLabel("");
		txtDesignation.setForeground(new Color(0, 0, 255));
		txtDesignation.setFont(new Font("Arial Black", Font.PLAIN, 19));
		txtDesignation.setBounds(860, 204, 368, 31);
		add(txtDesignation);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(141, 332, 949, 9);
		add(separator_4);
		setVisible(true);

		MySQLConection mySql = new MySQLConection();
		System.out.println(MainLogin.username);
		ResultSet empIdResult = mySql.getEmployeeId(MainLogin.username);
		int empId = 0;
		try {
			while(empIdResult.next()) {
				empId = empIdResult.getInt("employee_Id");
				System.out.println(empId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    ResultSet accountDetails  = mySql.displayMyAccount(empId); 
	    int leaveApplication=1;
		try {
			while(accountDetails.next()) {

				txtName.setText(accountDetails.getString("name"));
				System.out.println(accountDetails.getString("name"));
				txtDepartment.setText(accountDetails.getString("Department"));
				txtMobile.setText(accountDetails.getString("mobile"));
				txtCity.setText(accountDetails.getString("city"));
				txtEmailId.setText(accountDetails.getString("email"));
				txtDesignation.setText(accountDetails.getString("Designation"));
				ResultSet leaveResult = mySql.leaveCheck(empId);
				while(leaveResult.next()) {
					leaveApplication = leaveResult.getInt("rowCount");
				}
				if(leaveApplication==0) {
					txtLeaveStatus.setText("--");
				}
				else if(accountDetails.getString("status").equals("")) {
					txtLeaveStatus.setText("Pending");
				}
				else {
					txtLeaveStatus.setText(accountDetails.getString("status"));
				}
				salarytextField.setText(Integer.toString(accountDetails.getInt("net_salary")/12) + " Rs");
				int allowances = (accountDetails.getInt("HR")+accountDetails.getInt("DA")+accountDetails.getInt("MED")+accountDetails.getInt("Travel"))/12; 
				int leaveDeduction = (accountDetails.getInt("basic_pay")/12)*accountDetails.getInt("unpaid_leaves");
				System.out.println(leaveDeduction+ "------------------");
				int deductions = (accountDetails.getInt("MED")/12) + leaveDeduction + (accountDetails.getInt("tax")/12);
				allowancetextField.setText(allowances + " Rs");
				deductiontextField.setText(deductions + " Rs");

			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
			e1.printStackTrace();
		}
		//System.out.println("out...................332432..."+MainLogin.TextUserName.getText()+"...........");


	}
}