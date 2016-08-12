package com.xionglindong.lib.controllers;

import com.xionglindong.bean.User;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Interceptor;

//用户发出一次请求，拦截一次
@Interceptor(oncePerRequest=true)
public class PassportInterceptor extends ControllerInterceptorAdapter{
	
	public PassportInterceptor(){
		//优先级越高的拦截器，其before方法越先执行
		//数值越大，优先级越高
		this.setPriority(1000);
	}
	
	//before方法在调用控制器方法前执行，相反的after则是控制器执行后才执行
	protected Object before(Invocation inv)throws Exception{
		User loginUser=new User();
		if(loginUser!=null){
			inv.getRequest().setAttribute("loginUser", loginUser);
		}
		return true;		
	}

}
