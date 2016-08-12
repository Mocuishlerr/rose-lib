package com.xionglindong.lib.controllers.logs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xionglindong.bean.OperLog;
import com.xionglindong.dao.OperLogDAO;
import com.xionglindong.lib.controllers.LoginRequired;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@LoginRequired
@Path("")
public class LogsController {
	@Autowired
	private OperLogDAO operLogDAO;
	
	//16 按页列出所有用户操作日志   
	@Get
	public String list(Invocation inv,@Param("offest")int offest,@Param("p")int page){
		int start = (page-1)*10;
		int size = 10;
		List<OperLog> operLogs=operLogDAO.find(start, size);
		Integer mount = operLogDAO.getLogCount();
		Integer count = getCount(mount, size);
		inv.addModel("operLogs", operLogs);
		inv.addModel("count", count);
		return "logs_list";
	}
	
	public Integer getCount(int count, int size){
		if(count%size==0){
			return count/size;
		}
		return count/size+1;
	}

}
