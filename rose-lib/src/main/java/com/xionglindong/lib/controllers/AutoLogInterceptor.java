package com.xionglindong.lib.controllers;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;

import com.xionglindong.bean.OperLog;
import com.xionglindong.bean.User;
import com.xionglindong.dao.OperLogDAO;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

/**
 * 拦截器放在controllers包下，称为局部拦截器，局部拦截器只作用于所在目录以及子目录的控制器
 * 
 * @author xiong_lindong
 *
 */
public class AutoLogInterceptor extends ControllerInterceptorAdapter {
	@Autowired
	private ExecutorService executorService;
	
	@Autowired
	private OperLogDAO operLogDAO;

	// 在整个页面渲染完毕或因异常导致流程被中断执行
	// 无论请求正常或异常地被处理，每一个拦截器afterCompletion都被执行
	public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
		final OperLog operLog = new OperLog();
		operLog.setResourcePattern(inv.getResourceId());
		operLog.setResourceId(inv.getRequestPath().getUri());
		operLog.setSuccess(ex == null ? 0 : 1);
		operLog.setRemarks(ex == null ? null : ex.getMessage());
//		String uid = inv.getResourceId();// /lib/book/{bookId}
//		String uri = inv.getRequestPath().getUri();// /lib/book/12345
//		boolean success = (ex == null);
//		String remarks = success ? "" : ex.getMessage();
		// TODO: save it to database
		User loginUser=(User) inv.getRequest().getSession().getAttribute("loginUser");
		if(loginUser!=null){
			operLog.setUserName(loginUser.getLoginName());
		}else{
			operLog.setUserName(inv.getRequest().getRemoteAddr());
		}
		
		//封装一个任务
		Runnable task=new Runnable() {			
			public void run() {
				operLogDAO.save(operLog);
			}
		};
		// 将插入到数据库的操作提交executorService做异步更新
        // 在实际场景中，这种方式要注意webapp shutdown的时候，还未执行的Task的处理问题
		executorService.submit(task);
	}

}
