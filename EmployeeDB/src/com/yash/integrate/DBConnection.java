package com.yash.integrate;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		DataSourceReader dataSourceReader=new DataSourceReader("DB");
		DataSource dataSource=dataSourceReader.getDataSource();
		Class.forName(dataSource.getDriver());
		return (Connection) DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
	}
}
