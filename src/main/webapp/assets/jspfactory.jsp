<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title></title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- 获取项目名    赋值给变量 -->
    <c:set var="ctxPath" value="${pageContext.request.contextPath}"></c:set>  
    <!-- 项目名+资源路径 -->
    <link href="${ctxPath}/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctxPath}/assets/css/animate.min.css" rel="stylesheet"/>  
    <link href="${ctxPath}/assets/css/paper-dashboard.css" rel="stylesheet"/>   
    <link href="${ctxPath}/assets/css/demo.css" rel="stylesheet"/>    
    <link href="${ctxPath}/assets/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${ctxPath}/assets/css/css.css" rel='stylesheet' type='text/css'/>
    <link href="${ctxPath}/assets/css/themify-icons.css" rel="stylesheet"/>
</head>
    <script src="${ctxPath}/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${ctxPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${ctxPath}/assets/js/bootstrap-checkbox-radio.js"></script>
	<script src="${ctxPath}/assets/js/chartist.min.js"></script>
    <script src="${ctxPath}/assets/js/bootstrap-notify.js"></script> 
	<script src="${ctxPath}/assets/js/paper-dashboard.js"></script>	 
	<script src="${ctxPath}/assets/js/demo.js"></script>