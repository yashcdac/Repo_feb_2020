package com.yash.integrate;

import java.util.ResourceBundle;

public class DataSourceReader {

	private DataSource dataSource;

	public DataSourceReader(String basename) {
		ResourceBundle bundle = ResourceBundle.getBundle(basename);
		dataSource = new DataSource();
		dataSource.setDriver(bundle.getString("driver"));
		dataSource.setUrl(bundle.getString("url"));
		dataSource.setUsername(bundle.getString("username"));
		dataSource.setPassword(bundle.getString("password"));
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}
