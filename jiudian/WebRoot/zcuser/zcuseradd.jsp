<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	if (document.getElementById('usernameid').value=="")
	{
		alert("用户名不能为空");
		return false;
	}
	
	if (document.getElementById('passwordid').value=="")
	{
		alert("密码不能为空");
		return false;
	}
	
	if (document.getElementById('lianxifangshiid').value=="")
	{
		alert("联系方式不能为空");
		return false;
	}
	
	if (document.getElementById('truenameid').value=="")
	{
		alert("真实姓名不能为空");
		return false;
	}
	
	return true;
	
}


</script>
<style>
table,table td{border:none;text-align:left;vertical-align:top;}
form{padding:10px;}
.input{border:1px solid #ddd;}
</style>
    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class=" login_page">


        <div class="login-wrapper">
            <div id="login" class="login loginpage col-lg-offset-4 col-lg-4 col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-2 col-xs-8">
                <h1><a href="<%=basePath %>" title="Login Page" tabindex="-1">登录</a></h1>

                <form name="loginform" id="loginform" action="method!zcuseradd2" method="post" onsubmit="return checkform()">
                   
                   <table width="100%" border="0"  cellpadding="0" cellspacing="0">
  <tr>
   
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"  style="padding:15px;">
         
        <table width="99%" border="1"   cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
          
          <tr>
            <td width="30%" height="26" style="color:#333" class=""><div  class="STYLE2 STYLE1">
            用户名：
            </div>
            </td>
            <td width="70%" height="18" style="color:#333" class="STYLE1">
            <div  class="STYLE2 STYLE1">
           <input  type="text" name="username" class="input"  id='usernameid'  size="22"  /><span style="color: red;">*</span>
            </div></td>
           
          </tr>
          
          <tr>
            <td width="30%" height="26" style="color:#333" class="STYLE1"><div  class="STYLE2 STYLE1">
            密码：
            </div>
            </td>
            <td width="70%" height="18" style="color:#333" class="STYLE1">
            <div  class="STYLE2 STYLE1">
           <input  type="password" name="password" class="input"  id='passwordid'  size="22"  /><span style="color: red;">*</span>
           
            </div></td>
           
          </tr>
          <tr>
            <td width="30%" height="26" style="color:#333" class="STYLE1"><div  class="STYLE2 STYLE1">
            性别：
            </div>
            </td>
            <td width="70%" height="18" style="color:#333" class="STYLE1">
            <div  class="STYLE2 STYLE1">
            <select name="xingbie" id="xingbieid" class="input" style="width:150px">
            	<option value="男">男</option>
            	<option value="女">女</option>
            </select><span style="color: red;">*</span>
            </div></td>
           
          </tr>
          <tr>
            <td width="30%" height="26" style="color:#333" class="STYLE1"><div  class="STYLE2 STYLE1">
            真实姓名：
            </div>
            </td>
            <td width="70%" height="18" style="color:#333" class="STYLE1">
            <div  class="STYLE2 STYLE1">
           <input  type="text" name="truename"  class="input" id='truenameid'  size="22"  /><span style="color: red;">*</span>
            </div></td>
           
          </tr>
          
          <tr>
            <td width="30%" height="26" style="color:#333" class="STYLE1"><div  class="STYLE2 STYLE1">
            联系方式：
            </div>
            </td>
            <td width="70%" height="18" style="color:#333" class="STYLE1">
            <div  class="STYLE2 STYLE1">
           <input  type="text" name="lianxifangshi" class="input"  id='lianxifangshiid'  size="22"  /><span style="color: red;">*</span>
            </div></td>
           
          </tr>
          
          
          
         
          
        </table>
        
        </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
</table>
                   
                   
                   


                    <p class="submit">
                        <input type="submit" name="wp-submit" id="wp-submit"
                         class="btn btn-orange btn-block" value="下一步" />
                    </p>
                </form>

                <p id="nav">
                    
                    <a class="pull-right" href="<%=basePath %>login.jsp" title="Sign Up">返回登录</a>
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

