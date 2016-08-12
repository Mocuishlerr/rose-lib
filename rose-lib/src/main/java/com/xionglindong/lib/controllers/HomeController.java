package com.xionglindong.lib.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@LoginRequired
@Path("")
public class HomeController {
	
	//1 跳转到/lib/book；    
	@Get("")
	public String redirect(){
//		return "r:/lib/book";
		return "login";
	}

}
