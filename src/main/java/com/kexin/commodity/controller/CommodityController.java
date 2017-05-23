package com.kexin.commodity.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kexin.classify.service.ClassifyService;
import com.kexin.commodity.entity.CommodityEntity;
import com.kexin.commodity.service.CommodityService;
import com.kexin.user.service.UserService;

/**
 * controller类，调用业务层方法，返回相应页面
 * 
 * @author caokexin
 *
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
	// 声明成员变量。@Autowired为成员变量赋值
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private ClassifyService classifyService;
	@Autowired
	private UserService userService;

	/**
	 * 查询商品信息
	 * 
	 * @param request
	 * @return 根据 用户名，分类查询属性，名称查询属性，排序属性 查询商品信息。返回商品信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findCommodity")
	public ModelAndView findCommodity(String classify, String sort, String designation, HttpSession session)
			throws Exception {
		// session接收用户名
		String loginname = (String) session.getAttribute("name");
		// 变量名调用方法
		List<CommodityEntity> list = commodityService.findCommodity(loginname, classify, designation, sort);
		ModelAndView mv = new ModelAndView();
		// 封装要显示到视图的数据
		mv.addObject("re", list);
		// 视图名
		mv.setViewName("show/show");
		return mv;
	}

	/**
	 * 查询分类（添加商品使用）
	 * 
	 * @param request
	 * @return 查询商品分类。返回添加商品页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/selectClassify")
	public ModelAndView selectClassify() throws Exception {
		List<Map<String, String>> list = classifyService.selectClassify();
		ModelAndView mv = new ModelAndView();
		// 封装要显示到视图的数据
		mv.addObject("re", list);
		// 视图名
		mv.setViewName("show/add");
		return mv;
	}

	/**
	 * 添加商品
	 * 
	 * @param request
	 * @return 添加商品的ID,名称，数量，价格保质期，生产地，分类，用户名。返回查询商品首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addCommodity")
	public ModelAndView addCommodity(String commodityId, String commodityName, String commodityPrice,
			String commodityMuch, String commodityPeriod, String commodityYiedly, String categoryId,
			HttpSession session) throws Exception {
		 String loginName = (String) session.getAttribute("name");
		 // 返回用户ID
		 String userId = userService.getUserId(loginName);
		// 实列化类 创建对象 添加商品
		commodityService.addCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId, userId);
		// controller间的跳转 需要重定向
		return new ModelAndView("redirect:/commodity/findCommodity.kexin");
	}

	/**
	 * 根据ID查询商品信息（编辑商品信息使用）
	 * 
	 * @param request
	 * @return 根据ID查询商品信息。返回修改商品信息页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getCommoditybyId")
	public ModelAndView getCommoditybyId(String commodityId) throws Exception {
		// 根据ID查询商品的信息
		List<Map<String, String>> list1 = commodityService.getCommoditybyId(commodityId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list1);
		// 实列化查询分类的的类 获取分类
		List<Map<String, String>> list = classifyService.selectClassify();
		// 封装要显示到视图的数据
		mv.addObject("re", list);
		// 视图名
		mv.setViewName("show/update");
		return mv;
	}

	/**
	 * 修改商品信息
	 * 
	 * @param request
	 * @return 修改商品的ID,名称，数量，价格保质期，生产地，分类。返回查询商品首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateCommodity")
	public ModelAndView updateCommodity(String commodityId, String commodityName, String commodityPrice,
			String commodityMuch, String commodityPeriod, String commodityYiedly, String categoryId) throws Exception {
		commodityService.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId);
		return new ModelAndView("redirect:/commodity/findCommodity.kexin");
	}

	/**
	 * 删除商品信息
	 * 
	 * @param request
	 * @return 根据商品ID删除商品的信息。返回查询商品信息首页
	 * @throws Exception
	 *             抛出
	 */
	@RequestMapping("/deleteCommodity")
	public ModelAndView deleteCommodity(String commodityId) throws Exception {
		commodityService.deleteCommodity(commodityId);
		return new ModelAndView("redirect:/commodity/findCommodity.kexin");
	}

	/**
	 * 根据用户名 查询商品总数
	 * 
	 * @param request
	 * @return 根据用户名 ，查询商品总数。返回商品总数页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/commoditySum")
	public ModelAndView commoditySum(HttpSession session) throws Exception {
		String username = (String) session.getAttribute("name");
		List<Map<String, String>> list = commodityService.commoditySum(username);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("show/sum");
		return mv;
	}

	/**
	 * 每天录入商品总数
	 * 
	 * @param request
	 * @return 每天录入商品总数，返回每天录入商品信息页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/daySumCommodity")
	public ModelAndView daySumCommodity() throws Exception {
		List<Map<String, String>> list = commodityService.daySumCommodity();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("show/daysum");
		return mv;
	}

	/**
	 * 查询每个分类商品总数
	 * 
	 * @param request
	 * @return 查询每个分类商品总数，返回查询分类商品总数页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/classifySumCommodity")
	public ModelAndView classifySumCommodity() throws Exception {
		List<Map<String, String>> list = commodityService.classifySumCommodity();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("show/classifysum");
		return mv;
	}
}
