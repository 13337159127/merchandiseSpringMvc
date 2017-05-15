<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title></title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/animate.min.css" rel="stylesheet"/>  
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>   
    <link href="assets/css/demo.css" rel="stylesheet" />    
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/css.css" rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                                        超市管理系统
                </a>
            </div>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">登录页面</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>用户管理</p>
								<b class="caret"></b>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
									<p>分类管理</p>
									<b class="caret"></b>
                              </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
   <center> 
   <div class="content">       
  <form action="/merchandisemvc/RegisterUser.kexin" method="get">
  <div class="form-group">                                
  <input type="text" name="username" style="width: 300px; display: inline" class="form-control" placeholder="用户名">
  </div>
  <div class="form-group"> 
  <input type="password" name="password" style="width: 300px; display: inline"  class="form-control" placeholder="密码">
  </div>
    <button type="submit">登 录</button>
    <button type="reset" >重 置</button>
 </form>   
  </div>
  </center> 
    </div>
</div>
</body>
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>
	<script src="assets/js/chartist.min.js"></script>
    <script src="assets/js/bootstrap-notify.js"></script> 
	<script src="assets/js/paper-dashboard.js"></script>	 
	<script src="assets/js/demo.js"></script>
</html>
