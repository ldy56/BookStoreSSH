package com.oracle.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.book.domain.Book;


@Repository
@Transactional
public class BookDAO{

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	/*
	 * 添加新的书籍book
	 * 
	 * */
	public void saveBook(final Book b) throws Exception{
		
		hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				session.save(b);
				return null;
			}
			
		});
	}
	
	/*
	 * 查询所有书籍List
	 * 		返回值  list集合
	 * 
	 * */
	public List<Book> findBooks(){
		return (List<Book>) hibernateTemplate.execute(new HibernateCallback(){
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				
				String hql = "from Book";
				Query query = session.createQuery(hql);
				System.out.println("asdsa");
				List list = query.list();
				return list;
			}
			
		});
	}
	/*
	 * 根据书号查找书籍
	 *   	返回值  Book
	 * 
	 * */
	public Book getBook(int id){
		return (Book) hibernateTemplate.get(Book.class, id);
	}
	
	/*
	 * 
	 * 根据传入的类以id为索引修改数据
	 *
	 * */
	public void updateBook(final Book b) throws Exception{
		//hibernateTemplate.saveOrUpdate(p);
		hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				/*Transaction tran = session.beginTransaction();
				session.setFlushMode(FlushMode.AUTO);
				session.update(b);
				tran.commit();
				System.out.println("update ok...");*/
				
				
				String hql = "update Book set sort=? , bookname=? , authorname=?, discount=?, price=?, number=?, intro=? where id=?";
				Query query = session.createSQLQuery(hql);
				
				query.setString(0, b.getSort());
				query.setString(1, b.getBookname());
				query.setString(2, b.getAuthorname());
				query.setString(3, b.getDiscount());
				query.setBigDecimal(4, b.getPrice());
				query.setInteger(5, b.getNumber());
				query.setString(6, b.getIntro());
				query.setInteger(7, b.getId());
				
				query.executeUpdate();
				
				return null;
			}
			
		});
	}
	/*
	 * 根据id删除
	 * */
	public void deleteBook(int id){
		
		hibernateTemplate.execute(new HibernateCallback(){
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				System.out.println("id = " + id);
				
				String hql = "delete from Book  where id=?";
				Query query = session.createSQLQuery(hql);
				query.setInteger(0, id);
				
				query.executeUpdate();
				return null;
			}
			
		});
	}

	

}
