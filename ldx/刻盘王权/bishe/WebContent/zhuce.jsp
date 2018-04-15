<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>注册</title>
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
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
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
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">小手图片</span> <span class="second">您好</span></a>
        </div>
    </div>
    


    

    
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">注 册</p>
            <div class="block-body">
                <form action="addvol.do" method="post">
                    <label>用户名</label>
                    <input type="text" class="span12" name="volname" placeholder="请输入姓名">
                    <label>密码</label>
                    <input type="password" class="span12" name="volpassword" placeholder="请输入密码">
                    <label>确认密码</label>
                    <input type="password" class="span12" name="volpassword2" placeholder="请确认密码">
                    <label>身份证号码</label>
                    <input type="text" class="span12" name="volidnumber" placeholder="请输入21位身份证号码">
                    <label>电话号</label>
                    <input type="text" class="span12" name="voltel" name="voltel" placeholder="请输入电话号码">
                    <input type="submit"  class="btn btn-primary pull-right"value="注册!">
                    <label class="remember-me"><input type="checkbox"> 我同意 <a href="terms-and-conditions.html">辽宁省志愿者文明守则</a></label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="login.jsp">返回登录</a></p>
    </div>
</div>


    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>