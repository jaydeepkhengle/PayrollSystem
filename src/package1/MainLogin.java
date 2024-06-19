package package1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JPasswordField;
import javax.swing.JComboBox;


import javax.swing.DefaultComboBoxModel;
	
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainLogin {

	//protected static final String Radio = null;
	private JFrame frameNInfi;
	static  JTextField txtUsername;
	private JPasswordField pwdEnterThePassword;
	private JComboBox comboBoxSelectUser;
	private Connection con;
	public static String username;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin window = new MainLogin();
					window.frameNInfi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameNInfi = new JFrame();
		frameNInfi.setIconImage(Toolkit.getDefaultToolkit().getImage(MainLogin.class.getResource("/image/NInfinityLogo.jpeg")));
		frameNInfi.setTitle("N Infinity Info Solutions");
		frameNInfi.getContentPane().setBackground(new Color(255, 0, 0));
		frameNInfi.setForeground(new Color(72, 209, 204));
		frameNInfi.setEnabled(true);
		frameNInfi.setBackground(new Color(46, 61, 176,255));
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		frameNInfi.setSize(width,height);
		frameNInfi.getContentPane().setLayout(null);
		frameNInfi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(2, 5, 1517, 155);
		panel.setBackground(new Color(255, 255, 255));
		frameNInfi.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel paySystemLogo = new JLabel("");
		paySystemLogo.setFont(new Font("Arial Black", Font.PLAIN, 20));
		paySystemLogo .setIcon(new ImageIcon(HomePage.class.getResource("/image/Untitled1_20220225174414.png")));
		paySystemLogo .setBounds(-4, -7, 1525, 150);
		panel.add(paySystemLogo);

		JSeparator separator = new JSeparator();
		separator.setBounds(-10, 150, 1537, 9);
		panel.add(separator);
		separator.setBackground(new Color(46, 61, 176,255));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(146,189,213,252));
		panel_1.setBounds(2, 167, 1517, 620);
		frameNInfi.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(738, 141, 316, 436);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(27, 158, 178, -21);
		panel_2.add(separator_1);

		JLabel lblSelectUser = new JLabel("Select User");
		lblSelectUser.setBounds(10, 182, 112, 36);
		panel_2.add(lblSelectUser);
		lblSelectUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectUser.setFont(new Font("Georgia", Font.BOLD, 17));

		comboBoxSelectUser = new JComboBox();
		comboBoxSelectUser.setBounds(132, 183, 162, 31);
		panel_2.add(comboBoxSelectUser);
		comboBoxSelectUser.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Employee"}));
		comboBoxSelectUser.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
		comboBoxSelectUser.setBackground(new Color(255, 255, 255));
		comboBoxSelectUser.setForeground(new Color(0, 0, 0));

		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1.setFont(new Font("Georgia", Font.BOLD, 17));
		lblUsername_1.setBounds(10, 243, 112, 36);
		panel_2.add(lblUsername_1);

		JLabel lblUsername_1_1 = new JLabel("Password");
		lblUsername_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1_1.setFont(new Font("Georgia", Font.BOLD, 17));
		lblUsername_1_1.setBounds(10, 306, 112, 36);
		panel_2.add(lblUsername_1_1);

		pwdEnterThePassword = new JPasswordField();
		pwdEnterThePassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwdEnterThePassword.setText(null);
				pwdEnterThePassword.setForeground(Color.BLACK);
				pwdEnterThePassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
				pwdEnterThePassword.setEchoChar('\u2022');
			}
			public void focusLost(FocusEvent e) {
				if(pwdEnterThePassword.getText().equals("")) {
					pwdEnterThePassword.setEchoChar((char)0);
					pwdEnterThePassword.setForeground(Color.GRAY);
					pwdEnterThePassword.setText("password");
				}
			}
		});
		pwdEnterThePassword.setBounds(132, 307, 162, 31);
		panel_2.add(pwdEnterThePassword);
		pwdEnterThePassword.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
		pwdEnterThePassword.setForeground(Color.GRAY);
		pwdEnterThePassword.setEchoChar((char)0);
		pwdEnterThePassword.setText("password");
		pwdEnterThePassword.setToolTipText("Enter the Password");


		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsername.setText(null);
				txtUsername.setForeground(Color.BLACK);
				txtUsername.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
			}
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setForeground(Color.GRAY);
					txtUsername.setText("username");
				}
			}
		});
		txtUsername.setBounds(132, 246, 162, 31);

		panel_2.add(txtUsername);

		txtUsername.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
		txtUsername.setText("username");
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setColumns(10);


		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(27, 374, 95, 28);
		panel_2.add(btnLogin);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtUsername.getText().equals("usernmae") || pwdEnterThePassword.getText().equals("password")) {
					txtUsername.setText(null);
					pwdEnterThePassword.setText(null);

				}
				username =txtUsername.getText();
				String passwordStr = pwdEnterThePassword.getText();
				String UserType =  (String)comboBoxSelectUser.getSelectedItem();
				System.out.println("User Type Combo : " + UserType);

				if(username.equals("")||passwordStr.equals("")||UserType.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all fields");
				}
				else {
					try {
						System.out.println("Before Get Connection");
						con = MySQLConection.getconnection();
						System.out.println("Out From Connection");
						System.out.println(txtUsername.getText());	
						System.out.println(pwdEnterThePassword.getText());
						preparedStatement = con.prepareStatement("select * from employee where uid=? and password=?");
						preparedStatement.setString(1, username);	
						preparedStatement.setString(2, passwordStr);
						resultSet = preparedStatement.executeQuery();

						if(!txtUsername.getText().equalsIgnoreCase("") || !pwdEnterThePassword.getText().equalsIgnoreCase("")) {
							if(resultSet.next()) {
								String s1 = resultSet.getString("Usertype");
								System.out.println("Database User Type : " + s1);
								if(UserType.equals(s1) && UserType.equals("Admin")){
									System.out.println("Logined As Admin Successfully");
									HomePage.main(null);
									frameNInfi.setVisible(false);
								}
								else if(UserType.equals(s1) && UserType.equals("Employee")){
									System.out.println("Logined As Employee Successfully");
									EmployeeHomePage.main(null);
									frameNInfi.setVisible(false);

								}
								else {
									JOptionPane.showMessageDialog(null, "Invalid Data", "Login Failure", JOptionPane.ERROR_MESSAGE);
								}
								System.out.println("running");
							}
							else {
								JOptionPane.showMessageDialog(null, "Incorrect Id or Password Entered", "Login Failed", JOptionPane.ERROR_MESSAGE);			
							}
						}

					} 
					catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				txtUsername.setForeground(Color.GRAY);
				txtUsername.setText("username");
				pwdEnterThePassword.setForeground(Color.GRAY);
				pwdEnterThePassword.setEchoChar((char)0);
				pwdEnterThePassword.setText("password");
			}


		});

		btnLogin.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnLogin.setBackground(new Color(0, 191, 0));


		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(176, 374, 95, 28);
		panel_2.add(btnReset);
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setForeground(Color.GRAY);
				txtUsername.setText("username");
				pwdEnterThePassword.setForeground(Color.GRAY);
				pwdEnterThePassword.setEchoChar((char)0);
				pwdEnterThePassword.setText("password");
				comboBoxSelectUser.setSelectedIndex(0);

			}
		});

		btnReset.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnReset.setBackground(new Color(255, 0, 0));

		JLabel lblNewLabel = new JLabel("Login Portal");
		lblNewLabel.setFont(new Font("Blackadder ITC", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 53, 219, 104);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Ashish Mandke\\OneDrive\\Desktop\\zsddxfcghuji.png"));
		lblNewLabel_3.setBounds(436, 141, 307, 436);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Ashish Mandke\\OneDrive\\Desktop\\N INFINITY (1517 × 620px) (1517 × 620px).png"));
		lblNewLabel_1.setBounds(0, 0, 1517, 620);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Copyrights 2022 @ PAYROLL SYSTEM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Bodoni Bk BT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(584, 797, 353, 20);
		frameNInfi.getContentPane().add(lblNewLabel_2);

		frameNInfi.setLocationRelativeTo(null);
	}	
}
