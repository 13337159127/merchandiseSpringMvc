<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
							<p>商品信息列表</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/findAddClassify.kexin"> <i class="ti-user"></i>
							<p>添加商品</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/commoditySum.kexin"> <i class="ti-view-list-alt"></i>
							<p>用户商品总数</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/daySumCommodity.kexin"> <i class="ti-text"></i>
							<p>每天录入商品总数</p>
					</a></li>
					<li><a href="${ctxPath}/commodity/classifySumCommodity.kexin"> <i class="ti-pencil-alt2"></i>
							<p>每个分类商品总数</p>
					</a></li>
					<li><a href="${ctxPath}/classify/findClassify.kexin"> <i class="ti-map"></i>
							<p>商品分类管理</p>
					</a></li>
					<li><a href="${ctxPath}/user/findUser.kexin"> <i class="ti-bell"></i>
							<p>用户名管理</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">商品信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${ctxPath}/findUser.kexin">查询用户名</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="${ctxPath}/findClassify.kexin">查询分类</a></li>
							</ul></li>
					  </li>
					</ul>
				</div>
			</div>
			</nav>
			 
			<div class="content">
				<div class="container-fluid">
				<center> 
				<form action="">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>分类</label> <input type="text" name="classify"
										style="width: 300px; display: inline"
										class="form-control border-input" placeholder="请输入分类名"
										value="">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>名称</label> <input type="text" name="designation"
										style="width: 300px; display: inline"
										class="form-control border-input" placeholder="请输入商品名称"
										value="">
								</div>
							</div>
						</div>
                        <div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>排序</label> 
									<select name="sort" style="width: 300px; display: inline" class="form-control border-input">
                                    <option value="commodityId">商品id</option>
                                    <option value="commodityPrice">商品价格</option>
                                    <option value="commodityMuch">商品数量</option>
                                    </select>
								</div>
							</div>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-info btn-fill btn-wd">查询</button>
						</div>
 			        <br>
 					</form>
					</center>			
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">商品信息列表</h4>
								</div>

								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>id</th>
											<th>名称</th>
											<th>价格</th>
											<th>数量</th>
											<th>保质期</th>
											<th>生产地</th>
											<th>分类</th>
											<th>管理员</th>
											<th>录入时间</th>
											<th>编辑商品</th>
											<th>操作商品</th>
										</thead>
										<c:forEach items="${re}" var="commodity">
											<tbody>
												<td>${commodity.commodityId}</td>
												<td>${commodity.commodityName}</td>
												<td>${commodity.commodityPrice}</td>
												<td>${commodity.commodityMuch}</td>
												<td>${commodity.commodityPeriod}</td>
												<td>${commodity.commodityYiedly}</td>
												<td>${commodity.category}</td>
												<td>${commodity.loginName}</td>
												<!-- 格式化时间和日期 -->
												<td><fmt:formatDate value="${commodity.entryTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td><a href="${ctxPath}/commodity/findUpdateCommodity.kexin?commodityId=${commodity.commodityId}">修改商品</a></td>
												<td><a href="${ctxPath}/commodity/deleteCommodity.kexin?commodityId=${commodity.commodityId}">删除商品</a></td>
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