package com.kexin.supplier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kexin.supplier.entity.SupplierEntity;

/**
 * 对供货商进行增 删 改 查
 * 
 * @author caokexin
 *
 */
@Repository(value = "supplierDao")
public class SupplierDaoImpl implements SupplierDao {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private SupplierDao supplierDao;

	/**
	 * 会话工厂 实现方法被调用（共享）
	 * 
	 * @return 返回一个共享的方法
	 * @throws Exception
	 *             抛出异常
	 */
	public Statement getStatement() throws Exception {
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
	 * 查询供货商的信息
	 * 
	 * @return 返回供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<SupplierEntity> findSupplier() throws Exception {
		// 定义一个集合list
		List<SupplierEntity> list = new ArrayList<SupplierEntity>();
		try {
			Statement statement = supplierDao.getStatement();
			String sql = "select * from supplier";
			System.out.println(sql);
			ResultSet re = statement.executeQuery(sql);
			while (re.next()) {
				String supplierID = re.getString("supplierID");
				String supplierName = re.getString("supplierName");
				String supplierAddress = re.getString("supplierAddress");
				String supplierPhone = re.getString("supplierPhone");
				// 实列化实体类
				SupplierEntity supplierentity = new SupplierEntity();
				supplierentity.setSupplierID(supplierID);
				supplierentity.setSupplierName(supplierName);
				supplierentity.setSupplierAddress(supplierAddress);
				supplierentity.setSupplierPhone(supplierPhone);
				// 把对象放到list中
				list.add(supplierentity);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> getIdFindSupplier(String supplierID) throws Exception {
		// 定义一个集合list
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			Statement statement = supplierDao.getStatement();
			String sql = "select * from supplier where supplierId='" + supplierID + "'";
			ResultSet re = statement.executeQuery(sql);
			System.out.println(sql);
			while (re.next()) {
				String supplierName = re.getString("supplierName");
				String supplierAddress = re.getString("supplierAddress");
				String supplierPhone = re.getString("supplierPhone");
				Map<String, String> map = new HashMap<String, String>();
				map.put("supplierID", supplierID);
				map.put("supplierName", supplierName);
				map.put("supplierAddress", supplierAddress);
				map.put("supplierPhone", supplierPhone);
				list.add(map);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
		return list;
	}

	/**
	 * 修改供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @return 返回修改供货商信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String updateSupplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone)
			throws Exception {
		try {
			Statement statement = supplierDao.getStatement();
			String sql = "update supplier set supplierName='" + supplierName + "',supplierAddress='" + supplierAddress
					+ "',supplierPhone='" + supplierPhone + "' where supplierID='" + supplierID + "'";
			statement.executeUpdate(sql);
			System.out.println(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return supplierID;
	}

	/**
	 * 添加供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @param supplierName
	 *            供货商姓名
	 * @param supplierAddress
	 *            供货商地址
	 * @param supplierPhone
	 *            供货商电话
	 * @return 返回添加供货商信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String addSupplier(String supplierID, String supplierName, String supplierAddress, String supplierPhone)
			throws Exception {
		try {
			Statement statement = supplierDao.getStatement();
			String sql = "insert into supplier(supplierID,supplierName,supplierAddress,supplierPhone) values('"
					+ supplierID + "','" + supplierName + "','" + supplierAddress + "','" + supplierPhone + "')";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return supplierID;
	}

	/**
	 * 删除供货商信息
	 * 
	 * @param supplierID
	 *            供货商ID
	 * @return 返回删除信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String deleteSupplier(String supplierID) throws Exception {
		try {
			Statement statement = supplierDao.getStatement();
			String sql = "delete from supplier where supplierID='" + supplierID + "'";
			System.out.println(sql);
			statement.executeUpdate(sql);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return supplierID;
	}
}