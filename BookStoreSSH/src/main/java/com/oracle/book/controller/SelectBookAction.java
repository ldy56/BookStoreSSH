package com.oracle.book.controller;

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
@Action(value="selectBook")
@Controller
@Scope(value="prototype") 
@Results({  
   @Result(name="success", location="/BookDetails.jsp"), 
   @Result(name="update", location="/admin/UpdateBook.jsp"), 
   @Result(name="input", location="/index.jsp")
}) 
public class SelectBookAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SelectBookAction(BookService bookService) {
			super();
	}
	
	@Resource
    private BookService bookService;

    private int id;
    private String nextpath;
    
    
	public String getNextpath() {
		return nextpath;
	}

	public void setNextpath(String nextpath) {
		this.nextpath = nextpath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}






	@Override
    public String execute() throws BookException {
		Book book = null;
		
        book = bookService.getBook(id);
        
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = 
                (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);  
        request.setAttribute("book", book);
        if("select".equals(nextpath)){
        	return SUCCESS;
        }else if("update".equals(nextpath)){
        	return "update";
        }else{
        	return "input";
        }
        
        
    }  
}
