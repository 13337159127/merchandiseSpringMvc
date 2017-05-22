package com.kexin.supplier.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kexin.supplier.dao.SupplierDao;
import com.kexin.supplier.entity.SupplierEntity;

@Service(value = "supplierService")
public class SupplierServiceImpl implements SupplierService {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private SupplierDao supplierDao;

	/**
	 * 查询供货商的信息
	 * 
	 * @return 返回供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<SupplierEntity> findSupplier() throws Exception {
		List<SupplierEntity> list = supplierDao.findSupplier();
		return list;
	}

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> getSupplierbyId(String supplierID) throws Exception {
		List<Map<String, String>> list = supplierDao.getSupplierbyId(supplierID);
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
		supplierDao.updateSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
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
		supplierDao.addSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
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
		supplierDao.deleteSupplier(supplierID);
		return supplierID;
	}
}
