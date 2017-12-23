<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>酒店管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="http://static.runoob.com/assets/foundation-5.5.3/foundation.min.css">
   <link rel="stylesheet" href="http://static.runoob.com/assets/foundation-icons/foundation-icons.css">
  <script src="http://static.runoob.com/assets/jquery/2.0.3/jquery.min.js"></script>
  <script src="http://static.runoob.com/assets/foundation-5.5.3/js/foundation.min.js"></script>
  <script src="http://static.runoob.com/assets/foundation-5.5.3/js/vendor/modernizr.js"></script>
  <style type="text/css">@import url(main.css);</style>
  <style >
  .addGuest{
  	margin-left:600px;
  }
  .example {

    max-width: 100%;
    color:white;
  }
.foot{
	margin-top:4px;
  	margin-bottom: 3px;
  }
  </style>
</head>
<body>
<div class="header">
      <h1 class="aa" ><strong>酒店客房管理系统</strong></h1>	
	</div>
	
	<div class="row xuanze" >
  <div class="medium-3 columns" style="background-color:#f1f1f1;">
    <ul class="side-nav">
      <li ><a href="index" id="aaa">订房</a></li>
      <li ><a href="checkout" id="aaa">退房</a></li>
      <li><a href="roominfo" id="aaa">房间信息</a></li>
      <li class="active"><a href="guest" id="aaa">顾客信息</a></li>
        <li><a href="waiter" id="aaa">服务员信息</a></li> 
    </ul>
  </div>
</div>
<div class="row">
	<div class="test1">
			<table>
			 		<thead>
    						<tr>
      							<th>客户编号</th>
      							<th>客户姓名</th>
      							<th>性别</th>
      							<th>电话</th>
      							<th>身份证号</th>
      							<th>地址</th>
      							<th>修改</th>
      							<th>删除</th>
    						</tr>
  					</thead>
		  		<tbody>	
						
							<c:forEach var="guest" items="${guests}">
								<tr>
									<td>${guest.Gno}</td>
									<td>${guest.Gname}</td>
									<td>${guest.Gsex}</td>
									<td>${guest.Gtel}</td>
									<td>${guest.Gid}</td>
									<td>${guest.Gaddress}</td>
									<td><button  data-reveal-id="myModal${guest.Gno}" class="Button tiny round">修改</button>
									<div id="myModal${guest.Gno}" class="reveal-modal tiny" data-reveal>
  			 							<form method="POST" action="?type=updata&Gno=${guest.Gno}">	 
  											重新输入电话：
  											<input type="text" placeholder="Gtel" name="Gtel">
  										<input type="submit" class="button tiny round" style=" float:right;" value="确定">
										</form>
  									</div>
									</td>
									<td><form method="POST" action="?type=delete&Gno=${guest.Gno}"><button  class="button round tiny" >删除</button></form></td>
								</tr>
							</c:forEach>
						
		 		</tbody>
		</table>
	</div>
</div>
<div class="addGuest">
	<button type="button" class="button" data-reveal-id="myModaladd"> 增加顾客</button>

  		<div id="myModaladd" class="reveal-modal tiny" data-reveal>
  			 <form method="POST" action="?type=add">
 					  顾客编号:
  						<input type="text" placeholder="Gno" name="Gno">

  					顾客姓名:
  					<input type="text" placeholder="Gname" name="Gname">
  					性别:
  					<select class="Gsex" name="Gsex">
    					<option>男</option>
    					<option>女</option>
  					</select>
  					电话：
  					<input type="text" placeholder="Wtel" name="Gtel">
  					身份证：
  					<input type="text" placeholder="Wtel" name="Gid">
  					地址
  					<select class="Gaddress" name="Gaddress">
    					<option>青岛市</option>
    					<option>莱西市</option>
    					<option>济南市</option>
			                <option>潍坊市</option>
    		
  					</select>
					<input type="submit" value="确定">
			</form>
  	</div>

			<script>
				$(document).ready(function() {
   					 $(document).foundation();
					})
			</script>

</div>
<div class="example">
	<div class="text-center medium-12 columns" style="background-color:#31a7b9">
		<p class="foot">2017 @Cassie</p>
		<p> All Rights Reserved</p>
	</div>
</div>
</body>
</html>
