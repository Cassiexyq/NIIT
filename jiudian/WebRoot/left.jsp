<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>酒店管理</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE2 {color: #43860c; font-size: 12px; }

a:link {font-size:12px; text-decoration:none; color:#43860c;}
a:visited {font-size:12px; text-decoration:none; color:#43860c;}
a:hover{font-size:12px; text-decoration:none; color:#FF0000;}
-->
</style>

</head>

<body >
<table width="177" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed">
      <tr>
        <td height="26" background="images/main_21.gif">&nbsp;</td>
      </tr>
      
      <tr>
        <td  style="line-height:4px; background:url(images/main_38.gif)">&nbsp;</td>
      </tr>
      <tr>
      
        <td>
         <c:if test="${user.role==1}">
   		 </br>
       <a href="method!changepwd" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">修改密码</span> 
       </a><br/>  <br/>
        <a href="method!userlist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">用户管理</span> 
        </a><br/><br/>
        <a href="method!fenleilist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">客房分类管理</span> 
        </a><br/><br/>
        <a href="method!kefanglist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">客房信息管理</span> 
        </a><br/><br/>
        <a href="method!kaifanglist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">开房管理</span> 
        </a><br/><br/>
         <a href="method!tuifanglist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">退房管理</span> 
        </a><br/><br/>
        <a href="method!kfjilulist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">开房记录查询</span> 
            </a><br/><br/>
             <a href="method!ydjilulist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">预定记录查询</span> 
       </a><br/>  <br/>
          </c:if>
           <c:if test="${user.role==0}">
           </br>
           <a href="method!changepwd" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">修改密码</span> 
       </a><br/>  <br/>
        <a href="method!yudinglist" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">客房预定</span> 
       </a><br/>  <br/>
         <a href="method!ydjilulist2" target="I1">
       <span style="font-size: 15px;;font-weight: bold;">预定记录查询</span> 
       </a><br/>  <br/>
           </c:if>
        </td>
        
      </tr>
    </table></td>
    
  </tr>
</table>
</body>
</html>

