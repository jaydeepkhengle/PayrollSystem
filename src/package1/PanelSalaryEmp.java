package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSalaryEmp extends JPanel {
	private JTable table;
	String uid, Name,department,bank,leave,HR, DA,Med,Leave,travell,grosssalary,Netsalary,leaveday,date ;
	private JTextField BanktextField;
	private JTextField grosstextField_1;
	private JTextField DeductionField_2;
	private JTextField AllowancetextField_3;
	private JTextField NettextField_4;
	static JPanel panel_1;
	private JButton btnExit;
	private JPanel panel_1_1;
	private JLabel lblNewLabel_1;
	/**
	 * Create the panel.
	 */
	public  PanelSalaryEmp() {
		setBounds(0, 0, 1255, 656);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1255, 47);
		panel.setBackground(new Color(255, 0, 0));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Salary");
		lblNewLabel .setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel .setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel .setForeground(Color.WHITE);
		lblNewLabel .setBackground(Color.WHITE);
		lblNewLabel .setBounds(505, 0, 210, 38);
		panel.add(lblNewLabel);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(605, 47, 650, 582);
		panel_1.setLayout(null); 
		add(panel_1);
		panel_1.setVisible(false);
		
		
		
		table = new JTable();
		table.setOpaque(false);
		table.setVerifyInputWhenFocusTarget(false);
		table.setUpdateSelectionOnSort(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setFocusable(false);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setSelectionForeground(new Color(0, 139, 139));
		table.setIntercellSpacing(new Dimension(3, 3));
		table.setGridColor(Color.BLUE);
		table.setBounds(new Rectangle(0, 0, 0, 40));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSize(new Dimension(0, 20));
		table.setRowHeight(60);
		table.setBackground(Color.CYAN);
		
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Bank", "Salary", "Deduction", "Allowance", "Netpay", "SalaryReciept"},
				},
				new String[] {
					"Bank", "GrossSalary", "Deduction", "Allowance", "NetPay", "SalaryReciept"
				}
			));
	
		
		
		
	//	table.getColumnModel().getColumn(5).setPreferredWidth(74);
		//table.getColumnModel().getColumn(5).setMinWidth(16);
		table.setFont(new Font("Arial Black", Font.PLAIN, 20));
		table.setBounds(0, 253, 1255, 60);
		add(table);
		
		BanktextField = new JTextField();
		BanktextField.setBorder(null);
		BanktextField.setHorizontalAlignment(SwingConstants.CENTER);
		BanktextField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		BanktextField.setBackground(Color.CYAN);
		BanktextField.setBounds(-1, 314, 207, 53);
		add(BanktextField);
		BanktextField.setColumns(10);
		
		grosstextField_1 = new JTextField();
		grosstextField_1.setBorder(null);
		grosstextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		grosstextField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		grosstextField_1.setColumns(10);
		grosstextField_1.setBackground(Color.CYAN);
		grosstextField_1.setBounds(209, 314, 208, 53);
		add(grosstextField_1);
		
		DeductionField_2 = new JTextField();
		DeductionField_2.setBorder(null);
		DeductionField_2.setHorizontalAlignment(SwingConstants.CENTER);
		DeductionField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		DeductionField_2.setColumns(10);
		DeductionField_2.setBackground(Color.CYAN);
		DeductionField_2.setBounds(420, 314, 206, 53);
		add(DeductionField_2);
		
		AllowancetextField_3 = new JTextField();
		AllowancetextField_3.setBorder(null);
		AllowancetextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		AllowancetextField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AllowancetextField_3.setColumns(10);
		AllowancetextField_3.setBackground(Color.CYAN);
		AllowancetextField_3.setBounds(629, 314, 206, 53);
		add(AllowancetextField_3);
		
		NettextField_4 = new JTextField();
		NettextField_4.setBorder(null);
		NettextField_4.setHorizontalAlignment(SwingConstants.CENTER);
		NettextField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		NettextField_4.setColumns(10);
		NettextField_4.setBackground(Color.CYAN);
		NettextField_4.setBounds(838, 314, 206, 53);
		add(NettextField_4);
		
		JButton btnNewButton_1 = new JButton("CLICK HERE");
		btnNewButton_1.setBounds(1047, 314, 205, 53);
		add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(0, 0, 205));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					panel_1.setVisible(true);
					//PaySlip1 paySlip1 = new PaySlip1();
				//	paySlip1.setVisible(true);
					//panel_1.add(paySlip1);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.CYAN);
		
		btnExit = new JButton("BACK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMyAccountEmp panelMyAccountEmp = new PanelMyAccountEmp();
				panelMyAccountEmp.setVisible(true);
				EmployeeHomePage.contentpanel.add(panelMyAccountEmp );
				setVisible(false);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btnExit.setBackground(new Color(46, 61, 176));
		btnExit.setBounds(28, 567, 271, 36);
		add(btnExit);
		
		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(0, 631, 1255, 25);
		add(panel_1_1);
		
		lblNewLabel_1 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(451, 0, 353, 20);
		panel_1_1.add(lblNewLabel_1);
		
		
		MySQLConection mysql = new MySQLConection();
		uid = MainLogin.username;
		ResultSet resultSet  = mysql.getSalary(uid);
		
		
			try {
				while(resultSet.next()) {
					
					
		
						BanktextField.setText(resultSet.getString("Bank"));
						DeductionField_2.setText(resultSet.getString("Leave"));
						grosstextField_1 .setText(resultSet.getString("grosssalary"));
						NettextField_4.setText(resultSet.getString("netsalary"));
						float tot = Float.parseFloat(resultSet.getString("med"))+Float.parseFloat(resultSet.getString("travell"))+Float.parseFloat(resultSet.getString("hr"))+Float.parseFloat(resultSet.getString("da"));
						AllowancetextField_3.setText(Float.toString(tot));
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
				e1.printStackTrace();
			}
		System.out.println("--------------------------------------------------------------------------------------------------------");
	
		
	} 
}
