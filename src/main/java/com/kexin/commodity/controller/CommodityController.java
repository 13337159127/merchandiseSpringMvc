package com.kexin.commodity.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kexin.classify.service.ClassifyService;
import com.kexin.classify.service.ClassifyServiceImpl;
import com.kexin.commodity.entity.CommodityEntity;
import com.kexin.commodity.service.CommodityService;
import com.kexin.commodity.service.CommodityServiceImpl;
import com.kexin.user.service.UserService;
import com.kexin.user.service.UserServiceImpl;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
	/**
	 * 查询商品的方法
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fondCommodity")
	public String fondCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			String classify = request.getParameter("classify");
			String sort = request.getParameter("sort");
			String designation = request.getParameter("designation");
			// session接收用户名
			HttpSession session = request.getSession();
			String loginname = (String) session.getAttribute("name");
			// 实列化类
			CommodityService commodityservice = new CommodityServiceImpl();
			List<CommodityEntity> list = commodityservice.fondCommodity(loginname, classify, designation, sort);
			// 向前台传值
			request.setAttribute("re", list);
			//返回jsp页面
		    return "show/show";
	}

	/**
	 * 查询分类（添加商品使用）
	 */
	@RequestMapping("/fondAddClassify")
	public String fondAddClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			ClassifyService classifyservice = new ClassifyServiceImpl();
			List<Map<String, String>>  list = classifyservice.getClassify();
			request.setAttribute("re", list);
		    return "show/add";
	}
	/**
	 * 添加商品
	 */
	@RequestMapping("/addCommodity")
	public String addCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			String commodityId = request.getParameter("commodityId");
			String commodityName = request.getParameter("commodityName");
			String commodityPrice = request.getParameter("commodityPrice");
			String commodityMuch = request.getParameter("commodityMuch");
			String commodityPeriod = request.getParameter("commodityPeriod");
			String commodityYiedly = request.getParameter("commodityYiedly");
			String categoryId = request.getParameter("categoryId");
			// 接收用户名
			HttpSession session = request.getSession();
			String loginName = (String) session.getAttribute("name");
			// 实列化类 创建对象 返回用户ID
			UserService userservice = new UserServiceImpl();
			String userId = userservice.getUserId(loginName);
			// 实列化类 创建对象 添加商品
			CommodityService commodityservice = new CommodityServiceImpl();
			commodityservice.addCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
					commodityYiedly, categoryId, userId);
		    //controller间的跳转   需要重定向
		    return "redirect:/commodity/fondCommodity.kexin";
	}

	/**
	 * 根据ID查询商品信息（编辑商品使用）
	 */
	@RequestMapping("/fondUpdateCommodity")
	public String fondUpdateCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			String commodityId = request.getParameter("commodityId");
			// 实列化查询商品的类
			CommodityService commodityservice = new CommodityServiceImpl();
			List<Map<String, String>> list1 = commodityservice.fondUpdateCommodity(commodityId);
			request.setAttribute("list", list1);
			// 实列化查询分类的的类 获取分类
			ClassifyService classifyservice = new ClassifyServiceImpl();
			List<Map<String, String>> list = classifyservice.getClassify();
			request.setAttribute("re", list);
		    return "show/update";
	}
	/**
	 * 修改商品
	 */
	@RequestMapping("/updateCommodity")
	public String updateCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			String commodityId = request.getParameter("commodityId");
			String commodityName = request.getParameter("commodityName");
			String commodityPrice = request.getParameter("commodityPrice");
			String commodityMuch = request.getParameter("commodityMuch");
			String commodityPeriod = request.getParameter("commodityPeriod");
			String commodityYiedly = request.getParameter("commodityYiedly");
			String categoryId = request.getParameter("categoryId");
			// 实列化类 创建对象 修改商品
			CommodityService commodityservice = new CommodityServiceImpl();
			commodityservice.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
					commodityYiedly, categoryId);
		   return "redirect:/commodity/fondCommodity.kexin";
	}

	/**
	 * 删除商品
	 */
	@RequestMapping("/deleteCommodity")
	public String deleteCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			String commodityId = request.getParameter("commodityId");
			// 实列化类 删除商品
			CommodityService commodityservice = new CommodityServiceImpl();
			commodityservice.deleteCommodity(commodityId);
		    return "redirect:/commodity/fondCommodity.kexin";
	} 
	/**
	 * 查询商品总数
	 */
	@RequestMapping("/commoditySum")
	public String commoditySum(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("name");
			// 实列化类
			CommodityService commodityservice = new CommodityServiceImpl();
			List<Map<String, String>> list = commodityservice.commoditySum(username);
			request.setAttribute("list", list);
		return "show/sum";
	}
	/**
	 * 每天录入商品总数
	 */
	@RequestMapping("/daySumCommodity")
	public String daySumCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			CommodityService commodityservice = new CommodityServiceImpl();
			List<Map<String, String>> list = commodityservice.daySumCommodity();
			request.setAttribute("list", list);
		    return "show/daysum";
	} 
	/**
	 * 每个分类商品总数
	 */
	@RequestMapping("/classifySumCommodity")
	public String classifySumCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
			CommodityService commodityservice = new CommodityServiceImpl();
			List<Map<String, String>> list;
			list = commodityservice.classifySumCommodity();
			request.setAttribute("list", list);
		    return "show/classifysum";
	}
}
