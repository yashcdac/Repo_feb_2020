package com.yash.dao;

import java.sql.SQLException;
import java.util.List;

import com.yash.entities.Region;

public interface RegionDao {

	List<Region> getAllRegions() throws Exception ;
}
