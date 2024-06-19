package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



public class PanelMonthlySalaryEmployee extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String uid, Name,department,bank,HR, DA,Med,leave,travell,grosssalary,Netsalary,leaveday,date,Travell,basic;
	public static JButton btnGenerateSalary;
	static JPanel panelPaySlip;
	static Date dateChooser;
	public static JTextField txtEmployeeId, txtName, txtBankName, txtDepartment, txtUnpaidLeaves, txtBasicPay, txtHRA, txtDA, txtTravel, txtMedical, txtTax, txtNetSalary, txtMediclaim;

	public PanelMonthlySalaryEmployee() {
		setVisible(false);
		System.out.println("In Panel Monthly Salary");
		setBounds(0,0,1255, 656);
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		panelPaySlip = new JPanel();
		panelPaySlip.setBounds(491, 0, 764, 656);
		add(panelPaySlip);
		panelPaySlip.setLayout(null);
		panelPaySlip.setVisible(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 1255, 47);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel SalaryLabel = new JLabel("Monthly Salary");
		SalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SalaryLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		SalaryLabel.setForeground(Color.WHITE);
		SalaryLabel.setBackground(Color.WHITE);
		SalaryLabel.setBounds(505, 0, 210, 38);
		panel_1.add(SalaryLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(40, 131, 1190, 14);
		add(separator);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(100, 149, 237));
		dateChooser.setForeground(new Color(47, 79, 79));
		dateChooser.setBounds(898, 74, 332, 33);
		add(dateChooser);
		dateChooser.setDate(new java.util.Date());

		btnGenerateSalary = new JButton("GENARATE SALARY");
		btnGenerateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaySlipEmployee paySlip2 = new PaySlipEmployee();
				panelPaySlip.add(paySlip2);
				paySlip2.setVisible(true);
				panelPaySlip.setVisible(true);
				btnGenerateSalary.setVisible(false);

				MySQLConection mySQl = new MySQLConection();
				ResultSet result = mySQl.getSalary(Integer.toString(PanelSalaryEmployee.empId));
				try {
					while(result.next()) {
						int basicSalary = result.getInt("basic_pay")/12;
						int salaryPerDay = basicSalary/24;
						int unpaidDeduction = salaryPerDay * result.getInt("unpaid_leaves");
						int DA = result.getInt("DA")/12;
						int HRA = result.getInt("HR")/12;
						int med = result.getInt("med")/12;
						int travel = result.getInt("travel")/12;
						int grossSalary = basicSalary+DA+HRA+med+travel;
						int totalDeduction = (result.getInt("tax")/12) + med - unpaidDeduction;
						int tax = result.getInt("tax")/12;

						PaySlipEmployee.txtBasicSalary.setText(Integer.toString(basicSalary));
						PaySlipEmployee.txtDA.setText(Integer.toString(DA));
						PaySlipEmployee.txtHRA.setText(Integer.toString(HRA));
						PaySlipEmployee.txtMed.setText(Integer.toString(med));
						PaySlipEmployee.txtTravel.setText(Integer.toString(travel));
						PaySlipEmployee.txtTax.setText(tax + " Rs/-");
						PaySlipEmployee.txtMedclaim.setText(med+ " Rs/-");
						PaySlipEmployee.txtGrossSalary.setText(Integer.toString(grossSalary)+ " Rs/-");
						PaySlipEmployee.txtDeduction.setText(Integer.toString(totalDeduction) + " Rs/-");
						PaySlipEmployee.txtUnpaidLeaves.setText(unpaidDeduction+ " Rs/-");
						PaySlipEmployee.txtNetSalary.setText(((result.getInt("Net_Salary")/12)-totalDeduction) + " Rs/-");
						PaySlipEmployee.lblName.setText(result.getString("name"));
						PaySlipEmployee.lblDesignation.setText(result.getString("Designation"));
						PaySlipEmployee.lblPlace.setText(result.getString("City"));
						PaySlipEmployee.lblDept.setText(result.getString("Department"));
						PaySlipEmployee.lblBnk.setText(result.getString("Bank"));
						PaySlipEmployee.lblBankNum.setText("xxxxxXXXX");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnGenerateSalary.setForeground(Color.WHITE);
		btnGenerateSalary.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnGenerateSalary.setBorder(null);
		btnGenerateSalary.setBackground(new Color(46, 61, 176));
		btnGenerateSalary.setBounds(968, 578, 262, 33);
		add(btnGenerateSalary);

		JLabel lblNewLabel = new JLabel("Employee Id :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel.setBounds(40, 74, 172, 33);
		add(lblNewLabel);

		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblDate.setBounds(654, 74, 163, 33);
		add(lblDate);

		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblName.setBounds(40, 147, 215, 33);
		add(lblName);

		JLabel lblBank = new JLabel("Bank :");
		lblBank.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblBank.setBounds(40, 201, 214, 33);
		add(lblBank);

		JLabel lblNewLabel_9 = new JLabel("Medical : ");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_9.setBounds(40, 527, 238, 33);
		add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel("HRA : ");
		lblNewLabel_11.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_11.setBounds(40, 355, 238, 33);
		add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("DA  :");
		lblNewLabel_12.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_12.setBounds(40, 412, 238, 33);
		add(lblNewLabel_12);

		JLabel lblDeduction = new JLabel("Deductions");
		lblDeduction.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeduction.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblDeduction.setBounds(940, 271, 238, 33);
		add(lblDeduction);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelSalaryEmployee.btnBack.setVisible(true);
				PanelSalaryEmployee.btnClear.setVisible(true);
				PanelSalaryEmployee.btnMonthlySalary.setVisible(true);
				PanelSalaryEmployee.dateChooser.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(46, 61, 176));
		btnBack.setBounds(654, 578, 270, 33);
		add(btnBack);

		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblDepartment.setBounds(654, 155, 196, 33);
		add(lblDepartment);

		JLabel lblBank_1 = new JLabel("Unpaid Leaves :");
		lblBank_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblBank_1.setBounds(650, 370, 208, 33);
		add(lblBank_1);

		JLabel lblNetSalary = new JLabel("Basic Pay : ");
		lblNetSalary.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNetSalary.setBounds(40, 271, 184, 33);
		add(lblNetSalary);

		JLabel lblTravelling = new JLabel("Travelling : ");
		lblTravelling.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblTravelling.setBounds(40, 467, 214, 33);
		add(lblTravelling);

		JLabel lblLeave = new JLabel("Tax :");
		lblLeave.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblLeave.setBounds(650, 431, 214, 33);
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
		txtName.setBounds(258, 155, 332, 27);
		add(txtName);

		txtBankName = new JTextField();
		txtBankName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBankName.setColumns(10);
		txtBankName.setBackground(new Color(222, 222, 222));
		txtBankName.setBounds(258, 205, 332, 27);
		add(txtBankName);

		txtDepartment = new JTextField();
		txtDepartment.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDepartment.setColumns(10);
		txtDepartment.setBackground(new Color(222, 222, 222));
		txtDepartment.setBounds(898, 155, 332, 27);
		add(txtDepartment);

		txtUnpaidLeaves = new JTextField();
		txtUnpaidLeaves.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtUnpaidLeaves.setColumns(10);
		txtUnpaidLeaves.setBackground(new Color(222, 222, 222));
		txtUnpaidLeaves.setBounds(898, 374, 332, 27);
		add(txtUnpaidLeaves);

		txtBasicPay = new JTextField();
		txtBasicPay.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBasicPay.setColumns(10);
		txtBasicPay.setBackground(new Color(222, 222, 222));
		txtBasicPay.setBounds(258, 275, 332, 27);
		add(txtBasicPay);

		txtHRA = new JTextField();
		txtHRA.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtHRA.setColumns(10);
		txtHRA.setBackground(new Color(222, 222, 222));
		txtHRA.setBounds(258, 359, 332, 27);
		add(txtHRA);

		txtDA = new JTextField();
		txtDA.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtDA.setColumns(10);
		txtDA.setBackground(new Color(222, 222, 222));
		txtDA.setBounds(258, 416, 332, 27);
		add(txtDA);

		txtTravel = new JTextField();
		txtTravel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtTravel.setColumns(10);
		txtTravel.setBackground(new Color(222, 222, 222));
		txtTravel.setBounds(258, 471, 332, 27);
		add(txtTravel);

		txtMedical = new JTextField();
		txtMedical.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMedical.setColumns(10);
		txtMedical.setBackground(new Color(222, 222, 222));
		txtMedical.setBounds(258, 531, 332, 27);
		add(txtMedical);

		txtTax = new JTextField();
		txtTax.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtTax.setColumns(10);
		txtTax.setBackground(new Color(222, 222, 222));
		txtTax.setBounds(898, 435, 332, 27);
		add(txtTax);

		txtNetSalary = new JTextField();
		txtNetSalary.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtNetSalary.setColumns(10);
		txtNetSalary.setBackground(new Color(222, 222, 222));
		txtNetSalary.setBounds(898, 515, 332, 27);
		add(txtNetSalary);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 247, 1190, 14);
		add(separator_1);

		JLabel lblBenefits = new JLabel("Benefits");
		lblBenefits.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenefits.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
		lblBenefits.setBounds(295, 317, 238, 33);
		add(lblBenefits);

		txtMediclaim = new JTextField();
		txtMediclaim.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtMediclaim.setColumns(10);
		txtMediclaim.setBackground(new Color(222, 222, 222));
		txtMediclaim.setBounds(898, 315, 332, 27);
		add(txtMediclaim);

		JLabel lblNewLabel_9_1 = new JLabel("Medical : ");
		lblNewLabel_9_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_9_1.setBounds(650, 309, 238, 33);
		add(lblNewLabel_9_1);


	}
}
