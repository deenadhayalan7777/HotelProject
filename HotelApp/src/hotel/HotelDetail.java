package hotel;

import java.io.Serializable;

public class HotelDetail implements Serializable {

	private int hotelId;
	private String username;
    private String phone;
	public int getHotelId() {
		return hotelId;
	}
	public HotelDetail(int hotelId, String username, String phone, float rating, int status) {
		
		this.hotelId = hotelId;
		this.username = username;
		this.phone = phone;
		this.rating = rating;
		this.status=status;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	private float rating;
	private int status;
	
}
