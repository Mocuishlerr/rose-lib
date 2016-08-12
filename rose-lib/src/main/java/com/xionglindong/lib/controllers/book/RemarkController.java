package com.xionglindong.lib.controllers.book;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xionglindong.bean.Remark;
import com.xionglindong.bean.User;
import com.xionglindong.dao.RemarkDAO;
import com.xionglindong.lib.controllers.LoginRequired;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Delete;
import net.paoding.rose.web.annotation.rest.Post;

@LoginRequired
@Path("{id:[0-9]+}/remark")
public class RemarkController {
	@Autowired
	private RemarkDAO remarkDAO;
	
	@Post("add")
	public String add(Invocation inv,Remark remark){
		if(StringUtils.isEmpty(remark.getEssay())){
			inv.addModel("book", inv.getRequest().getSession().getAttribute("book"));
			inv.addModel("remarks", inv.getRequest().getSession().getAttribute("remarks"));
			inv.addModel("remark_error", "评论内容不能为空！");
			return "/views/book_page";
		}
		User user=(User) inv.getRequest().getSession().getAttribute("loginUser");
//		System.out.println("登陆的用户名："+user.getLoginName());
		remark.setUserName(user.getLoginName());
//		remark.setEssay(inv.getRequest().getParameter("essay"));
		remarkDAO.save(remark);
		return "r:/rose-lib/book/"+remark.getBookId();
	}
	
	//7 删除该书的所有备注 
	@Post("deleteAll")
	public String clear(Invocation inv,@Param("bookId")int bookId){
		remarkDAO.deleteByBookId(bookId);
		return "r:/rose-lib/book/"+bookId;
	}
	
	//8 删除某一个备注  
	@Post("{remarkId}/delete")
	public String removeRemark(@Param("bookId")int bookId,@Param("remarkId")int remarkId){
		remarkDAO.delete(remarkId);
		return "r:/rose-lib/book/"+bookId;
	}

}
