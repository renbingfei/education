package cn.xuhe.xls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import cn.xuhe.xls.ConstantValues;

public class DatabaseCreated {
	public DatabaseCreated() {

	}

	public boolean createDatabase(String databaseName)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		Class.forName(ConstantValues.driver).newInstance();
		Connection connection = DriverManager.getConnection(ConstantValues.url,
				ConstantValues.username, ConstantValues.password);
		Statement state = connection.createStatement();
		String sql = "CREATE DATABASE " + databaseName;
		state.executeUpdate(sql);
		state.close();
		connection.close();
		return true;
	}
}
