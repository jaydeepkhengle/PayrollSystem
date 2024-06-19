package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class PanelDeleteEmployee extends JPanel {

	private JTextField txtEmpId;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtAddress;
	private JTextField txtMobileNumber;
	private JTextField txtQualification;
	private JTextField txtDesignation;
	private JTextField txtSalary;
	private JComboBox<String>comboBoxDepartment;


	/**
	 * Create the panel.
	 */
	public PanelDeleteEmployee() {
		setBounds(0,0,1255, 659);
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLayout(null);



		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 1255, 47);
		add(panel_1);

		JLabel DeleteEmpLabel = new JLabel("Delete Employee");
		DeleteEmpLabel .setHorizontalAlignment(SwingConstants.CENTER);
		DeleteEmpLabel  .setFont(new Font("Arial Black", Font.PLAIN, 20));
		DeleteEmpLabel  .setForeground(Color.WHITE);
		DeleteEmpLabel .setBackground(Color.WHITE);
		DeleteEmpLabel .setBounds(505, 0, 210, 38);
		panel_1.add(DeleteEmpLabel);

		JButton buttonGetdata = new JButton("GET DATA");
		buttonGetdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mysql = new MySQLConection();
				int empId = Integer.parseInt(txtEmpId.getText()); 
				ResultSet resultset = mysql.getRow(empId);
				try {
					while(resultset.next()) {

						txtName.setText(resultset.getString("name"));
						txtGender.setText(resultset.getString("gender"));
						txtAddress.setText(resultset.getString("address"));
						txtMobileNumber.setText(resultset.getString("mobile"));
						txtQualification.setText(resultset.getString("Degree"));
						txtDesignation.setText(resultset.getString("Designation"));
						txtSalary.setText(resultset.getString("salary"));
						comboBoxDepartment.setSelectedItem(resultset.getString("department"));


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
		buttonGetdata.setBounds(614, 74, 260, 27);
		add(buttonGetdata);

		JButton btnDelete = new JButton("DELETE DATA");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do You Want To Delete ?", "Delete", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					MySQLConection mysql = new MySQLConection();
					int empId = Integer.parseInt(txtEmpId.getText());
					MySQLConection connection = new MySQLConection();
					int Id = connection.getSerialNumber(empId);

					int status = 0;

					status = mysql.deleteAnyData("salary", empId);
					status = mysql.deleteAnyData("leave_stats", empId);
					status = mysql.deleteAnyData("apply_leave", empId);
					status = mysql.DeleteData(empId);
					try {

						if(status==1) {
							JOptionPane.showMessageDialog(null, "Successfully Deleted");

							int rowCount=0;

							System.out.println("Serial No of Deleted One : " + Id);
							ResultSet result = connection.getRowCount();
							while(result.next()) {
								rowCount = result.getInt("count");
							}
							System.out.println("Row Count Is : " + rowCount);
							int limit = rowCount-Id;
							while(limit>=0) {
								System.out.println("Enter Loop");
								connection.updateRowNumber(Id);
								Id++;
								limit--;

							}
						}else {
							JOptionPane.showMessageDialog(null, "Failed to  Delete");
						}
					} 
					catch (Exception e2) {
						JOptionPane.showMessageDialog( null, "Database error:" +  ( e2.getMessage()));
					}
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnDelete.setBackground(new Color(46, 61, 176));
		btnDelete.setBounds(828, 562, 260, 30);
		add(btnDelete);

		JLabel lblEmpId = new JLabel("Employee Id : ");
		lblEmpId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpId.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblEmpId.setBounds(55, 68, 166, 30);
		add(lblEmpId);

		JLabel lblName1_1 = new JLabel("Name :");
		lblName1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_1.setBounds(55, 152, 138, 30);
		add(lblName1_1);

		JLabel lblName1_2 = new JLabel("Gender :");
		lblName1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_2.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_2.setBounds(55, 209, 138, 30);
		add(lblName1_2);

		JLabel lblName1_3 = new JLabel("Address :");
		lblName1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_3.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_3.setBounds(55, 266, 138, 30);
		add(lblName1_3);

		JLabel lblName1_7 = new JLabel("Department :");
		lblName1_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_7.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_7.setBounds(55, 327, 154, 30);
		add(lblName1_7);

		JLabel lblName1_8 = new JLabel("Mobile :");
		lblName1_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_8.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_8.setBounds(614, 152, 138, 30);
		add(lblName1_8);

		JLabel lblQualification = new JLabel("Qualification : ");
		lblQualification.setHorizontalAlignment(SwingConstants.LEFT);
		lblQualification.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblQualification.setBounds(614, 209, 171, 30);
		add(lblQualification);

		JLabel lblName1_10 = new JLabel("Designation : ");
		lblName1_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_10.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_10.setBounds(614, 266, 166, 30);
		add(lblName1_10);

		JLabel lblName1_10_1 = new JLabel("Salary : ");
		lblName1_10_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName1_10_1.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblName1_10_1.setBounds(614, 323, 138, 30);
		add(lblName1_10_1);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEmpId.setText(null); 
				txtGender.setText(null);
				txtQualification.setText(null);
				txtDesignation.setText(null); 
				txtName.setText(null);
				txtAddress.setText(null);
				txtMobileNumber.setText(null);
				txtSalary.setText(null);
				comboBoxDepartment.setSelectedItem(null);

			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnClear.setBackground(new Color(46, 61, 176));
		btnClear.setBounds(490, 562, 260, 30);
		add(btnClear);

		JSeparator separator = new JSeparator();
		separator.setBounds(36, 122, 1182, 2);
		add(separator);

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
		btnBack.setBounds(147, 562, 260, 30);
		add(btnBack);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 0, 0));
		panel_1_1.setBounds(0, 634, 1255, 25);
		add(panel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(451, 0, 353, 20);
		panel_1_1.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelDeleteEmployee.class.getResource("/image/DeleteEmployee.jpeg")));
		lblNewLabel.setBounds(503, 365, 238, 187);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelDeleteEmployee.class.getResource("/image/MinusLogo.png")));
		lblNewLabel_1.setBounds(198, 408, 138, 136);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelDeleteEmployee.class.getResource("/image/MinusLogo.png")));
		lblNewLabel_1_1.setBounds(881, 408, 138, 136);
		add(lblNewLabel_1_1);

		txtEmpId = new JTextField();
		txtEmpId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmpId.setColumns(10);
		txtEmpId.setBackground(new Color(222, 222, 222));
		txtEmpId.setBounds(261, 74, 260, 27);
		add(txtEmpId);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBackground(new Color(222, 222, 222));
		txtName.setBounds(261, 156, 260, 27);
		add(txtName);

		txtGender = new JTextField();
		txtGender.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtGender.setColumns(10);
		txtGender.setBackground(new Color(222, 222, 222));
		txtGender.setBounds(261, 213, 260, 27);
		add(txtGender);

		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtAddress.setColumns(10);
		txtAddress.setBackground(new Color(222, 222, 222));
		txtAddress.setBounds(261, 270, 260, 27);
		add(txtAddress);

		txtMobileNumber = new JTextField();
		txtMobileNumber.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBackground(new Color(222, 222, 222));
		txtMobileNumber.setBounds(828, 155, 260, 27);
		add(txtMobileNumber);

		txtQualification = new JTextField();
		txtQualification.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtQualification.setColumns(10);
		txtQualification.setBackground(new Color(222, 222, 222));
		txtQualification.setBounds(828, 212, 260, 27);
		add(txtQualification);

		txtDesignation = new JTextField();
		txtDesignation.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDesignation.setColumns(10);
		txtDesignation.setBackground(new Color(222, 222, 222));
		txtDesignation.setBounds(828, 266, 260, 27);
		add(txtDesignation);

		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtSalary.setColumns(10);
		txtSalary.setBackground(new Color(222, 222, 222));
		txtSalary.setBounds(828, 327, 260, 27);
		add(txtSalary);

		comboBoxDepartment = new JComboBox<String>();
		comboBoxDepartment.setModel(new DefaultComboBoxModel(new String[] {"Computer Engg", "Electrical Engg", "Electronics & Telecommunication Engg", "Civil Engg", "Mechanical Engg", "Other", "Not Selected"}));
		comboBoxDepartment.setSelectedIndex(6);
		comboBoxDepartment.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboBoxDepartment.setBackground(new Color(222, 222, 222));
		comboBoxDepartment.setBounds(261, 327, 260, 27);
		add(comboBoxDepartment);

	}
}
