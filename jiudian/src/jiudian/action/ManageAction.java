package jiudian.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jiudian.dao.FenleiDao;
import jiudian.dao.KaifangDao;
import jiudian.dao.KefangDao;
import jiudian.dao.UserDao;
import jiudian.dao.YudingDao;
import jiudian.model.Fenlei;
import jiudian.model.Kaifang;
import jiudian.model.Kefang;
import jiudian.model.User;
import jiudian.model.Yuding;
import jiudian.util.Pager;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;


public class ManageAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;

	private UserDao userDao;

	private String url = "./";

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	
	
	
//登入请求
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = userDao.selectBean(" where username = '" + username
				+ "' and password= '" + password + "' and role= "+role+" and userlock=0 ");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.setUrl("index.jsp");
			return "redirect";
		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误，或者是用户不存在');window.location.href='login.jsp';</script>");
		}
		return null;
	}
	

//用户退出
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.setUrl("login.jsp");
		return SUCCESS;
	}
//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("user/password.jsp");
		return SUCCESS;
	}
//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User bean = userDao.selectBean(" where username= '"+u.getUsername()+"' and password= '"+password1+"' and userlock=0");
		if(bean!=null){
			bean.setPassword(password2);
			userDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('修改成功');</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('原密码错误');</script>");
		}
	}
	
	//用户管理列表
	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (username != null && !"".equals(username)) {

			sb.append("username like '%" + username + "%'");
			sb.append(" and ");
			request.setAttribute("username", username);
		}

		
		
		
		sb.append("  userlock=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!userlist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!userlist");
		request.setAttribute("url2", "method!user");
		request.setAttribute("title", "用户管理");
		this.setUrl("user/userlist.jsp");
		return SUCCESS;

	}
//跳转到添加用户页面
	public String useradd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("url", "method!useradd2");
		request.setAttribute("title", "用户添加");
		this.setUrl("user/useradd.jsp");
		return SUCCESS;
	}
//添加用户操作
	public void useradd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String lianxifangshi = request.getParameter("lianxifangshi");
		String truename = request.getParameter("truename");
		String xingbie = request.getParameter("xingbie");
		String role = request.getParameter("role");
		User bean = userDao.selectBean(" where username='"+username+"' and userlock=0 ");
		if(bean==null){
			bean = new User();
			bean.setUsername(username);
			bean.setCreatetime(new Date());
			bean.setLianxifangshi(lianxifangshi);
			bean.setPassword("111111");
			bean.setRole(Integer.parseInt(role));
			bean.setTruename(truename);
			bean.setXingbie(xingbie);
			userDao.insertBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作失败，该用户名已经存在');window.location.href='method!userlist';</script>");
		}
	}
	
	
	//跳转到更新用户页面
	public String userupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!userupdate2");
		request.setAttribute("title", "用户修改");
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}
//更新用户操作
	public void userupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String lianxifangshi = request.getParameter("lianxifangshi");
		String truename = request.getParameter("truename");
		String xingbie = request.getParameter("xingbie");
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setLianxifangshi(lianxifangshi);
		bean.setTruename(truename);
		bean.setXingbie(xingbie);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");
	}

//删除用户操作
	public void userdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setUserlock(1);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");
	}
	
	
	
	//跳转到查看用户页面
	public String userupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("title", "用户查看");
		this.setUrl("user/userupdate3.jsp");
		return SUCCESS;
	}
	
	/**
	 * 普通用户注册
	 */
	//跳转到添加用户页面
	public String zcuseradd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("url", "method!zcuseradd2");
		request.setAttribute("title", "普通用户添加");
		this.setUrl("zcuser/zcuseradd.jsp");
		return SUCCESS;
	}
