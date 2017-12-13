package com.oracle.book.controller;

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
@Action(value="deleteBook")
@Controller
@Scope(value="prototype")
@Results({  
   @Result(name="success", type="redirect", location="/index.jsp"), 
   @Result(name="input", location="/ListBooks.jsp") 
})
public class DeleteBookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DeleteBookAction() {
		super();
	}

	@Resource
    private BookService bookService;

    private int id;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
    public String execute() {
		bookService.removeBook(id);
        return SUCCESS;
    }
}