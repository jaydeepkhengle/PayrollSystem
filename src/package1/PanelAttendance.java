package package1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PanelAttendance extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField UIDtextField;
	private JTextField NametextField_1;
	JDateChooser dateChooser;
	Date date;
	String firstHalf,SecondHalf;
	//java.sql.Date date;
	String uid ,passwordStr,password,Name,gender,address,state,city ,pincode,mobile,Degree,Designation,Department,Bank,email,Salary,Usertype,deduction ,allowance ,salary ;

	/**
	 * Create the panel.
	 */
	public PanelAttendance() {
		setBounds(0,0,1255, 656);
		setBackground(new Color(146,189,213,252));
		setVisible(true);
		setLayout(null);



		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 61, 176,255));
		panel_1.setBounds(0, 0, 1255, 47);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel SalaryReportLabel = new JLabel("Attendence");
		SalaryReportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SalaryReportLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		SalaryReportLabel.setForeground(Color.WHITE);
		SalaryReportLabel.setBackground(Color.WHITE);
		SalaryReportLabel.setBounds(505, 0, 210, 38);
		panel_1.add(SalaryReportLabel);

		UIDtextField = new JTextField();
		UIDtextField.setBorder(null);
		UIDtextField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		UIDtextField.setBackground(new Color(100, 149, 237));
		UIDtextField.setBounds(388, 83, 287, 38);
		add(UIDtextField);
		UIDtextField.setColumns(10);

		NametextField_1 = new JTextField();
		NametextField_1.setEditable(false);
		NametextField_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		NametextField_1.setColumns(10);
		NametextField_1.setBorder(null);
		NametextField_1.setBackground(new Color(100, 149, 237));
		NametextField_1.setBounds(388, 246, 287, 38);
		add(NametextField_1);

		JComboBox firstcomboBox = new JComboBox();
		firstcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Present", "Absent", "leave"}));
		firstcomboBox.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		firstcomboBox.setBackground(new Color(100, 149, 237));
		firstcomboBox.setBounds(384, 419, 291, 38);
		add(firstcomboBox);

		JComboBox secondcomboBox_1 = new JComboBox();
		secondcomboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Present", "Absent", "leave"}));
		secondcomboBox_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		secondcomboBox_1.setBackground(new Color(100, 149, 237));
		secondcomboBox_1.setBounds(384, 526, 291, 38);
		add(secondcomboBox_1);

		JButton UploadbtnNewButton = new JButton("UPLOAD");
		UploadbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				firstHalf =(String) firstcomboBox.getSelectedItem();
				SecondHalf = (String) secondcomboBox_1.getSelectedItem();
				date =  dateChooser.getDate();
				MySQLConection mysql = new MySQLConection();

				uid = UIDtextField.getText();

				int status = mysql.uploadattendence(uid, Name, firstHalf, SecondHalf, date);
				try {


					if(status==1) {
						JOptionPane.showMessageDialog(null, "Successfully Updated1");
					}else {
						JOptionPane.showMessageDialog(null, "Failed to  Update1");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog( null, "Database error:" +  ( e2.getMessage()));
				}

			}

		});
		UploadbtnNewButton.setForeground(new Color(255, 255, 255));
		UploadbtnNewButton.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		UploadbtnNewButton.setBackground(new Color(46, 61, 176,255));
		UploadbtnNewButton.setBounds(962, 594, 271, 38);
		add(UploadbtnNewButton);

		JLabel lblNewLabel = new JLabel("UID                    :");
		lblNewLabel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		lblNewLabel.setBounds(124, 82, 223, 38);
		add(lblNewLabel);

		JLabel lblFirstHalf = new JLabel("First half             :");
		lblFirstHalf.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		lblFirstHalf.setBounds(141, 419, 233, 38);
		add(lblFirstHalf);

		JLabel lblName = new JLabel("Name                  :");
		lblName.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		lblName.setBounds(124, 245, 233, 38);
		add(lblName);

		JLabel lblSecondHalf = new JLabel("Second half          :");
		lblSecondHalf.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		lblSecondHalf.setBounds(134, 524, 223, 38);
		add(lblSecondHalf);

		JButton UploadbtnNewButton_1 = new JButton("SEARCH");
		UploadbtnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {





				MySQLConection mysql = new MySQLConection();
				uid = UIDtextField.getText();
				ResultSet resultSet  = mysql.getRow(10); // Hard Coded For Temp Error Resolutions


				try {

					while(resultSet.next()) {

						NametextField_1.setText(resultSet.getString("name"));

					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
					e1.printStackTrace();
				}
			}
		});
		UploadbtnNewButton_1.setForeground(Color.WHITE);
		UploadbtnNewButton_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		UploadbtnNewButton_1.setBackground(new Color(46, 61, 176));
		UploadbtnNewButton_1.setBounds(897, 82, 271, 38);
		add(UploadbtnNewButton_1);

		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(100, 149, 237));
		dateChooser.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		dateChooser.setBounds(388, 331, 287, 38);
		add(dateChooser);

		JLabel lblDate = new JLabel("Date                   :");
		lblDate.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		lblDate.setBounds(141, 331, 223, 38);
		add(lblDate);

		JSeparator separator = new JSeparator();
		separator.setBounds(59, 163, 1156, 8);
		add(separator);

		JButton tnNewButton_2 = new JButton("BACK");
		tnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminStatus adminStatus = new AdminStatus();
				adminStatus.setVisible(true);
				HomePage.PanelContentpanel.add(adminStatus);
				setVisible(false);
			}
		});
		tnNewButton_2.setForeground(Color.WHITE);
		tnNewButton_2.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		tnNewButton_2.setBackground(new Color(46, 61, 176));
		tnNewButton_2.setBounds(124, 594, 271, 38);
		add(tnNewButton_2);

		JButton nNewButton_2 = new JButton("CLEAR");
		nNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIDtextField.setText(null);
				NametextField_1.setText(null);
			}
		});
		nNewButton_2.setForeground(Color.WHITE);
		nNewButton_2.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 30));
		nNewButton_2.setBackground(new Color(46, 61, 176));
		nNewButton_2.setBounds(539, 594, 271, 38);
		add(nNewButton_2);
	}
}
