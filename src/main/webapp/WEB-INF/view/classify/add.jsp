<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title></title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<link href="http://localhost:8080/merchandisemvc/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="http://localhost:8080/merchandisemvc/assets/css/animate.min.css" rel="stylesheet" />
<link href="http://localhost:8080/merchandisemvc/assets/css/paper-dashboard.css" rel="stylesheet" />
<link href="http://localhost:8080/merchandisemvc/assets/css/demo.css" rel="stylesheet" />
<link href="http://localhost:8080/merchandisemvc/assets/css/font-awesome.min.css" rel="stylesheet">
<link href="http://localhost:8080/merchandisemvc/assets/css/css.css" rel='stylesheet' type='text/css'>
<link href="http://localhost:8080/merchandisemvc/assets/css/themify-icons.css" rel="stylesheet">

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
					<li class="active"><a href="/merchandisemvc/commodity/fondCommodity.kexin"> <i class="ti-panel"></i>
							<p>返回首页</p>
					</a></li>
					<li><a href="/merchandisemvc/classify/fondClassify.kexin"> <i class="ti-map"></i>
							<p>商品分类管理</p>
					</a></li>
					<li><a href="/merchandisemvc/user/fondUser.kexin"> <i class="ti-bell"></i>
							<p>用户名管理</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">分类信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
								<li><a href="/merchandisemvc/user/fondUser.kexin">查询用户名</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
						<ul class="dropdown-menu">
								<li><a href="/merchandisemvc/classify/fondClassify.kexin">查询分类</a></li>
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
									<h4 class="title">添加分类信息</h4>
								</div>
								<div class="content table-responsive table-full-width">
				<form action="/merchandisemvc/classify/addClassify.kexin" method="get"> 			
				<table class="table table-striped">
				<tr>
                    <th>分类ID</th>
                    <td><input type="text" name="categoryId" value=""></td>
                </tr>
                <tr>
                    <th>商品分类</th>
                    <td><input type="text" name="category" value=""></td>
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
<script src="http://localhost:8080/merchandisemvc/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="http://localhost:8080/merchandisemvc/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="http://localhost:8080/merchandisemvc/assets/js/bootstrap-checkbox-radio.js"></script>
<script src="http://localhost:8080/merchandisemvc/assets/js/chartist.min.js"></script>
<script src="http://localhost:8080/merchandisemvc/assets/js/bootstrap-notify.js"></script>
<script src="http://localhost:8080/merchandisemvc/assets/js/paper-dashboard.js"></script>
<script src="http://localhost:8080/merchandisemvc/assets/js/demo.js"></script>
</html>