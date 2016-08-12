package com.xionglindong.lib.controllers;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xionglindong.bean.User;
import com.xionglindong.dao.UserDAO;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	//9 返回登录页面    
	@Get("")
	public String show(){
		return "login";
	}
	
	//10 执行登录判断
	@Post("")
	public String doLogin(Invocation inv,@Param("loginName")String loginName,
			@Param("password")String password){
		//TODO
		if(StringUtils.isEmpty(loginName)||StringUtils.isEmpty(password)){
			inv.addModel("error", "不能为空！");
			return "login";
		}
		User user=userDAO.getByLoginName(loginName);
		if(user==null){
			inv.addModel("loginName", loginName);
			inv.addModel("error", "用户名不存在！");
			return "login";
		}
		if(!user.getPassword().equals(password)){
			inv.addModel("loginName", loginName);
			inv.addModel("error", "密码错误！");
			return "login";
		}
		loginAction(inv, user);
		return "r:/rose-lib/book?p=1";
	}
	
	public static void loginAction(Invocation inv,User user){
		inv.getRequest().getSession().setAttribute("loginUser", user);
		//session的有效时间为10分钟
		inv.getRequest().getSession().setMaxInactiveInterval(10*60);
		Cookie cookie=new Cookie("user", String.valueOf(user.getId()));
		cookie.setMaxAge(5*60);
		cookie.setPath("/");
		inv.getResponse().addCookie(cookie);
	}

}
