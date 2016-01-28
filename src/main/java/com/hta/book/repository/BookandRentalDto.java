package com.hta.book.repository;

import org.springframework.web.multipart.MultipartFile;

public class BookandRentalDto {
	private int book_num;          
	private String  book_loc;
	private boolean  book_status;
	private String  book_img;
	private String  book_imdate;
	private boolean  book_res;
	private String  book_chunggu;
	private String  book_isbn;
	private String  book_title;          
	private String  book_label;          
	private String  book_author;          
	private String  book_genre;
	private int rental_num;
    private String rental_date;
	private String renbtal_returndate;
	private int return_sal;
	private int rental_extension;
	private int rental_res1;
	private int rental_return;           
	private String member_email;
	private int overdate;   //��ü��
	private String returndate; //�ݳ���
	private int res_num; //�����ȣ
	private String res_date; //������ 		
    private String res_end;// ���� ������
    private int rentallimit; 
    private int reslimit;
    private MultipartFile file;
    private String book_imgname;
    private String member_phonenumber;  
	private String return_date;

	
    
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
	public String getMember_phonenumber() {
		return member_phonenumber;
	}
	public void setMember_phonenumber(String member_phonenumber) {
		this.member_phonenumber = member_phonenumber;
	}
	public String getBook_imgname() {
		return book_imgname;
	}
	public void setBook_imgname(String book_imgname) {
		this.book_imgname = book_imgname;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public int getRentallimit() {
		return rentallimit;
	}
	public void setRentallimit(int rentallimit) {
		this.rentallimit = rentallimit;
	}
	public int getReslimit() {
		return reslimit;
	}
	public void setReslimit(int reslimit) {
		this.reslimit = reslimit;
	}
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
	public int getOverdate() {
		return overdate;
	}
	public void setOverdate(int overdate) {
		this.overdate = overdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public String getBook_loc() {
		return book_loc;
	}
	public void setBook_loc(String book_loc) {
		this.book_loc = book_loc;
	}
	public boolean isBook_status() {
		return book_status;
	}
	public void setBook_status(boolean book_status) {
		this.book_status = book_status;
	}
	
	public String getBook_imdate() {
		return book_imdate;
	}
	public void setBook_imdate(String book_imdate) {
		this.book_imdate = book_imdate;
	}
	public boolean isBook_res() {
		return book_res;
	}
	public void setBook_res(boolean book_res) {
		this.book_res = book_res;
	}
	public String getBook_chunggu() {
		return book_chunggu;
	}
	public void setBook_chunggu(String book_chunggu) {
		this.book_chunggu = book_chunggu;
	}
	public String getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_label() {
		return book_label;
	}
	public void setBook_label(String book_label) {
		this.book_label = book_label;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_genre() {
		return book_genre;
	}
	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}
	public int getRental_num() {
		return rental_num;
	}
	public void setRental_num(int rental_num) {
		this.rental_num = rental_num;
	}
	public String getRental_date() {
		return rental_date;
	}
	public void setRental_date(String rental_date) {
		this.rental_date = rental_date;
	}
	public String getRenbtal_returndate() {
		return renbtal_returndate;
	}
	public void setRenbtal_returndate(String renbtal_returndate) {
		this.renbtal_returndate = renbtal_returndate;
	}
	public int getReturn_sal() {
		return return_sal;
	}
	public void setReturn_sal(int return_sal) {
		this.return_sal = return_sal;
	}
	public int getRental_extension() {
		return rental_extension;
	}
	public void setRental_extension(int rental_extension) {
		this.rental_extension = rental_extension;
	}
	public int getRental_res1() {
		return rental_res1;
	}
	public void setRental_res1(int rental_res1) {
		this.rental_res1 = rental_res1;
	}
	public int getRental_return() {
		return rental_return;
	}
	public void setRental_return(int rental_return) {
		this.rental_return = rental_return;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	
	
}
