<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link href="<%=basePath%>assets/plugins/morris-chart/css/morris.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/jquery-ui/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/rickshaw-chart/css/graph.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/rickshaw-chart/css/detail.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/rickshaw-chart/css/legend.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/rickshaw-chart/css/extensions.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/rickshaw-chart/css/rickshaw.min.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/rickshaw-chart/css/lines.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/jvectormap/jquery-jvectormap-2.0.1.css" rel="stylesheet" type="text/css" media="screen"/><link href="<%=basePath%>assets/plugins/icheck/skins/minimal/white.css" rel="stylesheet" type="text/css" media="screen"/>        <!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 


        <!-- CORE CSS TEMPLATE - START -->
        <link href="<%=basePath%>assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="<%=basePath%>assets/css/responsive.css" rel="stylesheet" type="text/css"/>
        <!-- CORE CSS TEMPLATE - END -->

    </head>
    <!-- END HEAD -->

    <!-- BEGIN BODY -->
    <body class=" "><!-- START TOPBAR -->
        <div class='page-topbar '>
            <div class='logo-area'>

            </div>
            <div class='quick-area'>
                <div class='pull-left'>
                    <ul class="info-menu left-links list-inline list-unstyled">
                        <li class="sidebar-toggle-wrap">
                            <a href="#" data-toggle="sidebar" class="sidebar_toggle">
                                <i class="fa fa-bars"></i>
                            </a>
                        </li>
                        
                        
                    </ul>
                </div>		
                <div class='pull-right'>
                    <ul class="info-menu right-links list-inline list-unstyled">
                        <li class="profile">
                            <a href="#" data-toggle="dropdown" class="toggle">
                                欢迎您，${user.username }！
                                <span><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul class="dropdown-menu profile animated fadeIn">
                                <li>
                                    <a target="mainframe" href="method!changepwd">
                                        <i class="fa fa-wrench"></i>                                        密码更新
                                    </a>
                                </li>
                               
                                <li class="last">
                                  <a href="method!loginout">
                                        <i class="fa fa-lock"></i>
                                        退出登录
                                    </a>
                                </li>
                            </ul>
                        </li>
                       
                    </ul>			
                </div>		
            </div>

        </div>
        <!-- END TOPBAR -->
        <!-- START CONTAINER -->
        <div class="page-container row-fluid">

            <!-- SIDEBAR - START -->
            <div class="page-sidebar " style="min-height:1050px;">


                <!-- MAIN MENU - START -->
                <div class="page-sidebar-wrapper" id="main-menu-wrapper"> 

                    <!-- USER INFO - START -->
                    



                    <ul class='wraplist'>	


                        <li class="open"> 
                            <a href="<%=basePath%>">
                                <i class="fa fa-dashboard"></i>
                                <span class="title">控制面板</span>
                            </a>
                        </li>
                        <li class="open"> 
                            <a href="javascript:;">
                                <i class="fa fa-sliders"></i>
                                <span class="title">操作菜单</span>
                                <span class="arrow "></span>
                            </a>
                            <ul class="sub-menu" style="display:block" >
                              	  <c:if test="${user.role==1}">
   		
      <li> <a href="method!changepwd" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">修改密码</span> 
       </a>
       </li> 
       <li> <a href="method!userlist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">用户管理</span>   </a>
        </li>
       <li> <a href="method!fenleilist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">客房分类管理</span>   </a>
        </li>
       <li> <a href="method!kefanglist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">客房信息管理</span>   </a>
        </li>
       <li> <a href="method!kaifanglist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">开房管理</span>   </a>
        </li>
        <li> <a href="method!tuifanglist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">退房管理</span>   </a>
        </li>
       <li> <a href="method!kfjilulist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">开房记录查询</span>   </a>
            </li>
            <li> <a href="method!ydjilulist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">预定记录查询</span>   </a>
       </li> 
          </c:if>
           <c:if test="${user.role==0}">
           </br>
          <li> <a href="method!changepwd" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">修改密码</span>   </a>
       </li> 
       <li> <a href="method!yudinglist" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">客房预定</span>   </a>
       </li> 
        <li> <a href="method!ydjilulist2" target="mainframe">
       <span style="font-size: 15px;;font-weight: bold;">预定记录查询</span>   </a>
       </li> 
           </c:if>
                            </ul>
                        </li>
                        

                    </ul>

                </div>
                <!-- MAIN MENU - END -->



                


            </div>
            <!--  SIDEBAR - END -->
            <!-- START CONTENT -->
            <section id="main-content" class=" ">
                <section class="wrapper" style='margin-top:60px;display:inline-block;width:100%;padding:15px 0 0 15px;'>

                    <div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'>
                        <div class="page-title">

                            <div class="pull-left">
                                <h1 class="title">欢迎使用酒店客房管理系统</h1>                            </div>


                        </div>
                    </div>
                    <div class="clearfix"></div>


                    <div class="col-lg-12">
                        <section class="box nobox">
                            <div class="content-body">
                                <div class="row">
	<iframe id="main" name="mainframe" width="100%" height="100%" style="min-height: 850px" src=""
						frameborder="0"></iframe>
                                   
                </div>
                

            </div>
            </section>                      
                </div>

            </div>


            <div class="chatapi-windows ">


            </div>    </div>
        <!-- END CONTAINER -->
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
        <script src="<%=basePath%>assets/plugins/rickshaw-chart/vendor/d3.v3.js" type="text/javascript"></script> <script src="<%=basePath%>assets/plugins/jquery-ui/smoothness/jquery-ui.min.js" type="text/javascript"></script> <script src="<%=basePath%>assets/plugins/rickshaw-chart/js/Rickshaw.All.js"></script><script src="<%=basePath%>assets/plugins/sparkline-chart/jquery.sparkline.min.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/morris-chart/js/raphael-min.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/morris-chart/js/morris.min.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/jvectormap/jquery-jvectormap-2.0.1.min.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/gauge/gauge.min.js" type="text/javascript"></script><script src="<%=basePath%>assets/plugins/icheck/icheck.min.js" type="text/javascript"></script><script src="<%=basePath%>assets/js/dashboard.js" type="text/javascript"></script><!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END --> 


        <!-- CORE TEMPLATE JS - START --> 
        <script src="<%=basePath%>assets/js/scripts.js" type="text/javascript"></script> 
        <!-- END CORE TEMPLATE JS - END --> 

        <!-- Sidebar Graph - START --> 
        <script src="<%=basePath%>assets/plugins/sparkline-chart/jquery.sparkline.min.js" type="text/javascript"></script>
        <script src="<%=basePath%>assets/js/chart-sparkline.js" type="text/javascript"></script>
        <!-- Sidebar Graph - END --> 












    </body>
</html>





<script type="text/javascript">


</script>
