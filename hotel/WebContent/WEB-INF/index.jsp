<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<!DOCTYPE html>
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
  <style >@import url(main.css);
  .tabs-content > .content.active {
    -webkit-animation: fadeEffect 1s;
    animation: fadeEffect 1s;
}

@-webkit-keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
}

@keyframes fadeEffect {
    from {opacity: 0;}
    to {opacity: 1;}
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
      <li class="active"><a href="index"  data-dropdown="id01" data-options="align:right" class="dropdown">订房</a></li>
     	 <ul id="id01" data-dropdown-content class="f-dropdown tabs vertical" data-tab>
 		 <li class="tabs-title "><a href="#signal">单人间</a></li>
  		<li class="tabs-title"><a href="#standard">标准间</a></li>
 		 <li class="tabs-title"><a href="#triple">三人间</a></li>
		</ul>
      <li><a href="checkout" id="aaa">退房</a></li>
      <li><a href="roominfo" id="aaa">房间信息</a></li>
      <li><a href="guest" id="aaa">顾客信息</a></li>
        <li><a href="waiter" id="aaa">服务员信息</a></li>  
    </ul>
  </div>
</div>
<div class="tabs-content">

<div class="row content active" id="signal">
	<div class="test">
    	
		 	<table>
			 		<thead>
    						<tr>
      							<th>房间号</th>
      							<th>房间状态</th>
      							<th>房间类型</th>
      							<th>房间价格</th>
      							<th>房间楼层</th>
      							<th>房间朝向</th>
      							<th>选项</th>
    						</tr>
  					</thead>
		  		<tbody>	
						<c:forEach var="room" items="${rooms}">
								<tr>
									<td>${room.Rno}</td>
									<td>${room.Rstate}</td>
									<td>${room.Rtype}</td>
									<td>${room.Rprice}</td>
									<td>${room.Rfloor}</td>
									<td>${room.Rdri}</td>
									<td><button  data-reveal-id="myModal${room.Rno }" class="Button tiny round">订房</button>
									<div id="myModal${room.Rno }" class="reveal-modal tiny" data-reveal>
  			 							<form method="POST" action="?type=reserve&Rno=${room.Rno}">	 
  											客户编号：
  											<select class="Gno" name="Gno">
  											<c:forEach var="guest" items="${guests}">
  											<option>${guest.Gno}</option>
  											</c:forEach>
  											</select>
  											入住时间：
  											<input type="date" name="Rin"> <br>
  											退房时间：
  											<input type="date" name="Rout">
  											 <input type="submit" style=" float:right;" class="button tiny round" value="确定">
										</form>
  									</div>
									</td>
									
								</tr>
							</c:forEach>
		 		</tbody>
		</table>
		
	</div>
</div>

<div class="row content" id="standard">
	<div class="test">
    	
		 	<table>
			 		<thead>
    						<tr>
      							<th>房间号</th>
      							<th>房间状态</th>
      							<th>房间类型</th>
      							<th>房间价格</th>
      							<th>房间楼层</th>
      							<th>房间朝向</th>
      							<th>选项</th>
    						</tr>
  					</thead>
		  		<tbody>	
						<c:forEach var="room1" items="${rooms1}">
								<tr>
									<td>${room1.Rno}</td>
									<td>${room1.Rstate}</td>
									<td>${room1.Rtype}</td>
									<td>${room1.Rprice}</td>
									<td>${room1.Rfloor}</td>
									<td>${room1.Rdri}</td>
									<td><button  data-reveal-id="myModal${room1.Rno }" class="Button tiny round">订房</button>
									<div id="myModal${room1.Rno }" class="reveal-modal tiny" data-reveal>
  			 							<form method="POST" action="?type=reserve&Rno=${room1.Rno}">	 
  											客户编号：
  											<select class="Gno" name="Gno">
  											<c:forEach var="guest" items="${guests}">
  											<option>${guest.Gno}</option>
  											</c:forEach>
  											</select>
  											入住时间：
  											<input type="date" name="Rin"> <br>
  											退房时间：
  											<input type="date" name="Rout">
  											 <input type="submit" style=" float:right;" class="button tiny round" value="确定">
										</form>
  									</div>
									</td>
									
								</tr>
							</c:forEach>
		 		</tbody>
		</table>
		
	</div>
</div>
<div class="row content" id="triple">
	<div class="test">
    	
		 	<table>
			 		<thead>
    						<tr>
      							<th>房间号</th>
      							<th>房间状态</th>
      							<th>房间类型</th>
      							<th>房间价格</th>
      							<th>房间楼层</th>
      							<th>房间朝向</th>
      							<th>选项</th>
    						</tr>
  					</thead>
		  		<tbody>	
						<c:forEach var="room2" items="${rooms2}">
								<tr>
									<td>${room2.Rno}</td>
									<td>${room2.Rstate}</td>
									<td>${room2.Rtype}</td>
									<td>${room2.Rprice}</td>
									<td>${room2.Rfloor}</td>
									<td>${room2.Rdri}</td>
									<td><button  data-reveal-id="myModal${room2.Rno }" class="Button tiny round">订房</button>
									<div id="myModal${room2.Rno }" class="reveal-modal tiny" data-reveal>
  			 							<form method="POST" action="?type=reserve&Rno=${room2.Rno}">	 
  											客户编号：
  											<select class="Gno" name="Gno">
  											<c:forEach var="guest" items="${guests}">
  											<option>${guest.Gno}</option>
  											</c:forEach>
  											</select>
  											入住时间：
  											<input type="date" name="Rin"> <br>
  											退房时间：
  											<input type="date" name="Rout">
  											 <input type="submit" style=" float:right;" class="button tiny round" value="确定">
										</form>
  									</div>
									</td>
									
								</tr>
							</c:forEach>
		 		</tbody>
		</table>
		
	</div>
</div>


</div>
<div class="example">
	<div class="text-center medium-12 columns" style="background-color:#31a7b9">
		<p class="foot">2017 @Cassie</p>
		<p> All Rights Reserved</p>
	</div>
</div>
 			<script>
				$(document).ready(function() {
   					 $(document).foundation();
					})
			</script>

</body>
</html>