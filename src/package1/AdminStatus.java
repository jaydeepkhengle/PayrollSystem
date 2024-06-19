package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Insets;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class AdminStatus extends JPanel {
	String uid,name,date,days,reason,status;
	private JTextField leavetextField;
	private JTextField approvedtextField;
	private JTextField rejectedtextField;
	private JTextField totalEmptextField;

	/**
	 * Create the panel.
	 */
	public AdminStatus() {
		setBorder(null);
		setVisible(false);
		setBounds(0,0,1255, 658);
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1255, 55);
		panel_1.setBackground(new Color(255, 0, 0));
		add(panel_1);
		panel_1.setLayout(null);

		JLabel AddEmpLabel = new JLabel("Welcome To Admin Login");
		AddEmpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AddEmpLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		AddEmpLabel.setForeground(Color.WHITE);
		AddEmpLabel.setBackground(Color.WHITE);
		AddEmpLabel.setBounds(220, 0, 810, 55);
		panel_1.add(AddEmpLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 61, 176,255));
		panel.setBounds(82, 95, 281, 161);
		add(panel);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 56, 281, 7);
		panel.add(separator);

		JLabel lblNewLabel = new JLabel("New Leave");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(36, 0, 209, 54);
		panel.add(lblNewLabel);

		leavetextField = new JTextField();
		leavetextField.setHorizontalAlignment(SwingConstants.CENTER);
		leavetextField.setForeground(new Color(255, 255, 255));
		leavetextField.setBorder(null);
		leavetextField.setMargin(new Insets(0, 0, 0, 0));
		leavetextField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 60));
		leavetextField.setEditable(false);
		leavetextField.setBackground(new Color(46, 61, 176,255));
		leavetextField.setBounds(36, 68, 209, 83);
		panel.add(leavetextField);
		leavetextField.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(46, 61, 176));
		panel_2.setBounds(485, 95, 281, 161);
		add(panel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 56, 281, 7);
		panel_2.add(separator_1);

		approvedtextField = new JTextField();
		approvedtextField.setHorizontalAlignment(SwingConstants.CENTER);
		approvedtextField.setForeground(new Color(255, 255, 255));
		approvedtextField.setMargin(new Insets(0, 0, 0, 0));
		approvedtextField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 60));
		approvedtextField.setEditable(false);
		approvedtextField.setColumns(10);
		approvedtextField.setBorder(null);
		approvedtextField.setBackground(new Color(46, 61, 176));
		approvedtextField.setBounds(46, 68, 199, 83);
		panel_2.add(approvedtextField);

		JLabel lblLeaveApproved = new JLabel("Leave Approved");
		lblLeaveApproved.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveApproved.setForeground(Color.WHITE);
		lblLeaveApproved.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblLeaveApproved.setBounds(30, 0, 220, 54);
		panel_2.add(lblLeaveApproved);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(46, 61, 176));
		panel_3.setBounds(82, 371, 281, 161);
		add(panel_3);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 56, 281, 7);
		panel_3.add(separator_2);

		rejectedtextField = new JTextField();
		rejectedtextField.setHorizontalAlignment(SwingConstants.CENTER);
		rejectedtextField.setForeground(new Color(255, 255, 255));
		rejectedtextField.setMargin(new Insets(0, 0, 0, 0));
		rejectedtextField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 60));
		rejectedtextField.setEditable(false);
		rejectedtextField.setColumns(10);
		rejectedtextField.setBorder(null);
		rejectedtextField.setBackground(new Color(46, 61, 176));
		rejectedtextField.setBounds(36, 68, 209, 83);
		panel_3.add(rejectedtextField);

		JLabel lblLeaveRejected = new JLabel("Leave Rejected");
		lblLeaveRejected.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveRejected.setForeground(Color.WHITE);
		lblLeaveRejected.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblLeaveRejected.setBounds(29, 0, 222, 54);
		panel_3.add(lblLeaveRejected);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(46, 61, 176));
		panel_4.setBounds(485, 371, 281, 161);
		add(panel_4);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 56, 281, 7);
		panel_4.add(separator_3);

		totalEmptextField = new JTextField();
		totalEmptextField.setHorizontalAlignment(SwingConstants.CENTER);
		totalEmptextField.setForeground(new Color(255, 255, 255));
		totalEmptextField.setMargin(new Insets(0, 0, 0, 0));
		totalEmptextField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 60));
		totalEmptextField.setEditable(false);
		totalEmptextField.setColumns(10);
		totalEmptextField.setBorder(null);
		totalEmptextField.setBackground(new Color(46, 61, 176));
		totalEmptextField.setBounds(36, 68, 209, 83);
		panel_4.add(totalEmptextField);

		JLabel lblTotalEmployee = new JLabel("Total Employee");
		lblTotalEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalEmployee.setForeground(Color.WHITE);
		lblTotalEmployee.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTotalEmployee.setBounds(36, 0, 220, 54);
		panel_4.add(lblTotalEmployee);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminStatus.class.getResource("/image/453-4535976_leave-management-icon-hd-png-download-removebg-preview.png")));
		lblNewLabel_1.setBounds(789, 95, 389, 437);
		add(lblNewLabel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 0, 0));
		panel_1_1.setBounds(0, 633, 1255, 25);
		add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(451, 0, 353, 20);
		panel_1_1.add(lblNewLabel_2);


		MySQLConection mysql = new MySQLConection();
		ResultSet resultSet = mysql.numberOfApprovedLeaveApplication();
		try {	
			while(resultSet.next()) {
				approvedtextField.setText(resultSet.getString("rowCount"));
			}
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
		}

		resultSet = mysql.numberOfRejectedLeaveApplication();
		try {	
			while(resultSet.next()) {
				rejectedtextField.setText(resultSet.getString("rowCount"));
			}
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
		}


		resultSet = mysql.numberOfPendingLeaveApplications();
		try {	
			while(resultSet.next()) {
				leavetextField.setText(resultSet.getString("rowcount"));
			}
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
		}

		resultSet = mysql.getRowCount(); 
		try {
			while(resultSet.next()) {

				totalEmptextField.setText(resultSet.getString("count"));

			}
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));

		}
	}
}
