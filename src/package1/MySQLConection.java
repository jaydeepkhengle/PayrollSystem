package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.swing.JOptionPane;

import org.w3c.dom.UserDataHandler;

import com.mysql.*; // to deleted after checking

public class MySQLConection {

	private Connection con;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;


	public static Connection getconnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem in loading driver");
		}

		Connection con = null;

		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/PayrollSystem","root","ashu1234@2015");
			System.out.println("Connection Established Successfully");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Problem in getting connection");
		}
		return con;
	}

	// MY Account from Employee Page,PanelAttendence from Admin page
	ResultSet displayMyAccount(int empId) {

		try {
			con = MySQLConection.getconnection();
			String sql = "select * from employee LEFT JOIN salary on employee.employee_id = salary.employee_id LEFT JOIN leave_stats on employee.employee_id = leave_stats.employee_id LEFT JOIN apply_leave on employee.employee_id = apply_leave.employee_id where employee.employee_Id = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,empId);

			resultSet = preparedStatement.executeQuery();

		} catch (Exception e3) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e3.getMessage()));
		}
		System.out.println("out...................332432...displayMyAccount...........");
		return resultSet;	
	};


	//Leave Application Through Employee Login
	int applyLeave(int empId,String fromDate, String toDate, int numberOfDays, String reason) {

		int status = 0;
		
		try {
			con = MySQLConection.getconnection();
			PreparedStatement pstmt = con.prepareStatement("insert into apply_leave values (?,?,?,?,?,?)");
			pstmt.setInt(1, empId);
			pstmt.setString(2, fromDate);
			pstmt.setString(3, toDate);
			pstmt.setInt(4, numberOfDays);
			pstmt.setString(5, reason);
			pstmt.setString(6, "");
			status = pstmt.executeUpdate();
			
			System.out.println("out......................InsertData..............................");
		
		} catch (Exception e3) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e3.getMessage()));
		}
		return status;

	}
	
	//Pending Leave Checking
	ResultSet pendingLeaveCheck(int empId) {
		
		ResultSet result = null;
		con = MySQLConection.getconnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("select COUNT(*) as rowCount from apply_leave where employee_id = ? AND status = ''");
			pstmt.setInt(1, empId);
			
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	//Update Page from AdminPage
	int UpdateAdmin(int employeeId,String Name,String gender,String address,String state,String city ,String pincode,String mobile,String Degree,String Designation,String Department,String Bank,String email,String Salary,String Usertype  ) {	
		int status = 0;
		try {
			con = MySQLConection.getconnection();
			preparedStatement=con.prepareStatement("Update employee set name =?,gender =?,address =?,state =?,city =?,pincode =?,mobile =?,Degree =?,Designation =?,Department =?,Bank =?,email =?,salary =? Where employee_Id = ?");
			preparedStatement.setString(1, Name);
			preparedStatement.setString(2, gender);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, state);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, pincode);
			preparedStatement.setString(7, mobile);
			preparedStatement.setString(8, Degree);
			preparedStatement.setString(9, Designation);
			preparedStatement.setString(10, Department);
			preparedStatement.setString(11, Bank);
			preparedStatement.setString(12, email);
			preparedStatement.setString(13, Salary);
			preparedStatement.setInt(14, employeeId);

			status =(int) preparedStatement.executeUpdate();
			System.out.println("out.........UpdateData...............1.");	
		} 
		catch (Exception e4) {

			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();

		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return status;	
	}



	//Add Employee Page from AdminPage
	int insertdataAdmin(String uid ,String passwordStr,String Name,String gender,String address,String state,String city ,String pincode,String mobile,String Degree,String Designation,String Department,String Bank,String email,String Salary,String Usertype  ) {
		int status=0;
		int rowCount=0;
		try {
			con = MySQLConection.getconnection();
			String sql ="insert into employee(S_No, employee_Id, uid, password, name, gender, address, state, city, pincode, mobile, degree, designation, department, bank, email, salary, Usertype) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement=con.prepareStatement(sql);
			ResultSet result = getRowCount();
			while(result.next()) {
				rowCount = result.getInt("count");
			}
			preparedStatement.setInt(1, rowCount+1);
			preparedStatement.setInt(2, generateEmployeeId());
			preparedStatement.setString(3, uid);
			preparedStatement.setString(4, passwordStr);
			preparedStatement.setString(5, Name);
			preparedStatement.setString(6, gender);
			preparedStatement.setString(7, address);
			preparedStatement.setString(8, state);
			preparedStatement.setString(9, city);
			preparedStatement.setString(10, pincode);
			preparedStatement.setString(11, mobile);
			preparedStatement.setString(12, Degree);
			preparedStatement.setString(13, Designation);
			preparedStatement.setString(14, Department);
			preparedStatement.setString(15, Bank);
			preparedStatement.setString(16, email);
			preparedStatement.setString(17, Salary);
			preparedStatement.setString(18, Usertype);

			status = preparedStatement.executeUpdate();
			System.out.println("out............InsertDataAdmin............2.");
			System.out.println(Name+"Update fail"+""+address+""+""+city+""+pincode+""+mobile+""+Salary+""+Bank+""+email+""+Department+""+uid+""+passwordStr+""+gender+""+state+""+Degree+""+Designation+""+Usertype);	
		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return status;	

	}

	//For Displaying Tuple(empInfo) for a given employee Id
	ResultSet getRow(int employeeId) {

		try {
			con = MySQLConection.getconnection();
			String sql = "select  * from employee where employee_Id = ? ";
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setInt(1, employeeId);
			resultSet = preparedStatement.executeQuery();
			System.out.println("---Out of getRow---");

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return resultSet;	

	}



	//Employee List  Page from Admin Page
	ResultSet getTable() {
		try {
			con = MySQLConection.getconnection();
			Statement stmt = con.createStatement();
			resultSet = stmt.executeQuery("select  * from employee");
			java.sql.ResultSetMetaData rsmd = resultSet.getMetaData();
			int cols = rsmd.getColumnCount();
			System.out.println("---Out of getTable---");
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));
		}
		return resultSet;

	}
	//Delete Page from AdminPage
	int DeleteData(int empId) {
		int status =0;
		try {

			con = MySQLConection.getconnection();
			preparedStatement = con.prepareStatement("DELETE from employee WHERE employee_Id = ?");
			preparedStatement.setInt(1, empId);
			status = preparedStatement.executeUpdate();		
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));

		}

		return status;

	}
	//
	public int getSerialNumber(int empId) {

		ResultSet result = null;
		int serialNumber=0;
		PreparedStatement pstmt=null;
		try {
			con = MySQLConection.getconnection();
			pstmt = con.prepareStatement("select * from employee where employee_Id =?");
			pstmt.setInt(1, empId);
			result = pstmt.executeQuery();
			while(result.next()) {
				serialNumber = result.getInt("S_No");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return serialNumber;
	}
	public int updateRowNumber(int Id) {

		int status=0;
		PreparedStatement pstmt = null;


		try {
			pstmt = con.prepareStatement("update employee set S_No = ? where S_No = ?");
			pstmt.setInt(1, Id);
			pstmt.setInt(2, Id+1);

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			status = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==1) {
			System.out.println("Row Number Updated Successfully");
		}
		else {
			System.out.println("Row Number Updation Failure");
		}

		return status;
	}
	
	//Check Leave Status For MyAccount Employee Login
	public ResultSet leaveCheck(int empId) {
		ResultSet result = null;
		
		con = MySQLConection.getconnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select count(*) as rowCount from apply_leave where employee_Id = ?");
			pstmt.setInt(1, empId);
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}


	//leaveadmin,LeaveEmployee Employee  for info from Admin page 
	ResultSet getRowLeave(int empId) {
		ResultSet resultSet = null;
		try {
			con = MySQLConection.getconnection();
			String sql = "select * from apply_leave LEFT JOIN employee on apply_leave.employee_Id LEFT JOIN leave_stats on apply_leave.employee_Id LEFT JOIN salary on apply_leave.employee_id where apply_leave.employee_Id = ? ";
			System.out.println("---getRowLeave---");
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,empId);

			resultSet = preparedStatement.executeQuery();

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return resultSet;	

	}

	//leave Employee  for approvedButton from Admin page 
	int getStatusApproved (int employeeId, int numberOfDays) {
		int result = 0;
		try {
			con = MySQLConection.getconnection();
			preparedStatement=con.prepareStatement("Update apply_leave set status = 'Approved' where employee_id = ? and status = '' ");
			preparedStatement.setInt(1, employeeId);
			result = preparedStatement.executeUpdate();
			System.out.println("---Out of getStatusApproved---");
			updateLeaveDetails(employeeId, numberOfDays);

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return result;	

	}
	public void updateLeaveDetails(int empId, int numberOfDays) {
		PreparedStatement pstmt = null;

		ResultSet result = getleaveStats(empId);
		int balanceLeaves,usedLeaves, unpaidLeaves, totalLeavesTaken;
		balanceLeaves=usedLeaves=unpaidLeaves=totalLeavesTaken=0;
		try {
			while(result.next()) {
				balanceLeaves = result.getInt("balance_leaves");
				usedLeaves = result.getInt("used_leaves");
				unpaidLeaves = result.getInt("unpaid_leaves");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		con = MySQLConection.getconnection();
		int diff=0;
		try {
			pstmt = con.prepareStatement("update leave_stats set balance_leaves = ?, used_leaves = ?, unpaid_leaves = ?, total_leaves_taken = ? where employee_id = ?");

			if(balanceLeaves>=numberOfDays) {
				pstmt.setInt(1, balanceLeaves-numberOfDays);
				pstmt.setInt(2, usedLeaves+numberOfDays);

			}
			else {
				diff = Math.abs(numberOfDays-balanceLeaves);
				pstmt.setInt(1, Math.abs(balanceLeaves-(numberOfDays-diff)));
				pstmt.setInt(2, usedLeaves+Math.abs(numberOfDays-diff));
				pstmt.setInt(3, diff+unpaidLeaves);
			}
			pstmt.setInt(3, diff+unpaidLeaves);
			pstmt.setInt(4, (diff+unpaidLeaves)+usedLeaves+Math.abs(numberOfDays-diff));
			pstmt.setInt(5, empId);
			pstmt.executeUpdate();
			System.out.println("Out From Update leave Ss");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ResultSet getleaveStats(int empId) {
		ResultSet result = null;
		PreparedStatement pstmt = null;

		con = MySQLConection.getconnection();
		try {
			pstmt = con.prepareStatement("select * from leave_stats where employee_id = ?");
			pstmt.setInt(1, empId);
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	//leave Employee  for Declined Button from Admin page 
	int getStatusDeclined(int empId) {
		int result = 0;
		try {
			con = MySQLConection.getconnection();
			String sql = "Update apply_leave set status = 'Declined' where employee_id = ? and status = '' ";
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setInt(1, empId);
			result = preparedStatement.executeUpdate();
			System.out.println("--- Out of getStatusDeclined---");

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return result;	

	}

	//Number of leave Approved status of Employee for AdminStatus page Information 
	ResultSet numberOfApprovedLeaveApplication() {
		ResultSet resultSet = null;
		try {
			con = MySQLConection.getconnection();
			String sql = "select COUNT(*) as rowcount from apply_leave where status = 'approved'";
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("---Out of numberOfApprovedLeaveApplication---");

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return resultSet;	

	}	


	//Number of leave Rejected status of Employee for AdminStatus page Information
	ResultSet numberOfRejectedLeaveApplication() {
		ResultSet resultSet = null;
		try {
			con = MySQLConection.getconnection();
			String sql = "select COUNT(*) as rowCount from apply_leave where status = 'declined'";
			System.out.println("---Out of numberOfRejectedLeaveApplication---");
			preparedStatement = con.prepareStatement(sql);

			resultSet = preparedStatement.executeQuery();

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return resultSet;	

	}	


	//Number of Leave applications with pending status for AdminStatus Page Information
	ResultSet numberOfPendingLeaveApplications() {
		ResultSet resultSet = null;
		try {
			con = MySQLConection.getconnection();
			String sql = "select COUNT(*) as rowCount from apply_leave where status =''";
			System.out.println("---Out of numberOfPendingLeaveApplications---");
			preparedStatement = con.prepareStatement(sql);


			resultSet = preparedStatement.executeQuery();

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return resultSet;	

	}

	//	panelLeave  next,search  button from Admin page Next
	ResultSet leaveData() {
		Statement stmt = null;
		//		ResultSet resultSet = null;
		try {

			con = MySQLConection.getconnection();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = stmt.executeQuery("SELECT * FROM apply_leave JOIN employee ON apply_leave.employee_Id = employee.employee_Id JOIN leave_stats ON apply_leave.employee_Id = leave_stats.employee_Id where apply_leave.status = ''");
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error:" +  ( e.getMessage()));// TODO: handle exception
		}
		return resultSet;
	}

	//	panelLeave  next,search  button from AdminPage Search
	ResultSet leaveDataSearch(int employeeId) {
		PreparedStatement pstmt = null;
		//		ResultSet resultSet = null;
		
		try {

			con = MySQLConection.getconnection();
			pstmt = con.prepareStatement("SELECT * FROM apply_leave JOIN employee ON apply_leave.employee_Id = employee.employee_Id JOIN leave_stats ON apply_leave.employee_Id = leave_stats.employee_Id where apply_leave.status = '' and apply_leave.employee_id = ? ");
			pstmt.setInt(1, employeeId);
			resultSet = pstmt.executeQuery();

		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error:" +  ( e.getMessage()));// TODO: handle exception
		}
		System.out.println("---In Leave Data Search---");
		return resultSet;
	}

	ResultSet getApplyLeaveData(int employeeId) {
		PreparedStatement pstmt = null;
		//		ResultSet resultSet = null;
		
		try {

			con = MySQLConection.getconnection();
			pstmt = con.prepareStatement("SELECT * FROM apply_leave JOIN employee ON apply_leave.employee_Id = employee.employee_Id where apply_leave.employee_id = ? ");
			pstmt.setInt(1, employeeId);
			resultSet = pstmt.executeQuery();

		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database error:" +  ( e.getMessage()));// TODO: handle exception
		}
		System.out.println("---In Apply Leave Data Search---");
		return resultSet;
	}


	ResultSet getleaveapplication4(String username) {
		//	ResultSet resultSet4 = null;
		try {
			con = MySQLConection.getconnection();


			preparedStatement = con.prepareStatement("select * from apply_leave where uid = ? ");
			preparedStatement.setString(1,username);

			resultSet = preparedStatement.executeQuery();

		} catch (Exception e4) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();
		}
		return resultSet;	

	}	

	//Generates new employee Id when new employee is added
	public int generateEmployeeId() {
		int empId=0;
		ResultSet result = null;
		int rowNumber=0;
		try {
			con = MySQLConection.getconnection();
			Statement stmt = con.createStatement();
			result = getRowCount();
			while(result.next()) {
				rowNumber = result.getInt("count");
			}
			result = stmt.executeQuery("select * from employee");
			while(result.next()) {
				empId = result.getInt("employee_Id")+1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}
		if(empId!=0) {
			return empId;
		}
		return 1001;
	}

	//
	public ResultSet getEmployeeId(String uid) {
		ResultSet resultSet = null;
		PreparedStatement pstmt=null;

		con = MySQLConection.getconnection();

		try {
			con = MySQLConection.getconnection();
			pstmt = con.prepareStatement("select * from employee where uid = ? ");
			pstmt.setString(1, uid);
			resultSet = pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
		}


		return resultSet;

	}


	//total Employee from adminStatus page
	ResultSet getRowCount() {
		ResultSet resultSet = null;
		try {
			con = MySQLConection.getconnection();
			Statement stmt = con.createStatement();
			resultSet = stmt.executeQuery("select count(employee_Id) as count from employee");

		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog( null, "Database error:" +  (e.getMessage()));
		}
		return resultSet;

	}

	//Panel Salary ,PaySlip  from AdminPage
	//PanelSlaryemp PaySlip2 from employee
	ResultSet getSalary(String uid) {
		try {
			con = MySQLConection.getconnection();
			String sql = "SELECT *\r\n"
					+ "FROM salary\r\n"
					+ "LEFT JOIN employee ON salary.employee_id = employee.employee_id\r\n"
					+ "LEFT JOIN leave_stats ON salary.employee_id = leave_stats.employee_id\r\n"
					+ "WHERE salary.employee_id= ?";
			System.out.println("out.............getSalary.......................................");
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,uid);

			resultSet = preparedStatement.executeQuery();

		} catch (Exception e3) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e3.getMessage()));
		}
		System.out.println("out...................332432..............");
		return resultSet;	
	};
	public int getTotalLeaves(String uid) {
		con = MySQLConection.getconnection();
		PreparedStatement pstmt=null;
		ResultSet result=null;
		int noOfLeavesTaken=0;

		try {
			pstmt = con.prepareStatement("select * from applyleave where uid = ? ");
			pstmt.setString(1, uid);

			result = pstmt.executeQuery();

			while(result.next()) {
				noOfLeavesTaken += result.getInt("days");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return noOfLeavesTaken;
	}

	//PanelSalary Save button from AdminPage
	int SaveSalray(String uid ,String Name,String department,String date,String HR,String DA,String Med,String leave,String Travell,String grosssalary,String Netsalary,String leaveday ) {
		int status = 0;
		try {
			con = MySQLConection.getconnection();
			preparedStatement = con.prepareStatement("insert into salary (UID, date, hr, da, med, travel, grosssalary, netsalary) values (?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, uid);
			preparedStatement.setString(2, date);
			preparedStatement.setInt(3, Integer.parseInt(HR));
			preparedStatement.setInt(4, Integer.parseInt(DA));
			preparedStatement.setInt(5, Integer.parseInt(Med));
			preparedStatement.setInt(6, Integer.parseInt(Travell));
			preparedStatement.setInt(7, Integer.parseInt(grosssalary));
			preparedStatement.setInt(8, Integer.parseInt(Netsalary));

			status = preparedStatement.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;

	}

	// Atendence panel from Admin Page
	int uploadattendence(String uid ,String Name,String firstHalf,String SecondHalf,Date date) {

		int status=0;
		try {
			con = MySQLConection.getconnection();
			String sql =
					" Update attendence Set f_half ='"+firstHalf
					+"',s_half ='"+SecondHalf
					+"',Date ='"+ date
					+"' where UID=?";   
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			status =(int) preparedStatement.executeUpdate();
			System.out.println("out.....uploadAttendance...................1.");	
		} catch (Exception e4) {

			JOptionPane.showMessageDialog( null, "Database error:" +  ( e4.getMessage()));
			e4.printStackTrace();

		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return status;	
	}

	//Adding the leaves in leave_stats table
	public int addLeaveStats(int empId) {
		int result = 0;

		PreparedStatement pstmt = null;
		con = MySQLConection.getconnection();
		try {
			pstmt = con.prepareStatement("INSERT INTO leave_stats (employee_Id, Allocated_Leaves, Balance_Leaves, Used_Leaves, Unpaid_Leaves, Total_Leaves_Taken) VALUES (?, 50, 50, 0, 0, 0);");
			pstmt.setInt(1, empId);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e.getMessage()));
		}
		return result;
	}
	// Adding all Salary components by formulating them
	public int addSalarComponents(int empId, int CTC) {

		int result = 0;
		PreparedStatement pstmt = null;
		con = MySQLConection.getconnection();
		try {
			pstmt = con.prepareStatement("insert into salary values(?,default,?,?,?,?,?,?,?,?)");	

			int baiscSalary = (int)(CTC*0.6);
			int HRA = (int)(CTC*0.2);
			int DA = (int)(CTC*0.1);
			int Med = (int)(CTC*0.05);
			int travel = (int)(CTC*0.05);
			int netSalary = (baiscSalary+DA+travel+HRA)- calculateIncomeTax(CTC);

			pstmt.setInt(1, empId);
			System.out.println(empId);
			pstmt.setInt(2, CTC);
			System.out.println(CTC);
			pstmt.setInt(3, baiscSalary);
			System.out.println(baiscSalary);
			pstmt.setInt(4, HRA);
			System.out.println(HRA);
			pstmt.setInt(5, DA);
			System.out.println(DA);
			pstmt.setInt(6, Med);
			System.out.println(Med);
			pstmt.setInt(7, travel);
			System.out.println(travel);
			pstmt.setInt(8, calculateIncomeTax(CTC));
			pstmt.setInt(9, netSalary);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	public int calculateIncomeTax(int CTC) {
		int excessLimit = 0;
		int incomeTax = 0;

		if(CTC>0 && CTC<=300000) {
			incomeTax=0;
		}
		else if (CTC>300000 && CTC<=600000) {
			excessLimit = CTC-300000;
			incomeTax = (int)(excessLimit*0.05);

		}
		else if(CTC>600000 && CTC<=900000) {
			excessLimit = CTC-600000;
			incomeTax = (int)(excessLimit*0.1);
		}
		else if(CTC>900000 && CTC<=1200000) {
			excessLimit = CTC-900000;
			incomeTax = (int)(excessLimit*0.15);
		}
		else if(CTC>1200000 && CTC<=1500000) {
			excessLimit = CTC-1200000;
			incomeTax = (int)(excessLimit*0.2);
		}
		else if(CTC>1500000) {
			excessLimit = CTC-1200000;
			incomeTax = (int)(excessLimit*0.3);
		}

		return incomeTax;
	}
	public int deleteAnyData(String tableName, int empId) {
		con = MySQLConection.getconnection();
		PreparedStatement pstmt = null;
		int status = 0;
		try {
			pstmt = con.prepareStatement("delete from " + tableName + " where employee_id = ?");
			pstmt.setInt(1, empId);
			status = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}




	/*	ResultSet paySlip( String uid,String bank,String leave,String Name,String department,String HR,String DA,String Med,String Leave,String travell,String grosssalary,String Netsalary  ) {

	try {
		con = MySQLConection.getconnection();
		String sql = "select *from employee NATURAL  LEFT JOIN salary NATURAL LEFT JOIN applyleave where UID=?";
		System.out.println("out....................................................");
		preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,uid);

	    resultSet = preparedStatement.executeQuery();

	} catch (Exception e3) {
		JOptionPane.showMessageDialog( null, "Database error2222222222222:" +  ( e3.getMessage()));
	}
	System.out.println("out...................332432..............");
	return resultSet;	

}*/





	/*		ResultSet attandanceFHalf(String uid ,String Name,String firstHalf,String SecondHalf,String Date) {
	ResultSet resultSet2 = null;
	try {
		con = MySQLConection.getconnection();
		String sql = "select   COUNT(*) as present from applyleave where  f_half ='Present'";
		System.out.println("out....................................................");
		preparedStatement = con.prepareStatement(sql);
	//	preparedStatement.setString(1,uid);
	    resultSet2 = preparedStatement.executeQuery();

	} catch (Exception e3) {
		JOptionPane.showMessageDialog( null, "Database error:" +  ( e3.getMessage()));
	}
	System.out.println("out....                  ...............332432..............");
	return resultSet2;

}  


	ResultSet attandanceSHalf(String uid ,String Name,String firstHalf,String SecondHalf,String Date) {
		ResultSet resultSet3 = null;
		try {
			con = MySQLConection.getconnection();
			String sql = "select   COUNT(*) as present1 from applyleave where  s_half ='Present' ";
			System.out.println("out....................................................");
			preparedStatement = con.prepareStatement(sql);
		//	preparedStatement.setString(1,uid);
		    resultSet3 = preparedStatement.executeQuery();

		} catch (Exception e3) {
			JOptionPane.showMessageDialog( null, "Database error:" +  ( e3.getMessage()));
		}
		System.out.println("out....                  ...............332432..............");
		return resultSet3;

	}  */

}


