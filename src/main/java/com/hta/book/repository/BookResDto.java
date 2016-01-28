package com.hta.book.repository;

public class BookResDto {
	private int res_num; 
    private String member_email; 
    private int book_num;
    private String res_date; 		
    private String res_end;
    
    
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_end() {
		return res_end;
	}
	public void setRes_end(String res_end) {
		this.res_end = res_end;
	}
	public int getRes_num() {
		return res_num;
	}
	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	} 
    
    
}
