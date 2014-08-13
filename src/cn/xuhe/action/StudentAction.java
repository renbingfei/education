package cn.xuhe.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.xuhe.entity.Blog;
import cn.xuhe.entity.Friend;
import cn.xuhe.entity.Photo;
import cn.xuhe.entity.Student;
import cn.xuhe.service.BlogService;
import cn.xuhe.service.FriendService;
import cn.xuhe.service.PhotoService;
import cn.xuhe.service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	private PhotoService photoService;
	private FriendService friendService;
	private BlogService blogService;
	private String oldpassword;
	private String newpassword;
	private String temppassword;
	private String userid;
	private File file;	
	private String fileFileName;
	private String password;
	private String studentid;
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	private Map<String,Object> session;
	private Map<String,Object> result;
	private Map<String,Object> info;
	private Map<String,Object> friendinfo;
	private Map<String,Object> friendphoto;
	private Map<String,Object> fphotolist;
	private Map<String,Object> fbloglist;
	private Map<String,Object> fvediolist;
	
	
	public String updateAvatar(){
		System.out.println("===============================updateAvatar");
		session = ActionContext.getContext().getSession();
		if(file==null){
			return "fail";
		}
		Student student = (Student)session.get("user");
		String url = ServletActionContext.getServletContext().getRealPath("/avatar");
		String filename = getTimeStamp()+"."+getExt();
		System.out.println(url + fileFileName);
		File image = new File(url,filename);
		try {
			FileUtils.copyFile(file, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentService.saveAvatar("avatar/"+filename, student);
        return SUCCESS;
	}
	private String getTimeStamp(){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		return sdf.format(new Date()); 
	} 
	private String getExt(){
		String[] sfile = fileFileName.split("\\.");
		return sfile[sfile.length-1];
	}
	public BlogService getBlogService() {
		return blogService;
	}
	public void setBlogService(BlogService blogservice) {
		this.blogService = blogservice;
	}
	public Map<String, Object> getFphotolist() {
		return fphotolist;
	}
	public void setFphotolist(Map<String, Object> fphotolist) {
		this.fphotolist = fphotolist;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getFbloglist() {
		return fbloglist;
	}
	public void setFbloglist(Map<String, Object> fbloglist) {
		this.fbloglist = fbloglist;
	}
	public Map<String, Object> getFvediolist() {
		return fvediolist;
	}
	public void setFvediolist(Map<String, Object> fvediolist) {
		this.fvediolist = fvediolist;
	}
	public Map<String, Object> getFriendphoto() {
		return friendphoto;
	}
	public void setFriendphoto(Map<String, Object> friendphoto) {
		this.friendphoto = friendphoto;
	}
	public Map<String, Object> getFriendblog() {
		return friendblog;
	}
	public void setFriendblog(Map<String, Object> friendblog) {
		this.friendblog = friendblog;
	}
	public Map<String, Object> getFriendvedio() {
		return friendvedio;
	}
	public void setFriendvedio(Map<String, Object> friendvedio) {
		this.friendvedio = friendvedio;
	}
	private Map<String,Object> friendblog;
	private Map<String,Object> friendvedio;

	public Map<String, Object> getFriendinfo() {
		return friendinfo;
	}
	public void setFriendinfo(Map<String, Object> friendinfo) {
		this.friendinfo = friendinfo;
	}
	public String login() throws Exception{
		System.out.println(userid+"|"+password);
		result = new HashMap<String,Object>();
		Student student = studentService.isValidStudent(userid,password);
		System.out.println("!!!!!!!!!!");
		if(student!=null){
			System.out.println("^^^^^^^^^^");
			session = ActionContext.getContext().getSession();
			session.put("user",student);
			result.put("success", true);
			friendService.InitialFriend(userid);
			System.out.println("success...............");
		}
		else{
			result.put("success", false);
			System.out.println("error...............");
		}
		return SUCCESS;
	}
	public String changepassword() throws Exception{
		session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("user");
		String studentid = student.getStudentid();
		String password = studentService.getStudentDAO().findById(studentid).getPassword();
		System.out.println(password+"---------------------");
		System.out.println(newpassword+"---------------------");
		System.out.println(temppassword+"---------------------");
		if(!password.equals(oldpassword)){
			System.out.println("old---------------------");
			return "passworderror";
		}
		if(!newpassword.equals(temppassword)){
			System.out.println("new---------------------");
			return "newerror";
		}
		System.out.println(student.getStudentid());
		studentService.savePassword(student.getStudentid(), newpassword);
		System.out.println(student.getStudentid()+"------------------");
		return SUCCESS;
	}
	public String person() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "person";
	}

	@SuppressWarnings("unchecked")
	public String listfriend() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		List<Student> photos = (List<Student>) studentService.getStudentInfo(sid).get("friendlist");
		friendinfo = new HashMap<String,Object>();
		friendinfo.put("friendinfo", photos);
		System.out.println(photos.get(0).getAvatar());
		return SUCCESS;
	}
	public String friendphoto() throws Exception{
		System.out.println("in friend photo......");
		session = ActionContext.getContext().getSession();
		String uid= ServletActionContext.getRequest().getParameter("studentid");
		System.out.println(uid);
		String u = uid;
		System.out.println("********************************");
		System.out.println(uid);
		System.out.println("*********************************");
		if(u==null)
			return "friendphoto";
		
		if(!session.containsKey("frinndid")){
			session.put("friendid",u);
		}else{
			if(!session.get("friendid").equals(u)){
				session.remove("friendid");
				session.put("friendid", u);
			}
		}
		
//		System.out.println(u);
//		System.out.println(u);
//		List<Photo> photos = photoService.listAllPhotos(u);
//		friendphoto = new HashMap<String,Object>();
//		friendphoto.put("friendphoto", photos);
//		System.out.println(u);
		return "friendphoto";
	}
	public String friendphotolist() throws Exception{
		System.out.println("in friend photo list............");
		session = ActionContext.getContext().getSession();
		String sid = (String) session.get("friendid");
		List<Photo> photos = photoService.listAllPhotos(sid);
		fphotolist = new HashMap<String,Object>();
		fphotolist.put("fphotolist", photos);
		return SUCCESS;
	}
	public String friendblog() throws Exception{
//		session = ActionContext.getContext().getSession();
//		String u= ServletActionContext.getRequest().getParameter("userid");
//		System.out.println(u);
//		System.out.println(u);
//		System.out.println(u);
		return "friendblog";
	}
	public String friendbloglist() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = (String) session.get("friendid");
		List<Blog> blogs = blogService.getAllBlog(sid);
		fbloglist = new HashMap<String,Object>();
		System.out.println("**********");
		System.out.println(blogs.size());
		System.out.println("**********");
		fbloglist.put("fbloglist", blogs);
		return SUCCESS;
	}
	public String friendvedio() throws Exception{
//		session = ActionContext.getContext().getSession();
//		String u= ServletActionContext.getRequest().getParameter("userid");
//		System.out.println(u);
//		System.out.println(u);
//		System.out.println(u);
		return "friendvedio";
	}
	public String friendvediolist() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		List<Friend> photos = (List<Friend>) studentService.getStudentInfo(sid).get("friendlist");
		friendinfo = new HashMap<String,Object>();
		friendinfo.put("friendinfo", photos);
		return SUCCESS;
	}
	
	public String status() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "status";
	}
	public String resume() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "resume";
	}
	public String friend() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "friend";
	}
	public String find() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "find";
	}
	public String photo() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "photo";
	}
	public String blog() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		info = studentService.getStudentInfo(sid);
		return "blog";
	}
	public String exit() throws Exception{
		session = ActionContext.getContext().getSession();
		session.clear();
		return "login";
	}
	public StudentService getStudentService() {
		return studentService;
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
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public PhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	public Map<String, Object> getInfo() {
		return info;
	}
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
}
