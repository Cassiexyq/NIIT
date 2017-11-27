<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>${title}</title><link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
 <script src="<%=basePath %>js/demo.js"></script><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}

-->
</style>


</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="images/tab_05.gif" align="center">
        <span class="STYLE4">${title }</span>
        </td>
        
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>

    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
          <tr>
             <td height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">预定客户姓名</div></td>
            <td height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">身份证号码</div></td>
            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">客房类型</div></td>
            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">客房价格 (元/天)</div></td>
            <td  height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">房间编号</div></td>
             <td height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">预定入住时间</div></td>
            <td height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">备注</div></td>
          </tr>
          
          <c:forEach items="${list}" var="bean">
          <tr>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.truename }</div></td>
            <td  height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.yudingidcard}</div></td>
            <td  height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.kefang.fenlei.leixing}</div></td>
             <td  height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.kefang.fenlei.jiage }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.kefang.fangjianhao }</div></td>
               <td  height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.yudingtime }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${bean.beizhu }</div></td>
            </tr>
          </c:forEach>
          
          <tr>
           
            <td height="18" bgcolor="#FFFFFF" class="STYLE2" colspan="7">
            <div align="center" class="STYLE2 STYLE1">
            ${pagerinfo }
            </div></td>
            
            
            </tr>
          
          
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  
</table>
</body>
</html>


