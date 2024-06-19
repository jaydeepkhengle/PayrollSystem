package package1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import package1.HomePage.PanelButtonMouseAdapter;

public class EmployeeHomePage {

	private JFrame frmDrDyPatil;
	private PanelMyAccountEmp panelMyAccountEmp;
	private PanelLeaveEmp panelLeaveEmp;
	private PanelSalaryEmployee panelSalary;
	static public 	JPanel contentpanel ;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeHomePage window = new EmployeeHomePage();
					window.frmDrDyPatil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDrDyPatil = new JFrame();
		frmDrDyPatil.setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeHomePage.class.getResource("/image/NInfinityLogo.jpeg")));
		frmDrDyPatil.setTitle("N Infinity Info Solutions");
		frmDrDyPatil.getContentPane().setBackground(new Color(255, 0, 0));
		frmDrDyPatil.getContentPane().setLayout(null);
		frmDrDyPatil.setForeground(new Color(64, 224, 208));
		frmDrDyPatil.setEnabled(true);
		frmDrDyPatil.setBackground(new Color(255, 0, 0));
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		frmDrDyPatil.setSize(width,height+10);
		frmDrDyPatil.setLocationRelativeTo(null);
		frmDrDyPatil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelMyAccountEmp = new PanelMyAccountEmp();
		panelLeaveEmp = new PanelLeaveEmp();
		panelLeaveEmp.setBackground(new Color(255, 255, 255));
		panelSalary = new PanelSalaryEmployee();

		JPanel panel = new JPanel();
		panel.setBounds(5, 162, 249, 656);
		panel.setBackground(new Color(0, 64, 128));
		frmDrDyPatil.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 57, 226, 211);
		panel.add(panel_5);
		panel_5.setBackground(new Color(255, 255, 255));
		panel.add(panel_5);
		panel_5.setLayout(null);

		JPanel paneMyAccountEmp = new JPanel();
		paneMyAccountEmp.setBounds(7, 7, 212, 46);
		paneMyAccountEmp.addMouseListener(new PanelButtonMouseAdapter(paneMyAccountEmp) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelMyAccountEmp);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				paneMyAccountEmp.setBackground(new Color(46, 61, 176));
			}
		});
		paneMyAccountEmp.setBackground(new Color(46, 61, 176));
		panel_5.add(paneMyAccountEmp);
		paneMyAccountEmp.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("My Account");
		lblNewLabel_3.setBounds(10, 7, 139, 31);
		paneMyAccountEmp.add(lblNewLabel_3);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.WHITE);

		JPanel paneLeaveEmp = new JPanel();
		paneLeaveEmp.setBounds(7, 57, 212, 46);
		paneLeaveEmp .addMouseListener(new PanelButtonMouseAdapter(paneLeaveEmp ) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelLeaveEmp);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneLeaveEmp.setBackground(new Color(46, 61, 176));
			}
		});
		paneLeaveEmp.setBackground(new Color(46, 61, 176));
		panel_5.add(paneLeaveEmp);
		paneLeaveEmp.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Leave");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 7, 202, 31);
		paneLeaveEmp.add(lblNewLabel_4);

		JPanel paneSalaryEmp = new JPanel();
		paneSalaryEmp.setBounds(7, 107, 212, 46);
		paneSalaryEmp.addMouseListener(new PanelButtonMouseAdapter(paneSalaryEmp) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelSalary);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneSalaryEmp.setBackground(new Color(46, 61, 176));
			}
		});
		paneSalaryEmp.setBackground(new Color(46, 61, 176));
		panel_5.add(paneSalaryEmp);
		paneSalaryEmp.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Salary");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(10, 7, 202, 31);
		paneSalaryEmp.add(lblNewLabel_5);

		JPanel paneLogoutEmp = new JPanel();
		paneLogoutEmp.setBounds(7, 157, 212, 46);
		paneLogoutEmp.addMouseListener(new PanelButtonMouseAdapter(paneLogoutEmp) {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do You Want Log out ", "Log Out", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					MainLogin.main(null);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paneLogoutEmp.setBackground(new Color(46, 61, 176));
			}
		});
		paneLogoutEmp.setBackground(new Color(46, 61, 176));
		panel_5.add(paneLogoutEmp);
		paneLogoutEmp.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Logout");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 21));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(10, 7, 202, 31);
		paneLogoutEmp.add(lblNewLabel_6);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBounds(10, 278, 226, 368);
		panel.add(panel_10);
		panel_10.setLayout(null);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(146, 189, 213));
		panel_11.setBounds(7, 7, 211, 351);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(EmployeeHomePage.class.getResource("/image/PngItem_1111076.png")));
		lblNewLabel_7.setBounds(0, 81, 211, 209);
		panel_11.add(lblNewLabel_7);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 1, 249, 47);
		panel.add(panel_4);
		panel_4.setBackground(new Color(255, 0, 0));
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Home");
		lblNewLabel_1.setBounds(20, 0, 208, 47);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 30));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 5, 1510, 205);
		panel_2.setBackground(new Color(255, 255, 255));
		frmDrDyPatil.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(-5, 150, 1537, 9);
		separator.setBackground(new Color(46, 61, 176,255));
		panel_2.add(separator);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/image/Untitled1_20220225174414.png")));
		lblNewLabel.setBounds(-5, -7, 1507, 150);
		panel_2.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(255, 158, 1255, 47);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Welcome to Employee Login");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(313, 0, 658, 47);
		panel_1.add(lblNewLabel_2);

		contentpanel = new JPanel();
		contentpanel.setBounds(260, 162, 1255, 656);
		frmDrDyPatil.getContentPane().add(contentpanel);
		contentpanel.setBackground(new Color(146,189,213,252));
		contentpanel.setLayout(null);


		contentpanel.add(panelMyAccountEmp);
		contentpanel.add(panelLeaveEmp);
		contentpanel.add(panelSalary);
		menuClicked(panelMyAccountEmp);

	}
	public void menuClicked(JPanel panel) {

		panelMyAccountEmp.setVisible(false);
		panelLeaveEmp.setVisible(false);
		panelSalary.setVisible(false);
		panel.setVisible(true);

	}

	public class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(0, 139, 139));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(146,189,213,252));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(146,189,213,252));
		}

	}
}


