<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text"> 超市管理系统 </a>
				</div>
				<ul class="nav">
					<li class="active"><a href="dashboard.html"> <i class="ti-panel"></i>
							<p>供货商信息列表</p>
					</a></li>
					<li><a href="${ctxPath}/supplier/returnAddSupplierJsp.kexin"> <i class="ti-user"></i>
							<p>添加供货商</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/findCommodity.kexin"> <i class="ti-view-list-alt"></i>
							<p>返回首页</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">供货商信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${ctxPath}/user/findUser.kexin">查询用户名</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${ctxPath}/classify/findClassify.kexin">查询分类</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			</nav>		 
			<div class="content">
				<div class="container-fluid">			
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">供货商信息</h4>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>供货商Id</th>
                                            <th>供货商姓名</th>
                                            <th>供货商地址</th>
                                            <th>供货商电话</th>
                                            <th>编辑供货商</th>
                                            <th>删除供货商</th>
										</thead>
										<c:forEach items="${list}" var="supplier"> 
											<tbody>
											  <td>${supplier.supplierID}</td>
                                              <td>${supplier.supplierName}</td>
                                              <td>${supplier.supplierAddress}</td>
                                              <td>${supplier.supplierPhone}</td>
                                              <td><a href="${ctxPath}/supplier/getSupplierbyId.kexin?supplierID=${supplier.supplierID}">编辑供货商</a></td>
                                              <td><a href="${ctxPath}/supplier/deleteSupplier.kexin?supplierID=${supplier.supplierID}">删除供货商</a></td>
											</tbody>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>