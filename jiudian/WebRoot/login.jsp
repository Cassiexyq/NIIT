<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="jiudian.util.Util"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>


<!DOCTYPE html>
<html class=" ">
    <head>
        
        <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8" />
        <title>酒店客房管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="" name="description" />
        <meta content="" name="author" />

      




        <!-- CORE CSS FRAMEWORK - START -->
        <link href="<%=basePath%>assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
        <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/fonts/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/plugins/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS FRAMEWORK - END -->

        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START --> 
        <link href="<%=basePath%>assets/plugins/icheck/skins/square/orange.css" rel="stylesheet" type="text/css" media="screen"/>        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 


        <!-- CORE CSS TEMPLATE - START -->
        <link href="<%=basePath%>assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/css/responsive.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS TEMPLATE - END -->

    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class=" login_page">


        <div class="login-wrapper">
            <div id="login" class="login loginpage col-lg-offset-4 col-lg-4 col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-2 col-xs-8">
                <h1><a href="<%=basePath %>" title="Login Page" tabindex="-1">登录</a></h1>

                <form name="loginform" id="loginform" action="method!login" method="post">
                    <p>
                        <label for="user_login">用户名<br />
                            <input required type="text" name="username" id="user_login" class="input" value="" size="20" /></label>
                    </p>
                    <p>
                        <label for="user_pass">密码<br />
                            <input required type="password" name="password" id="user_pass" class="input" value="" size="20" /></label>
                    </p>
                      <p>
                        <label for="user_pass">角色<br />
                             <select style="width:150px;" class="input" name="role">
                <option value="1">系统管理员</option>
                <option value="0">普通用户</option>
                </select>
                    </p>
                    
                    <p class="forgetmenot">
                        <label class="icheck-label form-label" for="rememberme"><input checked name="rememberme" type="checkbox" id="rememberme" value="forever" class="skin-square-orange" checked> 记住密码</label>
                    </p>



                    <p class="submit">
                        <input type="submit" name="wp-submit" id="wp-submit" class="btn btn-orange btn-block" value="马上登录" />
                    </p>
                </form>

                <p id="nav">
                    
                    <a class="pull-right" href="method!zcuseradd" title="Sign Up">注册账号</a>
                </p>


            </div>
        </div>





        <!-- LOAD FILES AT PAGE END FOR FASTER LOADING -->


        <!-- CORE JS FRAMEWORK - START --> 
        <script src="<%=basePath%>assets/js/jquery-1.11.2.min.js" type="text/javascript"></script> 
        <script src="<%=basePath%>assets/js/jquery.easing.min.js" type="text/javascript"></script> 
        <script src="<%=basePath%>assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="<%=basePath%>assets/plugins/pace/pace.min.js" type="text/javascript"></script>  
        <script src="<%=basePath%>assets/plugins/perfect-scrollbar/perfect-scrollbar.min.js" type="text/javascript"></script> 
        <script src="<%=basePath%>assets/plugins/viewport/viewportchecker.js" type="text/javascript"></script>  
        <!-- CORE JS FRAMEWORK - END --> 


        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START --> 
        <script src="<%=basePath%>assets/plugins/icheck/icheck.min.js" type="text/javascript"></script><!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 


        <!-- CORE TEMPLATE JS - START --> 
        <script src="<%=basePath%>assets/js/scripts.js" type="text/javascript"></script> 
        <!-- END CORE TEMPLATE JS - END --> 

        <!-- Sidebar Graph - START --> 
        <script src="<%=basePath%>assets/plugins/sparkline-chart/jquery.sparkline.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/chart-sparkline.js" type="text/javascript"></script>
        <!-- Sidebar Graph - END --> 

     
    </body>
</html>



