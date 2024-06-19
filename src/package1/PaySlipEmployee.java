package package1;

import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class PaySlipEmployee extends JInternalFrame {
	String uid, Name,department,bank,leave,HR, DA,Med,Leave,travell,grosssalary,Netsalary ,firstHalf,SecondHalf, Date,basicsalary ;
	private JPanel panel;
	private JTextField txtNInfinityInfo;
	public static JTextField txtPaySlipFor, txtUnpaidLeaves, txtEarnings, txtSalary, txtNetSalary, txtGrossSalary, txtMedicalAllowDeduction, txtMedclaim, txtTotalDeductions, txtDeduction, txtTax, txtSalaryHead, txtAmount, txtBasic, txtDearnessAllowance, txtHouseRentAllowance, txtMedicalAllowance, txtTravelAllowance, txtBasicSalary,  txtDA, txtHRA, txtMed, txtTravel, txtDeductions;
	private JTextField txtSNo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField txtTaxDeductedAt;
	private JTextField txtSalary_1;
	private JLabel lblNewLabel_1;
	private JTextField txtDate;
	private JTextField textField_19;
	public static JLabel lblName, lblDesignation, lblPlace, lblDept,  lblBnk, lblBankNum;

	private JLabel lblNInifnityInfo;
	private JTextField textField_5;
	private JTextField txtUnpaidLeaves_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaySlipEmployee frame = new PaySlipEmployee();
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
	public PaySlipEmployee() {
		setRootPaneCheckingEnabled(false);
		setTitle("N Infinity Info Solutions");                                                                                        
		setResizable(true);
		setMaximizable(true);
		setEnabled(false);
		setBackground(new Color(100, 149, 237));
		setBorder(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setFrameIcon(new ImageIcon(PanelSalary.class.getResource("/image/kisspng-dr-d-y-patil-college-of-engineering.png")));
		setBounds(0, 0, 740, 668);
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setBounds(479, 599, 253, 32);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName(" Print Component ");

				pj.setPrintable (new Printable() {    
					public int print(Graphics pg, PageFormat pf, int pageNum){
						if (pageNum > 0){
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						panel.paint(g2);
						return Printable.PAGE_EXISTS;
					}
				});
				if (pj.printDialog() == false)
					return;

				try {
					pj.print();
				} catch (PrinterException ex) {
					// handle exception
				}


			}
		});
		getContentPane().setLayout(null);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton_1.setBackground(new Color(46, 61, 176));
		getContentPane().add(btnNewButton_1);


		JButton btnClose = new JButton("Close");
		btnClose.setBounds(7, 599, 264, 32);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMonthlySalaryEmployee.panelPaySlip.setVisible(false);
				PanelMonthlySalaryEmployee.btnGenerateSalary.setVisible(true);
			}
		});
		btnClose.setBackground(new Color(46, 61, 176,255));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setFont(new Font("Arial Black", Font.PLAIN, 20));
		getContentPane().add(btnClose);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 5, 725, 584);
		getContentPane().add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		txtNInfinityInfo = new JTextField();
		txtNInfinityInfo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtNInfinityInfo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtNInfinityInfo.setHorizontalAlignment(SwingConstants.CENTER);
		txtNInfinityInfo.setText("N INFINITY INFO SOLUTIONS");
		txtNInfinityInfo.setBounds(10, 10, 703, 28);
		panel.add(txtNInfinityInfo);
		txtNInfinityInfo.setColumns(10);
		
		LocalDate currentDate = LocalDate.now();
		int year = currentDate.getYear();
		
		Month month = currentDate.getMonth();
		String monthName = month.toString();
		
		txtPaySlipFor = new JTextField();
		txtPaySlipFor.setText("PAY SLIP FOR " + monthName + " " + year);
		txtPaySlipFor.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaySlipFor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		txtPaySlipFor.setColumns(10);
		txtPaySlipFor.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtPaySlipFor.setBounds(10, 36, 703, 28);
		panel.add(txtPaySlipFor);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 74, 55, 13);
		panel.add(lblNewLabel);
		
		JLabel lblDesgination = new JLabel("Desgination :");
		lblDesgination.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDesgination.setBounds(20, 97, 107, 13);
		panel.add(lblDesgination);
		
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblLocation.setBounds(20, 120, 78, 13);
		panel.add(lblLocation);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDepartment.setBounds(354, 74, 107, 13);
		panel.add(lblDepartment);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bank Name :");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(354, 97, 100, 13);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bank Acc No :");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(354, 120, 119, 13);
		panel.add(lblNewLabel_1_2);
		
		txtEarnings = new JTextField();
		txtEarnings.setText("Earnings");
		txtEarnings.setHorizontalAlignment(SwingConstants.CENTER);
		txtEarnings.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txtEarnings.setColumns(10);
		txtEarnings.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtEarnings.setBounds(10, 175, 317, 28);
		panel.add(txtEarnings);
		
		txtSNo = new JTextField();
		txtSNo.setText("S No");
		txtSNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSNo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtSNo.setColumns(10);
		txtSNo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtSNo.setBounds(10, 199, 64, 28);
		panel.add(txtSNo);
		
		txtSalaryHead = new JTextField();
		txtSalaryHead.setText("Salary Head");
		txtSalaryHead.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalaryHead.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtSalaryHead.setColumns(10);
		txtSalaryHead.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtSalaryHead.setBounds(71, 199, 164, 28);
		panel.add(txtSalaryHead);
		
		txtAmount = new JTextField();
		txtAmount.setText("Amount");
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtAmount.setColumns(10);
		txtAmount.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtAmount.setBounds(227, 199, 100, 28);
		panel.add(txtAmount);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField.setBounds(10, 220, 64, 28);
		panel.add(textField);
		
		txtBasic = new JTextField();
		txtBasic.setText("Basic");
		txtBasic.setHorizontalAlignment(SwingConstants.CENTER);
		txtBasic.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtBasic.setColumns(10);
		txtBasic.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtBasic.setBounds(71, 220, 164, 28);
		panel.add(txtBasic);
		
		textField_1 = new JTextField();
		textField_1.setText("2");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_1.setBounds(10, 242, 64, 28);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("3");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_2.setBounds(10, 264, 64, 28);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("4");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_3.setBounds(10, 286, 64, 28);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("5");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_4.setBounds(10, 308, 64, 28);
		panel.add(textField_4);
		
		txtDearnessAllowance = new JTextField();
		txtDearnessAllowance.setText("Dearness Allowance");
		txtDearnessAllowance.setHorizontalAlignment(SwingConstants.CENTER);
		txtDearnessAllowance.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtDearnessAllowance.setColumns(10);
		txtDearnessAllowance.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtDearnessAllowance.setBounds(71, 242, 164, 28);
		panel.add(txtDearnessAllowance);
		
		txtHouseRentAllowance = new JTextField();
		txtHouseRentAllowance.setText("House Rent Allowance");
		txtHouseRentAllowance.setHorizontalAlignment(SwingConstants.CENTER);
		txtHouseRentAllowance.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtHouseRentAllowance.setColumns(10);
		txtHouseRentAllowance.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtHouseRentAllowance.setBounds(71, 264, 164, 28);
		panel.add(txtHouseRentAllowance);
		
		txtMedicalAllowance = new JTextField();
		txtMedicalAllowance.setText("Medical Allowance");
		txtMedicalAllowance.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicalAllowance.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMedicalAllowance.setColumns(10);
		txtMedicalAllowance.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtMedicalAllowance.setBounds(71, 286, 164, 28);
		panel.add(txtMedicalAllowance);
		
		txtTravelAllowance = new JTextField();
		txtTravelAllowance.setText("Travel Allowance");
		txtTravelAllowance.setHorizontalAlignment(SwingConstants.CENTER);
		txtTravelAllowance.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTravelAllowance.setColumns(10);
		txtTravelAllowance.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTravelAllowance.setBounds(71, 308, 164, 28);
		panel.add(txtTravelAllowance);
		
		txtBasicSalary = new JTextField();
		txtBasicSalary.setHorizontalAlignment(SwingConstants.CENTER);
		txtBasicSalary.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtBasicSalary.setColumns(10);
		txtBasicSalary.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtBasicSalary.setBounds(227, 220, 100, 28);
		panel.add(txtBasicSalary);
		
		txtDA = new JTextField();
		txtDA.setHorizontalAlignment(SwingConstants.CENTER);
		txtDA.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtDA.setColumns(10);
		txtDA.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtDA.setBounds(227, 242, 100, 28);
		panel.add(txtDA);
		
		txtHRA = new JTextField();
		txtHRA.setHorizontalAlignment(SwingConstants.CENTER);
		txtHRA.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtHRA.setColumns(10);
		txtHRA.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtHRA.setBounds(227, 264, 100, 28);
		panel.add(txtHRA);
		
		txtMed = new JTextField();
		txtMed.setHorizontalAlignment(SwingConstants.CENTER);
		txtMed.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMed.setColumns(10);
		txtMed.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtMed.setBounds(227, 286, 100, 28);
		panel.add(txtMed);
		
		txtTravel = new JTextField();
		txtTravel.setHorizontalAlignment(SwingConstants.CENTER);
		txtTravel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTravel.setColumns(10);
		txtTravel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTravel.setBounds(227, 308, 100, 28);
		panel.add(txtTravel);
		
		txtDeductions = new JTextField();
		txtDeductions.setText("Deductions");
		txtDeductions.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeductions.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txtDeductions.setColumns(10);
		txtDeductions.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtDeductions.setBounds(396, 175, 317, 28);
		panel.add(txtDeductions);
		
		textField_10 = new JTextField();
		textField_10.setText("S No");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_10.setColumns(10);
		textField_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_10.setBounds(396, 199, 64, 28);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("1");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_11.setColumns(10);
		textField_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_11.setBounds(396, 220, 64, 28);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("2");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_12.setColumns(10);
		textField_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_12.setBounds(396, 242, 64, 28);
		panel.add(textField_12);
		
		textField_16 = new JTextField();
		textField_16.setText("Salary Head");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_16.setColumns(10);
		textField_16.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_16.setBounds(456, 199, 164, 28);
		panel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("Amount");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_17.setColumns(10);
		textField_17.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_17.setBounds(613, 199, 100, 28);
		panel.add(textField_17);
		
		txtTaxDeductedAt = new JTextField();
		txtTaxDeductedAt.setText("Tax Deducted At Source");
		txtTaxDeductedAt.setHorizontalAlignment(SwingConstants.CENTER);
		txtTaxDeductedAt.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtTaxDeductedAt.setColumns(10);
		txtTaxDeductedAt.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTaxDeductedAt.setBounds(456, 220, 164, 28);
		panel.add(txtTaxDeductedAt);
		
		txtMedicalAllowDeduction = new JTextField();
		txtMedicalAllowDeduction.setText("Med Allow Deduction");
		txtMedicalAllowDeduction.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedicalAllowDeduction.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMedicalAllowDeduction.setColumns(10);
		txtMedicalAllowDeduction.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtMedicalAllowDeduction.setBounds(456, 242, 164, 28);
		panel.add(txtMedicalAllowDeduction);
		
		txtTax = new JTextField();
		txtTax.setHorizontalAlignment(SwingConstants.CENTER);
		txtTax.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTax.setColumns(10);
		txtTax.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTax.setBounds(613, 220, 100, 28);
		panel.add(txtTax);
		
		txtMedclaim = new JTextField();
		txtMedclaim.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedclaim.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtMedclaim.setColumns(10);
		txtMedclaim.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtMedclaim.setBounds(613, 242, 100, 28);
		panel.add(txtMedclaim);
		
		txtTotalDeductions = new JTextField();
		txtTotalDeductions.setText("TOTAL DEDUCTION");
		txtTotalDeductions.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDeductions.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTotalDeductions.setColumns(10);
		txtTotalDeductions.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtTotalDeductions.setBounds(396, 330, 192, 28);
		panel.add(txtTotalDeductions);
		
		txtDeduction = new JTextField();
		txtDeduction.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeduction.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtDeduction.setColumns(10);
		txtDeduction.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtDeduction.setBounds(582, 330, 131, 28);
		panel.add(txtDeduction);
		
		txtSalary = new JTextField();
		txtSalary.setText("SALARY (GROSS)/ PM");
		txtSalary.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalary.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtSalary.setColumns(10);
		txtSalary.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtSalary.setBounds(10, 372, 192, 28);
		panel.add(txtSalary);
		
		txtGrossSalary = new JTextField();
		txtGrossSalary.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrossSalary.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtGrossSalary.setColumns(10);
		txtGrossSalary.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtGrossSalary.setBounds(196, 372, 131, 28);
		panel.add(txtGrossSalary);
		
		txtSalary_1 = new JTextField();
		txtSalary_1.setText("NET SALARY");
		txtSalary_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalary_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtSalary_1.setColumns(10);
		txtSalary_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtSalary_1.setBounds(10, 426, 192, 28);
		panel.add(txtSalary_1);
		
		txtNetSalary = new JTextField();
		txtNetSalary.setHorizontalAlignment(SwingConstants.CENTER);
		txtNetSalary.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtNetSalary.setColumns(10);
		txtNetSalary.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtNetSalary.setBounds(196, 426, 131, 28);
		panel.add(txtNetSalary);
		
		lblNewLabel_1 = new JLabel("Reimbursement");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(11, 408, 107, 13);
		panel.add(lblNewLabel_1);
		
		txtDate = new JTextField();
		txtDate.setText("DATE");
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtDate.setColumns(10);
		txtDate.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtDate.setBounds(10, 479, 119, 28);
		panel.add(txtDate);
		
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-YYY");
		String formattedDate = currentDate.format(formatter);
		textField_19 = new JTextField();
		textField_19.setText(formattedDate);
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_19.setColumns(10);
		textField_19.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_19.setBounds(126, 479, 201, 28);
		panel.add(textField_19);
		
		lblName = new JLabel("Ashish Ajay Mandke");
		lblName.setForeground(new Color(122, 122, 122));
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblName.setBounds(142, 74, 180, 13);
		panel.add(lblName);
		
		lblDesignation = new JLabel("SDE II");
		lblDesignation.setForeground(new Color(122, 122, 122));
		lblDesignation.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDesignation.setBounds(142, 99, 180, 13);
		panel.add(lblDesignation);
		
		lblPlace = new JLabel("Pune");
		lblPlace.setForeground(new Color(122, 122, 122));
		lblPlace.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPlace.setBounds(142, 122, 180, 13);
		panel.add(lblPlace);
		
		lblDept = new JLabel("Mechanical Engg");
		lblDept.setForeground(new Color(122, 122, 122));
		lblDept.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblDept.setBounds(474, 74, 239, 13);
		panel.add(lblDept);
		
		lblBnk = new JLabel("HDFC, PUNE");
		lblBnk.setForeground(new Color(122, 122, 122));
		lblBnk.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblBnk.setBounds(474, 97, 180, 13);
		panel.add(lblBnk);
		
		lblBankNum = new JLabel("xxxxXXX");
		lblBankNum.setForeground(new Color(122, 122, 122));
		lblBankNum.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblBankNum.setBounds(474, 122, 180, 13);
		panel.add(lblBankNum);
		
		lblNInifnityInfo = new JLabel("N Inifnity Info Solutions");
		lblNInifnityInfo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNInifnityInfo.setBounds(501, 532, 201, 13);
		panel.add(lblNInifnityInfo);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Ashish Mandke\\OneDrive\\Desktop\\ninfinity Stamp 200.png"));
		lblNewLabel_2.setBounds(479, 346, 200, 200);
		panel.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setText("3");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textField_5.setBounds(396, 264, 64, 28);
		panel.add(textField_5);
		
		txtUnpaidLeaves_1 = new JTextField();
		txtUnpaidLeaves_1.setText("Unpaid Leaves");
		txtUnpaidLeaves_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnpaidLeaves_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtUnpaidLeaves_1.setColumns(10);
		txtUnpaidLeaves_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtUnpaidLeaves_1.setBounds(456, 264, 164, 28);
		panel.add(txtUnpaidLeaves_1);
		
		txtUnpaidLeaves = new JTextField();
		txtUnpaidLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnpaidLeaves.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtUnpaidLeaves.setColumns(10);
		txtUnpaidLeaves.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtUnpaidLeaves.setBounds(613, 264, 100, 28);
		panel.add(txtUnpaidLeaves);


		MySQLConection mysql = new MySQLConection();

		uid = Integer.toString(PanelSalaryEmployee.empId);
		ResultSet resultSet  = mysql.getSalary(uid);


		try {
			while(resultSet.next()) {
				
				//float att =  Float.parseFloat(resultSet2.getString("present"))+Float.parseFloat(resultSet3.getString("present1"));

				/*	GrosstextField_3.setText(resultSet.getString("grosssalary"));
						NettextField_4.setText(resultSet.getString("netsalary"));
						float tot = Float.parseFloat(MedtextField_6.getText())+Float.parseFloat(TravelltextField_8.getText());
						TotaltextField_7.setText(Float.toString(tot));
						float tot1 = Float.parseFloat(HRtextField_4.getText())+Float.parseFloat(DAtextField_5.getText())+ Float.parseFloat(LeavetextField_9.getText());
						TotaltextField_11.setText(Float.toString(tot1));
						float net = Float.parseFloat(GrosstextField_3.getText())-(Float.parseFloat(MedtextField_6.getText())+Float.parseFloat(TravelltextField_8.getText()) +  Float.parseFloat(HRtextField_4.getText())+Float.parseFloat(DAtextField_5.getText()));
						NettextField_4.setText(Float.toString(net)); */
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
			e1.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------------------------------------------------");



	}
}
