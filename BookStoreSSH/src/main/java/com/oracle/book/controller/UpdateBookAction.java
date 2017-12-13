package com.oracle.book.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.book.service.BookService;

@Namespace(value="/admin")  
@ParentPackage(value="struts-default")
@Action(value="updateBook")
@Controller
@Scope(value="prototype") 
@Results({  
   @Result(name="success", location="/index.jsp"), 
   @Result(name="input", location="/admin/UpdateBook.jsp") 
})
public class UpdateBookAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	public UpdateBookAction() {
		super();
	}
	@Resource
    private BookService bookService;
	
	private int id;
	private String sort;
	private String bookname;
	private String authorname;
	private String discount;
	private BigDecimal price;
	private int number;
	private String intro;

	

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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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





	

	@Override
    public String execute() throws Exception {
        bookService.modifyBook(id, sort, bookname, authorname, discount, price, number, intro);
        return SUCCESS;
    }  
}
