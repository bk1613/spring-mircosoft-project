package com.synex.domain;

public class Hoteladdress {
	
	private int hotelid;
	
	private String hotelNm;
	
	private String hotelAddr;
	
	private String hotelCt;
	
	private String hotelStt;
	
	private String image;

	public Hoteladdress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelNm() {
		return hotelNm;
	}

	public void setHotelNm(String hotelNm) {
		this.hotelNm = hotelNm;
	}

	public String getHotelAddr() {
		return hotelAddr;
	}

	public void setHotelAddr(String hotelAddr) {
		this.hotelAddr = hotelAddr;
	}

	public String getHotelCt() {
		return hotelCt;
	}

	public void setHotelCt(String hotelCt) {
		this.hotelCt = hotelCt;
	}

	public String getHotelStt() {
		return hotelStt;
	}

	public void setHotelStt(String hotelStt) {
		this.hotelStt = hotelStt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Hoteladdress [hotelid=" + hotelid + ", hotelNm=" + hotelNm + ", hotelAddr=" + hotelAddr + ", hotelCt="
				+ hotelCt + ", hotelStt=" + hotelStt + ", image=" + image + "]";
	}
	
	
}
