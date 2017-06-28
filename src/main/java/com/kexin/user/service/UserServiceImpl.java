package com.kexin.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kexin.user.dao.UserDao;

/**
 * 调用dao层 处理业务操作
 * 
 * @author caokexin
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	// 声明变量名 为变量赋值
	@Autowired
	private UserDao userDao;

	/**
	 * 查询用户名和密码（登录用户）
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 返回查询用户名和密码，返回判断登录成功，失败
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> findUserName(String username, String password) throws Exception {
		return userDao.findUserName(username, password);
	}

	/**
	 * 根据用户名查询用户的ID （添加商品信息）
	 * 
	 * @param loginName
	 *            用户名
	 * @return 根据用户名查询用户的ID，返回用户的ID（添加商品信息使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public String getUserId(String loginName) throws Exception {
		return userDao.getUserId(loginName);
	}

	/**
	 * 查询用户信息
	 * 
	 * @return 返回查询用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> findUser() throws Exception {
		return userDao.findUser();
	}

	/**
	 * 添加用户信息
	 * 
	 * @param userId
	 *            用户名ID
	 * @param loginName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 返回添加用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String addUserName(String userId, String loginName, String passWord) throws Exception {
		userDao.addUserName(userId, loginName, passWord);
		return "添加";
	}

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return 返回根据ID查询的用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> getUserbyId(String userId) throws Exception {
		return userDao.getUserbyId(userId);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @param loginName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 返回修改的用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String updateUserName(String userId, String loginName, String passWord) throws Exception {
		userDao.updateUserName(userId, loginName, passWord);
		return "修改";
	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return 根据ID删除用户的信息，返回删除用户
	 * @throws Exception
	 *             抛出异常
	 */
	public String DeleteUserName(String userId) throws Exception {
		userDao.DeleteUserName(userId);
		return "1";
	}
}