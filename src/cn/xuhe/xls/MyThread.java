package cn.xuhe.xls;

import java.sql.SQLException;

import cn.xuhe.xls.SqlOperator;

import jxl.Sheet;

public class MyThread{
	private String schoolId;
	private Sheet sheet;
	private SqlOperator sqlOperator;
	public MyThread(String Id,Sheet mySheet) throws ClassNotFoundException{
		schoolId=Id;
		sheet=mySheet;
		sqlOperator=new SqlOperator();
	}
	public String run() throws SQLException {
		// TODO Auto-generated method stub
			return sqlOperator.insertData(schoolId, sheet);
	}

}
