package com.kexin.classify.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kexin.classify.entity.ClassifyEntity;
/**
 * 对数据库进行访问   实现商品分类的  增  删  改  查  
 * @author caokexin
 *
 */
@Repository(value="classifyDao")
public class ClassifyDaoImpl implements ClassifyDao {
	 
	/**
	 * 会话工厂   实现方法被调用（共享）
	 * @return
	 *       返回一个共享的方法
	 * @throws Exception
	 *        抛出异常
	 */    
	public Statement getStatement() throws Exception {
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
	 * 查询商品的分类 （添加，修改商品使用）
	 * 
	 * @return
	 *             查询商品的分类，返回商品分类的信息（添加，修改商品使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> selectClassify() throws Exception {
		// 创建一个list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Statement statement = getStatement();
			String sql = "select * from classify";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String categoryId = re.getString("categoryId");
				String category = re.getString("category");
				Map<String, String> map = new HashMap<String, String>();
				map.put("categoryId", categoryId);
				map.put("category", category);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 查询商品分类
	 * 
	 * @return
	 *             查询商品的分类信息，返回商品的分类信息表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<ClassifyEntity> findClassify() throws Exception {
		// 创建一个list
		List<ClassifyEntity> list = new ArrayList<ClassifyEntity>();
		try {
			Statement statement = getStatement();
			String sql = "select * from classify";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String categoryId = re.getString("categoryId");
				String category = re.getString("category");
				ClassifyEntity classifyentity = new ClassifyEntity();
				classifyentity.setCategoryId(categoryId);
				classifyentity.setCategory(category);
				list.add(classifyentity);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 添加商品分类
	 * 
	 * @param category
	 *            分类类别
	 * @param categoryId
	 *            分类ID
	 * @return
	 *            添加商品分类，返回商品分类ID和商品分类
	 * @throws Exception
	 *            抛出异常
	 */
	public String addClassify(String category, String categoryId) throws Exception {
		try {
			Statement statement = getStatement();
			String sql = "insert into classify(categoryId,category) values('" + categoryId + "','" + category + "')";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return category;
	}

	/**
	 * 根据ID查询商品分类（修改商品信息使用）
	 * 
	 * @param categoryid
	 *            商品的ID
	 * @return
	 *            根据ID查询商品分类，返回分类的信息
	 * @throws Exception
	 *            抛出异常
	 */
	public List<Map<String, String>> getClassifybyId(String categoryid) throws Exception {
		// 创建一个list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Statement statement = getStatement();
			String sql = "select * from classify where categoryId='" + categoryid + "'";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String categoryId = re.getString("categoryId");
				String category = re.getString("category");
				Map<String, String> map = new HashMap<String, String>();
				map.put("categoryId", categoryId);
				map.put("category", category);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 修改商品的分类
	 * 
	 * @param category
	 *            商品类别
	 * @param categoryId
	 *            商品ID
	 * @return
	 *            修改商品的分类，返回修改商品分类的信息
	 * @throws Exception
	 *            抛出异常
	 */
	public String updateClassify(String category, String categoryId) throws Exception {
		try {
			Statement statement = getStatement();
			String sql = "update classify set category='" + category + "' where categoryId='" + categoryId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return category;
	}

	/**
	 * 根据分类ID删除商品分类
	 * 
	 * @param categoryId
	 *            商品分类ID
	 * @return
	 *            根据分类ID删除商品分类，返回删除商品分类的信息
	 * @throws Exception
	 *            抛出异常
	 */
	public String deleteClassify(String categoryId) throws Exception {
		try {
			Statement statement = getStatement();
			String sql = "delete from classify where categoryId='" + categoryId + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return categoryId;
	}
}
