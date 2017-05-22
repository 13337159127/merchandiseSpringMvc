package com.kexin.classify.dao;

import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.kexin.classify.entity.ClassifyEntity;

public interface ClassifyDao {
	/**
	 * 会话工厂   实现方法被调用（共享）
	 * @return
	 *       返回一个共享的方法
	 * @throws Exception
	 *        抛出异常
	 */    
	public Statement getStatement() throws Exception;

	/**
	 * 查询商品的分类 （添加，修改商品使用）
	 * 
	 * @return
	 *             查询商品的分类，返回商品分类的信息（添加，修改商品使用）
	 * @throws Exception
	 *             抛出异常
	 */
	public List<Map<String, String>> selectClassify() throws Exception;

	/**
	 * 查询商品分类
	 * 
	 * @return
	 *             查询商品的分类信息，返回商品的分类信息表
	 * @throws Exception
	 *             抛出异常
	 */
	public List<ClassifyEntity> findClassify() throws Exception;

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
	public String addClassify(String category, String categoryId) throws Exception;

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
	public List<Map<String, String>> getClassifybyId(String categoryid) throws Exception;

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
	public String updateClassify(String category, String categoryId) throws Exception;

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
	public String deleteClassify(String categoryId) throws Exception;

}
