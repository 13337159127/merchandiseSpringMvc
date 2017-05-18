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
	 * 查询用户信息（用户登录）
	 * 
	 * @param request
	 * @return  
	 *             如果查询的值与数据库匹配，则list.size()>0，登录成功，返回成功页面，否则登录失败，返回首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/registerUser")
	public String registerUser(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userservice = new UserServiceImpl();
		List<Map<String, String>> list = userservice.findUserName(username, password);
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
	  * 添加用户信息
	  * @param request
	  * @return
	  *       返回用户信息首页
	  * @throws Exception
	  *       抛出异常
	  */
	@RequestMapping("/addUserName")
	public String addUserName(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String loginName = request.getParameter("loginName");
		String passWord = request.getParameter("passWord");
		UserService userservice = new UserServiceImpl();
		userservice.addUserName(userId, loginName, passWord);
		return "redirect:/user/findUser.kexin";
	}

	 /**
	  * 根据ID查询用户信息
	  * @param request
	  * @return
	  *    返回修改用户信息页面
	  * @throws Exception
	  *    抛出异常
	  */
	@RequestMapping("/getIdfindUserName")
	public String getIdfindUserName(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		UserService userservice = new UserServiceImpl();
		List<Map<String, String>> list = userservice.getIdfindUser(userId);
		request.setAttribute("list", list);
		return "username/updateuser";
	}

	 /**
	  * 修改用户信息
	  * @param request
	  * @return
	  *    返回用户信息首页
	  * @throws Exception
	  *    抛出异常
	  */
	@RequestMapping("/updateUserName")
	public String updateUserName(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String loginName = request.getParameter("loginName");
		String passWord = request.getParameter("passWord");
		UserService userservice = new UserServiceImpl();
		userservice.updateUserName(userId, loginName, passWord);
		return "redirect:/user/findUser.kexin";
	}

	 /**
	  * 查询用户信息
	  * @param request
	  * @return
	  *      返回用户信息首页
	  * @throws Exception 
	  *      抛出异常
	  */
	@RequestMapping("/findUser")
	public String findUser(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		UserService userservice = new UserServiceImpl();
		List<UserEntity> list = userservice.findUser();
		request.setAttribute("list", list);
		return "username/userindex";
	}

	 /**
	  * 根据ID删除用户
	  * @param request
	  * @return
	  *    返回用户信息首页
	  * @throws Exception
	  *    抛出异常
	  */
	@RequestMapping("/deleteUserName")
	public String deleteUserName(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		UserService userservice = new UserServiceImpl();
		userservice.DeleteUserName(userId);
		return "redirect:/user/findUser.kexin";
	}

	 /**
	  * 用户新增页面方法
	  * @return
	  *       返回新增用户信息页面
	  * @throws Exception 
	  *       抛出异常
	  */
	@RequestMapping("returnAddUserJsp")
	public String returnAddUserJsp() throws Exception {

		return "username/add";
	}
}
