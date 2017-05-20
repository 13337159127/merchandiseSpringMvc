package com.kexin.classify.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kexin.classify.entity.ClassifyEntity;
import com.kexin.classify.service.ClassifyService;

@Controller
@RequestMapping("/classify")
public class ClassifyController {
	//声明变量  为变量赋值
	@Autowired
	private ClassifyService classifyservice;
	//set方法设值注入
	public void setClassifyservice(ClassifyService classifyservice) {
		this.classifyservice = classifyservice;
	}
	/**
	 *             查询分类信息
	 * @param request
	 * @return 
	 *             返回商品信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findClassify")
	public String findClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		List<ClassifyEntity> list = classifyservice.findClassify();
		request.setAttribute("list", list);
		return "classify/index";
	}

	/**
	 * 根据ID查询分类信息
	 * @param request
	 * @return  
	 *             返回修改分类页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getIdUpdateClassify")
	public String getIdUpdateClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
		String categoryid = request.getParameter("categoryId");
		List<Map<String, String>> list = classifyservice.getIdUpdateClassify(categoryid);
		request.setAttribute("list", list);
		return "classify/update";
	}

	/**
	 * 修改商品分类
	 * 
	 * @param request
	 * @return  
	 *             返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateClassify")
	public String updateClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
		String categoryId = request.getParameter("categoryId");
		String category = request.getParameter("category");
		classifyservice.updateClassify(category, categoryId);
		return "redirect:/classify/findClassify.kexin";
	}

	/**
	 * 添加商品分类
	 * 
	 * @param request
	 * @return 
	 *             返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addClassify")
	public String addClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
		String category = request.getParameter("category");
		String categoryId = request.getParameter("categoryId");
		classifyservice.addClassify(category, categoryId);
		return "redirect:/classify/findClassify.kexin";
	}

	/**
	 * 删除商品分类
	 * 
	 * @param request
	 * @return 
	 *             返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/deleteClassify")
	public String deleteClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
		String categoryId = request.getParameter("categoryId");
		classifyservice.deleteClassify(categoryId);
		return "redirect:/classify/findClassify.kexin";
	}

	/**
	 * 返回添加分类页面
	 * 
	 * @return 
	 *             返回添加分类页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/returnAddJsp")
	public String returnAddJsp() throws Exception {

		return "classify/add";
	}
}
