package package1;

import java.awt.Color;
import java.awt.Font;
import static package1.PanelMonthlySalary.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PanelSalaryEmployee extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String Name,department,bank,HR, DA,Med,leave,travell,grosssalary,Netsalary,leaveday,date,Travell,basic;
	
	public static JTextField txtEmployeeId;
	private JTextField txtName;
	private JTextField txtBankName;
	private JTextField txtDepartment;
	private JTextField txtTotalLeavesTaken;
	private JTextField txtCTC;
	private JTextField txtBasicPay;
	private JTextField txtHRA;
	private JTextField txtDA;
	private JTextField txtTravel;
	private JTextField txtMedical;
	private JTextField txtTax;
	private JTextField txtNetSalary;
	PanelMonthlySalaryEmployee panelMonthlySalary;
	public static int empId;
	static JDateChooser dateChooser;
	static public JButton btnBack, btnClear,  btnMonthlySalary;
	ResultSet resultSet;

	public PanelSalaryEmployee() {
		MySQLConection mySql = new MySQLConection();
		ResultSet empIdResult = mySql.getEmployeeId(MainLogin.username);
		try {
			while(empIdResult.next()) {
				empId = empIdResult.getInt("employee_id");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(0,0,1255, 656);
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLayout(null);
		panelMonthlySalary = new PanelMonthlySalaryEmployee();
		add(panelMonthlySalary);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 1255, 47);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel SalaryLabel = new JLabel("Salary");
		SalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SalaryLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		SalaryLabel.setForeground(Color.WHITE);
		SalaryLabel.setBackground(Color.WHITE);
		SalaryLabel.setBounds(505, 0, 210, 38);
		panel_1.add(SalaryLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(40, 131, 1190, 14);
		add(separator);

		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(100, 149, 237));
		dateChooser.setForeground(new Color(47, 79, 79));
		dateChooser.setBounds(258, 169, 332, 33);
		add(dateChooser);
		dateChooser.setDate(new java.util.Date());

	

		btnMonthlySalary = new JButton("MONTHLY SALARY");
		btnMonthlySalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMonthlySalary.setVisible(true);
				btnBack.setVisible(false);
				btnClear.setVisible(false);
				btnMonthlySalary.setVisible(false);
				dateChooser.setVisible(false);
				
				MySQLConection mySql = new MySQLConection();
				ResultSet resultSet = mySql.getSalary(Integer.toString(empId));
				
				try {
					while(resultSet.next()) {

						PanelMonthlySalaryEmployee.txtEmployeeId.setText(Integer.toString(empId));
						PanelMonthlySalaryEmployee.txtName.setText(resultSet.getString("name"));
						PanelMonthlySalaryEmployee.txtDepartment.setText(resultSet.getString("Department"));
						PanelMonthlySalaryEmployee.txtBankName.setText(resultSet.getString("Bank"));
						PanelMonthlySalaryEmployee.txtHRA.setText(Integer.toString(resultSet.getInt("HR")/12));
						PanelMonthlySalaryEmployee.txtDA.setText(Integer.toString(resultSet.getInt("DA")/12));
						PanelMonthlySalaryEmployee.txtMedical.setText(Integer.toString(resultSet.getInt("Med")/12));
						PanelMonthlySalaryEmployee.txtMediclaim.setText(Integer.toString(resultSet.getInt("Med")/12));
						PanelMonthlySalaryEmployee.txtTravel.setText(Integer.toString(resultSet.getInt("travel")/12));
						PanelMonthlySalaryEmployee.txtUnpaidLeaves.setText(resultSet.getString("unpaid_leaves"));
						PanelMonthlySalaryEmployee.txtBasicPay.setText(Integer.toString(resultSet.getInt("Basic_Pay")/12));
						PanelMonthlySalaryEmployee.txtTax.setText(Integer.toString(resultSet.getInt("Tax")/12));
						PanelMonthlySalaryEmployee.txtNetSalary.setText(Integer.toString(resultSet.getInt("Net_Salary")/12) + " Rs /-");
					}


				} catch (SQLException e1) {
					JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
					e1.printStackTrace();
				}

			}
		});
		btnMonthlySalary.setForeground(Color.WHITE);
		btnMonthlySalary.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnMonthlySalary.setBorder(null);
		btnMonthlySalary.setBackground(new Color(46, 61, 176));
		btnMonthlySalary.setBounds(821, 578, 262, 33);
		add(btnMonthlySalary);

		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtBankName.setText(null);
				txtDepartment.setText(null);
				txtTax.setText(null);
				txtCTC.setText(null);
				txtBasicPay.setText(null);
				txtTravel.setText(null);
				txtMedical.setText(null);
				txtHRA.setText(null);
				txtDA.setText(null);
				txtTotalLeavesTaken.setText(null);
				txtBasicPay.setText(null);
				txtNetSalary.setText(null);
				txtEmployeeId.setText(null);
				dateChooser.setCalendar(null);
				PanelMonthlySalary.txtEmployeeId.setText(Integer.toString(empId));
				PanelMonthlySalary.txtName.setText(null);
				PanelMonthlySalary.txtDepartment.setText(null);
				PanelMonthlySalary.txtBankName.setText(null);
				PanelMonthlySalary.txtHRA.setText(null);
				PanelMonthlySalary.txtDA.setText(null);
				PanelMonthlySalary.txtMedical.setText(null);
				PanelMonthlySalary.txtMediclaim.setText(null);
				PanelMonthlySalary.txtTravel.setText(null);
				PanelMonthlySalary.txtUnpaidLeaves.setText(null);
				PanelMonthlySalary.txtBasicPay.setText(null);
				PanelMonthlySalary.txtTax.setText(null);
				PanelMonthlySalary.txtNetSalary.setText(null);
				

			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnClear.setBorder(null);
		btnClear.setBackground(new Color(46, 61, 176));
		btnClear.setBounds(495, 578, 270, 33);
		add(btnClear);

		JLabel lblNewLabel = new JLabel("Employee Id :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel.setBounds(40, 74, 172, 33);
		add(lblNewLabel);

		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblDate.setBounds(40, 169, 163, 33);
		add(lblDate);

		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblName.setBounds(40, 228, 215, 33);
		add(lblName);

		JLabel lblBank = new JLabel("Bank :");
		lblBank.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblBank.setBounds(40, 285, 214, 33);
		add(lblBank);

		JLabel lblNewLabel_9 = new JLabel("Medical : ");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(650, 399, 238, 33);
		add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel("HRA : ");
		lblNewLabel_11.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_11.setBounds(650, 169, 238, 33);
		add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("DA  :");
		lblNewLabel_12.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_12.setBounds(650, 226, 238, 33);
		add(lblNewLabel_12);

		JLabel lblDeduction = new JLabel("Deductions");
		lblDeduction.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeduction.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblDeduction.setBounds(906, 342, 238, 33);
		add(lblDeduction);

		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMyAccountEmp panelMyAccountEmp = new PanelMyAccountEmp();
				panelMyAccountEmp.setVisible(true);
				EmployeeHomePage.contentpanel.add(panelMyAccountEmp );
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(46, 61, 176));
		btnBack.setBounds(172, 578, 270, 33);
		add(btnBack);

		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblDepartment.setBounds(40, 342, 196, 33);
		add(lblDepartment);

		JLabel lblBank_1 = new JLabel("Unpaid Leaves : ");
		lblBank_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblBank_1.setBounds(40, 399, 208, 33);
		add(lblBank_1);

		JLabel lblGrossSalary = new JLabel("CTC : ");
		lblGrossSalary.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblGrossSalary.setBounds(40, 456, 196, 33);
		add(lblGrossSalary);

		JLabel lblNetSalary = new JLabel("Basic Pay : ");
		lblNetSalary.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNetSalary.setBounds(40, 511, 184, 33);
		add(lblNetSalary);

		JLabel lblTravelling = new JLabel("Travelling : ");
		lblTravelling.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblTravelling.setBounds(650, 283, 214, 33);
		add(lblTravelling);

		JLabel lblLeave = new JLabel("Tax :");
		lblLeave.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblLeave.setBounds(650, 456, 214, 33);
		add(lblLeave);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 0, 0));
		panel_1_1.setBounds(0, 631, 1255, 25);
		add(panel_1_1);

		JLabel lblNewLabel_2_5 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(449, 0, 353, 20);
		panel_1_1.add(lblNewLabel_2_5);

		JLabel lblNetSalary_1 = new JLabel("Net Salary : ");
		lblNetSalary_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNetSalary_1.setBounds(650, 511, 214, 33);
		add(lblNetSalary_1);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBackground(new Color(222, 222, 222));
		txtEmployeeId.setBounds(258, 78, 332, 27);
		add(txtEmployeeId);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBackground(new Color(222, 222, 222));
		txtName.setBounds(258, 226, 332, 27);
		add(txtName);

		txtBankName = new JTextField();
		txtBankName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBankName.setColumns(10);
		txtBankName.setBackground(new Color(222, 222, 222));
		txtBankName.setBounds(258, 283, 332, 27);
		add(txtBankName);

		txtDepartment = new JTextField();
		txtDepartment.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDepartment.setColumns(10);
		txtDepartment.setBackground(new Color(222, 222, 222));
		txtDepartment.setBounds(258, 340, 332, 27);
		add(txtDepartment);

		txtTotalLeavesTaken = new JTextField();
		txtTotalLeavesTaken.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtTotalLeavesTaken.setColumns(10);
		txtTotalLeavesTaken.setBackground(new Color(222, 222, 222));
		txtTotalLeavesTaken.setBounds(258, 397, 332, 27);
		add(txtTotalLeavesTaken);

		txtCTC = new JTextField();
		txtCTC.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtCTC.setColumns(10);
		txtCTC.setBackground(new Color(222, 222, 222));
		txtCTC.setBounds(258, 454, 332, 27);
		add(txtCTC);

		txtBasicPay = new JTextField();
		txtBasicPay.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBasicPay.setColumns(10);
		txtBasicPay.setBackground(new Color(222, 222, 222));
		txtBasicPay.setBounds(258, 513, 332, 27);
		add(txtBasicPay);

		txtHRA = new JTextField();
		txtHRA.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtHRA.setColumns(10);
		txtHRA.setBackground(new Color(222, 222, 222));
		txtHRA.setBounds(898, 175, 332, 27);
		add(txtHRA);

		txtDA = new JTextField();
		txtDA.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDA.setColumns(10);
		txtDA.setBackground(new Color(222, 222, 222));
		txtDA.setBounds(898, 232, 332, 27);
		add(txtDA);

		txtTravel = new JTextField();
		txtTravel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtTravel.setColumns(10);
		txtTravel.setBackground(new Color(222, 222, 222));
		txtTravel.setBounds(898, 289, 332, 27);
		add(txtTravel);

		txtMedical = new JTextField();
		txtMedical.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMedical.setColumns(10);
		txtMedical.setBackground(new Color(222, 222, 222));
		txtMedical.setBounds(898, 403, 332, 27);
		add(txtMedical);

		txtTax = new JTextField();
		txtTax.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtTax.setColumns(10);
		txtTax.setBackground(new Color(222, 222, 222));
		txtTax.setBounds(898, 460, 332, 27);
		add(txtTax);

		txtNetSalary = new JTextField();
		txtNetSalary.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtNetSalary.setColumns(10);
		txtNetSalary.setBackground(new Color(222, 222, 222));
		txtNetSalary.setBounds(898, 515, 332, 27);
		add(txtNetSalary);
		
		
		resultSet  = mySql.getSalary(Integer.toString(empId));

		try {
			while(resultSet.next()) {
                txtEmployeeId.setText(empId + "");
				txtName.setText(resultSet.getString("name"));
				txtDepartment.setText(resultSet.getString("Department"));
				txtBankName.setText(resultSet.getString("Bank"));
				txtHRA.setText(resultSet.getString("HR"));
				txtDA.setText(resultSet.getString("DA"));
				txtMedical.setText(resultSet.getString("Med"));
				txtTravel.setText(resultSet.getString("travel"));
				txtTotalLeavesTaken.setText(resultSet.getString("unpaid_leaves"));
				txtCTC.setText(Integer.toString(resultSet.getInt("CTC")));
				txtBasicPay.setText(Integer.toString(resultSet.getInt("Basic_Pay")));
				txtTax.setText(resultSet.getString("Tax"));
				txtNetSalary.setText(resultSet.getString("Net_Salary")  + " Rs /-");

			}


		} catch (SQLException e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
			e1.printStackTrace();
		}

	}
}
