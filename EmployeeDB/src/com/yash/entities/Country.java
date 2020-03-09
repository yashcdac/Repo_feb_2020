package com.yash.entities;

public class Country {
	private String countryId;
	private String CountryName;
	private Region region;
	
	public Country() {
		
	}
	public Country(String countryId, String countryName, Region region) {
	
		this.countryId = countryId;
		CountryName = countryName;
		this.region = region;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", CountryName=" + CountryName + ", region=" + region + "]";
	}
	
	
}
