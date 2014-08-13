package cn.xuhe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Blog;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Photo;
import cn.xuhe.service.BlogService;
import cn.xuhe.service.EnterpriseService;
import cn.xuhe.service.PhotoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EnterpriseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private EnterpriseService enterpriseService;
	private String userid;
	private String oldpassword;
	private String newpassword;
	private String temppassword;
	private boolean top;
	private boolean recommend;
	private Map<String,Object> session;
	private String password;
	private Map<String,Object> result;
	private Enterprise enterprise;
	private int eid;
	private boolean rec;
	private String studentid;
	private Map<String,Object> fphotolist;
	private Map<String,Object> fbloglist;
	private PhotoService photoService;
	private BlogService blogService;
	
	public String listAllEnterprise() throws Exception{
		List enterprises = enterpriseService.listAllEnterprise();
		result = new HashMap<String,Object>();
		result.put("enlist",enterprises);
		return SUCCESS;
	}
	
	public String setTopEnterprise() throws Exception{
		enterpriseService.setTop(eid);
		return SUCCESS;
	}
	
	public String setRec() throws Exception{
		enterpriseService.setRec(eid,rec);
		return SUCCESS;
	}
	
	public String getTopEnterprise()throws Exception{
		List enterprises = enterpriseService.getTopEnterprise(top);
		result = new HashMap<String,Object>();
		result.put("top_en",enterprises);
		return SUCCESS;
	}
	
	public String getRecEnterprise()throws Exception{
		List enterprises = enterpriseService.getRecEnterprise(recommend);
		result = new HashMap<String,Object>();
		result.put("rec_en",enterprises);
		return SUCCESS;
	}
	
	public String getTopRecFalse()throws Exception{
		List enterprises = enterpriseService.getTopRecFalse();
		result = new HashMap<String,Object>();
		result.put("en_list_false",enterprises);
		return SUCCESS;
	}
	
	public PhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public BlogService getBlogService() {
		return blogService;
	}
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String login() throws Exception{
		result = new HashMap<String,Object>();
		Enterprise enterprise = enterpriseService.isValidEnterprise(userid,password);
		if(enterprise!=null){
			session = ActionContext.getContext().getSession();
			session.clear();
			session.put("user",enterprise);
			result.put("success", true);
			System.out.println("success...............");
		}
		else{
			result.put("success", false);
			System.out.println("error...............");
		}
		return SUCCESS;
	}
	public String pic() throws Exception{
		Enterprise en = (Enterprise)ActionContext.getContext().getSession().get("user");
		int id = en.getId();
		String pictures = enterpriseService.getEnPhotos(id);
		result = new HashMap<String,Object>();
		result.put("result",pictures);
		return SUCCESS;
	}
	public String resume() throws Exception{
		return "resume";
	}
	public String en_look_stu_photo() throws Exception{
		System.out.println("en  look  stu ......");
		String u = studentid;
		System.out.println("********************************");
		System.out.println(studentid);
		System.out.println(session);
		System.out.println("*********************************");
		session = ActionContext.getContext().getSession();
		if(u==null)
			return "photo";
		
		if(!session.containsKey("frinndid")){
			session.put("friendid",u);
		}else{
			if(!session.get("friendid").equals(u)){
				session.remove("friendid");
				session.put("friendid", u);
			}
		}
		return "photo";
	}
	public String en_look_stu_blog() throws Exception{
//		session = ActionContext.getContext().getSession();
//		String u= ServletActionContext.getRequest().getParameter("userid");
//		System.out.println(u);
//		System.out.println(u);
//		System.out.println(u);
		return "blog";
	}
	public String photo() throws Exception{
		return "photo";
	}
	public String person() throws Exception{
		return "person";
	}
	public String establish() throws Exception{
		return "establish";
	}
	public String changepassword() throws Exception{
		session = ActionContext.getContext().getSession();
		Enterprise enterpise = (Enterprise)session.get("user");
		int id = enterpise.getId();
		String password = enterpriseService.getEnterpriseDAO().findById(id).getPassword();
		System.out.println(password+"---------------------");
		System.out.println(oldpassword + "----------------");
		System.out.println(newpassword+"---------------------");
		System.out.println(temppassword+"---------------------");
		if(!password.equals(oldpassword)){
//			System.out.println("old---------------------");
			return "passworderror";
		}
		if(!newpassword.equals(temppassword)){
//			System.out.println("new---------------------");
			return "newerror";
		}
//		System.out.println(enterpise.getEmail());
		enterpriseService.savePassword(enterpise.getId(), newpassword);
//		System.out.println(enterprise.getId()+"------------------");
		return SUCCESS;
	}
	public String exit() throws Exception{
		session = ActionContext.getContext().getSession();
		session.clear();
		return "login";
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getTemppassword() {
		return temppassword;
	}
	public void setTemppassword(String temppassword) {
		this.temppassword = temppassword;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}
	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public boolean getTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public boolean isRec() {
		return rec;
	}

	public void setRec(boolean rec) {
		this.rec = rec;
	}

	public String published_resume(){
		return "published_resume";
	}
}
