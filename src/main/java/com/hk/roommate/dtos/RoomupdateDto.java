package com.hk.roommate.dtos;

import java.util.Date;

public class RoomupdateDto {
	
    private int r_seq;
    private String r_title;
    private String location;
    private String room1;
    private String room2;
    private int r_size;
    private int cost1;
    private int cost2;
    private int cost3;
    private int cost4;
    private String lat;
    private String lot;
    private String parking;
    private int stare;
    private String detail;
    private int click;
    private String roomoption;
    private String info;
    private Date updateregdate;
    
	public RoomupdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

    public RoomupdateDto(int r_seq, String location, String r_title, String room1, String room2, int r_size, int cost1, 
            int cost2, int cost3, int cost4, String lat, String lot, String parking, int stare, 
            String detail, int click, String roomoption, String info, Date updateregdate)
    {
        this.r_seq = r_seq;
        this.r_title = r_title;
        this.location = location;
        this.room1 = room1;
        this.room2 = room2;
        this.r_size = r_size;
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.cost3 = cost3;
        this.cost4 = cost4;
        this.lat = lat;
        this.lot = lot;
        this.parking = parking;
        this.stare = stare;
        this.detail = detail;
        this.click = click;
        this.roomoption = roomoption;
        this.info = info;
        this.updateregdate = updateregdate;
    }
	

	
    public RoomupdateDto(String location, String r_title, String room1, String room2, int r_size, int cost1, int cost2, 
            int cost3, int cost4, String lat, String lot, String parking, int stare, String detail, 
            String roomoption, String info)
    {
        this.location = location;
        this.r_title = r_title;
        this.room1 = room1;
        this.room2 = room2;
        this.r_size = r_size;
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.cost3 = cost3;
        this.cost4 = cost4;
        this.lat = lat;
        this.lot = lot;
        this.parking = parking;
        this.stare = stare;
        this.detail = detail;
        this.roomoption = roomoption;
        this.info = info;
    }


	public int getR_seq() {
		return r_seq;
	}


	public void setR_seq(int r_seq) {
		this.r_seq = r_seq;
	}


	public String getR_title() {
		return r_title;
	}


	public void setR_title(String r_title) {
		this.r_title = r_title;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getRoom1() {
		return room1;
	}


	public void setRoom1(String room1) {
		this.room1 = room1;
	}


	public String getRoom2() {
		return room2;
	}


	public void setRoom2(String room2) {
		this.room2 = room2;
	}


	public int getR_size() {
		return r_size;
	}


	public void setR_size(int r_size) {
		this.r_size = r_size;
	}


	public int getCost1() {
		return cost1;
	}


	public void setCost1(int cost1) {
		this.cost1 = cost1;
	}


	public int getCost2() {
		return cost2;
	}


	public void setCost2(int cost2) {
		this.cost2 = cost2;
	}


	public int getCost3() {
		return cost3;
	}


	public void setCost3(int cost3) {
		this.cost3 = cost3;
	}


	public int getCost4() {
		return cost4;
	}


	public void setCost4(int cost4) {
		this.cost4 = cost4;
	}


	public String getLat() {
		return lat;
	}


	public void setLat(String lat) {
		this.lat = lat;
	}


	public String getLot() {
		return lot;
	}


	public void setLot(String lot) {
		this.lot = lot;
	}


	public String getParking() {
		return parking;
	}


	public void setParking(String parking) {
		this.parking = parking;
	}


	public int getStare() {
		return stare;
	}


	public void setStare(int stare) {
		this.stare = stare;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public int getClick() {
		return click;
	}


	public void setClick(int click) {
		this.click = click;
	}


	public String getRoomoption() {
		return roomoption;
	}


	public void setRoomoption(String roomoption) {
		this.roomoption = roomoption;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public Date getUpdateregdate() {
		return updateregdate;
	}


	public void setUpdateregdate(Date updateregdate) {
		this.updateregdate = updateregdate;
	}


	@Override
	public String toString() {
		return "RoomupdateDto [r_seq=" + r_seq + ", r_title=" + r_title + ", location=" + location + ", room1=" + room1
				+ ", room2=" + room2 + ", r_size=" + r_size + ", cost1=" + cost1 + ", cost2=" + cost2 + ", cost3="
				+ cost3 + ", cost4=" + cost4 + ", lat=" + lat + ", lot=" + lot + ", parking=" + parking + ", stare="
				+ stare + ", detail=" + detail + ", click=" + click + ", roomoption=" + roomoption + ", info=" + info
				+ ", updateregdate=" + updateregdate + "]";
	}


}
