package com.kexin.commodity.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CommodityService {
	/**
	 * 查询商品信息
	 * 
	 * @param loginname
	 *            根据用户名查询
	 * @param classify
	 *            根据分类查询
	 * @param designation
	 *            根据商品名称查询
	 * @param sort
	 *            根据商品ID，数量，价格排序
	 * @return 返回根据 用户名，分类查询属性，名称查询属性，排序属性 查询商品信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> findCommodity(String loginname, String classify, String designation, String sort) throws Exception;

	/**
	 * 添加商品信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @param commodityName
	 *            商品名称
	 * @param commodityPrice
	 *            商品价格
	 * @param commodityMuch
	 *            商品数量
	 * @param commodityPeriod
	 *            商品保质期
	 * @param commodityYiedly
	 *            商品生产地
	 * @param categoryId
	 *            商品分类ID
	 * @param userId
	 *            商品用户名ID
	 * @return 返回添加商品的ID,名称，数量，价格保质期，生产地，分类，用户名
	 * @throws Exception
	 *             抛出异常
	 */
	public String addCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String category, String loginName, Date entryTime)
			throws Exception;

	/**
	 * 根据ID查询商品信息（修改商品信息使用）
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return 返回根据ID查询的商品信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> getCommoditybyId(String commodityId) throws Exception;

	/**
	 * 修改商信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @param commodityName
	 *            商品名称
	 * @param commodityPrice
	 *            商品价格
	 * @param commodityMuch
	 *            商品数量
	 * @param commodityPeriod
	 *            商品保质期
	 * @param commodityYiedly
	 *            商品生产地
	 * @param categoryId
	 *            商品分类
	 * @return 返回修改商品的ID,名称，数量，价格保质期，生产地，分类
	 * @throws Exception
	 *             抛出异常
	 */
	public String updateCommodity(String commodityId, String commodityName, String commodityPrice, String commodityMuch,
			String commodityPeriod, String commodityYiedly, String categoryId) throws Exception;

	/**
	 * 根据ID删除商品信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return 返回根据商品ID删除商品的信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String deleteCommodity(String commodityId) throws Exception;

	/**
	 * 根据用户名查询商品总数
	 * 
	 * @param username
	 *            用户名
	 * @return 返回根据用户名查询商品的总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> commoditySum(String username) throws Exception;

	/**
	 * 每天录入商品总数
	 * 
	 * @return 返回每天录入商品的总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> daySumCommodity() throws Exception;

	/**
	 * 每个分类商品总数
	 * 
	 * @return 返回每个分类的商品总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> classifySumCommodity() throws Exception;
}
