package com.kexin.classify.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kexin.classify.entity.ClassifyEntity;
import com.kexin.classify.service.ClassifyService;
import com.kexin.classify.service.ClassifyServiceImpl;

@Controller
@RequestMapping("/classify")
public class ClassifyController {
	/**
	 * 查询分类
	 */
	@RequestMapping("/fondClassify")
	public String fondClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
			request.setCharacterEncoding("UTF-8");
			ClassifyService classifyservice = new ClassifyServiceImpl();
			List<ClassifyEntity> list = classifyservice.fondClassify();
			request.setAttribute("list", list);
		    return "classify/index";
	}

	/**
	 * 根据ID查询分类信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getIdUpdateClassify")
	public String getIdUpdateClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
			String categoryid = request.getParameter("categoryId");
			// 实列化类 创建对象
			ClassifyService classifyservice = new ClassifyServiceImpl();
			List<Map<String, String>> list = classifyservice.getIdUpdateClassify(categoryid);
			request.setAttribute("list", list);
		    return "classify/update";
	}

	/**
	 * 修改商品
	 */
	@RequestMapping("/updateClassify")
	public String updateClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
			String categoryId = request.getParameter("categoryId");
			String category = request.getParameter("category");
			ClassifyService classifyservice = new ClassifyServiceImpl();
			classifyservice.updateClassify(category, categoryId);
			return "redirect:/classify/fondClassify.kexin";
	}

	/**
	 * 添加商品
	 */
	@RequestMapping("/addClassify")
	public String addClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
			String category = request.getParameter("category");
			String categoryId = request.getParameter("categoryId");
			ClassifyService classifyservice = new ClassifyServiceImpl();
			classifyservice.addClassify(category, categoryId);
		    return "redirect:/classify/fondClassify.kexin";
	}

	/**
	 * 删除商品
	 */
	@RequestMapping("/deleteClassify")
	public String deleteClassify(HttpServletRequest request) throws Exception {
		// 设置字符集
			String categoryId = request.getParameter("categoryId");
			ClassifyService classifyservice = new ClassifyServiceImpl();
			classifyservice.deleteClassify(categoryId);	 
		    return "redirect:/classify/fondClassify.kexin";
	} 
	/**
	 * 返回新增页面
	 */
	@RequestMapping("/returnAddJsp")
	public String returnAddJsp() throws Exception{
	
		return "classify/add";
	}
}
