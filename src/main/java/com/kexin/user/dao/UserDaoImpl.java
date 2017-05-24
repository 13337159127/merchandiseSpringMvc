package com.kexin.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kexin.user.entity.UserEntity;
/**
 * 操作数据库  类实现接口   实现对用户信息的增删改查
 * @author caokexin
 *
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
	 
	/**
	 * 会话工厂  方法被调用（共享）
	 * @return
	 *    返回一个共享的方法
	 * @throws Exception
	 *    抛出异常
	 */
	public Statement getStatement() throws Exception{
		// 定义变量
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/commoditymessage?"
					+ "user=root&password=1234&useUnicode=true&characterEncoding=UTF8";
			Connection conn = DriverManager.getConnection(url);
			statement = conn.createStatement();
		} catch (Exception e) {
			throw new Exception(e);
		}
		return statement;
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
		// 定义一个集合list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Statement statement =  getStatement();
			String sql = "select * from user where loginName='" + username + "' and passWord='" + password + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String loginName = re.getString("loginName");
				String passWord = re.getString("passWord");
				// 定义一个集合map
				Map<String, String> map = new HashMap<String, String>();
				map.put("username", loginName);
				map.put("password", passWord);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
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
		try {
			Statement statement = getStatement();
			String sql = "select userId from user where loginName='" + loginName + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			String userId = "";
			while (re.next()) {
				userId = re.getString("userId");
			}
			return userId;
		} catch (Exception e) {
			throw new Exception(e);
		}
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
		// 创建一个list
		List<UserEntity> list = new ArrayList<UserEntity>();
		try {
			Statement statement =  getStatement();
			String sql = "select * from user";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String userId = re.getString("userId");
				String loginName = re.getString("loginName");
				String passWord = re.getString("passWord");
				UserEntity userentity = new UserEntity();
				userentity.setUserId(userId);
				userentity.setPassWord(passWord);
				userentity.setLoginName(loginName);
				list.add(userentity);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
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
		try {
			Statement statement =  getStatement();
			String sql = "insert into user(userId,loginName,passWord) values('" + userId + "','" + loginName + "','"
					+ passWord + "')";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
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
	public List<Map<String, String>> getUserbyId(String userId) throws Exception {
		// 创建一个list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Statement statement =  getStatement();
			String sql = "select * from user where userId='" + userId + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String loginName = re.getString("loginName");
				String passWord = re.getString("passWord");
				Map<String, String> map = new HashMap<String, String>();
				map.put("loginName", loginName);
				map.put("passWord", passWord);
				map.put("userId", userId);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
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
		try {
			Statement statement =  getStatement();
			String sql = "update user set loginName='" + loginName + "',passWord='" + passWord + "' where userId='"
					+ userId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
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
		try {
			Statement statement =  getStatement();
			String sql = "delete from user where userId='" + userId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return userId;
	}
}
