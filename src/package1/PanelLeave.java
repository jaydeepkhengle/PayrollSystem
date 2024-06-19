package package1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelLeave extends JPanel {
	private JTextField txtLeaveApplications;
	private JTextField panelDeclinetext;
	private JTextField panelapprovedtext;
	private JTextField reasontext;
	private JPanel panel_4 ;
	int ID, empId, numberOfDays;
	String  name,date,days,reason,status;
	private JTextField txtEmpId;
	private JTextField txtFromDate;
	private JTextField txtToDate;
	private JTextField txtName; 
	private JTextArea txtReason ;
	private JTextField txtNumberOfDays;
	private JTextField txtBalancedLeaves;
	private JLabel leaveBalanceWarning;

	/**
	 * Create the panel.
	 */
	public PanelLeave() {
		setBounds(0,0,1255, 656);
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 0, 1255, 47);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel LeaveLabel = new JLabel("Leave");
		LeaveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LeaveLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		LeaveLabel .setForeground(Color.WHITE);
		LeaveLabel.setBackground(Color.WHITE);
		LeaveLabel.setBounds(505, 0, 210, 38);
		panel_1.add(LeaveLabel);

		MySQLConection mysql = new MySQLConection();

		panel_4 = new JPanel(); 		
		panel_4.setBorder(new LineBorder(new Color(222, 222, 222)));
		panel_4.setBounds(20, 208, 1235, 413);
		panel_4.setVisible(false);
		panel_4.setBackground(new Color(255, 255, 255));
		add(panel_4);
		panel_4.setLayout(null);

		JButton Approvedbutton = new JButton("APPROVE");
		Approvedbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mySql = new MySQLConection();
				empId = Integer.parseInt(txtEmpId.getText());
				numberOfDays = Integer.parseInt(txtNumberOfDays.getText());
				int result= mySql.getStatusApproved(empId, numberOfDays);
				try {
					if (result==1) {
						JOptionPane.showMessageDialog(null, "Leave Application is Approved");
						ResultSet resultSet = mySql.numberOfApprovedLeaveApplication();
						try {	
							while(resultSet.next()) {

								panelapprovedtext.setText(resultSet.getString("rowCount"));

							}
						} 
						catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
						}
						resultSet = mySql.numberOfPendingLeaveApplications();
						while(resultSet.next()) {
							txtLeaveApplications.setText(Integer.toString(resultSet.getInt("rowCount")));
						}
						Thread.sleep(1000);
						txtEmpId.setText("");
						txtName.setText(null);
						txtFromDate.setText(null);
						txtToDate.setText(null);
						txtNumberOfDays.setText(null);
						txtReason.setText(null);
						txtBalancedLeaves.setText(null);

					} 
					else {

						JOptionPane.showMessageDialog(null, "Leave Application is Failed");	
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Database error:" +  ( e2.getMessage()));
				}
			}
		});
		Approvedbutton .setBackground(new Color(0, 210, 0));
		Approvedbutton.setForeground(Color.WHITE);
		Approvedbutton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		Approvedbutton.setBounds(331, 355, 140, 40);
		panel_4.add(Approvedbutton);

		JLabel lblNewLabel_2 = new JLabel("From Date :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(20, 85, 131, 43);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("No. of Days : ");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_1.setBounds(20, 210, 152, 43);
		panel_4.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Reason :");
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_2.setBounds(516, 85, 119, 43);
		panel_4.add(lblNewLabel_2_2);

		JButton declineButton = new JButton("DECLINE");
		declineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mySql = new MySQLConection();
				empId = Integer.parseInt(txtEmpId.getText());

				int result= mySql.getStatusDeclined(empId);
				try {
					if (result==1) {
						JOptionPane.showMessageDialog(null, "Leave Application is Declined");
						ResultSet resultSet1 = mySql.numberOfRejectedLeaveApplication();
						try {	
							while(resultSet1.next()) {
								panelDeclinetext.setText(resultSet1.getString("rowCount"));
							}
						} 
						catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
						}
						ResultSet resultSet = mySql.numberOfPendingLeaveApplications();
						while(resultSet.next()) {
							txtLeaveApplications.setText(Integer.toString(resultSet.getInt("rowCount")));
						}
						Thread.sleep(1000);
						txtEmpId.setText("");
						txtName.setText(null);
						txtFromDate.setText(null);
						txtToDate.setText(null);
						txtNumberOfDays.setText(null);
						txtReason.setText(null);
						txtBalancedLeaves.setText(null);

					} else {

						JOptionPane.showMessageDialog(null, "Failed");	
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Database error:" +  ( e2.getMessage()));
				}	


			}
		});
		declineButton.setBackground(new Color(255, 0, 0));
		declineButton.setForeground(Color.WHITE);
		declineButton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		declineButton.setBounds(122, 355, 140, 40);
		panel_4.add(declineButton);

		JLabel lblNewLabel_2_3 = new JLabel("Employee Id : ");
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_3.setBounds(20, 23, 152, 43);
		panel_4.add(lblNewLabel_2_3);

		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mysql = new MySQLConection();
				ResultSet resultSet = mysql.leaveDataSearch(Integer.parseInt(txtEmpId.getText()));
				try {

					resultSet.first();
					txtEmpId.setText(resultSet.getString("employee_id"));
					txtName.setText(resultSet.getString("name"));
					txtFromDate.setForeground(Color.BLACK);
					txtToDate.setForeground(Color.BLACK);
					txtFromDate.setText(resultSet.getString("from_date"));
					txtToDate.setText(resultSet.getString("to_date"));
					txtNumberOfDays.setText(resultSet.getString("number_of_days"));
					txtReason.setText(resultSet.getString("reason"));
					txtBalancedLeaves.setText(resultSet.getString("Balance_leaves"));


				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Database error:" +  ( e1.getMessage()));
					e1.printStackTrace();
				}


			}


		});
		btnNewButton .setBackground(new Color(46, 61, 176));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnNewButton.setBounds(1065, 144, 160, 40);
		panel_4.add(btnNewButton);

		JLabel lblNewLabel_2_3_1 = new JLabel("Name :");
		lblNewLabel_2_3_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_3_1.setBounds(516, 23, 87, 43);
		panel_4.add(lblNewLabel_2_3_1);

		JButton NEXTbutton_1 = new JButton("NEXT");
		NEXTbutton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLConection mysql = new MySQLConection();
				ResultSet resultSet = mysql.leaveData();

				String nextCheck = txtEmpId.getText();
				try {

					if(!resultSet.isLast()) {

						while(resultSet.next()) {

							txtEmpId.setText(resultSet.getString("employee_Id"));
							txtName.setText(resultSet.getString("name"));
							txtFromDate.setForeground(Color.BLACK);
							txtToDate.setForeground(Color.BLACK);
							txtFromDate.setText(resultSet.getString("from_date"));
							txtToDate.setText(resultSet.getString("to_date"));
							txtNumberOfDays.setText(resultSet.getString("Number_Of_Days"));
							txtReason.setText(resultSet.getString("reason"));
							txtBalancedLeaves.setText(resultSet.getString("Balance_leaves"));
							int balanceLeaves = Integer.parseInt(txtBalancedLeaves.getText());
							int numberOdDays = Integer.parseInt(txtNumberOfDays.getText());
							if(balanceLeaves<numberOdDays) {
								leaveBalanceWarning.setVisible(true);
							}

						}
					}


				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Database error:" +  ( e2.getMessage()));
				}
				if(txtEmpId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No Pending Leaves", "Leave Pending Status", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(nextCheck.equals(txtEmpId.getText()) && !txtEmpId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Proccess The Current Leave Application To Continue With The Next", "Leave Application", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		NEXTbutton_1.setForeground(Color.WHITE);
		NEXTbutton_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		NEXTbutton_1.setBackground(new Color(46, 61, 176));
		NEXTbutton_1.setBounds(1065, 51, 160, 40);
		panel_4.add(NEXTbutton_1);

		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtEmpId.setText("");
				txtName.setText(null);
				txtFromDate.setText(null);
				txtToDate.setText(null);
				txtBalancedLeaves.setText(null);
				txtNumberOfDays.setText(null);
				txtReason.setText(null);
				txtEmpId.setText(null);

			}



		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnClear.setBackground(new Color(46, 61, 176));
		btnClear.setBounds(812, 355, 140, 40);
		panel_4.add(btnClear);

		JButton btnExit = new JButton("BACK");
		btnExit.setBounds(1065, 355, 160, 40);
		panel_4.add(btnExit);
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

		JLabel lblNewLabel_2_4 = new JLabel("To Date :");
		lblNewLabel_2_4.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_4.setBounds(20, 143, 103, 43);
		panel_4.add(lblNewLabel_2_4);

		txtEmpId = new JTextField();
		txtEmpId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmpId.setColumns(10);
		txtEmpId.setBackground(new Color(222, 222, 222));
		txtEmpId.setBounds(175, 32, 252, 27);
		panel_4.add(txtEmpId);

		txtFromDate = new JTextField();
		txtFromDate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtFromDate.setForeground(Color.GRAY);
		txtFromDate.setText("dd/mm/yyyy");
		txtFromDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFromDate.getText().equals("dd/mm/yyyy")) {
					txtFromDate.setForeground(Color.BLACK);
					txtFromDate.setText(null);
				}
			}
		});
		txtFromDate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtFromDate.setColumns(10);
		txtFromDate.setBackground(new Color(222, 222, 222));
		txtFromDate.setBounds(175, 94, 252, 27);
		panel_4.add(txtFromDate);

		txtToDate = new JTextField();
		txtToDate.setForeground(Color.GRAY);
		txtToDate.setText("dd/mm/yyyy");
		txtToDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtToDate.getText().equals("dd/mm/yyyy")) {
					txtToDate.setForeground(Color.BLACK);
					txtToDate.setText(null);
				}
			}
		});
		txtToDate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtToDate.setColumns(10);
		txtToDate.setBackground(new Color(222, 222, 222));
		txtToDate.setBounds(175, 152, 252, 27);
		panel_4.add(txtToDate);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBackground(new Color(222, 222, 222));
		txtName.setBounds(684, 32, 252, 27);
		panel_4.add(txtName);

		txtReason = new JTextArea();
		txtReason.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReason.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtReason.setBackground(new Color(222, 222, 222));
		txtReason.setBounds(684, 91, 252, 87);
		panel_4.add(txtReason);

		txtNumberOfDays = new JTextField();
		txtNumberOfDays.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtNumberOfDays.setColumns(10);
		txtNumberOfDays.setBackground(new Color(222, 222, 222));
		txtNumberOfDays.setBounds(175, 219, 252, 27);
		panel_4.add(txtNumberOfDays);

		JLabel lblNewLabel_2_1_1 = new JLabel("Balanced Leaves :");
		lblNewLabel_2_1_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_1_1.setBounds(516, 210, 199, 43);
		panel_4.add(lblNewLabel_2_1_1);

		txtBalancedLeaves = new JTextField();
		txtBalancedLeaves.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtBalancedLeaves.setColumns(10);
		txtBalancedLeaves.setBackground(new Color(222, 222, 222));
		txtBalancedLeaves.setBounds(812, 219, 124, 27);
		panel_4.add(txtBalancedLeaves);

		leaveBalanceWarning = new JLabel("Employee is short on leave");
		leaveBalanceWarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
		leaveBalanceWarning.setForeground(new Color(255, 0, 0));
		leaveBalanceWarning.setHorizontalAlignment(SwingConstants.CENTER);
		leaveBalanceWarning.setBounds(204, 299, 199, 27);
		panel_4.add(leaveBalanceWarning);
		leaveBalanceWarning.setVisible(false);





		JPanel panel = new JPanel();
		panel.setBounds(23, 57, 278, 146);
		add(panel);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(true);




			}
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(0, 139, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(46, 61, 176,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setBackground(new Color(46, 61, 176,255));
			}
		});
		panel.setBackground(new Color(46, 61, 176,255));
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 45, 278, 17);
		panel.add(separator);

		JLabel lblNewLabel = new JLabel("Leave Application");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 0, 258, 44);
		panel.add(lblNewLabel);

		txtLeaveApplications = new JTextField();
		txtLeaveApplications.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeaveApplications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(true);
			}


		});
		txtLeaveApplications.setEditable(false);
		txtLeaveApplications.setBorder(null);
		txtLeaveApplications.setForeground(Color.WHITE);
		txtLeaveApplications.setBackground(new Color(46, 61, 176,255));
		txtLeaveApplications.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 40));
		txtLeaveApplications.setText("");
		txtLeaveApplications.setBounds(29, 50, 220, 68);
		panel.add(txtLeaveApplications);
		txtLeaveApplications.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Click Here");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 110, 258, 36);
		panel.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(348, 57, 278, 146);
		add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(46, 61, 176));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 45, 278, 17);
		panel_2.add(separator_1);

		JLabel lblApproved = new JLabel("Approved");
		lblApproved.setHorizontalAlignment(SwingConstants.CENTER);
		lblApproved.setForeground(Color.WHITE);
		lblApproved.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblApproved.setBounds(54, 0, 174, 44);
		panel_2.add(lblApproved);

		panelapprovedtext = new JTextField();
		panelapprovedtext.setHorizontalAlignment(SwingConstants.CENTER);
		panelapprovedtext.setEditable(false);
		panelapprovedtext.setBorder(null);
		panelapprovedtext.setForeground(Color.WHITE);
		panelapprovedtext.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 40));
		panelapprovedtext.setColumns(10);
		panelapprovedtext.setBackground(new Color(46, 61, 176));
		panelapprovedtext.setBounds(28, 54, 222, 82);
		panel_2.add(panelapprovedtext);
		ResultSet resultSet0 = mysql.numberOfApprovedLeaveApplication();
		try {	
			while(resultSet0.next()) {
				panelapprovedtext.setText(resultSet0.getString("rowCount"));

			}
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
		}

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(681, 57, 278, 146);
		add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(46, 61, 176));

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 45, 278, 17);
		panel_3.add(separator_2);

		JLabel lblDecline = new JLabel("Decline");
		lblDecline.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecline.setForeground(Color.WHITE);
		lblDecline.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblDecline.setBounds(54, 0, 174, 44);
		panel_3.add(lblDecline);

		panelDeclinetext = new JTextField();
		panelDeclinetext.setHorizontalAlignment(SwingConstants.CENTER);
		panelDeclinetext.setEditable(false);
		panelDeclinetext.setBorder(null);
		panelDeclinetext.setForeground(Color.WHITE);
		panelDeclinetext.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 40));
		panelDeclinetext.setColumns(10);
		panelDeclinetext.setBackground(new Color(46, 61, 176));
		panelDeclinetext.setBounds(40, 54, 198, 82);
		panel_3.add(panelDeclinetext);
		ResultSet resultSet1 = mysql.numberOfRejectedLeaveApplication();
		try {	
			while(resultSet1.next()) {
				panelDeclinetext.setText(resultSet1.getString("rowCount"));
			}
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
		}

		JButton BACkbutton = new JButton("CLOSE");
		BACkbutton.setBounds(1085, 57, 160, 40);
		add(BACkbutton);
		BACkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_4.setVisible(false);;
			}
		});
		BACkbutton.setBackground(new Color(46, 61, 176));
		BACkbutton.setForeground(Color.WHITE);
		BACkbutton.setFont(new Font("Arial Black", Font.PLAIN, 19));

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

		ResultSet resultSet2 = mysql.numberOfPendingLeaveApplications();
		try {	
			while(resultSet2.next()) {
				txtLeaveApplications.setText(resultSet2.getString("rowCount"));
			}
		} 
		catch (Exception e1) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));// TODO: handle exception
		}


	}

	private void panelMethod() {
		// TODO Auto-generated method stub

	}
}

