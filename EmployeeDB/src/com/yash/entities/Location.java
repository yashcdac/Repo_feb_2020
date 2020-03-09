package com.yash.entities;

public class Location {
	private int locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private Country country;
	
	public Location() {
	
	}

	public Location(int locationId, String streetAddress, String postalCode, String city, String stateProvince,
			Country country) {
	
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode
				+ ", city=" + city + ", stateProvince=" + stateProvince + ", country=" + country + "]";
	}
	
	
}
