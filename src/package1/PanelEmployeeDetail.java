package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PanelEmployeeDetail extends JPanel {
	String uid ,passwordStr,Name,gender,address,state,city ,pincode,mobile,Degree,Designation,Department,Bank,email,Salary,Usertype,deduction ,allowance ,salary ;
	private JLabel lblState;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtAddress;
	private JTextField txtState;
	private JTextField txtCity;
	private JTextField txtPincode;
	private JTextField txtMobileNumber;
	private JTextField txtQualification;
	private JTextField txtDesignation;
	private JTextField txtSalary;
	private JTextField txtBankAccount;
	private JTextField txtEmailId;
	private JTextField txtEmployeeId;

	/**
	 * Create the panel.
	 */
	public  PanelEmployeeDetail() {
		// TODO Auto-generated constructor stub
	
		setBounds(0,0,1255, 656);
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLayout(null);
		
		
		
	
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1255, 47);
		panel.setBackground(new Color(255, 0, 0));
		add(panel);
		panel.setLayout(null);
		
		JLabel EmpDetailLabel = new JLabel("Employee Detail");
		EmpDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmpDetailLabel .setFont(new Font("Arial Black", Font.PLAIN, 20));
		EmpDetailLabel.setForeground(Color.WHITE);
		EmpDetailLabel.setBackground(Color.WHITE);
		EmpDetailLabel.setBounds(505, 0, 210, 38);
		panel.add(EmpDetailLabel);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(277, 179, 260, 27);
		add(txtName);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtGender.setColumns(10);
		txtGender.setBorder(null);
		txtGender.setBackground(new Color(255, 255, 255));
		txtGender.setBounds(277, 236, 260, 27);
		add(txtGender);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBorder(null);
		txtAddress.setBackground(new Color(255, 255, 255));
		txtAddress.setBounds(277, 293, 260, 27);
		add(txtAddress);
		
		txtState = new JTextField();
		txtState.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtState.setColumns(10);
		txtState.setBorder(null);
		txtState.setBackground(new Color(255, 255, 255));
		txtState.setBounds(277, 350, 260, 27);
		add(txtState);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBorder(null);
		txtCity.setBackground(new Color(255, 255, 255));
		txtCity.setBounds(277, 407, 260, 27);
		add(txtCity);
		
		txtPincode = new JTextField();
	
		txtPincode.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtPincode.setColumns(10);
		txtPincode.setBorder(null);
		txtPincode.setBackground(new Color(255, 255, 255));
		txtPincode.setBounds(277, 464, 260, 27);
		add(txtPincode);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBorder(null);
		txtMobileNumber.setBackground(new Color(255, 255, 255));
		txtMobileNumber.setBounds(822, 179, 260, 27);
		add(txtMobileNumber);
		
		txtQualification = new JTextField();
		txtQualification.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtQualification.setColumns(10);
		txtQualification.setBorder(null);
		txtQualification.setBackground(new Color(255, 255, 255));
		txtQualification.setBounds(822, 236, 260, 27);
		add(txtQualification);
		
		txtDesignation = new JTextField();
		txtDesignation.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDesignation.setColumns(10);
		txtDesignation.setBorder(null);
		txtDesignation.setBackground(new Color(255, 255, 255));
		txtDesignation.setBounds(822, 293, 260, 27);
		add(txtDesignation);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtSalary.setColumns(10);
		txtSalary.setBorder(null);
		txtSalary.setBackground(new Color(255, 255, 255));
		txtSalary.setBounds(822, 350, 260, 27);
		add(txtSalary);
		
		txtBankAccount = new JTextField();
		txtBankAccount.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBankAccount.setColumns(10);
		txtBankAccount.setBorder(null);
		txtBankAccount.setBackground(new Color(255, 255, 255));
		txtBankAccount.setBounds(822, 407, 260, 27);
		add(txtBankAccount);
		
		txtEmailId = new JTextField();
		txtEmailId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmailId.setColumns(10);
		txtEmailId.setBorder(null);
		txtEmailId.setBackground(new Color(255, 255, 255));
		txtEmailId.setBounds(822, 464, 344, 27);
		add(txtEmailId);
		
		JButton buttonGetdata = new JButton("GET DATA");
		buttonGetdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mysql = new MySQLConection();
				int empId = Integer.parseInt(txtEmployeeId.getText());
			
				ResultSet resultset = mysql.getRow(empId);
			try {
					while(resultset.next()) {
							
							txtName.setText(resultset.getString("name"));
							txtGender.setText(resultset.getString("gender"));
							txtAddress.setText(resultset.getString("address"));
							txtState.setText(resultset.getString("state"));
							txtCity.setText(resultset.getString("city"));
							txtPincode.setText(resultset.getString("pincode"));
							txtMobileNumber.setText(resultset.getString("mobile"));
							txtQualification.setText(resultset.getString("Degree"));
							txtDesignation.setText(resultset.getString("Designation"));
							
;							txtBankAccount.setText(resultset.getString("Bank"));
							txtSalary.setText(resultset.getString("salary"));
							txtEmailId.setText(resultset.getString("email"));
							
							System.out.println(Name+""+""+address+""+""+city+""+pincode+""+mobile+""+Salary+""+Bank+""+email+""+uid+""+gender+""+state+""+Degree+""+Designation+""+Usertype);		
					}
			
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog( null, "Database error:" +  ( e2.getMessage()));
				e2.printStackTrace();
				}
			}
		});
		buttonGetdata.setForeground(Color.WHITE);
		buttonGetdata.setFont(new Font("Arial Black", Font.PLAIN, 15));
		buttonGetdata.setBackground(new Color(46, 61, 176));
		buttonGetdata.setBounds(613, 72, 260, 30);
		add(buttonGetdata);
		
		JLabel lblName1 = new JLabel("Name :");
		lblName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1.setBounds(76, 177, 138, 30);
		add(lblName1);
		
		JLabel lblName1_1 = new JLabel("Gender :");
		lblName1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_1.setBounds(76, 234, 138, 30);
		add(lblName1_1);
		
		JLabel lblName1_2 = new JLabel("Address :");
		lblName1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_2.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_2.setBounds(76, 291, 138, 30);
		add(lblName1_2);
		
		JLabel lblName1_3 = new JLabel("State :");
		lblName1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_3.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_3.setBounds(76, 348, 138, 30);
		add(lblName1_3);
		
		JLabel lblName1_4 = new JLabel("City :");
		lblName1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_4.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_4.setBounds(76, 405, 138, 30);
		add(lblName1_4);
		
		JLabel lblName1_5 = new JLabel("Pincode :");
		lblName1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_5.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_5.setBounds(76, 462, 138, 30);
		add(lblName1_5);
		
		JLabel lblName1_7 = new JLabel("Mobile :");
		lblName1_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_7.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_7.setBounds(613, 177, 138, 30);
		add(lblName1_7);
		
		JLabel lblName1_8 = new JLabel("Qualification : ");
		lblName1_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_8.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_8.setBounds(613, 234, 167, 30);
		add(lblName1_8);
		
		JLabel lblName1_9 = new JLabel("Designation :");
		lblName1_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_9.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_9.setBounds(613, 291, 151, 30);
		add(lblName1_9);
		
		JLabel lblName1_10 = new JLabel("Salary :");
		lblName1_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_10.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_10.setBounds(613, 348, 138, 30);
		add(lblName1_10);
		
		JLabel lblName1_11 = new JLabel("Bank Account :");
		lblName1_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_11.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_11.setBounds(613, 405, 194, 30);
		add(lblName1_11);
		
		JLabel lblName1_12 = new JLabel("Email :");
		lblName1_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_12.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_12.setBounds(613, 462, 138, 30);
		add(lblName1_12);
		
		JLabel lblEmployeeId = new JLabel("Employee Id :");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblEmployeeId.setBounds(76, 72, 151, 30);
		add(lblEmployeeId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 132, 1177, 2);
		add(separator);
		
		JButton btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminStatus adminStatus = new AdminStatus();
				adminStatus.setVisible(true);
				HomePage.PanelContentpanel.add(adminStatus);
				setVisible(false);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnExit.setBackground(new Color(46, 61, 176));
		btnExit.setBounds(251, 544, 260, 30);
		add(btnExit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmployeeId.setText(null); 
				txtGender.setText(null);
				txtState.setText(null);
				txtQualification.setText(null);
				txtDesignation.setText(null); 
				txtName.setText(null);
				txtAddress.setText(null);
			    txtCity.setText(null);
				txtPincode.setText(null);
				txtMobileNumber.setText(null);
				txtSalary.setText(null);
				txtBankAccount.setText(null);
		    	txtEmailId.setText(null);
		    	
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnClear.setBackground(new Color(46, 61, 176));
		btnClear.setBounds(613, 544, 260, 30);
		add(btnClear);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 0, 0));
		panel_1_1.setBounds(0, 631, 1255, 25);
		add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(451, 0, 353, 20);
		panel_1_1.add(lblNewLabel_2);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBackground(new Color(222, 222, 222));
		txtEmployeeId.setBounds(251, 74, 252, 27);
		add(txtEmployeeId);
	}
}
