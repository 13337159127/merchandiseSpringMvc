package com.kexin.classify.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kexin.classify.service.ClassifyService;

@Controller
@RequestMapping("/classify")
public class ClassifyController {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private ClassifyService classifyService;

	/**
	 * 查询分类信息
	 * 
	 * @param request
	 * @return 返回商品信息首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findClassify")
	public ModelAndView findClassify() throws Exception {
		List<Map> list = classifyService.findClassify();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("classify/index");
		return mv;
	}

	/**
	 * 根据ID查询分类信息
	 * 
	 * @param request
	 * @return 返回修改分类页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getClassifybyId")
	public ModelAndView getClassifybyId(@RequestParam(value = "categoryId") String categoryid) throws Exception {
		List<Map> list = classifyService.getClassifybyId(categoryid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("classify/update");
		return mv;
	}

	/**
	 * 修改商品分类
	 * 
	 * @param request
	 * @return 返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateClassify")
	public ModelAndView updateClassify(String categoryId, String category) throws Exception {
		classifyService.updateClassify(category, categoryId);
		return new ModelAndView("redirect:/classify/findClassify.kexin");
	}

	/**
	 * 添加商品分类
	 * 
	 * @param request
	 * @return 返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addClassify")
	public ModelAndView addClassify(String category, String categoryId) throws Exception {
		classifyService.addClassify(category, categoryId);
		return new ModelAndView("redirect:/classify/findClassify.kexin");
	}

	/**
	 * 删除商品分类
	 * 
	 * @param request
	 * @return 返回查询分类首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/deleteClassify")
	public ModelAndView deleteClassify(String categoryId) throws Exception {
		classifyService.deleteClassify(categoryId);
		return new ModelAndView("redirect:/classify/findClassify.kexin");
	}

	/**
	 * 返回添加分类页面
	 * 
	 * @return 返回添加分类页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/returnAddClassifyJsp")
	public ModelAndView returnAddClassifyJsp() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("classify/add");
		return mv;
	}
}
