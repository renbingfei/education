package cn.xuhe.xls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.Cell;
import jxl.Sheet;

import cn.xuhe.xls.ConstantValues;

public class SqlOperator {

	public SqlOperator() throws ClassNotFoundException {
		Class.forName(ConstantValues.driver);
	}

//	public boolean createTables(String tableName)
//			throws InstantiationException, IllegalAccessException,
//			ClassNotFoundException, SQLException {
//		Connection connection = DriverManager.getConnection(ConstantValues.url
//				+ ConstantValues.databaseName, ConstantValues.username,
//				ConstantValues.password);
//		Statement statement = connection.createStatement();
//		MytableName = tableName;
//		String sqlHead = "Create table if not exists " + tableName + "(";
//		String sqlEnd = "_id int primary key auto_increment,"
//				+ "studentid varchar (30)," +  "password varchar (30)," + "name varchar (20))";
//		String sql = sqlHead + sqlEnd;
//		statement.execute(sql);
//
//		connection.close();
//		return true;
//	}

	public String insertData(String schoolId, Sheet sheet) throws SQLException {
		Connection connection = null;
		Statement state = null;
		
		try {
			connection = DriverManager.getConnection(ConstantValues.url
					+ ConstantValues.databaseName, ConstantValues.username,
					ConstantValues.password);
			state = connection.createStatement();
			Cell cell = null;
			String sqlCon = "";
			int rowCounts = sheet.getRows();
			int columnCounts = sheet.getColumns();
			if(columnCounts!=5)return "ferror";
//			System.out.println(rowCounts+"@"+columnCounts);

			for (int i = 0; i < rowCounts; i++) {
//				System.out.println("i@"+i);
				for (int j = 0; j < columnCounts; j++) {
//					System.out.println("j@"+j);
					cell = sheet.getCell(j, i);

					if (j < columnCounts - 1) {
						sqlCon += cell.getContents() + ",";
//						 System.out.print(sqlCon+"\t");
					} else {
						sqlCon += cell.getContents();
//						 System.out.print(sqlCon+"\t");
					}

				}
//				System.out.println(sqlCon);
				String[] sqlData = sqlCon.split(",");

				String sql = "insert into student"
						+ "(studentid,password,name,sex,contact,major,avatar) values('" + sqlData[0] + '@' + schoolId
						+ "','" + sqlData[0] + "','" + sqlData[1] +"','" + sqlData[2]
						+ "','" + sqlData[3] + "','" + sqlData[4]+ "','image/stu.jpg')";
				state.execute(sql);
				sqlCon = "";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
			return "sqlerror";
		} finally {
			if (state != null) {
				state.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return "success";
	}
}
//public class SqlOperator {
//	private String MytableName;
//
//	public SqlOperator() throws ClassNotFoundException {
//		Class.forName(ConstantValues.driver);
//	}
//
//	public boolean createTables(String tableName)
//			throws InstantiationException, IllegalAccessException,
//			ClassNotFoundException, SQLException {
//		Connection connection = DriverManager.getConnection(ConstantValues.url
//				+ ConstantValues.databaseName, ConstantValues.username,
//				ConstantValues.password);
//		Statement statement = connection.createStatement();
//		MytableName = tableName;
//		String sqlHead = "Create table if not exists " + tableName + "(";
//		String sqlEnd = "studentid varchar (30) primary key," +  "password varchar (30)," + "name varchar (30)" 
//				+ "grade varchar(10)" + " sex char(4)" + "contact varchar(30)" + "major varchar (30)" 
//				+ "avatar varchar(300))";
//		String sql = sqlHead + sqlEnd;
//		statement.execute(sql);
//
//		connection.close();
//		return true;
//	}
//
//	public void insertData(Sheet sheet) throws SQLException {
//		Connection connection = null;
//		Statement state = null;
//		try {
//			connection = DriverManager.getConnection(ConstantValues.url
//					+ ConstantValues.databaseName, ConstantValues.username,
//					ConstantValues.password);
//			state = connection.createStatement();
//			Cell cell = null;
//			String sqlCon = "";
//			int rowCounts = sheet.getRows();
//			int columnCounts = sheet.getColumns();
//
//			for (int i = 0; i < rowCounts; i++) {
//				for (int j = 0; j < columnCounts; j++) {
//
//					cell = sheet.getCell(j, i);
//
//					if (j < columnCounts - 1) {
//						sqlCon += cell.getContents() + ",";
//						// System.out.print(sqlCon+"\t");
//					} else {
//						sqlCon += cell.getContents();
//						// System.out.print(sqlCon+"\t");
//					}
//
//				}
//				String[] sqlData = sqlCon.split(",");
//
//				String sql = "insert into " + MytableName
//						+ "(studentid,password,name,sex,major) values('" + sqlData[0]
//						+ "','" + sqlData[0] + "','" + sqlData[1] +"','" + sqlData[2]
//						+ "','" + sqlData[3] +"')";
//				state.execute(sql);
//				sqlCon = "";
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (state != null) {
//				state.close();
//			}
//			if (connection != null) {
//				connection.close();
//			}
//		}
//	}
//	public String getpassword(String schoolname, String studentid) throws SQLException {
//		Connection connection = null;
//		Statement state = null;
//		String password = null;
//		try {
//			connection = DriverManager.getConnection(ConstantValues.url
//					+ ConstantValues.databaseName, ConstantValues.username,
//					ConstantValues.password);
//			state = connection.createStatement();
//			Cell cell = null;
//
//			String sql = "select * from " + schoolname + " where studentid=" + studentid;
//			System.out.println(sql);
//			ResultSet rs = state.executeQuery(sql);
//			
//			if(rs.next()){
//				password = rs.getString("password");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (state != null) {
//				state.close();
//			}
//			if (connection != null) {
//				connection.close();
//			}
//		}
//		return password;
//	}
//}
