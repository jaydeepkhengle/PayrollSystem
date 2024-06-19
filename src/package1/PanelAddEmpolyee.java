package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class PanelAddEmpolyee extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String uid ,password,name,gender,address,state,city,pincode,mobile,degree,Designation,Department,Bank,email,Salary,Usertype;
	private JTextField txtAddress, txtEmpId, txtState, txtCity, txtPincode, uidtext, txtSalary, txtBankAccount, txtEmailId, txtDesignation, txtDegree, txtMobileNumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNotToSay, rdbtnFemale, rdbtnMale;
	private JComboBox<Object> comboBoxUserType ;
	private JPasswordField pwdPassword;
	private JTextField txtName;

	/**
	 * Create the panel.
	 */
	public PanelAddEmpolyee() {
		setBounds(0,0,1255, 656);
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1255, 47);
		panel_1.setBackground(new Color(255, 0, 0));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel AddEmpLabel = new JLabel("Add Employee");
		AddEmpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddEmpLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		AddEmpLabel.setForeground(Color.WHITE);
		AddEmpLabel.setBackground(Color.WHITE);
		AddEmpLabel.setBounds(522, 0, 210, 47);
		panel_1.add(AddEmpLabel);

		txtAddress = new JTextField();
		txtAddress.setBackground(new Color(222, 222, 222));
		txtAddress.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtAddress.setBounds(289, 260, 252, 27);
		add(txtAddress);
		txtAddress.setColumns(10);

		txtState = new JTextField();
		txtState.setBackground(new Color(222, 222, 222));
		txtState.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtState.setColumns(10);
		txtState.setBounds(289, 317, 252, 27);
		add(txtState);

		txtCity = new JTextField();
		txtCity.setBackground(new Color(222, 222, 222));
		txtCity.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBounds(289, 374, 252, 27);
		add(txtCity);

		txtPincode = new JTextField();
		txtPincode.setBackground(new Color(222, 222, 222));
		txtPincode.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtPincode.setColumns(10);
		txtPincode.setBounds(289, 431, 252, 27);
		add(txtPincode);

		uidtext = new JTextField();
		uidtext.setBackground(new Color(222, 222, 222));
		uidtext.setFont(new Font("Arial Black", Font.PLAIN, 15));
		uidtext.setColumns(10);
		uidtext.setBounds(202, 74, 168, 27);
		add(uidtext);

		JComboBox<Object> comboxDepartment = new JComboBox<Object>();
		comboxDepartment.setBackground(new Color(222, 222, 222));
		comboxDepartment.setModel(new DefaultComboBoxModel(new String[] {"Computer Engg", "Electrical Engg", "Electronics & Telecommunication Engg", "Civil Engg", "Mechanical Engg", "Other", "Not Selected"}));
		comboxDepartment.setSelectedIndex(6);
		comboxDepartment.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboxDepartment.setBounds(289, 488, 252, 27);
		add(comboxDepartment);

		txtSalary = new JTextField();
		txtSalary.setBackground(new Color(222, 222, 222));
		txtSalary.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtSalary.setColumns(10);
		txtSalary.setBounds(902, 317, 252, 27);
		add(txtSalary);

		txtBankAccount = new JTextField();
		txtBankAccount.setToolTipText("Bank Account Name");
		txtBankAccount.setBackground(new Color(222, 222, 222));
		txtBankAccount.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBankAccount.setColumns(10);
		txtBankAccount.setBounds(902, 374, 252, 27);
		add(txtBankAccount);

		txtEmailId = new JTextField();
		txtEmailId.setBackground(new Color(222, 222, 222));
		txtEmailId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmailId.setColumns(10);
		txtEmailId.setBounds(902, 431, 252, 27);
		add(txtEmailId);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do You Want To Submit", "Submit Data", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {

					uid = uidtext.getText(); 
					password = pwdPassword.getText();
					if(rdbtnMale.isSelected()) {
						gender = rdbtnMale.getLabel();
					}
					if(rdbtnFemale.isSelected()) {
						gender = rdbtnFemale.getLabel();
					}
					if(rdbtnNotToSay.isSelected()) {
						gender = rdbtnNotToSay.getLabel();
					}
					state = txtState.getText();
					degree = txtDegree.getText();
					Designation = txtDesignation.getText(); 
					name=txtName.getText();
					address=txtAddress.getText();
					city= txtCity.getText();
					pincode = txtPincode.getText();
					mobile = txtMobileNumber.getText();
					Salary = txtSalary.getText();
					Bank= txtBankAccount.getText();
					email = txtEmailId.getText();
					Department =(String) comboxDepartment.getSelectedItem();
					Usertype = (String)comboBoxUserType.getSelectedItem();

					System.out.println(name+""+""+address+""+""+city+""+pincode+""+mobile+""+Salary+""+Bank+""+email+""+Department+""+uid+password+""+gender+""+state+""+degree+""+Designation+""+Usertype);	

					MySQLConection mysql = new MySQLConection();
					int status = mysql.insertdataAdmin(uid, password, name, gender, address, state, city, pincode, mobile, degree, Designation, Department, Bank, email, Salary,Usertype);
					if(status==1) {

						JOptionPane.showMessageDialog(null, "Successfully Uploaded");
						MySQLConection connection = new MySQLConection();
						ResultSet result = connection.getEmployeeId(uid);
						try {
							while(result.next()) {
								String empId = Integer.toString(result.getInt("employee_Id"));
								JOptionPane.showMessageDialog(null, "Empoloyee Id : " + empId, "New Employee Id  Generated", JOptionPane.INFORMATION_MESSAGE);
								txtEmpId.setText(empId);
								int statusOfLeaveStats  = mysql.addLeaveStats(Integer.parseInt(empId));
								if(statusOfLeaveStats==1) {
									System.out.println("Leave Stats Updated Successfully");
								}
								else {
									System.out.println("Leave Stats Updation Failed");
								}
								status = mysql.addSalarComponents(Integer.parseInt(empId), Integer.parseInt(Salary));
								if(status==1) {
									System.out.println("Salary Added");
								}
								else {
									System.out.println("Salary Addition Failed");
								}
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//JOptionPane.showMessageDialog(null, );
					}
					else {
						JOptionPane.showMessageDialog(null, "Failed to  Upload");
					}
				}
			}  


		});
		btnSubmit.setBackground(new Color(46, 61, 176));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnSubmit.setBounds(902, 553, 252, 33);
		add(btnSubmit);

		txtDesignation = new JTextField();
		txtDesignation.setBackground(new Color(222, 222, 222));
		txtDesignation.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDesignation.setColumns(10);
		txtDesignation.setBounds(902, 260, 252, 27);
		add(txtDesignation);

		txtDegree = new JTextField();
		txtDegree.setBackground(new Color(222, 222, 222));
		txtDegree.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDegree.setColumns(10);
		txtDegree.setBounds(902, 203, 252, 27);
		add(txtDegree);

		JLabel lblName1 = new JLabel("Name :");
		lblName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1.setBounds(50, 142, 138, 30);
		add(lblName1);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblGender.setBounds(50, 200, 138, 30);
		add(lblGender);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblAddress.setBounds(50, 257, 138, 30);
		add(lblAddress);

		JLabel lblState = new JLabel("State :");
		lblState.setHorizontalAlignment(SwingConstants.LEFT);
		lblState.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblState.setBounds(50, 314, 138, 30);
		add(lblState);

		JLabel lblCity = new JLabel("Pincode :");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblCity.setBounds(50, 428, 138, 30);
		add(lblCity);

		JLabel lblName1_1 = new JLabel("City :");
		lblName1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_1.setBounds(50, 371, 138, 30);
		add(lblName1_1);

		JLabel lblUid = new JLabel("Username :");
		lblUid.setHorizontalAlignment(SwingConstants.LEFT);
		lblUid.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblUid.setBounds(50, 71, 125, 30);
		add(lblUid);

		txtMobileNumber = new JTextField();
		txtMobileNumber.setBackground(new Color(222, 222, 222));
		txtMobileNumber.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBounds(902, 145, 252, 27);
		add(txtMobileNumber);

		JLabel lblMobileNo = new JLabel("Mobile No. :");
		lblMobileNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNo.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblMobileNo.setBounds(647, 142, 138, 30);
		add(lblMobileNo);

		JLabel lblDegree = new JLabel("Qualification :");
		lblDegree.setHorizontalAlignment(SwingConstants.LEFT);
		lblDegree.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblDegree.setBounds(647, 200, 155, 30);
		add(lblDegree);

		JLabel lblDesignation = new JLabel("Designation :");
		lblDesignation.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesignation.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblDesignation.setBounds(647, 257, 205, 30);
		add(lblDesignation);

		JLabel lblSalary = new JLabel("Salary (CTC) :");
		lblSalary.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalary.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblSalary.setBounds(647, 314, 155, 30);
		add(lblSalary);

		JLabel lblBankAccount = new JLabel("Bank Account :");
		lblBankAccount.setHorizontalAlignment(SwingConstants.LEFT);
		lblBankAccount.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblBankAccount.setBounds(647, 371, 200, 30);
		add(lblBankAccount);

		JLabel lblEmail = new JLabel("Email  :");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblEmail.setBounds(647, 428, 138, 30);
		add(lblEmail);

		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartment.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblDepartment.setBounds(50, 484, 168, 30);
		add(lblDepartment);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblPassword.setBounds(439, 71, 138, 30);
		add(lblPassword);

		JSeparator separator = new JSeparator();
		separator.setBounds(31, 117, 1157, 10);
		add(separator);

		JLabel lblUsertype = new JLabel("User Type  :");
		lblUsertype.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsertype.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblUsertype.setBounds(647, 484, 138, 30);
		add(lblUsertype);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uidtext.setText(null); 
				pwdPassword.setText(null);
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				rdbtnNotToSay.setSelected(false);
				txtState.setText(null);
				txtDegree.setText(null);
				txtDesignation.setText(null); 
				txtName.setText(null);
				txtAddress.setText(null);
				txtCity.setText(null);
				txtPincode.setText(null);
				txtMobileNumber.setText(null);
				txtSalary.setText(null);
				txtBankAccount.setText(null);
				txtEmailId.setText(null);
				comboxDepartment.setSelectedItem("Not Selected");
				comboBoxUserType.setSelectedItem("Not Selected");
				buttonGroup.clearSelection();

			}
		});

		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnClear.setBackground(new Color(46, 61, 176));
		btnClear.setBounds(572, 553, 252, 33);
		add(btnClear);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminStatus adminStatus = new AdminStatus();
				adminStatus.setVisible(true);
				HomePage.PanelContentpanel.add(adminStatus);
				setVisible(false);

			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnBack.setBackground(new Color(46, 61, 176));
		btnBack.setBounds(241, 553, 252, 33);
		add(btnBack);

		JLabel lblEmployeeId = new JLabel("Employee Id :");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeId.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblEmployeeId.setBounds(812, 71, 168, 30);
		add(lblEmployeeId);

		txtEmpId = new JTextField();
		txtEmpId.setEditable(false);
		txtEmpId.setForeground(new Color(255, 0, 0));
		txtEmpId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmpId.setColumns(10);
		txtEmpId.setBorder(null);
		txtEmpId.setBackground(new Color(255, 255, 255));
		txtEmpId.setBounds(990, 75, 168, 27);
		add(txtEmpId);

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

		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(new Color(255, 255, 255));
		rdbtnMale.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rdbtnMale.setBounds(289, 207, 65, 21);
		add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(356, 207, 87, 21);
		add(rdbtnFemale);

		rdbtnNotToSay = new JRadioButton("Not To Say");
		buttonGroup.add(rdbtnNotToSay);
		rdbtnNotToSay.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rdbtnNotToSay.setBackground(Color.WHITE);
		rdbtnNotToSay.setBounds(439, 207, 111, 21);
		add(rdbtnNotToSay);

		comboBoxUserType = new JComboBox<Object>();
		comboBoxUserType.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Admin", "Not Selected"}));
		comboBoxUserType.setSelectedIndex(2);
		comboBoxUserType.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboBoxUserType.setBackground(new Color(222, 222, 222));
		comboBoxUserType.setBounds(902, 488, 252, 27);
		add(comboBoxUserType);

		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(222, 222, 222));
		pwdPassword.setBounds(589, 74, 168, 27);
		add(pwdPassword);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBackground(new Color(222, 222, 222));
		txtName.setBounds(289, 145, 252, 27);
		add(txtName);


	}
}
