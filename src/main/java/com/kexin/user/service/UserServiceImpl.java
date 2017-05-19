package com.kexin.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kexin.user.dao.UserDao;
import com.kexin.user.entity.UserEntity;
/**
 * 调用dao层  处理业务操作
 * @author caokexin
 *
 */
@Service(value="userservice")
public class UserServiceImpl implements UserService {
	//声明变量名 为变量赋值
	@Autowired 
	private UserDao userdao;
	//set方法设置注入
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	/**
	 * 查询用户名和密码（登录用户）
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 *            返回查询用户名和密码，返回判断登录成功，失败
	 * @throws Exception
	 *            抛出异常
	 */
	public List<Map<String, String>> findUserName(String username, String password) throws Exception {
		List<Map<String, String>> list = userdao.findUserName(username, password);
		return list;
	}

	/**
	 * 根据用户名查询用户的ID （添加商品信息）
	 * 
	 * @param loginName
	 *            用户名
	 * @return
	 *            根据用户名查询用户的ID，返回用户的ID（添加商品信息使用）
	 * @throws Exception
	 *            抛出异常
	 */
	public String getUserId(String loginName) throws Exception {
		String userId = userdao.getUserId(loginName);
		return userId;
	}

	/**
	 * 查询用户信息
	 * 
	 * @return
	 *             返回查询用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<UserEntity> findUser() throws Exception {
		List<UserEntity> list = userdao.findUser();
		return list;
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
	 * @return
	 *            返回添加用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String addUserName(String userId, String loginName, String passWord) throws Exception {
		userdao.addUserName(userId, loginName, passWord);
		return userId;
	}

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 *            返回根据ID查询的用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> getIdfindUser(String userId) throws Exception {
		List<Map<String, String>> list = userdao.getIdfindUser(userId);
		return list;
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
	 * @return
	 *           返回修改的用户信息
	 * @throws Exception
	 *            抛出异常
	 */
	public String updateUserName(String userId, String loginName, String passWord) throws Exception {
		userdao.updateUserName(userId, loginName, passWord);
		return userId;
	}

	/**
	 * 根据ID删除用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 *            根据ID删除用户的信息，返回删除用户
	 * @throws Exception
	 *            抛出异常
	 */
	public String DeleteUserName(String userId) throws Exception {
		userdao.DeleteUserName(userId);
		return userId;
	}
}