package com.revature.models;

public class TruckCoordinates {

	private int id;
	private String latitude;
	private String longitude;
	
	public TruckCoordinates() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "TruckCoordinates [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
