package com.hta.studyroom.repository;

//studyroom 예약 관련  DTO
public class StudyroomDto {
	private int reservation_num;
	private String reservation_date;
	private String reservation_time;
	private int table_num;
	private String member_email;
	private String member_name;
	
	public StudyroomDto(){}
	
	public StudyroomDto(int reservation_num, String reservation_date, String reservation_time, int table_num,
			String member_email, String member_name) {
		super();
		this.reservation_num = reservation_num;
		this.reservation_date = reservation_date;
		this.reservation_time = reservation_time;
		this.table_num = table_num;
		this.member_email = member_email;
		this.member_name = member_name;
	}

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}

	public String getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	public String getReservation_time() {
		return reservation_time;
	}

	public void setReservation_time(String reservation_time) {
		this.reservation_time = reservation_time;
	}

	public int getTable_num() {
		return table_num;
	}

	public void setTable_num(int table_num) {
		this.table_num = table_num;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	

	
}