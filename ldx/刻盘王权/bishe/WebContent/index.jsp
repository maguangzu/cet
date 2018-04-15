<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>辽宁省志愿者管理系统</title>
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">

		<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
		<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

		<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

		<!-- Demo page code -->

		<style type="text/css">
			#line-chart {
				height: 300px;
				width: 800px;
				margin: 0px auto;
				margin-top: 1em;
			}
			
			.brand {
				font-family: georgia, serif;
			}
			
			.brand .first {
				color: #ccc;
				font-style: italic;
			}
			
			.brand .second {
				color: #fff;
				font-weight: bold;
			}
		</style>

		<link rel="shortcut icon" href="../assets/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
	</head>

	<body class="">

		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">

					<li>
						<a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Setting</a>
					</li>
					<li id="fat-menu" class="dropdown">
						<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i> 用户名
							<i class="icon-caret-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a tabindex="-1" href="zhuxiao.do">注销用户</a>
							</li>
							<li class="divider"></li>
							<li>
								<a tabindex="-1" class="visible-phone" href="#">22222</a>
							</li>
							<li class="divider visible-phone"></li>
							<li>
								<a tabindex="-1" href="login.jsp">切换用户</a>
							</li>
						</ul>
					</li>

				</ul>
				<a class="brand" href="#"><span class="second">小手图片</span> <span class="second">您好</span></a>
			</div>
		</div>

		<div class="sidebar-nav">
			<h1 class="page-title" >管理中心</h1>
			<!--
	作者：18302456725@163.com
	时间：2016-10-20
	描述：第一个菜单模块
-->
			<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>信息管理<i class="icon-chevron-up"></i></a>
			<ul id="dashboard-menu" class="nav nav-list collapse in">
				<li class="active">
					<a href="myself.do" target="mainContent">我的资料</a>
			    <li class="active">
					<a  target="mainContent">我的记录</a>
				</li>
				</li>
				<li>
					<a href="modfiymyself.jsp" target="mainContent">修改我的资料</a>
				</li>
			</ul>
			<!--
	作者：18302456725@163.com
	时间：2016-10-20
	描述：第二个菜单模块
-->
			<a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>活动管理<i class="icon-chevron-up"></i></a>
                                                                                                                                                    <!--
                                                                                                                                                    	作者：18302456725@163.com
                                                                                                                                                    	时间：方块+3标志
                                                                                                                                                    	描述：<span class="label label-info">+3</span>\*
                                                                                                                                                    -->
			<ul id="accounts-menu" class="nav nav-list collapse">
				<li>
					<a href="findallactive.do" target="mainContent">活动搜索</a>
				</li>
				<li>
					<a href="findmyactive.do" target="mainContent">我的活动</a>
				</li>
				<li>
					<a href="AddActive.jsp" target="mainContent">发起活动</a>
				</li>
			</ul>
			<!--
	作者：18302456725@163.com
	时间：2016-10-20
	描述：第三个菜单模块
-->
			<a href="#error-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-exclamation-sign"></i>团队管理 <i class="icon-chevron-up"></i></a>
			<ul id="error-menu" class="nav nav-list collapse">
				<li>
					<a href="findallteam.do" target="mainContent">团队搜索</a>
				</li>
				<li>
					<a href="findmyteam.do" target="mainContent">我的团队</a>
				</li>
				<li>
					<a href="createteam.do" target="mainContent">创建团队</a>
				</li>				
			
			</ul>
			<!--
	作者：18302456725@163.com
	时间：2016-10-20
	描述：第四个菜单模块
-->
			<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>系统管理<i class="icon-chevron-up"></i></a>
			<ul id="legal-menu" class="nav nav-list collapse">
				<li>
					<a href="volsl.do" target="mainContent">志愿者审理</a>
				</li>
				<li>
					<a href="activesl.do" target="mainContent">活动审理</a>
				</li>
				<li>
					<a href="teamsl.do" target="mainContent">团队审理</a>
				</li>
			</ul>
			<!--
	作者：18302456725@163.com
	时间：2016-10-20
	描述：第五个菜单模块
-->
			<a href="volzhming.do" class="nav-header"  target="mainContent"><i class="icon-question-sign"></i>志愿者证明</a>
			<!--
        	作者：18302456725@163.com
        	时间：2016-10-20
        	描述：第六个菜单模块
        -->
			<a href="faq.html" class="nav-header"><i class="icon-comment"></i>退出</a>
		</div>

		
		
		<!--
   	作者：18302456725@163.com
   	时间：2016-10-20
   	描述：右侧显示主体部分
   -->
		<div class="content">
			
        <div class="header">
            
            <h1 class="page-title">我的资料管理</h1>
        </div>
        
            <ul class="breadcrumb">
            <li><a href="index.html"></a> <span class="divider">/</span></li>
            <li><a href="users.html" id="onetip" >信息管理</a> <span class="divider">/</span></li>
            <li class="active" id="twotip">我的资料</li>
        </ul>

        <div class="container-fluid">
        	 <iframe src="myself.do" name="mainContent" style="width:100%;height:710px" frameborder="no" border="0" marginwidth="0" marginheight="0" ></iframe>
        </div>

		</div>
		<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">Delete Confirmation</h3>
			</div>
			<div class="modal-body">

				<p class="error-text"><i class="icon-warning-sign modal-icon"></i>Are you sure you want to delete the user?</p>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
				<button class="btn btn-danger" data-dismiss="modal">Delete</button>
			</div>
		</div>

		<footer>
			<hr>

			<p class="pull-right">Collect from
				
			</p>

			<p>&copy; 2016.10.20
				<a href="#" target="_blank">Portnine</a>
			</p>
		</footer>
		</div>
		</div>
		</div>

		<script src="lib/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript">
			$("[rel=tooltip]").tooltip();
			$(function() {
				$('.demo-cancel-click').click(function() {
					return false;
				});
			});
		</script>
<script type="text/javascript">

var onetipnode=document.getElementById("onetip");
var twotipnode=document.getElementById("twotip");
function modtip(onetip,twotip){

	
	
	
}


</script>
	</body>

</html>