package com.kexin.supplier.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kexin.supplier.entity.SupplierEntity;
import com.kexin.supplier.service.SupplierService;

/**
 * controller类 调用service层 实现跳转增 删 改 查页面
 * 
 * @author caokexin
 *
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
	// 声明变量 @Autowired为变量赋值
	@Autowired
	private SupplierService supplierService;

	/**
	 * 查询供货商的信息
	 * 
	 * @param request
	 *            向页面传递list
	 * @return 返回展示页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/findSupplier")
	public String findSupplier(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		List<SupplierEntity> list = supplierService.findSupplier();
		request.setAttribute("list", list);
		return "supplier/supplierindex";
	}

	/**
	 * 根据ID查询供货商的信息
	 * 
	 * @return 返回修改供货商信息列表
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/getIdFindSupplier")
	public String getIdFindSupplier(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String supplierID = request.getParameter("supplierID");
		List<Map<String, String>> list = supplierService.getIdFindSupplier(supplierID);
		request.setAttribute("list", list);
		return "supplier/updatesupplier";
	}

	/**
	 * 修改供货商信息
	 * 
	 * @param request
	 *            接收参数
	 * @return 返回首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/updateSupplier")
	public String updateSupplier(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String supplierID = request.getParameter("supplierID");
		String supplierName = request.getParameter("supplierName");
		String supplierAddress = request.getParameter("supplierAddress");
		String supplierPhone = request.getParameter("supplierPhone");
		supplierService.updateSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
		return "redirect:/supplier/findSupplier.kexin";
	}

	/**
	 * 
	 * @return 返回添加jsp页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/returnAddSupplierJsp")
	public String returnAddSupplierJsp() throws Exception {

		return "supplier/addsupplier";
	}

	/**
	 * 添加供货商信息
	 * 
	 * @param request
	 *            接收参数
	 * @return 返回添加jsp页面
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/addSupplier")
	public String addSupplier(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String supplierID = request.getParameter("supplierID");
		String supplierName = request.getParameter("supplierName");
		String supplierAddress = request.getParameter("supplierAddress");
		String supplierPhone = request.getParameter("supplierPhone");
		supplierService.addSupplier(supplierID, supplierName, supplierAddress, supplierPhone);
		return "redirect:/supplier/findSupplier.kexin";
	}

	/**
	 * 
	 * @param request
	 *            接收参数
	 * @return 返回首页
	 * @throws Exception
	 *             抛出异常
	 */
	@RequestMapping("/deleteSupplier")
	public String deleteSupplier(HttpServletRequest request) throws Exception {
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		String supplierID = request.getParameter("supplierID");
		supplierService.deleteSupplier(supplierID);
		return "redirect:/supplier/findSupplier.kexin";
	}
}