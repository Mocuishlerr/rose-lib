package com.xionglindong.dao;

import java.util.List;

import com.xionglindong.bean.Book;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 只有标注 @SQL 注解的方法才被Jade识别为可以查询数据库的、真正的DAO方法。
 * 
 * 或者是一个含有变量的 SQL 语句，此时需要使用 ":1"、":2"类似的符号表示一个变量， 其中1、2表示方法的第i个参数(i=1、2、3 ……)：
 * 
 * 也可以使用:id, :name的形式，但这需要在具体的方法参数前加 @SQLParam 注解进行说明：
 * 
 * 通过 ’.’ 号来使用Bean 的属性，将其作为 SQL 参数。 示例一: 使用 :1.id、:1.name、:1.age @SQL(
 * "INSERT user (id, name, age) VALUES (:1.id, :1.name, :1.age)") 
 * public void save(User user);
 * 
 * @author xiong_lindong
 *
 */
@DAO
public interface BookDAO {

	@SQL("SELECT id,book_id,name,price,author,create_time,book_type,book_status FROM book WHERE id=:1")
	public Book get(int bookId);

	@SQL("SELECT id,book_id,name,price,author,create_time,book_type,book_status FROM book order by id limit :1,:2")
	public List<Book> findPage(int start, int size);
	
	@SQL("select count(*) from book")
	public Integer getBookCount();
	
	@SQL("UPDATE book SET book_id=:1.bookId,name=:1.name,price=:1.price,author=:1.author,book_type=:1.bookType WHERE id=:1.id")
	public void update(Book book);
	
	@SQL("INSERT INTO book(book_id,name,price,author,book_type) VALUES(:1.bookId,:1.name, :1.price, :1.author,:1.bookType)")
	public void save(Book book);
	
	@SQL("SELECT id,book_id,name,price,author FROM book WHERE name=:1")
	public List<Book> getBookByName(String name);
	
	@SQL("delete from book where id=:1")
	public void deleteById(int bookId);
	
	/**根据书名来模糊查询*/
	@SQL("SELECT id,book_id,name,price,author,create_time,book_type,book_status FROM book WHERE name LIKE concat('%', :1, '%') order by id limit :2,:3")
	public List<Book> getBookBySearchName(String name,int start, int size);
	
	@SQL("SELECT count(*) FROM book WHERE name LIKE concat('%', :1, '%')")
	public Integer getBookBySearchNameCount(String name);
	
	/**
	 * 根据作者名来模糊查询
	 */
	@SQL("SELECT id,book_id,name,price,author,create_time,book_type,book_status FROM book WHERE author LIKE concat('%', :1, '%') order by id limit :2,:3")
	public List<Book> getBookBySearchAuthor(String author,int start, int size);
	
	@SQL("SELECT count(*) FROM book WHERE author LIKE concat('%', :1, '%')")
	public Integer getBookBySearchAuthorCount(String author);
	
	/**
	 * 更新书籍的状态
	 */
	@SQL("update book set book_status=:1.bookStatus WHERE id=:1.id")
	public Integer updateBookStatus(Book book);
	
}









