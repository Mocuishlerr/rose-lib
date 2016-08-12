package com.xionglindong.lib.controllers;

import java.lang.annotation.Annotation;

import com.xionglindong.bean.User;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

public class LoginRequredInterceptor extends ControllerInterceptorAdapter{
	
	public LoginRequredInterceptor(){
		this.setPriority(900);
	}
	
	//覆盖这个方法返回一个注解类，使得只有注解了该Annotation的方法才会被起作用
	//（注解在控制器类或方法上均有效）
	//还有一个相反功能的方法：getDenyAnnotationClass，表示注解了某个annotatioin后，拦截器不要拦截他
	protected Class<? extends Annotation> getRequiredAnnotationClass(){
		return LoginRequired.class;
	}
	
	protected Object before(Invocation inv)throws Exception{
		User loginUser=(User) inv.getRequest().getAttribute("loginUser");
		// 如果当前没有登录就返回"r:/lib/login"表示重定向到http://host:port/lib/login页面
		if(loginUser==null){
			// 没有返回true或null，表示要中断整个处理流程，即不再继续调用其他拦截器以及最终的控制器
			return "r:/rose-lib/user";
		}
		// 返回true或null，表示继续整个流程
		return true;
	}

}
