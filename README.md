# NIIT
酒店管理系统

<br>
<p>1. 需求简介</p>
<p>&nbsp; &nbsp; 该系统可以实现客房预订、接待入住、结账、退还押金、营业额的查询，并且对于这些系统提供了相应的查询功能，注册的时候提供了表单验证的功能，提供管理员和普通用户两种登录权限。能够满足各大酒店实现智能一体化的需求，从客人预定房间到入住房间到结账离房。对于客人来说，客人预定房间不需要亲自到酒店进行预定或是打电话预定，简便了客人预定房间的操作，同时能够根据需要修改和取消自己的预定。对于管理员来说，酒店的信息量越来越大，管理员对房间预定、入住、结账进行人工管理工作量巨大，开发此系统也能够提高管理员的工作效率，还能够查询酒店营业额的操作。
</p>

<p>2.  项目需求</p>
<p>根据提供管理员和普通用户两种权限，分为普通用户预定系统和管理员管理系统两个模块。
</p>
<p>(一)	普通用户预定系统：</p>
<p>普通用户注册登录进入酒店主页，根据房间的类型，查询酒店的房间信息，并在网上完成房间的预定。用户预定房间成功后可以生成订单信息，对已生成的订单进行查询，修改和删除操作。
</p>
 ![image](https://github.com/Cassiexyq/NIIT/blob/master/image/1.png)</br>
a)  浏览房间，查询房间的相关信息如房间类型、房间容量、房间配置等。</br>
b)	用户可以自定义房间的要求查询是否有满足条件的房间。</br>
c)	用户在已选择入住时间和退房时间情况下可以线上办理延房。</br>
d)	选择时间进行房间预定，也可以撤销房间订单或修改订单。</br>
e)	能够显示用户曾经的浏览记录。</br>
f)	在个人信息中能够显示用户曾经预定过的房间订单。</br>
g)	管理个人信息，可以修改密码等。

<p>(二)    管理员管理系统：</p>
<p>管理员根据在网上进行预定过的用户提供姓名查询对应订单信息，进行入住登记，等到用户离房后，确定退房登记，结算账单。另外，管理员可以增加删除房间信息，对网上注册过的用户信息可以进行查询、修改、增加、删除的操作，还能够查询每年或每月或季度的营业额情况。
</p>
   ![image](https://github.com/Cassiexyq/NIIT/blob/master/image/2.png)</br>
a)    能够为客户办理接待入住手续。<br/>
b)	能够为客户办理结账、退还押金、退房手续。<br/>
c)	能够进行月季度或年营业额的查询。<br/>
d)	查询并管理客户信息，对用户信息进行维护。<br/>
e)	能够管理订单，对订单进行查询，删除操作。<br/>
f)	能够管理房间，能添加房间，更新房间信息，删除房间。</br>
</br>
<p>3.  性能分析</p>
（1）在网络性能良好的前提下，能3秒内响应用户需求。<br/>
（2）为保证数据实时性，每隔5秒刷新一次页面。<br/>
（3）能够解决高并发的数据读写问题，利用索引优化数据库结构，使用缓存技术减少与数据库的交互提高性能。</br>
（4）能方便进行二次开发操作，满足对功能的扩充和提高。</br>
<p></br>4.    项目分析</p>
<p>用例图：</p>
  <p>描述了管理员和用户的基本操作。</p>
  <p>![image](https://github.com/Cassiexyq/NIIT/blob/master/image/3.png)
  </p><p>ER图：
</p><p>  将“用户”，“房间”，“订单”作为实体，“浏览”，“生成/查看”作为联系，得到用户与房间及订单之间的局部ER图。
</p>
 ![image](https://github.com/Cassiexyq/NIIT/blob/master/image/4.png)
<p></br> 5.    小组成员</p>
Java01 宣益清   https://github.com/Cassiexyq/NIIT   (作为主维护者)</br>
Java02 何幸松</br>
Java01 吕明玥   https://github.com/173737114/2014-S7-Java0102  </br>
Java05 成一田 https://github.com/QiTianDash </br>