//添加用户操作
	public void zcuseradd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String username = request.getParameter("username");
		String lianxifangshi = request.getParameter("lianxifangshi");
		String truename = request.getParameter("truename");
		String xingbie = request.getParameter("xingbie");
		String password = request.getParameter("password");
		User bean = userDao.selectBean(" where username='"+username+"' and userlock=0 ");
		if(bean==null){
			bean = new User();
			bean.setUsername(username);
			bean.setCreatetime(new Date());
			bean.setLianxifangshi(lianxifangshi);
			bean.setPassword(password);
			bean.setRole(0);
			bean.setTruename(truename);
			bean.setXingbie(xingbie);
			userDao.insertBean(bean);
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作成功');window.location.href='login.jsp';</script>");
		}else{
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作失败，该用户名已经存在，请再次注册');window.location.href='login.jsp';</script>");
		}
	}
	
	/**
	 * 将fenleiDao注入到MangeAction
	 * 
	 */
	
	private FenleiDao fenleiDao;

	public FenleiDao getFenleiDao() {
		return fenleiDao;
	}

	public void setFenleiDao(FenleiDao fenleiDao) {
		this.fenleiDao = fenleiDao;
	}
	
	//客房分类管理列表
	public String fenleilist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String leixing = request.getParameter("leixing");
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (leixing != null && !"".equals(leixing)) {

			sb.append("leixing like '%" + leixing + "%'");
			sb.append(" and ");
			request.setAttribute("leixing", leixing);
		}

		
		
		
		sb.append("  deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = fenleiDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", fenleiDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!fenleilist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!fenleilist");
		request.setAttribute("url2", "method!fenlei");
		request.setAttribute("title", "客房分类管理");
		this.setUrl("fenlei/fenleilist.jsp");
		return SUCCESS;

	}
//跳转到添加客房分类页面
	public String fenleiadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("url", "method!fenleiadd2");
		request.setAttribute("title", "客房分类添加");
		this.setUrl("fenlei/fenleiadd.jsp");
		return SUCCESS;
	}
//添加客房分类操作
	public void fenleiadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String leixing = request.getParameter("leixing");
		String jiage = request.getParameter("jiage");
		Fenlei bean = fenleiDao.selectBean(" where leixing='"+leixing+"' and deletestatus=0 ");
		if(bean==null){
			bean = new Fenlei();
			bean.setDeletestatus(0);
			bean.setJiage(Double.parseDouble(jiage));
			bean.setLeixing(leixing);
			bean.setCreatetime(new Date());
			fenleiDao.insertBean(bean);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作成功');window.location.href='method!fenleilist';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作失败，该客房分类名已经存在');window.location.href='method!fenleilist';</script>");
		}
	}
	
	
	//跳转到更新客房分类页面
	public String fenleiupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Fenlei bean = fenleiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		request.setAttribute("url", "method!fenleiupdate2");
		request.setAttribute("title", "客房分类修改");
		this.setUrl("fenlei/fenleiupdate.jsp");
		return SUCCESS;
	}
//更新客房分类操作
	public void fenleiupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String leixing = request.getParameter("leixing");
		String jiage = request.getParameter("jiage");
		Fenlei bean = fenleiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setJiage(Double.parseDouble(jiage));
		bean.setLeixing(leixing);
		fenleiDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!fenleilist';</script>");
	}

//删除客房分类操作
	public void fenleidelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Fenlei bean = fenleiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDeletestatus(1);
		fenleiDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!fenleilist';</script>");
	}
	
	
	
	//跳转到查看客房分类页面
	public String fenleiupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Fenlei bean = fenleiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("title", "客房分类查看");
		this.setUrl("fenlei/fenleiupdate3.jsp");
		return SUCCESS;
	}
	
	/**
	 * 将KefangDao注入到MangeAction中
	 */
	
	private KefangDao kefangDao;

	public KefangDao getKefangDao() {
		return kefangDao;
	}

	public void setKefangDao(KefangDao kefangDao) {
		this.kefangDao = kefangDao;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	//客房信息管理列表
	public String kefanglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fangjianhao = request.getParameter("fangjianhao");
		String leixing = request.getParameter("leixing");
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (fangjianhao != null && !"".equals(fangjianhao)) {

			sb.append(" fangjianhao like '%" + fangjianhao + "%'");
			sb.append(" and ");
			request.setAttribute("fangjianhao", fangjianhao);
		}
		
		if (leixing != null && !"".equals(leixing)) {

			sb.append("fenlei.leixing like '%" + leixing + "%'");
			sb.append(" and ");
			request.setAttribute("leixing", leixing);
		}

		
		
		
		sb.append("  deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kefangDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", kefangDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!kefanglist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!kefanglist");
		request.setAttribute("url2", "method!kefang");
		request.setAttribute("title", "客房信息管理");
		this.setUrl("kefang/kefanglist.jsp");
		return SUCCESS;

	}
//跳转到添加客房信息页面
	public String kefangadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		request.setAttribute("url", "method!kefangadd2");
		request.setAttribute("title", "客房信息添加");
		this.setUrl("kefang/kefangadd.jsp");
		return SUCCESS;
	}
