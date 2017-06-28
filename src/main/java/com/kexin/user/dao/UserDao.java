package com.kexin.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface UserDao {

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
	public List<Map> findUserName(@Param("username") String username, @Param("password") String password)
			throws Exception;

	/**
	 * 根据用户名返回用户的ID （添加商品信息）
	 * 
	 * @param loginName
	 *            用户名
	 * @return 根据用户名查询用户的ID，返回用户的ID（添加商品信息使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public String getUserId(@Param("loginName") String loginName) throws Exception;

	/**
	 * 查询用户信息
	 * 
	 * @return 返回查询用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> findUser() throws Exception;

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
	public void addUserName(@Param("userId") String userId, @Param("loginName") String loginName,
			@Param("passWord") String passWord) throws Exception;

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return 返回根据ID查询的用户信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> getUserbyId(@Param("userId") String userId) throws Exception;

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
	public void updateUserName(@Param("userId") String userId, @Param("loginName") String loginName,
			@Param("passWord") String passWord) throws Exception;

	/**
	 * 根据ID删除用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return 根据ID删除用户的信息，返回删除用户
	 * @throws Exception
	 *             抛出异常
	 */
	public void DeleteUserName(@Param("userId") String userId) throws Exception;
}
