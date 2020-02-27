package com.yash.dao;

import static com.yash.integrate.DBConnection.getConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.yash.entities.Region;

public class RegionDaoImpl implements RegionDao {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement1;
	
	public RegionDaoImpl() throws ClassNotFoundException, SQLException {
		connection=getConnection();
		statement=(Statement) connection.createStatement();
		
	}

	@Override
	public List<Region> getAllRegions() throws Exception {
		List<Region> regions=new ArrayList<>();
		ResultSet rs=statement.executeQuery("select * from regions");  
		while(rs.next())  
			  regions.add(new Region(rs.getInt(1), rs.getString(2)));
		return regions;
	}

}
