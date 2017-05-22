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
					<li class="active"><a href="${ctxPath}/commodity/findCommodity.kexin"> <i class="ti-panel"></i>
							<p>返回首页</p>
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
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">修改商品信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
						</li>
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
									<h4 class="title">修改商品信息</h4>
								</div>
								<div class="content table-responsive table-full-width">
				<form action="${ctxPath}/commodity/updateCommodity.kexin" method="get">				
				<table class="table table-striped">
				<c:forEach items="${list}" var="commodity" > 
				<tr>
					<th width="30%">商品id</th>
					<td width="70%"><input type="text" name="commodityId" value="${commodity.commodityId}">
				</tr>
				<tr>
					<th width="30%">商品名称</th>
					<td width="70%"><input type="text" name="commodityName"
						value="${commodity.commodityName}">
				</tr>
				<tr>
					<th width="30%">商品价格</th>
					<td width="70%"><input type="text" name="commodityPrice"
						value="${commodity.commodityPrice}">
				</tr>
				<tr>
					<th width="30%">商品数量</th>
					<td width="70%"><input type="text" name="commodityMuch"
						value="${commodity.commodityMuch}">
				</tr>
				<tr>
					<th width="30%">商品保质期</th>
					<td width="70%"><input type="text" name="commodityPeriod"
						value="${commodity.commodityPeriod}">
				</tr>
				<tr>
					<th width="30%">商品生产地</th>
					<td width="70%"><input type="text" name="commodityYiedly"
						value="${commodity.commodityYiedly}">
				</tr>
				<tr>
					<th width="30%">商品分类</th>
					<td width="70%">			 
					<select name="categoryId">
					<c:forEach  items="${re}" var="categor">
                   <!-- 这里判断，如果商品的分类ID == 你当前分类的分类ID，说明这个分类就是这个商品的分类。 -->
                   <c:if test="${commodity.categoryId eq categor.categoryId}">
   		           <option value="${categor.categoryId}" selected="selected">${categor.category}</option>
                   </c:if> 
                   <c:if test="${commodity.categoryId!= categor.categoryId}">
   		           <option value="${categor.categoryId}" >${categor.category}</option>
                  </c:if>
                   </c:forEach>
					</select> 			 
					</td> 
				</tr> 
				</c:forEach>
				</table>
				<div class="text-center">
					<button type="submit" class="btn btn-info btn-fill btn-wd">修改</button>
				</div>
				</form>
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