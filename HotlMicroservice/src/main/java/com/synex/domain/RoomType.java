package com.synex.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomType {
	@Id
    private int typeId;
    private String name;
	public RoomType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RoomType [typeId=" + typeId + ", name=" + name + "]";
	}
    
    
}
