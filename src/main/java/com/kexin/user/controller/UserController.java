package com.kexin.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kexin.user.entity.UserEntity;
import com.kexin.user.service.UserService;
import com.kexin.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 登录用户名的方法
	 */
	@RequestMapping("/registerUser")
	public String registerUser(HttpServletRequest request) throws Exception {
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserService userservice = new UserServiceImpl();
			List<Map<String, String>> list = userservice.fontUserName(username, password);
			// 返回list的值，在servlet里面接收list的值。如果查询的值与数据库匹配，则list.size()>0，登录成功，否则登录失败
			if (list.size() > 0) {
				// session对象传用户名
				HttpSession session = request.getSession();
				session.setAttribute("name", username);
				return "show/success";
			    } else {
				return "show/register";
			}
	}

	/**
	 * 添加用户名
	 */
	@RequestMapping("/addUserName")
	public String addUserName(HttpServletRequest request) throws Exception {
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			String loginName = request.getParameter("loginName");
			String passWord = request.getParameter("passWord");
			UserService userservice = new UserServiceImpl();
			userservice.addUserName(userId, loginName, passWord);
		    return "redirect:/user/fondUser";
	}

	/**
	 * 根据Id查询用户信息
	 */
	@RequestMapping("/getIdFondUserName")
	public String getIdFondUserName(HttpServletRequest request) throws Exception {
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			UserService userservice = new UserServiceImpl();
			List<Map<String, String>> list = userservice.getIdFondUser(userId);
			request.setAttribute("list", list); 
		    return "username/updateuser";
	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping("/updateUserName")
	public String updateUserName(HttpServletRequest request) throws Exception {
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			String loginName = request.getParameter("loginName");
			String passWord = request.getParameter("passWord");
			UserService userservice = new UserServiceImpl();
			userservice.updateUserName(userId, loginName, passWord);
			return "redirect:/user/fondUser";
	}

	/**
	 * 查询用户信息
	 */
	@RequestMapping("/fondUser")
	public String fondUser(HttpServletRequest request) throws Exception {
			request.setCharacterEncoding("UTF-8");
			UserService userservice = new UserServiceImpl();
			List<UserEntity> list = userservice.fondUser();
			request.setAttribute("list", list);
		    return "username/userindex";
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("/deleteUserName")
	public String deleteUserName(HttpServletRequest request) throws Exception {
			request.setCharacterEncoding("UTF-8");
			String userId = request.getParameter("userId");
			UserService userservice = new UserServiceImpl();
			userservice.DeleteUserName(userId);
		    return "redirect:/user/fondUser";
	}

	/**
	 * 返回新增用户名页面
	 */
	@RequestMapping("returnAddUserJsp")
	public String returnAddUserJsp() throws Exception{

		return "username/add";
	}
}
