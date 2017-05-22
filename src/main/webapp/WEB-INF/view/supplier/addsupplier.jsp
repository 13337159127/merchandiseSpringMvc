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
					<a class="navbar-brand" href="#">供货商信息</a>
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
									<h4 class="title">添加供货商信息</h4>
								</div>
								<div class="content table-responsive table-full-width">
				<form action="${ctxPath}/supplier/addSupplier.kexin" method="get">				
				<table class="table table-striped">
				<tr>
               <th width="30%">供货商ID</th>
               <td width="70%"><input type="text" name="supplierID" value=""></td>
               </tr>
               <tr>
              <th width="30%">供货商姓名</th>
              <td width="70%"><input type="text" name="supplierName" value=""></td>
              </tr>
              <tr>
              <th width="30%">供货商地址</th>
              <td width="70%"><input type="text" name="supplierAddress" value=""></td>
              </tr>
               <tr>
              <th width="30%">供货商电话</th>
              <td width="70%"><input type="text" name="supplierPhone" value=""></td>
              </tr>
				</table>
				<div class="text-center">
				<button type="submit" class="btn btn-info btn-fill btn-wd">添加</button>
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