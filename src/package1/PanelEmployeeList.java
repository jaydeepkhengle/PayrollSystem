package package1;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class PanelEmployeeList extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelEmployeeList() {
	
		setBounds(0,0,1257, 656);
		setBackground(new Color(255, 255, 255));
		setLayout(null);


		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1255, 47);
		panel_1.setBackground(new Color(255, 0, 0));
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel EmpListLabel = new JLabel("Employee List");
		EmpListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		EmpListLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		 EmpListLabel.setForeground(Color.WHITE);
		 EmpListLabel.setBackground(Color.WHITE);
		 EmpListLabel.setBounds(505, 0, 210, 38);
		panel_1.add(EmpListLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(313, 645, 932, -527);
		add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(453, 174, -304, 149);
		add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Employee List Table");
		lblNewLabel.setBounds(425, 57, 356, 57);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 28));
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(415, 174, 717, -31);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(39, 113, 1179, 5);
		add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setEnabled(false);
		scrollPane.setAutoscrolls(true);
		scrollPane.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		scrollPane.setViewportBorder(null);
		scrollPane.setForeground(Color.BLUE);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setBounds(11, 137, 1235, 360);
		scrollPane.setForeground(getBackground());
		scrollPane.setBackground(new Color(192, 192, 192));
		add(scrollPane);
		
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(511, 400));
		table.setOpaque(false);
		table.setRowHeight(20);
		table.	setBackground(new Color(192, 192, 192));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sr no.", "UID", "name", "gender", "address", "state", "city", "pincode", "mobile", "Degree", "Designation", "Department", "email", "Bank Account", "salary"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(132);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(115);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(45);
		table.getColumnModel().getColumn(7).setPreferredWidth(35);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(60);
		table.getColumnModel().getColumn(10).setPreferredWidth(74);
		table.getColumnModel().getColumn(11).setPreferredWidth(70);
		table.getColumnModel().getColumn(12).setPreferredWidth(109);
		table.getColumnModel().getColumn(13).setPreferredWidth(90);
		table.getColumnModel().getColumn(14).setPreferredWidth(90);
		scrollPane.setViewportView(table);
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 19));
		btnNewButton.setBackground(new Color(46, 61, 176,255));
		btnNewButton.setBounds(753, 522, 321, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MySQLConection mysql = new MySQLConection();
				ResultSet resultSet = mysql.getTable();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String [] columnNames = {"Sr no.","Emp Id", "UID", "Name","Gender", "Address", "State", "City", "Pincode", "Mobile_No", "Degree", "Designation", "Department", "Bank", "Email", "salary"};
				model.setColumnIdentifiers(columnNames);
				model.setRowCount(0);
				try {
					while(resultSet.next()) {
						model.addRow(new Object [] {
								resultSet.getString(1),
								resultSet.getString(2),
								resultSet.getString(3),
								resultSet.getString(5),
								resultSet.getString(6),
								resultSet.getString(7),
								resultSet.getString(8),
								resultSet.getString(9),
								resultSet.getString(10),
								resultSet.getString(11),
								resultSet.getString(12),
								resultSet.getString(13),
								resultSet.getString(14),
								resultSet.getString(15),
								resultSet.getString(16),
								resultSet.getString(17)
								
						});
					}		
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog( null, "Database error:" +  ( e1.getMessage()));
				}
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				System.out.println("succeefully builded");
		
				
					
				
			}
			
			
			
		});
		add(btnNewButton);
		
		JButton Button = new JButton("BACK");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminStatus adminStatus = new AdminStatus();
				adminStatus.setVisible(true);
				HomePage.PanelContentpanel.add(adminStatus);
				setVisible(false);
			}
		});
		Button.setForeground(Color.WHITE);
		Button.setFont(new Font("Arial Black", Font.PLAIN, 19));
		Button.setBackground(new Color(46, 61, 176));
		Button.setBounds(250, 524, 321, 27);
		add(Button);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 0, 0));
		panel_1_1.setBounds(0, 631, 1255, 25);
		add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(449, 0, 353, 20);
		panel_1_1.add(lblNewLabel_2);
		
		
		
	}
}
