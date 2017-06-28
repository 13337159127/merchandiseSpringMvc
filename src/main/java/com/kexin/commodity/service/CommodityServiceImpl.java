package com.kexin.commodity.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kexin.commodity.dao.CommodityDao;

/**
 * 实现接口的类 对dao层进行调用
 * 
 * @author caokexin
 * 
 */
@Service(value = "commodityService")
public class CommodityServiceImpl implements CommodityService {
	// 声明成员变量。@Autowired为成员变量赋值
	@Autowired
	private CommodityDao commodityDao;

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
	public List<Map> findCommodity(String loginname, String classify, String designation, String sort)
			throws Exception {
		return commodityDao.findCommodity(loginname, classify, designation, sort);
	}

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
			String commodityPeriod, String commodityYiedly, String categoryId, String userId, Date addTime)
			throws Exception {
		Map map = new HashMap();
		map.put("commodityId", commodityId);
		map.put("commodityName", commodityName);
		map.put("commodityPrice", commodityPrice);
		map.put("commodityMuch", commodityMuch);
		map.put("commodityPeriod", commodityPeriod);
		map.put("commodityYiedly", commodityYiedly);
		map.put("categoryId", categoryId);
		map.put("userId", userId);
		map.put("addTime", addTime);
		commodityDao.addCommodity(map);
		return "添加";
	}

	/**
	 * 根据ID查询商品信息（修改商品信息使用）
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return 返回根据ID查询的商品信息
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> getCommoditybyId(String commodityId) throws Exception {
		return commodityDao.getCommoditybyId(commodityId);
	}

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
			String commodityPeriod, String commodityYiedly, String categoryId) throws Exception {
		commodityDao.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId);
		return "修改";
	}

	/**
	 * 根据ID删除商品信息
	 * 
	 * @param commodityId
	 *            商品ID
	 * @return 返回根据商品ID删除商品的信息
	 * @throws Exception
	 *             抛出异常
	 */
	public String deleteCommodity(String commodityId) throws Exception {
		commodityDao.deleteCommodity(commodityId);
		return "删除";
	}

	/**
	 * 根据用户名查询商品总数
	 * 
	 * @param username
	 *            用户名
	 * @return 返回根据用户名查询商品的总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> commoditySum(String username) throws Exception {
		return commodityDao.commoditySum(username);
	}

	/**
	 * 每天录入商品总数
	 * 
	 * @return 返回每天录入商品总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> daySumCommodity() throws Exception {
		return commodityDao.daySumCommodity();
	}

	/**
	 * 每个分类商品总数
	 * 
	 * @return 返回每个分类商品总数
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map> classifySumCommodity() throws Exception {
		return commodityDao.classifySumCommodity();
	}
}
