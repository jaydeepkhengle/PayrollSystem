package package1;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.border.CompoundBorder;

public class PanelEmployeeUpdate extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String Name,gender,address,state,city ,pincode,mobile,Degree,Designation,Department,Bank,email,Salary,Usertype,deduction ,allowance ,salary ;
	private JLabel lblState;
	private JLabel lblPincode;
	private JLabel lblDegree;
	private JLabel lblDesignation;
	private JButton clearbutton;
	private JButton btnExit;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	JRadioButton rdbtnMale, rdbtnFemale, rdbtnNotToSay;
	private JLabel lblEmployeeId;
	private JComboBox<String> comboBoxUserType, comboBoxDepartment;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtName;
	private JTextField txtEmailId;
	private JTextField txtState;
	private JTextField txtCity;
	private JTextField txtPincode;
	private JTextField txtMobileNumber;
	private JTextField txtQualification;
	private JTextField txtDesignation;
	private JTextField txtSalary;
	private JTextField txtBankAccount;
	private JTextField txtAddress;
	private JTextField txtEmpId;


	/**
	 * Create the panel.
	 */
	public PanelEmployeeUpdate() {
		setBounds(0,0,1255, 656);
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1255, 47);
		panel.setBackground(new Color(255, 0, 0));
		add(panel);
		panel.setLayout(null);

		JLabel LabelEmpUpdate = new JLabel("Update Employee");
		LabelEmpUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		LabelEmpUpdate.setFont(new Font("Arial Black", Font.PLAIN, 20));
		LabelEmpUpdate.setForeground(Color.WHITE);
		LabelEmpUpdate.setBackground(Color.WHITE);
		LabelEmpUpdate.setBounds(505, 0, 210, 47);
		panel.add(LabelEmpUpdate);

		JLabel lblName1 = new JLabel("Name : ");
		lblName1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1.setBounds(50, 151, 138, 30);
		add(lblName1);

		JLabel lblAddress1 = new JLabel("Address : ");
		lblAddress1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblAddress1.setBounds(643, 436, 138, 30);
		add(lblAddress1);

		JLabel lblCity1 = new JLabel("City : ");
		lblCity1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblCity1.setBounds(50, 379, 138, 30);
		add(lblCity1);

		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartment.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblDepartment.setBounds(50, 491, 168, 30);
		add(lblDepartment);

		comboBoxDepartment = new JComboBox<String>();
		comboBoxDepartment.setBackground(new Color(222, 222, 222));
		comboBoxDepartment.setModel(new DefaultComboBoxModel(new String[] {"Computer Engg", "Electrical Engg", "Electronics & Telecommunication Engg", "Civil Engg", "Mechanical Engg", "Other", "Not Selected"}));
		comboBoxDepartment.setSelectedIndex(6);
		comboBoxDepartment.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboBoxDepartment.setBounds(267, 495, 260, 27);
		add(comboBoxDepartment);
		comboBoxDepartment.setSelectedItem("Mechanical");
		


		JLabel lblMob1 = new JLabel("Mobile :");
		lblMob1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMob1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblMob1.setBounds(643, 151, 138, 30);
		add(lblMob1);


		JLabel lblSalary1 = new JLabel("Salary :");
		lblSalary1.setHorizontalAlignment(SwingConstants.LEFT);
		lblSalary1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblSalary1.setBounds(643, 322, 138, 30);
		add(lblSalary1);

		JLabel lblAcc1 = new JLabel("Bank Account :");
		lblAcc1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcc1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblAcc1.setBounds(643, 379, 168, 30);
		add(lblAcc1);

		JLabel lblEmail1 = new JLabel("Email :");
		lblEmail1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblEmail1.setBounds(50, 265, 138, 30);
		add(lblEmail1);

		JButton buttonGetdata = new JButton("GET DATA");	
		buttonGetdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mysql = new MySQLConection();
				String empId = txtEmpId.getText(); 
				ResultSet resultset = mysql.getRow(Integer.parseInt(empId));
				System.out.println("Out Of While");
				try {
					while(resultset.next()) {
						
						System.out.println("In While");
						txtName.setText(resultset.getString("name"));
						gender = resultset.getString("gender");
						if(gender.equalsIgnoreCase(rdbtnMale.getLabel())) {
							rdbtnMale.doClick();
						}
						else if(gender.equalsIgnoreCase(rdbtnFemale.getLabel())){
							rdbtnFemale.doClick();
						}
						else {
							rdbtnNotToSay.doClick();
						}
						txtAddress.setText(resultset.getString("address"));
						txtState.setText(resultset.getString("state"));
						txtCity.setText(resultset.getString("city"));
						txtPincode.setText(resultset.getString("pincode"));
						txtMobileNumber.setText(resultset.getString("mobile"));
						txtQualification.setText(resultset.getString("Degree"));
						txtDesignation.setText(resultset.getString("Designation"));
						String department =(String) comboBoxDepartment.getSelectedItem();
						txtBankAccount.setText(resultset.getString("Bank"));
						txtSalary.setText(resultset.getString("salary"));
						txtEmailId.setText(resultset.getString("email"));
						System.out.println(resultset.getString("department"));
						System.out.println(resultset.getString("usertype"));
						comboBoxDepartment.setSelectedItem(resultset.getString("department"));
						comboBoxUserType.setSelectedItem(resultset.getString("usertype"));
						System.out.println(Name+""+""+address+""+""+city+""+pincode+""+mobile+""+Salary+""+Bank+""+email+""+department+""+""+gender+""+state+""+Degree+""+Designation+""+Usertype);		
					}


				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog( null, "Database error:" +  ( e2.getMessage()));
					e2.printStackTrace();
				}
			}

		});
		buttonGetdata.setForeground(Color.WHITE);
		buttonGetdata.setFont(new Font("Arial Black", Font.PLAIN, 19));
		buttonGetdata.setBackground(new Color(46, 61, 176));
		buttonGetdata.setBounds(577, 74, 260, 27);
		add(buttonGetdata);
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Name = txtName.getText().toString();
				System.out.println(Name);
				if(rdbtnMale.isSelected()) {
					gender = rdbtnMale.getLabel();
				}
				else if(rdbtnFemale.isSelected()){
					gender = rdbtnFemale.getLabel();
				}
				else if(rdbtnNotToSay.isSelected()) {
					gender = rdbtnNotToSay.getLabel();
				}
				address =txtAddress.getText().toString();
				state = txtState.getText().toString();
				city = txtCity.getText().toString();
				pincode = txtPincode.getText().toString();
				mobile = txtMobileNumber.getText().toString();
				Degree = txtQualification.getText().toString();
				Designation = txtDesignation.getText().toString();
				Department = (String)comboBoxDepartment.getSelectedItem();
			    Usertype = (String)comboBoxUserType.getSelectedItem();
				Bank = txtBankAccount.getText().toString();
				email = txtEmailId.getText().toString();
				Salary = txtSalary.getText().toString();
				
			
				;
				
				MySQLConection mysql = new MySQLConection();
				employeeId = Integer.parseInt(txtEmpId.getText());
				
				ResultSet result = mysql.getSalary(Integer.toString(employeeId));
				int dbSalary=0;
				try {
					dbSalary = result.getInt("CTC");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(Integer.parseInt(Salary) == dbSalary) {
					
				}
				else {
					mysql.deleteAnyData("salary", employeeId);
					mysql.addSalarComponents(employeeId, Integer.parseInt(Salary));
				}
				
				int	status = mysql.UpdateAdmin(employeeId,Name,gender,address,state,city ,pincode,mobile,Degree,Designation,Department,Bank,email,Salary,Usertype);
				try {
					if(status==1) {
						JOptionPane.showMessageDialog(null, "Successfully Updated");
					}else {
						JOptionPane.showMessageDialog(null, "Failed to  Update");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog( null, "Database error:" +  ( e2.getMessage()));
					e2.printStackTrace();// TODO: handle exception
				}




			}
		});
		btnUpdate.setBackground(new Color(46, 61, 176));
		btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(871, 561, 260, 30);
		add(btnUpdate);



		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblGender.setBounds(50, 208, 138, 30);
		add(lblGender);


		lblState = new JLabel("State : ");
		lblState.setHorizontalAlignment(SwingConstants.LEFT);
		lblState.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblState.setBounds(50, 322, 138, 30);
		add(lblState);

		lblPincode = new JLabel("Pincode : ");
		lblPincode.setHorizontalAlignment(SwingConstants.LEFT);
		lblPincode.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblPincode.setBounds(50, 436, 138, 30);
		add(lblPincode);

		lblDegree = new JLabel("Qualification :");
		lblDegree.setHorizontalAlignment(SwingConstants.LEFT);
		lblDegree.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblDegree.setBounds(643, 208, 155, 30);
		add(lblDegree);

		lblDesignation = new JLabel("Designation");
		lblDesignation.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesignation.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblDesignation.setBounds(643, 265, 138, 30);
		add(lblDesignation);

		lblEmployeeId = new JLabel("Employee Id :");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeId.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblEmployeeId.setBounds(50, 70, 168, 30);
		add(lblEmployeeId);

		JSeparator separator = new JSeparator();
		separator.setBounds(66, 123, 1125, 2);
		add(separator);

		clearbutton = new JButton("CLEAR");
		clearbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmpId.setText(null); 
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				rdbtnNotToSay.setSelected(false);
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
				comboBoxDepartment.setSelectedItem(null);
				buttonGroup.clearSelection();

			}
			
			
		});
	

		clearbutton.setForeground(Color.WHITE);
		clearbutton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		clearbutton.setBackground(new Color(46, 61, 176));
		clearbutton.setBounds(512, 561, 260, 30);
		add(clearbutton);

		btnExit = new JButton("BACK");
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
		btnExit.setBounds(148, 561, 260, 30);
		add(btnExit);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 631, 1255, 25);
		add(panel_1);

		lblNewLabel = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(451, 0, 353, 20);
		panel_1.add(lblNewLabel);

		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(267, 217, 65, 21);
		add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(334, 217, 87, 21);
		add(rdbtnFemale);

		rdbtnNotToSay = new JRadioButton("Not To Say");
		buttonGroup.add(rdbtnNotToSay);
		rdbtnNotToSay.setFont(new Font("Arial Black", Font.PLAIN, 14));
		rdbtnNotToSay.setBackground(Color.WHITE);
		rdbtnNotToSay.setBounds(417, 217, 111, 21);
		add(rdbtnNotToSay);
		
		JLabel lblUserType = new JLabel("User Type : ");
		lblUserType.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserType.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblUserType.setBounds(643, 491, 138, 30);
		add(lblUserType);
		
		comboBoxUserType = new JComboBox<String>();
		comboBoxUserType.setModel(new DefaultComboBoxModel(new String[] {"Employee", "Admin", "Not Selected"}));
		comboBoxUserType.setSelectedIndex(2);
		comboBoxUserType.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboBoxUserType.setBackground(new Color(222, 222, 222));
		comboBoxUserType.setBounds(871, 495, 260, 27);
		add(comboBoxUserType);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBackground(new Color(222, 222, 222));
		txtName.setBounds(267, 151, 260, 27);
		add(txtName);
		
		txtEmailId = new JTextField();
		txtEmailId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmailId.setColumns(10);
		txtEmailId.setBackground(new Color(222, 222, 222));
		txtEmailId.setBounds(267, 265, 260, 27);
		add(txtEmailId);
		
		txtState = new JTextField();
		txtState.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtState.setColumns(10);
		txtState.setBackground(new Color(222, 222, 222));
		txtState.setBounds(267, 324, 260, 27);
		add(txtState);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtCity.setColumns(10);
		txtCity.setBackground(new Color(222, 222, 222));
		txtCity.setBounds(267, 382, 260, 27);
		add(txtCity);
		
		txtPincode = new JTextField();
		txtPincode.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtPincode.setColumns(10);
		txtPincode.setBackground(new Color(222, 222, 222));
		txtPincode.setBounds(267, 439, 260, 27);
		add(txtPincode);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBackground(new Color(222, 222, 222));
		txtMobileNumber.setBounds(871, 151, 260, 27);
		add(txtMobileNumber);
		
		txtQualification = new JTextField();
		txtQualification.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtQualification.setColumns(10);
		txtQualification.setBackground(new Color(222, 222, 222));
		txtQualification.setBounds(871, 208, 260, 27);
		add(txtQualification);
		
		txtDesignation = new JTextField();
		txtDesignation.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDesignation.setColumns(10);
		txtDesignation.setBackground(new Color(222, 222, 222));
		txtDesignation.setBounds(871, 265, 260, 27);
		add(txtDesignation);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtSalary.setColumns(10);
		txtSalary.setBackground(new Color(222, 222, 222));
		txtSalary.setBounds(871, 322, 260, 27);
		add(txtSalary);
		
		txtBankAccount = new JTextField();
		txtBankAccount.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBankAccount.setColumns(10);
		txtBankAccount.setBackground(new Color(222, 222, 222));
		txtBankAccount.setBounds(871, 379, 260, 27);
		add(txtBankAccount);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBackground(new Color(222, 222, 222));
		txtAddress.setBounds(871, 436, 260, 27);
		add(txtAddress);
		
		txtEmpId = new JTextField();
		txtEmpId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmpId.setColumns(10);
		txtEmpId.setBackground(new Color(222, 222, 222));
		txtEmpId.setBounds(267, 75, 260, 27);
		add(txtEmpId);


	}
}