//添加客房信息操作
	public void kefangadd2() throws IOException {
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String fangjianhao = request.getParameter("fangjianhao");
		 String miaoshu = request.getParameter("miaoshu");
		 String fenlei = request.getParameter("fenlei");
		 Kefang bean = new Kefang();
		 bean.setFangjianhao(fangjianhao);
		 bean.setDeletestatus(0);//添加客房信息时默认客房信息的状态为0，1则表示该客房信息已删除
		 bean.setFangjianstatus("空房");//添加客房信息的时候默认为0  房间为空的状态
         bean.setFenlei((fenleiDao.selectBean(" where id="+fenlei+" and deletestatus=0")));
		 bean.setMiaoshu(miaoshu);
		 kefangDao.insertBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('操作成功');window.location.href='method!kefanglist';</script>");
		}
	
	
	//跳转到更新客房信息页面
	public String kefangupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		request.setAttribute("url", "method!kefangupdate2");
		request.setAttribute("title", "客房信息修改");
		this.setUrl("kefang/kefangupdate.jsp");
		return SUCCESS;
	}
//更新客房信息操作
	public void kefangupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fenlei = request.getParameter("fenlei");
		String fangjianhao = request.getParameter("fangjianhao");
		String miaoshu = request.getParameter("miaoshu");
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setFangjianhao(fangjianhao);
		bean.setFenlei((fenleiDao.selectBean(" where id="+fenlei+" and deletestatus=0")));
		bean.setMiaoshu(miaoshu);
		kefangDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!kefanglist';</script>");
	}

//删除客房信息操作
	public void kefangdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDeletestatus(1);//1表示删除客房信息
		kefangDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!kefanglist';</script>");
	}
	
	
	
	//跳转到查看客房信息页面
	public String kefangupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("title", "客房信息查看");
		this.setUrl("kefang/kefangupdate3.jsp");
		return SUCCESS;
	}
	
	/**
	 * 将kaifangDao 注入到 MangeAction当中
	 */
	private KaifangDao kaifangDao;

	public KaifangDao getKaifangDao() {
		return kaifangDao;
	}

	public void setKaifangDao(KaifangDao kaifangDao) {
		this.kaifangDao = kaifangDao;
	}
	

	//开房管理列表
	public String kaifanglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fangjianhao = request.getParameter("fangjianhao");
		String fangjianstatus = request.getParameter("fangjianstatus");
		String leixing = request.getParameter("leixing");
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (fangjianhao != null && !"".equals(fangjianhao)) {

			sb.append(" fangjianhao like '%" + fangjianhao + "%'");
			sb.append(" and ");
			request.setAttribute("fangjianhao", fangjianhao);
		}
		if (fangjianstatus != null && !"".equals(fangjianstatus)) {

			sb.append(" fangjianstatus like '%" + fangjianstatus + "%'");
			sb.append(" and ");
			request.setAttribute("fangjianstatus", fangjianstatus);
		}
		if (leixing != null && !"".equals(leixing)) {

			sb.append("fenlei.leixing like '%" + leixing + "%'");
			sb.append(" and ");
			request.setAttribute("leixing", leixing);
		}

		
		
		
		sb.append("  deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kefangDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", kefangDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!kaifanglist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!kaifanglist");
		request.setAttribute("url2", "method!kaifang");
		request.setAttribute("title", "开房管理");
		this.setUrl("kaifang/kaifanglist.jsp");
		return SUCCESS;

	}
	
	//跳转到开房信息页面
	public String kaifangupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!kaifangupdate2");
		request.setAttribute("title", "开房信息添加");
		this.setUrl("kaifang/kaifangupdate.jsp");
		return SUCCESS;
	}
