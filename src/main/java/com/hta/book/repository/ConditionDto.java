package com.hta.book.repository;

public class ConditionDto {
	private String op;
	private String value;
	private String item;
	private String secondop;
	private String seconditem;
	private String secondvalue;
	private String thirditem;
	private String thirdvalue;
	
	
	public String getSecondop() {
		return secondop;
	}
	public void setSecondop(String secondop) {
		this.secondop = secondop;
	}
	public String getSeconditem() {
		return seconditem;
	}
	public void setSeconditem(String seconditem) {
		this.seconditem = seconditem;
	}
	public String getSecondvalue() {
		return secondvalue;
	}
	public void setSecondvalue(String secondvalue) {
		this.secondvalue = secondvalue;
	}
	public String getThirditem() {
		return thirditem;
	}
	public void setThirditem(String thirditem) {
		this.thirditem = thirditem;
	}
	public String getThirdvalue() {
		return thirdvalue;
	}
	public void setThirdvalue(String thirdvalue) {
		this.thirdvalue = thirdvalue;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
}
