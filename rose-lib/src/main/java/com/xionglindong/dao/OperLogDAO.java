package com.xionglindong.dao;

import java.util.List;

import com.xionglindong.bean.OperLog;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface OperLogDAO {
	
	@SQL("select id,user_name,resource_pattern,resource_id,success,remarks,create_time from oper_log order by id limit :1,:2")
	public List<OperLog> find(int start, int size);
	
	@SQL("insert into oper_log(user_name,resource_pattern,resource_id,success,remarks)"
			+ " values(:1.userName,:1.resourcePattern,:1.resourceId,:1.success,:1.remarks)")
	public void save(OperLog operLog);
	
	@SQL("select count(*) from oper_log")
	public Integer getLogCount();

}