//更新开房信息操作
	public void kaifangupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setFangjianstatus("已入住");
		String beizhu = request.getParameter("beizhu");
		String idcard = request.getParameter("idcard");
		String kehuname = request.getParameter("kehuname");
		String yajin = request.getParameter("yajin");
		Kaifang bean2 = new Kaifang();
		bean2.setBeizhu(beizhu);
		bean2.setIdcard(idcard);
		bean2.setKehuname(kehuname);
		bean2.setRuzhutime(new Date());
		bean2.setKefang(bean);
		bean2.setYajin(Double.parseDouble(yajin));
		bean2.setJiezhangstatus("未结账");
		kaifangDao.insertBean(bean2);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!kaifanglist';</script>");
	}


	
	//跳转到查看开房信息页面
	public String kaifangupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaifang bean = kaifangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("title", "开房信息查看");
		this.setUrl("kaifang/kaifangupdate3.jsp");
		return SUCCESS;
	}
	
	/**
	 * 退房操作
	 */
	public String tuifanglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fangjianhao = request.getParameter("fangjianhao");
		String idcard = request.getParameter("idcard");
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (fangjianhao != null && !"".equals(fangjianhao)) {

			sb.append(" fangjianhao like '%" + fangjianhao + "%'");
			sb.append(" and ");
			request.setAttribute("fangjianhao", fangjianhao);
		}
		if (idcard != null && !"".equals(idcard)) {

			sb.append(" idcard like '%" + idcard + "%'");
			sb.append(" and ");
			request.setAttribute("idcard", idcard);
		}

		sb.append("  kefang.deletestatus=0 and kefang.fangjianstatus='已入住' and jiezhangstatus='未结账' order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kaifangDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", kaifangDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!tuifanglist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!tuifanglist");
		request.setAttribute("url2", "method!tuifang");
		request.setAttribute("title", "退房管理");
		this.setUrl("tuifang/tuifanglist.jsp");
		return SUCCESS;

	}
	
	//跳转到退房信息页面
	public String tuifangupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaifang bean = kaifangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		
		long t1 = new Date().getTime();//当前时间毫秒数
		
		long t2 = bean.getRuzhutime().getTime();//入住时间毫秒数
		
		long t3 = 24*60*60*1000;//一天的毫秒数
		
		long tianshu = ((t1-t2)/t3 )+1;//入住天数
		
		double feiyong = tianshu*bean.getKefang().getFenlei().getJiage();//费用
		
		request.setAttribute("tianshu", tianshu);
		
		request.setAttribute("feiyong", feiyong);
		
		request.setAttribute("tuifangshijian", new Date());
		
		request.setAttribute("url", "method!tuifangupdate2");
		request.setAttribute("title", "退房信息");
		this.setUrl("tuifang/tuifangupdate.jsp");
		return SUCCESS;
	}
