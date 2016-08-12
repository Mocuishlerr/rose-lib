package com.xionglindong.dao;

import java.util.List;

import com.xionglindong.bean.Remark;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface RemarkDAO {
	
	@SQL("select id, user_name, book_id, essay, create_time from remark where book_id=:1")
	public List<Remark> findByBookId(int bookId);
	
	@SQL("DELETE FROM remark WHERE book_id=:1")
	public void deleteByBookId(int bookId);
	
	@SQL("DELETE FROM remark WHERE id=:1")
	public int delete(int remarkId);
	
	@SQL("insert into remark (user_name, book_id, essay) values(:1.userName, :1.bookId, :1.essay)")
	public void save(Remark remark);
	

}
