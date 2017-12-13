package com.oracle.book.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.book.dao.BookDAO;
import com.oracle.book.domain.Book;
import com.oracle.book.exception.BookException;


@Service
@Transactional
public class BookService {
	
	
	@Resource
	private BookDAO bookDAO;
	
	
	//登记新书籍入库的功能
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BookException.class)
	public void registerBook(String sort, String bookname , String authorname , String discount, BigDecimal price , int number , String intro) throws Exception {
		Book book = new Book(sort , bookname , authorname , discount, price , number, intro);
		
		bookDAO.saveBook(book);
	}
	
	
	//检索入库书籍的功能
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Book> getAllBooks() {
		return bookDAO.findBooks();
	}
	
	//检索指定入库书籍的功能
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}
	
	//删除书籍
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BookException.class)
	public void removeBook(int id) {
		bookDAO.deleteBook(id);
	}
	
	//修改书籍
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=BookException.class)
	public void modifyBook(int id, String sort, String bookname , String authorname , String discount, BigDecimal price , int number , String intro) throws Exception {
		Book book = new Book(id, sort , bookname , authorname , discount, price , number, intro);
		
		bookDAO.updateBook(book);

	}

}
