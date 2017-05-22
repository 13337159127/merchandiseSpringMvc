package com.kexin.supplier.entity;

/**
 * 供货商的属性，把供货商属性定义成私有类型变量。 为变量创建get和set方法
 * 
 * @author caokexin
 *
 */
public class SupplierEntity {
	// 供货商ID
	private String supplierID;
	// 供货商名称
	private String supplierName;
	// 供货商名称
	private String supplierAddress;
	// 供货商名称
	private String supplierPhone;

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

}
