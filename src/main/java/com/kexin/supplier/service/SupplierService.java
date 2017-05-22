package com.kexin.supplier.service;

import java.util.List;
import java.util.Map;

import com.kexin.supplier.entity.SupplierEntity;

public interface SupplierService {
	/**
	 * 查询供货商的信息
	 * 
	 * @return 返回供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<SupplierEntity> findSupplier() throws Exception;

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String,String>> getSupplierbyId(String supplierID) throws Exception;
	
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
	public String updateSupplier(String supplierID, String supplierName, String supplierAddress,
			String supplierPhone) throws Exception;
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
	public String addSupplier(String supplierID, String supplierName, String supplierAddress,
			String supplierPhone) throws Exception;
	/**
	 *  删除供货商信息
	 * @param supplierID
	 *    供货商ID
	 * @return
	 *    返回删除信息
	 * @throws Exception
	 *    抛出异常
	 */
	public String deleteSupplier(String supplierID) throws Exception;
}
