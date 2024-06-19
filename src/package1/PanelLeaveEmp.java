package package1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.management.relation.Relation;
import javax.swing.ImageIcon;

public class PanelLeaveEmp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel3 ;
	private JPanel panelLeaveStatus ;
	private JSpinner noDaysSpinner;
	private JCalendar calendarFromDate, calendarToDate; 
	private JTextField txtEmployeeId;
	private JTextField txtName;
	private JTextField txtFromDate;
	private JTextField txtToDate;
	private JTextField txtNoOfDays;
	private JTextField txtStatus;
	private JTextField txtAllocatedLeaves;
	private JTextField txtBalanceLeaves;
	private JTextField txtUsedLeaves;
	private JTextField txtUnpaidLeaves;
	private JTextField txtTotalleavesTaken;
	private JTextArea txtReason;
	private int empId, allocatedLeaves,  balanceLeaves, usedLeaves, unpaidLeaves, totalLeavesTaken;
	private String name, fromDate, toDate, reason, noOfDays, status;



	public PanelLeaveEmp() {


		setBounds(0, 0, 1255, 656);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setVisible(true);

		JPanel pnlLeaveStats = new JPanel();
		pnlLeaveStats.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlLeaveStats.setBackground(new Color(255, 255, 255));
		pnlLeaveStats.setBounds(338, 57, 907, 566);
		add(pnlLeaveStats);
		pnlLeaveStats.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(46, 61, 176));
		panel_2.setBounds(78, 10, 278, 146);
		pnlLeaveStats.add(panel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 45, 278, 17);
		panel_2.add(separator_1);

		JLabel lblApproved = new JLabel("Allocated Leaves");
		lblApproved.setHorizontalAlignment(SwingConstants.CENTER);
		lblApproved.setForeground(Color.WHITE);
		lblApproved.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblApproved.setBounds(40, 0, 198, 44);
		panel_2.add(lblApproved);



		ResultSet result = new MySQLConection().getEmployeeId(MainLogin.username);
		try {
			while(result.next()) {
				empId = result.getInt("employee_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MySQLConection mySql = new MySQLConection();
		result = null;
		result = mySql.getleaveStats(empId);

		//= mySql.getleaveStats();
		try {
			while(result.next()) {
				allocatedLeaves = result.getInt("allocated_leaves");
				balanceLeaves = result.getInt("balance_leaves");
				usedLeaves = result.getInt("used_leaves");
				unpaidLeaves = result.getInt("unpaid_leaves");
				totalLeavesTaken = result.getInt("total_leaves_taken");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtAllocatedLeaves = new JTextField();
		txtAllocatedLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		txtAllocatedLeaves.setForeground(Color.WHITE);
		txtAllocatedLeaves.setFont(new Font("Dialog", Font.PLAIN, 40));
		txtAllocatedLeaves.setEditable(false);
		txtAllocatedLeaves.setColumns(10);
		txtAllocatedLeaves.setBorder(null);
		txtAllocatedLeaves.setBackground(new Color(46, 61, 176));
		txtAllocatedLeaves.setBounds(28, 54, 222, 82);
		txtAllocatedLeaves.setText(Integer.toString(allocatedLeaves));
		panel_2.add(txtAllocatedLeaves);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(46, 61, 176));
		panel_2_1.setBounds(526, 10, 278, 146);
		pnlLeaveStats.add(panel_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 45, 278, 17);
		panel_2_1.add(separator_1_1);

		JLabel lblUsedLeaves = new JLabel("Balance Leaves");
		lblUsedLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsedLeaves.setForeground(Color.WHITE);
		lblUsedLeaves.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblUsedLeaves.setBounds(54, 0, 174, 44);
		panel_2_1.add(lblUsedLeaves);

		txtBalanceLeaves = new JTextField();
		txtBalanceLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalanceLeaves.setForeground(Color.WHITE);
		txtBalanceLeaves.setFont(new Font("Dialog", Font.PLAIN, 40));
		txtBalanceLeaves.setEditable(false);
		txtBalanceLeaves.setColumns(10);
		txtBalanceLeaves.setBorder(null);
		txtBalanceLeaves.setBackground(new Color(46, 61, 176));
		txtBalanceLeaves.setBounds(28, 54, 222, 82);
		txtBalanceLeaves.setText(Integer.toString(balanceLeaves));
		panel_2_1.add(txtBalanceLeaves);

		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(46, 61, 176));
		panel_2_2.setBounds(78, 216, 278, 146);
		pnlLeaveStats.add(panel_2_2);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(0, 45, 278, 17);
		panel_2_2.add(separator_1_2);

		JLabel lblUnpaidLeaves = new JLabel("Used Leaves");
		lblUnpaidLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnpaidLeaves.setForeground(Color.WHITE);
		lblUnpaidLeaves.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblUnpaidLeaves.setBounds(54, 0, 174, 44);
		panel_2_2.add(lblUnpaidLeaves);

		txtUsedLeaves = new JTextField();
		txtUsedLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsedLeaves.setForeground(Color.WHITE);
		txtUsedLeaves.setFont(new Font("Dialog", Font.PLAIN, 40));
		txtUsedLeaves.setEditable(false);
		txtUsedLeaves.setColumns(10);
		txtUsedLeaves.setBorder(null);
		txtUsedLeaves.setBackground(new Color(46, 61, 176));
		txtUsedLeaves.setBounds(28, 54, 222, 82);
		txtUsedLeaves.setText(Integer.toString(usedLeaves));
		panel_2_2.add(txtUsedLeaves);

		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBackground(new Color(46, 61, 176));
		panel_2_3.setBounds(526, 216, 278, 146);
		pnlLeaveStats.add(panel_2_3);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(0, 45, 278, 17);
		panel_2_3.add(separator_1_3);

		JLabel lblUnpaidLeaves_1 = new JLabel("Unpaid Leaves");
		lblUnpaidLeaves_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnpaidLeaves_1.setForeground(Color.WHITE);
		lblUnpaidLeaves_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblUnpaidLeaves_1.setBounds(54, 0, 174, 44);
		panel_2_3.add(lblUnpaidLeaves_1);

		txtUnpaidLeaves = new JTextField();
		txtUnpaidLeaves.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnpaidLeaves.setForeground(Color.WHITE);
		txtUnpaidLeaves.setFont(new Font("Dialog", Font.PLAIN, 40));
		txtUnpaidLeaves.setEditable(false);
		txtUnpaidLeaves.setColumns(10);
		txtUnpaidLeaves.setBorder(null);
		txtUnpaidLeaves.setBackground(new Color(46, 61, 176));
		txtUnpaidLeaves.setBounds(28, 54, 222, 82);
		txtUnpaidLeaves.setText(Integer.toString(unpaidLeaves));
		panel_2_3.add(txtUnpaidLeaves);

		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBackground(new Color(46, 61, 176));
		panel_2_4.setBounds(303, 391, 278, 146);
		pnlLeaveStats.add(panel_2_4);

		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(0, 45, 278, 17);
		panel_2_4.add(separator_1_4);

		JLabel lblTotalLeavesTaken = new JLabel("Total Leaves Taken");
		lblTotalLeavesTaken.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalLeavesTaken.setForeground(Color.WHITE);
		lblTotalLeavesTaken.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblTotalLeavesTaken.setBounds(30, 0, 218, 44);
		panel_2_4.add(lblTotalLeavesTaken);

		txtTotalleavesTaken = new JTextField();
		txtTotalleavesTaken.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalleavesTaken.setForeground(Color.WHITE);
		txtTotalleavesTaken.setFont(new Font("Dialog", Font.PLAIN, 40));
		txtTotalleavesTaken.setEditable(false);
		txtTotalleavesTaken.setColumns(10);
		txtTotalleavesTaken.setBorder(null);
		txtTotalleavesTaken.setBackground(new Color(46, 61, 176));
		txtTotalleavesTaken.setBounds(28, 54, 222, 82);
		txtTotalleavesTaken.setText(Integer.toString(totalLeavesTaken));
		panel_2_4.add(txtTotalleavesTaken);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1255, 47);
		panel.setBackground(new Color(255, 0, 0));
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Leave");
		lblNewLabel .setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel .setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel .setForeground(Color.WHITE);
		lblNewLabel .setBackground(Color.WHITE);
		lblNewLabel .setBounds(505, 0, 210, 38);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				panel3.setVisible(true);
				panelLeaveStatus.setVisible(false);
				pnlLeaveStats.setVisible(false);

			}
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(0, 139, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(46, 61, 176,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_1.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_1.setBackground(new Color(46, 61, 176,255));
			}
		});
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(46, 61, 176));
		panel_1.setBounds(34, 57, 281, 44);
		add(panel_1);

		JLabel applyleave = new JLabel("APPLY LEAVE");
		applyleave.setHorizontalAlignment(SwingConstants.CENTER);
		applyleave.setForeground(Color.WHITE);
		applyleave.setFont(new Font("Arial Black", Font.PLAIN, 19));
		applyleave.setBounds(36, 0, 209, 44);
		panel_1.add(applyleave);

		JPanel panelStatus = new JPanel();
		panelStatus.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				panel3.setVisible(false);
				panelLeaveStatus.setVisible(true);
				pnlLeaveStats.setVisible(false);
				MySQLConection mySql = new MySQLConection();
				System.out.println("---------" + empId + "---------");
				ResultSet resultSet = mySql.getApplyLeaveData(empId);

				try {
					while(resultSet.next()) {
						txtEmployeeId.setText(Integer.toString(empId));
						txtName.setText(resultSet.getString("name"));
						txtFromDate.setText(resultSet.getString("from_date"));
						txtToDate.setText(resultSet.getString("to_date"));
						txtNoOfDays.setText(resultSet.getString("number_of_days"));
						String status = (resultSet.getString("status"));
						if(status.equals("")) {
							txtStatus.setText("Pending");
						}
						else {
							txtStatus.setText(status);
						}
						txtReason.setText(resultSet.getString("reason"));


					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			public void mouseEntered(MouseEvent e) {
				panelStatus.setBackground(new Color(0, 139, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelStatus.setBackground(new Color(46, 61, 176,255));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panelStatus.setBackground(new Color(60, 179, 113));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelStatus.setBackground(new Color(46, 61, 176,255));
			}
		});

		panelStatus.setLayout(null);
		panelStatus.setBackground(new Color(46, 61, 176));
		panelStatus.setBounds(34, 124, 281, 44);
		add(panelStatus);

		JLabel lblNewLabel_4_1 = new JLabel("STATUS");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_4_1.setBounds(36, 0, 209, 44);
		panelStatus.add(lblNewLabel_4_1);

		panelLeaveStatus = new JPanel();
		panelLeaveStatus.setBorder(new LineBorder(new Color(0, 0, 0)));

		panelLeaveStatus.setBackground(new Color(255, 255, 255));
		panelLeaveStatus.setBounds(338, 57, 907, 436);
		add(panelLeaveStatus);
		panelLeaveStatus.setVisible(false);
		panelLeaveStatus.setLayout(null);

		JButton NewButton_1_1_2 = new JButton("CLOSE");
		NewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLeaveStatus.setVisible(false);
				pnlLeaveStats.setVisible(true);

			}
		});
		NewButton_1_1_2.setForeground(Color.WHITE);
		NewButton_1_1_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		NewButton_1_1_2.setBackground(new Color(46, 61, 176));
		NewButton_1_1_2.setBounds(318, 358, 281, 39);
		panelLeaveStatus.add(NewButton_1_1_2);

		txtEmployeeId = new JTextField();
		txtEmployeeId.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBackground(new Color(222, 222, 222));
		txtEmployeeId.setBounds(197, 81, 252, 27);
		panelLeaveStatus.add(txtEmployeeId);

		JLabel lblNewLabel_2_3_1 = new JLabel("Employee Id : ");
		lblNewLabel_2_3_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_3_1.setBounds(21, 72, 152, 43);
		panelLeaveStatus.add(lblNewLabel_2_3_1);

		txtName = new JTextField();
		txtName.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBackground(new Color(222, 222, 222));
		txtName.setBounds(627, 81, 252, 27);
		panelLeaveStatus.add(txtName);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("Name :");
		lblNewLabel_2_3_1_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_3_1_1.setBounds(505, 72, 89, 43);
		panelLeaveStatus.add(lblNewLabel_2_3_1_1);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("From Date :");
		lblNewLabel_2_3_1_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_3_1_2.setBounds(21, 132, 152, 43);
		panelLeaveStatus.add(lblNewLabel_2_3_1_2);

		txtFromDate = new JTextField();
		txtFromDate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtFromDate.setColumns(10);
		txtFromDate.setBackground(new Color(222, 222, 222));
		txtFromDate.setBounds(197, 141, 252, 27);
		panelLeaveStatus.add(txtFromDate);

		txtToDate = new JTextField();
		txtToDate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtToDate.setColumns(10);
		txtToDate.setBackground(new Color(222, 222, 222));
		txtToDate.setBounds(197, 209, 252, 27);
		panelLeaveStatus.add(txtToDate);

		JLabel lblNewLabel_2_3_1_2_1 = new JLabel("To Date :");
		lblNewLabel_2_3_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_3_1_2_1.setBounds(21, 200, 152, 43);
		panelLeaveStatus.add(lblNewLabel_2_3_1_2_1);

		txtReason = new JTextArea();
		txtReason.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtReason.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReason.setBackground(new Color(222, 222, 222));
		txtReason.setBounds(627, 143, 252, 93);
		panelLeaveStatus.add(txtReason);

		JLabel lblNewLabel_2_2 = new JLabel("Reason :");
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_2.setBounds(498, 132, 119, 43);
		panelLeaveStatus.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("No of Days :");
		lblNewLabel_2_2_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_2_1.setBounds(20, 270, 153, 43);
		panelLeaveStatus.add(lblNewLabel_2_2_1);

		txtNoOfDays = new JTextField();
		txtNoOfDays.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtNoOfDays.setColumns(10);
		txtNoOfDays.setBackground(new Color(222, 222, 222));
		txtNoOfDays.setBounds(197, 279, 252, 27);
		panelLeaveStatus.add(txtNoOfDays);

		JLabel lblNewLabel_2_2_2 = new JLabel("Status :");
		lblNewLabel_2_2_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblNewLabel_2_2_2.setBounds(498, 270, 119, 43);
		panelLeaveStatus.add(lblNewLabel_2_2_2);

		txtStatus = new JTextField();
		txtStatus.setFont(new Font("Arial Black", Font.PLAIN, 15));
		txtStatus.setColumns(10);
		txtStatus.setBackground(new Color(222, 222, 222));
		txtStatus.setBounds(627, 279, 252, 27);
		panelLeaveStatus.add(txtStatus);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(46, 61, 176));
		panel_4.setBounds(0, 0, 907, 47);
		panelLeaveStatus.add(panel_4);

		JLabel lblNewLabel_2 = new JLabel("Leave Status");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(348, 4, 210, 38);
		panel_4.add(lblNewLabel_2);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(Color.RED);
		panel_1_1_1.setBounds(0, 633, 1255, 25);
		add(panel_1_1_1);

		JLabel lblNewLabel_2_5 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2_5.setBounds(451, 0, 353, 20);
		panel_1_1_1.add(lblNewLabel_2_5);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(34, 273, 281, 201);
		add(panel_1_2);
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(46, 61, 176));

		JLabel lblLeaveStats = new JLabel("Leave Stats");
		lblLeaveStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveStats.setForeground(Color.WHITE);
		lblLeaveStats.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblLeaveStats.setBounds(36, 0, 209, 47);
		panel_1_2.add(lblLeaveStats);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 42, 355, 17);
		panel_1_2.add(separator);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Balance Leaves : ");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setBounds(20, 57, 194, 33);
		panel_1_2.add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));

		JLabel txtBalance = new JLabel("");
		txtBalance.setBounds(232, 57, 39, 33);
		panel_1_2.add(txtBalance);
		txtBalance.setForeground(new Color(255, 255, 255));
		txtBalance.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtBalance.setText(Integer.toString(balanceLeaves));

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Used Leaves : ");
		lblNewLabel_1_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_2.setBounds(20, 100, 167, 33);
		panel_1_2.add(lblNewLabel_1_1_1_1_2);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Arial Black", Font.PLAIN, 20));

		JLabel txtUsed = new JLabel("");
		txtUsed.setBounds(232, 100, 39, 33);
		panel_1_2.add(txtUsed);
		txtUsed.setForeground(new Color(255, 255, 255));
		txtUsed.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtUsed.setText(Integer.toString(usedLeaves));

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Unpaid Leaves :");
		lblNewLabel_1_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_2_1.setBounds(20, 143, 194, 33);
		panel_1_2.add(lblNewLabel_1_1_1_1_2_1);

		JLabel txtUnpaid = new JLabel("");
		txtUnpaid.setForeground(Color.WHITE);
		txtUnpaid.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtUnpaid.setBounds(232, 143, 39, 33);
		txtUnpaid.setText(Integer.toString(unpaidLeaves));
		panel_1_2.add(txtUnpaid);

		try {
			while(result.next()) {
				txtBalance.setText(result.getString("balance_leaves"));
				txtUsed.setText(result.getString("used_leaves"));
				txtUnpaid.setText(result.getString("unpaid_leaves"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JButton CloseNewButton_1_1 = new JButton("BACK");
		CloseNewButton_1_1.setBounds(34, 558, 281, 39);
		add(CloseNewButton_1_1);
		CloseNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMyAccountEmp panelMyAccountEmp = new PanelMyAccountEmp();
				panelMyAccountEmp.setVisible(true);
				EmployeeHomePage.contentpanel.add(panelMyAccountEmp );
				setVisible(false);


			}
		});
		CloseNewButton_1_1.setForeground(Color.WHITE);
		CloseNewButton_1_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		CloseNewButton_1_1.setBackground(new Color(46, 61, 176));

		panel3 = new JPanel();
		panel3.setBounds(338, 57, 907, 566);
		add(panel3);
		panel3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel3.setBackground(new Color(255, 255, 255));
		panel3.setVisible(false);
		panel3.setLayout(null); 

		JLabel lblNewLabel_1_1 = new JLabel("From Date ");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(21, 75, 146, 33);
		panel3.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("No. of Days ");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(21, 276, 146, 33);
		panel3.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("Reason");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(21, 354, 139, 33);
		panel3.add(lblNewLabel_3);


		noDaysSpinner = new JSpinner();
		noDaysSpinner.setBackground(new Color(100, 149, 237));
		noDaysSpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		noDaysSpinner.setBounds(177, 280, 271, 33);
		panel3.add(noDaysSpinner);

		JTextArea txtReasonApplyLeave = new JTextArea();
		txtReasonApplyLeave.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReasonApplyLeave.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		txtReasonApplyLeave.setBackground(new Color(255, 255, 255));
		txtReasonApplyLeave.setBounds(177, 351, 271, 100);
		panel3.add(txtReasonApplyLeave);

		JButton btnNewButton = new JButton("APPLY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MySQLConection mySql = new MySQLConection();
				ResultSet result = mySql.pendingLeaveCheck(empId);
				int rowCount = 1;
				try {
					while(result.next()) {
						rowCount = result.getInt("rowCount");
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(rowCount==0) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					fromDate = sdf.format(calendarFromDate.getDate());
					toDate = sdf.format(calendarToDate.getDate());
					noOfDays = noDaysSpinner.getValue().toString();
					reason = txtReasonApplyLeave.getText(); 
					
					int status = mySql.applyLeave(empId, fromDate, toDate,Integer.parseInt(noOfDays), reason) ;
					try {
						
						if(status==1) {
							JOptionPane.showMessageDialog(null, "Successfully Applied");
						}else {
							JOptionPane.showMessageDialog(null, "Failed to  Apply");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Cant't Apply New Leave Because Previous Leave Application Is Pending", "Leave Application Failure", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnNewButton.setBackground(new Color(46, 61, 176));
		btnNewButton.setBounds(639, 502, 258, 39);
		panel3.add(btnNewButton);

		JButton CloseNewButton_1 = new JButton("CLEAR");
		CloseNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				noDaysSpinner.setValue(1);
			    txtReasonApplyLeave.setText(null);		

			}
		});
		CloseNewButton_1.setForeground(Color.WHITE);
		CloseNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 19));
		CloseNewButton_1.setBackground(new Color(46, 61, 176));
		CloseNewButton_1.setBounds(337, 502, 258, 39);
		panel3.add(CloseNewButton_1);

		JButton BackButton_1_2 = new JButton("CLOSE");
		BackButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(false);
				pnlLeaveStats.setVisible(true);
			}
		});
		BackButton_1_2.setForeground(Color.WHITE);
		BackButton_1_2.setFont(new Font("Arial Black", Font.PLAIN, 19));
		BackButton_1_2.setBackground(new Color(46, 61, 176));
		BackButton_1_2.setBounds(39, 502, 258, 39);
		panel3.add(BackButton_1_2);



		JLabel lblNewLabel_1_1_1 = new JLabel("To Date");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(481, 75, 93, 33);
		panel3.add(lblNewLabel_1_1_1);

		calendarFromDate = new JCalendar();
		calendarFromDate.setBounds(175, 75, 271, 152);
		panel3.add(calendarFromDate);

		calendarToDate = new JCalendar();
		calendarToDate.setBounds(610, 75, 271, 152);
		panel3.add(calendarToDate);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ashish Mandke\\OneDrive\\Desktop\\man-back-with-travel-suitcase-and-backpack-icon-vector-28092220.jpg"));
		lblNewLabel_1.setBounds(586, 237, 300, 274);
		panel3.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(46, 61, 176));
		panel_3.setBounds(0, 0, 907, 47);
		panel3.add(panel_3);

		JLabel lblLeaveApplication = new JLabel("Leave Application");
		lblLeaveApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaveApplication.setForeground(Color.WHITE);
		lblLeaveApplication.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblLeaveApplication.setBackground(Color.WHITE);
		lblLeaveApplication.setBounds(348, 4, 210, 38);
		panel_3.add(lblLeaveApplication);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 196, 281, 2);
		add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(34, 231, 281, 2);
		add(separator_3);
		setVisible(true);

	}
}
