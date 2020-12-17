package com.synex.domain;

public class RoomInventory {

	private int roomId;
	
	private int noRoom;

	public RoomInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomInventory(int roomid, int noRoom) {
		super();
		this.roomId = roomid;
		this.noRoom = noRoom;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomid) {
		this.roomId = roomid;
	}

	public int getNoRoom() {
		return noRoom;
	}

	public void setNoRoom(int noRoom) {
		this.noRoom = noRoom;
	}

	@Override
	public String toString() {
		return "RoomInventory [roomId=" + roomId + ", noRoom=" + noRoom + "]";
	}
	
	
}
