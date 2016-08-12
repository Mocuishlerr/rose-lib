package com.xionglindong.lib.controllers.book;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xionglindong.bean.Book;
import com.xionglindong.bean.Remark;
import com.xionglindong.dao.BookDAO;
import com.xionglindong.dao.RemarkDAO;
import com.xionglindong.lib.controllers.LoginRequired;
import com.xionglindong.util.Utils;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

@LoginRequired
@Path("")
public class BookController {
	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private RemarkDAO remarkDAO;
	
	private int size = 10;
	
	//2 按页浏览书库的书，参数byBookId用于定位与分页；
//	@Get("{p:[0-9]+}")
	@Get
	public String bookList(Invocation inv,@Param("p")int page){
		Cookie[] cookies=inv.getRequest().getCookies();
		cookies.toString();
		int start = (page-1)*size;
		List<Book> books=bookDAO.findPage(start, size);
		int Count=bookDAO.getBookCount();
		int bookCount=getCount(Count, size);
		inv.addModel("books", books);
		inv.addModel("bookCount", bookCount);
		return "book-list";
	}
	
	//3 增加一本书，参数为name、author、price，都是必填项目；
	@Post("add")
	public String addBook(Invocation inv,Book book){
		if(StringUtils.isEmpty(book.getName())||StringUtils.isEmpty(book.getAuthor())
				||StringUtils.isEmpty(book.getPrice())){
			inv.addModel("error", "任何一项都不能为空！");
			return "add-book";
		}
		// 书的名称和作者不能同时在数据库中有重复
		List<Book> books=bookDAO.getBookByName(book.getName());
		for(Book b:books){
			if(b.getAuthor().equals(book.getAuthor())){
				inv.addModel("error", "书的名称和作者不能同时在数据库中有重复");
				return "add-book";
			}
		}
		bookDAO.save(book);
		return "r:/rose-lib/book?p=1";
	}
	
	//4 显示增加书的页面     
	@Get("add")
	public String showAdd(){
		return "add-book";
	}
	
	//5 展示该书的详细信息，包括附属的所有评论，最新的备注在前；
	//如果带有edit参数，则返回编辑页面，页面不包含评论
	// 可以通过大括号表示一个变量，通过冒号说明他的正则规则
	@Get("{id:[0-9]+}")
	public String show(Invocation inv,@Param("id")int id,@Param("edit")boolean edit){
		//TODO 数据库操作
		Book book=bookDAO.get(id);
		List<Remark> remarks=remarkDAO.findByBookId(id);
		inv.addModel("book", book);
		inv.addModel("remarks", remarks);
		//放入session中
		inv.getRequest().getSession().setAttribute("book", book);
		inv.getRequest().getSession().setAttribute("remarks", remarks);
		if(edit){
			return "book_edit";
		}
		return "book_page";
	}
	
	//6 修改该书的信息 
	@Post("{id:[0-9]+}/update")
	public String update(Invocation inv,@Param("id")int id,Book book){
		if(StringUtils.isEmpty(book.getPrice())){
			inv.addModel("error", "不能为空！");
			return "book_edit";
		}
		//TODO 数据库操作
		Book booker=bookDAO.get(id);
		Utils.updateModel(booker, book);
		bookDAO.update(book);
		return "r:/rose-lib/book/"+id;
	}
	
	// 删除该书
	@Post("{id:[0-9]+}/delete")
	public String delete(@Param("id")int id){
		bookDAO.deleteById(id);
		return "r:/rose-lib/book?p=1";
	}
	
	//搜索
	@Post("")
	public String searchString(Invocation inv,@Param("string")String string,
			@Param("search")String search, @Param("page")int page){
		List<Book> books=new ArrayList<Book>();
		int count=0,bookCount=0;
		int start = (page-1)*size;
		if("name".equals(search)){
			count=bookDAO.getBookBySearchNameCount(string);	
			bookCount=getCount(count, size);
			books=bookDAO.getBookBySearchName(string,start,size);
		}else{
			count=bookDAO.getBookBySearchAuthorCount(string);
			bookCount=getCount(count, size);
			books=bookDAO.getBookBySearchAuthor(string,start,size);
		}
		inv.addModel("books", books);	
		inv.addModel("bookCount", bookCount);
		return "book-list";
	}
	
//	//增加评论
//	@Post("{id:[0-9]}/remark/add")
//	public String addComment(Invocation inv,@Param("id")int id,@Param("essay")String essay){
//		User user=(User) inv.getRequest().getSession().getAttribute("loginUser");
//		String userName=user.getLoginName();
//		Remark remark=new Remark();
//		remark.setBookId(id);
//		remark.setEssay(essay);
//		remark.setUserName(userName);
//		remarkDAO.save(remark);
//		return "book_page";
//	}
	
	public Integer getCount(int count, int size){
		if(count%size==0){
			return count/size;
		}
		return count/size+1;
	}
	

}
