package com.xionglindong.lib.controllers.user;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xionglindong.bean.User;
import com.xionglindong.dao.UserDAO;
import com.xionglindong.lib.controllers.LoginRequired;
import com.xionglindong.util.Utils;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

@LoginRequired
@Path("")
public class UserController {
	@Autowired
	private UserDAO userDAO;
	//11  列出所有用户   
	@Get
	public String list(Invocation inv){
		List<User> users=userDAO.find();
		inv.addModel("users", users);
		return "user_list";
	}
	
	//12 新增一个注册用户  
	@Post("add")
	public String addUser(Invocation inv,@Param("password2")String password2,User user){
		if(StringUtils.isEmpty(user.getLoginName())||StringUtils.isEmpty(user.getPassword())
				||StringUtils.isEmpty(user.getName())){
			inv.addModel("error", "不能为空！");
			return "add_user";
		}
		User uu=userDAO.getByLoginName(user.getLoginName());
		if(uu!=null){
			inv.addModel("error", "用户名已经存在！");
			return "add_user";
		}
		if(!password2.equals(user.getPassword())){
			inv.addModel("error", "两次密码不相等！");
			return "add_user";
		}
		userDAO.save(user);
		return "r:/rose-lib/user";
	}
	
	//13 显示增加用户的页面
	@Get("add")
	public String showAdd(){
		return "add_user";
	}
	
	@Get("my")
    public String showMy(Invocation inv) {
        User user = (User) inv.getRequest().getSession().getAttribute("loginUser");
        inv.addModel("user", user);
        return "user_page";
    }
	
	//14 显示某个用户的详细信息；如果带有edit参数，则返回编辑页面
	@Get("{userId}")
	public String show(Invocation inv,@Param("userId")int userId,@Param("edit")boolean isEdit){
		User user=userDAO.getById(userId);
		inv.addModel("user", user);
		if(isEdit){
			return "user_edit";
		}
		return "user_page";
	}
	
	@Post("{userId}/info/update")
    public String updateUser(Invocation inv, @Param("userId")int userId, User user) {
        final User userFromDB = this.userDAO.getById(userId);
        // 服务器端验证字符的合法性
        if (StringUtils.isEmpty(user.getName())) {
            inv.addModel("user", userFromDB);
            inv.addModel("error", "任何一项都不能为空！");
            return "one_user_edit";
        }
        Utils.updateModel(userFromDB, user);
        this.userDAO.update(userFromDB);
        return "r:/rose-lib/user/" + userId;
    }

    @Post("{userId}/password/update")
    public String updatePassword(Invocation inv, @Param("userId")int userId,
            @Param("old_password")String oldPassword,
            @Param("password")String password, @Param("password2")String password2) {
        User userFromDB = this.userDAO.getById(userId);
        inv.addModel("user", userFromDB);
        // 服务器端验证字符的合法性
        if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(password2)) {
            inv.addModel("error", "任何一项都不能为空！");
            return "one_user_edit";
        }
        if (!password.equals(password2)) {
            inv.addModel("error", "两次输入的密码不相等！");
            return "one_user_edit";
        }
        User user = this.userDAO.getById(userId);
        if (!user.getPassword().equals(oldPassword)) {
            inv.addModel("error", "原密码错误！");
            return "one_user_edit";
        }
        user.setPassword(password);
        this.userDAO.update(user);
        return "r:/rose-lib/user/" + userId;
    }

    @Post("{userId}/delete")
    public String delete(@Param("userId")int userId) {
        this.userDAO.delete(userId);
        return "r:/rose-lib/user";
    }

    @Get("logout")
    public String logout(final Invocation inv) {
        User user = (User) inv.getRequest().getSession().getAttribute("loginUser");
        Cookie[] cookies = inv.getRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                String id = cookie.getValue();
                if (String.valueOf(user.getId()).equals(id)) {
                    final Cookie c = new Cookie(cookie.getName(), null);
                    c.setPath("/");
                    c.setMaxAge(0);
                    inv.getResponse().addCookie(c);
                    break;
                }
            }
        }
        inv.getRequest().getSession().removeAttribute("loginUser");
        inv.getRequest().getSession().invalidate();
        return "r:/rose-lib/login";
    }
	

}
