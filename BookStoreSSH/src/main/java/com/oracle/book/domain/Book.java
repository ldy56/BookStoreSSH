package com.oracle.book.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String sort;
	private String bookname;
	private String authorname;
	private String discount;
	private BigDecimal price;
	private int number;
	private String intro;
	
	public Book() {
		super();
	}

	public Book(String sort, String bookname, String authorname, String discount, BigDecimal price, int number,
			String intro) {
		super();
		this.sort = sort;
		this.bookname = bookname;
		this.authorname = authorname;
		this.discount = discount;
		this.price = price;
		this.number = number;
		this.intro = intro;
	}

	public Book(int id, String sort, String bookname, String authorname, String discount, BigDecimal price, int number,
			String intro) {
		super();
		this.id = id;
		this.sort = sort;
		this.bookname = bookname;
		this.authorname = authorname;
		this.discount = discount;
		this.price = price;
		this.number = number;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", sort=" + sort + ", bookname=" + bookname + ", authorname=" + authorname
				+ ", discount=" + discount + ", price=" + price + ", number=" + number + ", intro=" + intro + "]";
	}
	
	
}
