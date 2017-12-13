package com.oracle.book.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.oracle.book.domain.Book;
import com.oracle.book.exception.BookException;
import com.oracle.book.service.BookService;

@Namespace(value="/admin")  
@ParentPackage(value="struts-default")
@Action(value="selectAllBook")
@Controller
@Scope(value="prototype") 
@Results({  
   @Result(name="success", location="/ListBooks.jsp"), 
   @Result(name="input", location="/index.jsp") 
})
public class SelectAllBookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SelectAllBookAction() {
		super();
	}

	@Resource
    private BookService bookService;

    @Override
    public String execute() throws BookException {
    	List<Book> books = null;
    	
        books = bookService.getAllBooks();

        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = 
                (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);  
        
        request.setAttribute("books", books);
        return SUCCESS;
    }  
}
