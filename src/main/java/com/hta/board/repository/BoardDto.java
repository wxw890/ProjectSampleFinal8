package com.hta.board.repository;

//dto
public class BoardDto {
  private int b_num; 
  private String b_title; 
  private String b_content;
  private String b_writer;
  private String b_date; 
  private int b_count;
  private String b_password;
  private String member_email;
  private int pos;
  private int depth;
  private String keyWord;
  private String keyField;
  private String filename;
  private String filepath;
  
  public BoardDto(){}

public BoardDto(int b_num, String b_title, String b_content, String b_writer, String b_date, int b_count,
		String b_password, String member_email, int pos, int depth, String keyWord, String keyField, String filenme, String filepath) {
	super();
	this.b_num = b_num;
	this.b_title = b_title;
	this.b_content = b_content;
	this.b_writer = b_writer;
	this.b_date = b_date;
	this.b_count = b_count;
	this.b_password = b_password;
	this.member_email = member_email;
	this.pos = pos;
	this.depth = depth;
	this.keyWord = keyWord;
	this.keyField = keyField;
	this.filename = filenme;
	this.filepath = filepath;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getFilepath() {
	return filepath;
}

public void setFilepath(String filepath) {
	this.filepath = filepath;
}

public int getB_num() {
	return b_num;
}

public void setB_num(int b_num) {
	this.b_num = b_num;
}

public String getB_title() {
	return b_title;
}

public void setB_title(String b_title) {
	this.b_title = b_title;
}

public String getB_content() {
	return b_content;
}

public void setB_content(String b_content) {
	this.b_content = b_content;
}

public String getB_writer() {
	return b_writer;
}

public void setB_writer(String b_writer) {
	this.b_writer = b_writer;
}

public String getB_date() {
	return b_date;
}

public void setB_date(String b_date) {
	this.b_date = b_date;
}

public int getB_count() {
	return b_count;
}

public void setB_count(int b_count) {
	this.b_count = b_count;
}

public String getB_password() {
	return b_password;
}

public void setB_password(String b_password) {
	this.b_password = b_password;
}

public String getMember_email() {
	return member_email;
}

public void setMember_email(String member_email) {
	this.member_email = member_email;
}

public int getPos() {
	return pos;
}

public void setPos(int pos) {
	this.pos = pos;
}

public int getDepth() {
	return depth;
}

public void setDepth(int depth) {
	this.depth = depth;
}

public String getKeyField() {
	return keyField;
}

public void setKeyField(String keyField) {
	this.keyField = keyField;
}

public String getKeyWord() {
	return keyWord;
}

public void setKeyWord(String keyWord) {
	this.keyWord = keyWord;
}
  


  
  
}