<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%@include file="/assets/jspfactory.jsp"%>
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
  <form action="${ctxPath}/user/registerUser.kexin" method="get">
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
</html>