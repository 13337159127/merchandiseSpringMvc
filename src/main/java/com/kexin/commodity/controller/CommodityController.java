package com.kexin.commodity.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kexin.classify.service.ClassifyService;
import com.kexin.commodity.entity.CommodityEntity;
import com.kexin.commodity.service.CommodityService;
import com.kexin.user.service.UserService;
/**
 * controller类，调用业务层方法，返回相应页面
 * @author caokexin
 *
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
	//声明成员变量。@Autowired为成员变量赋值
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
	 * @return
	 *             根据 用户名，分类查询属性，名称查询属性，排序属性 查询商品信息。返回商品信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findCommodity")
	public String findCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String classify = request.getParameter("classify");
		String sort = request.getParameter("sort");
		String designation = request.getParameter("designation");
		// session接收用户名
		HttpSession session = request.getSession();
		String loginname = (String) session.getAttribute("name");
		// 实列化类
		List<CommodityEntity> list = commodityService.findCommodity(loginname, classify, designation, sort);
		// 向前台传值
		request.setAttribute("re", list);
		// 返回jsp页面
		return "show/show";
	}

	/**
	  * 查询分类（添加商品使用）
	  * @param request
	  * @return
	  *    查询商品分类。返回添加商品页面
	  * @throws Exception
	  *   抛出异常
	  */
	@RequestMapping("/findAddClassify")
	public String findAddClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		List<Map<String, String>> list = classifyService.getClassify();
		request.setAttribute("re", list);
		return "show/add";
	}

	 /**
	  * 添加商品
	  * @param request
	  * @return
	  *      添加商品的ID,名称，数量，价格保质期，生产地，分类，用户名。返回查询商品首页
	  * @throws Exception
	  *      抛出异常
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
		// 返回用户ID
		String userId = userService.getUserId(loginName);
		// 实列化类 创建对象 添加商品
		commodityService.addCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId, userId);
		// controller间的跳转 需要重定向
		return "redirect:/commodity/findCommodity.kexin";
	}

	 /**
	  * 根据ID查询商品信息（编辑商品信息使用）
	  * @param request
	  * @return
	  *       根据ID查询商品信息。返回修改商品信息页面
	  * @throws Exception
	  *       抛出异常
	  */
	@RequestMapping("/findUpdateCommodity")
	public String findUpdateCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String commodityId = request.getParameter("commodityId");
		// 根据ID查询商品的信息
		List<Map<String, String>> list1 = commodityService.findUpdateCommodity(commodityId);
		request.setAttribute("list", list1);
		// 实列化查询分类的的类 获取分类
		List<Map<String, String>> list = classifyService.getClassify();
		request.setAttribute("re", list);
		return "show/update";
	}

	/**
	 * 修改商品信息
	 * @param request
	 * @return
	 *      修改商品的ID,名称，数量，价格保质期，生产地，分类。返回查询商品首页
	 * @throws Exception
	 *      抛出异常
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
		commodityService.updateCommodity(commodityId, commodityName, commodityPrice, commodityMuch, commodityPeriod,
				commodityYiedly, categoryId);
		return "redirect:/commodity/findCommodity.kexin";
	}

	 /**
	  * 删除商品信息
	  * @param request
	  * @return
	  *     根据商品ID删除商品的信息。返回查询商品信息首页
	  * @throws Exception
	  *     抛出
	  */
	@RequestMapping("/deleteCommodity")
	public String deleteCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String commodityId = request.getParameter("commodityId");
		commodityService.deleteCommodity(commodityId);
		return "redirect:/commodity/findCommodity.kexin";
	}

	 /**
	  * 根据用户名  查询商品总数
	  * @param request
	  * @return
	  *    根据用户名 ，查询商品总数。返回商品总数页面
	  * @throws Exception
	  *    抛出异常
	  */
	@RequestMapping("/commoditySum")
	public String commoditySum(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("name");
		List<Map<String, String>> list = commodityService.commoditySum(username);
		request.setAttribute("list", list);
		return "show/sum";
	}

	 /**
	  * 每天录入商品总数
	  * @param request
	  * @return
	  *       每天录入商品总数，返回每天录入商品信息页面
	  * @throws Exception
	  *       抛出异常
	  */
	@RequestMapping("/daySumCommodity")
	public String daySumCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		List<Map<String, String>> list = commodityService.daySumCommodity();
		request.setAttribute("list", list);
		return "show/daysum";
	}

	 /**
	  * 查询每个分类商品总数
	  * @param request
	  * @return
	  *     查询每个分类商品总数，返回查询分类商品总数页面
	  * @throws Exception
	  *     抛出异常
	  */
	@RequestMapping("/classifySumCommodity")
	public String classifySumCommodity(HttpServletRequest request) throws Exception {
		// 设置字符集
		List<Map<String, String>> list = commodityService.classifySumCommodity();
		request.setAttribute("list", list);
		return "show/classifysum";
	}
}
