package com.xionglindong.dao;

import java.util.List;

import com.xionglindong.bean.User;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface UserDAO {
	
	@SQL("select id,name,login_name,password,create_time from user where login_name=:1")
	public User getByLoginName(String loginName);
	
	@SQL("select id,name,login_name,password,create_time from user where id=:1")
	public User getById(int id);
	
	@SQL("select id,name,login_name,create_time from user")
	public List<User> find();
	
	@SQL("delete from user where id=:1")
	public void delete(int id);
	
	@SQL("insert into user(login_name,password,name,groups)"
			+ " values(:1.loginName,:1.password,:1.name,:1.groups)")
	public void save(User user);
	
	@SQL("update user set login_name=:1.loginName, password=:1.password, name=:1.name where id=:1.id")
    public void update(User user);

}
