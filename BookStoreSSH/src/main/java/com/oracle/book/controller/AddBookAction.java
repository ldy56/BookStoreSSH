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
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.oracle.book.service.BookService;

@Namespace(value="/admin")  
@ParentPackage(value="struts-default") 
@Action(value="addBook")
@Controller
@Scope(value="prototype") 
@Results({  
   @Result(name="success", location="/admin/BookRegisterSucc.jsp"), 
   @Result(name="input", location="/admin/BookRegister.jsp")
})
public class AddBookAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 public AddBookAction() {
			super();
	}
		
	@Resource
    private BookService bookService;
	
	
	private String sort;
	private String bookname;
	private String authorname;
	private String discount;
	private String intro;
	private BigDecimal price;
	private int number;
    
	@RequiredStringValidator(
			//key = "error.sortField",
			message = "类别不能为空",
			trim = true,
			shortCircuit = true
	)
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@RequiredStringValidator(
			message = "书名不能为空",
			trim = true,
			shortCircuit = true
	)
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	@RequiredStringValidator(
			message = "作者不能为空",
			trim = true,
			shortCircuit = true
	)
	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	@RequiredStringValidator(
			message = "折扣不能为空",
			trim = true,
			shortCircuit = true
	)
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	@RequiredStringValidator(
			message = "简介不能为空",
			trim = true,
			shortCircuit = true
	)
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	@RequiredStringValidator(
			message = "价格不能为空",
			trim = true,
			shortCircuit = true
	)
	@DoubleRangeFieldValidator(
			message = "请输入正确价格"
	)
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@RequiredStringValidator(
			message = "数量不能为空",
			trim = true,
			shortCircuit = true
	)
	@IntRangeFieldValidator(
			message = "数量为整数"
	)
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}




    @Override
    public String execute() throws Exception {
    	System.out.println(sort + bookname + authorname + discount + price + number + intro);
    	bookService.registerBook(sort, bookname, authorname, discount, price, number, intro);
    	
        return SUCCESS;
    }  
}
