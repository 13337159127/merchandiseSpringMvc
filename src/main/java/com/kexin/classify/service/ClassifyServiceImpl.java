package com.kexin.classify.service;

import java.util.List;
import java.util.Map;

import com.kexin.classify.dao.ClassifyDao;
import com.kexin.classify.dao.ClassifyDaoImpl;
import com.kexin.classify.entity.ClassifyEntity;

public class ClassifyServiceImpl implements ClassifyService {
	/**
	 * 查询商品的分类 （添加，修改商品使用）
	 * 
	 * @return
	 *             查询商品的分类，返回商品分类的信息（添加，修改商品使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> getClassify() throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		List<Map<String, String>> list = classifydao.getClassify();
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
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		List<ClassifyEntity> list = classifydao.findClassify();
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
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		classifydao.addClassify(category, categoryId);
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
	public List<Map<String, String>> getIdUpdateClassify(String categoryid) throws Exception {
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		List<Map<String, String>> list = classifydao.getIdUpdateClassify(categoryid);
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
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		classifydao.updateClassify(category, categoryId);
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
		// 实列化类
		ClassifyDao classifydao = new ClassifyDaoImpl();
		classifydao.deleteClassify(categoryId);
		return categoryId;
	}
}