//更新退房信息操作
	public void tuifangupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kaifangid = request.getParameter("id");
		String xiaofei = request.getParameter("xiaofei");
		String tianshu = request.getParameter("tianshu");
		Kaifang bean2 = kaifangDao.selectBean(" where id= " + kaifangid);
	    bean2.setJiezhangstatus("已结账");
		bean2.setTuifangtime(new Date());
		bean2.setXiaofei(Double.parseDouble(xiaofei));
		bean2.setTianshu(Integer.parseInt(tianshu));
		Kefang bean = kefangDao.selectBean(" where id="+bean2.getKefang().getId());
		bean.setFangjianstatus("空房");
		bean2.setKefang(bean);
		kaifangDao.updateBean(bean2);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!kaifanglist';</script>");
	}


	
	//跳转到查看退房信息页面
	public String tuifangupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaifang bean = kaifangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("title", "退房信息查看");
		this.setUrl("kaifang/kaifangupdate3.jsp");
		return SUCCESS;
	}
	
	/**
	 * 开房记录查询
	 */
	public String kfjilulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fangjianhao = request.getParameter("fangjianhao");
		String idcard = request.getParameter("idcard");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (fangjianhao != null && !"".equals(fangjianhao)) {

			sb.append(" kefang.fangjianhao like '%" + fangjianhao + "%'");
			sb.append(" and ");
			request.setAttribute("fangjianhao", fangjianhao);
		}
		if (idcard != null && !"".equals(idcard)) {

			sb.append(" idcard like '%" + idcard + "%'");
			sb.append(" and ");
			request.setAttribute("idcard", idcard);
		}
		
	
		sb.append("  jiezhangstatus='已结账' order by id desc ");
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kaifangDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", kaifangDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!kfjilulist", "共有" + total + "条记录"));
		
		request.setAttribute("url", "method!kfjilulist");
		request.setAttribute("title", "开房记录查询");
		this.setUrl("kfjilu/kfjilulist.jsp");
		return SUCCESS;

	}
	/**
	 * 房间预定
	 */
	//将yudingDao注入到MangeAction当中
	private YudingDao yudingDao;
	
	public YudingDao getYudingDao() {
		return yudingDao;
	}

	public void setYudingDao(YudingDao yudingDao) {
		this.yudingDao = yudingDao;
	}

	//预定管理列表
	public String yudinglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fangjianhao = request.getParameter("fangjianhao");
		String leixing = request.getParameter("leixing");
		request.setAttribute("leixinglist", fenleiDao.selectBeanList(0, 9999, " where deletestatus=0 "));
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (fangjianhao != null && !"".equals(fangjianhao)) {

			sb.append(" fangjianhao like '%" + fangjianhao + "%'");
			sb.append(" and ");
			request.setAttribute("fangjianhao", fangjianhao);
		}
		
		if (leixing != null && !"".equals(leixing)) {

			sb.append("fenlei.leixing like '%" + leixing + "%'");
			sb.append(" and ");
			request.setAttribute("leixing", leixing);
		}

		
		
		
		sb.append("  deletestatus=0 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kefangDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", kefangDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!yudinglist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!yudinglist");
		request.setAttribute("url2", "method!yuding");
		request.setAttribute("title", "预定管理");
		this.setUrl("yuding/yudinglist.jsp");
		return SUCCESS;

	}
	
	//跳转到预定信息页面
	public String yudingupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!yudingupdate2");
		request.setAttribute("title", "预定信息添加");
		this.setUrl("yuding/yudingupdate.jsp");
		return SUCCESS;
	}
//更新预定信息操作
	public void yudingupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		String beizhu = request.getParameter("beizhu");
		String lianxifangshi = request.getParameter("lianxifangshi");
		String truename = request.getParameter("truename");
		String xingbie = request.getParameter("xingbie");
		String yudingidcard = request.getParameter("yudingidcard");
		String yudingtime = request.getParameter("yudingtime");
		Yuding bean2 = new Yuding();
		bean2.setBeizhu(beizhu);
		bean2.setCreatetime(new Date());
		bean2.setLianxifangshi(lianxifangshi);
		bean2.setTruename(truename);
		bean2.setXingbie(xingbie);
		bean2.setYudingidcard(yudingidcard);
		bean2.setYudingstatus(0);
	    bean2.setYudingtime(yudingtime);
	    HttpSession session = request.getSession();
	    User user = (User)session.getAttribute("user");
	    bean2.setUser(user);
	    bean2.setKefang(bean);
		yudingDao.insertBean(bean2);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='method!yudinglist';</script>");
	}


	
	//跳转到查看开房信息页面
	public String yudingupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kefang bean = kefangDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("title", "房间信息查看");
		this.setUrl("yuding/yudingupdate3.jsp");
		return SUCCESS;
	}
	
	/**
	 *管理员预定记录查询
	 */
	public String ydjilulist() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String where = " where 1=1 and yudingstatus='0' order by id desc";
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = yudingDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", yudingDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!ydjilulist", "共有" + total + "条记录"));
		
		request.setAttribute("url", "method!kfjilulist");
		request.setAttribute("title", "预定记录查询");
		this.setUrl("ydjilu/ydjilulist.jsp");
		return SUCCESS;

	}
	
	/**
	 *普通用户预定记录查询
	 */
	public String ydjilulist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
	    User user = (User)session.getAttribute("user");
		String where = " where user.id="+user.getId()+" and yudingstatus='0' order by id desc";
		int currentpage = 1;
		int pagesize = 10;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = yudingDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", yudingDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!ydjilulist", "共有" + total + "条记录"));
		
		request.setAttribute("url", "method!kfjilulist");
		request.setAttribute("title", "预定记录查询");
		this.setUrl("ydjilu/ydjilulist.jsp");
		return SUCCESS;

	}
}
