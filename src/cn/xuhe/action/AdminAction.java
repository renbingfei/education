package cn.xuhe.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.xuhe.entity.Employment;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Resume;
import cn.xuhe.entity.School;
import cn.xuhe.entity.Record;
import cn.xuhe.entity.Student;
import cn.xuhe.service.AdminService;
import cn.xuhe.service.EnterpriseService;
import cn.xuhe.service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private StudentService studentService;
	private EnterpriseService enterpriseService;
	private int id;
//	private Boolean isaccepted;
	private String userid;
	private String password;
	private String schoolid;
	private String studentid;
	private String enterpriseemail;
	private int employmentid;
	private String name;
	private String description;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private Map<String,Object> result;
	private Map<String,Object> session;
	private String rpassresult;
	
	public String getRpassresult() {
		return rpassresult;
	}

	public void setRpassresult(String rpassresult) {
		this.rpassresult = rpassresult;
	}

	public String login() throws Exception{
		session = ActionContext.getContext().getSession();
		session.put("user", userid);
		result = new HashMap<String,Object>();
		System.out.println("admin login:"+userid);
		String psw = adminService.getAdminPsw(userid);
		System.out.println(psw);
		if(psw != null && password.equals(psw)){
			result.put("success", true);
			return SUCCESS;
		}
		else{
			result.put("success", false);
			return SUCCESS;
		}
	}
	
	public String resetEnPSW() throws Exception{
		boolean tag = enterpriseService.savePassword(enterpriseemail, "123456");
		result = new HashMap<String,Object>();
		if(tag == true){
			result.put("result", true);
		}
		else{
			result.put("result", false);
		}
		return SUCCESS;
	}
	
	public String resetStuPSW() throws Exception{
		boolean tag = studentService.savePassword(studentid, studentid.split("@")[0]);
		result = new HashMap<String,Object>();
		if(tag == true){
			result.put("result", true);
		}
		else{
			result.put("result", false);
		}
		return SUCCESS;
	}
	
	public String main(){
		return "main";
	}
	public String employ(){
		return "employ";
	}
	public String data(){
		return "data";
	}
	public String enterprise(){
		return "enterprise";
	}
	public String resume(){
		return "resume";
	}
	public String school(){
		return "school";
	}
	public String index(){
		return "index";
	}
	public String edit(){
		return "edit";
	}
	public String querypsw(){
		return "querypsw";
	}
	
	public String exit(){
		session = ActionContext.getContext().getSession();
		session.clear();
		return "admin-login";
	}
	public String get_info(){
		result = new HashMap<String,Object>();
		int enternumber = adminService.enterprise_validate().size();
		int recordnumber = adminService.list_record().size();
		int resumenumber = adminService.get_resume().size();
		int studentnumber = adminService.list_students().size();
		result.put("result", studentnumber+"#"+resumenumber+"#"+enternumber+"#"+recordnumber);
		return SUCCESS;
	}
	
	public String list_notaccept(){
		List<Employment> employments = adminService.not_accepted();
		result = new HashMap<String,Object>();
		result.put("employments", employments);
		List<Enterprise> enterprises = adminService.enterprise_validate();
		result.put("enterprises", enterprises);
		return SUCCESS;
	}
	
	public String getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String list_accept(){
		List<Employment> employments = adminService.accepted();
		result = new HashMap<String,Object>();
		result.put("employments", employments);
		List<Enterprise> enterprises = adminService.enterprise_validate();
		result.put("enterprises", enterprises);
		return SUCCESS;
	}
	
	public String en_aem(){
		result = new HashMap<String,Object>();
		result.put("enterprises", adminService.enlist());
		result.put("num", adminService.emnum(true));
		return SUCCESS;
	}
	
	public String en_nem(){
		result = new HashMap<String,Object>();
		result.put("enterprises", adminService.enlist());
		result.put("num", adminService.emnum(false));
		return SUCCESS;
	}
	
	public String em_accepted(){
		result = new HashMap<String,Object>();
		result.put("employments", adminService.emlist(id, true));
		return SUCCESS;
	}
	
	public String em_naccepted(){
		result = new HashMap<String,Object>();
		result.put("employments", adminService.emlist(id, false));
		return SUCCESS;
	}
	
	public String accept(){
		adminService.set_isaccepted(id);
		return SUCCESS;
	}
	
	public String delete_employment(){
		adminService.delete_employment(employmentid);
		adminService.delete_records(employmentid);
		return SUCCESS;
	}
	@SuppressWarnings("unused")
	public String get_record(){
		result = new HashMap<String,Object>();
//		List<Student> students = adminService.list_students();		
//		result.put("students", students);
		Vector<String> relist = new Vector<String>();
		List<Record> records = adminService.list_record();		
		List<Enterprise> enterprises = adminService.enterprise_validate();
		int rcount;
		for(int i=0; i < enterprises.size();i++){
			relist.add(enterprises.get(i).getName());
			rcount=0;
			for(int j=0; j<records.size(); j++){
				if((""+records.get(j).getEnid()).equals((""+enterprises.get(i).getId()))){
					rcount++;
				}
			}
			
			relist.add(""+rcount);
		}
		result.put("result", relist);
//		List<School> schools = adminService.list_school();
//		result.put("schools", schools);			
//		List<Employment> employments = adminService.accepted();
//		result.put("employments", employments);
//		List<Resume> resumes = adminService.get_resume();
//		result.put("resumes", resumes);
		return SUCCESS;
	}
	
	public String delet_record(){
		adminService.delete_record(id);
		return SUCCESS;
	}
	
	public String valid_enterprise(){
		List<Enterprise> enterprises = adminService.enterprise_validate();
		result = new HashMap<String,Object>();
		result.put("result", enterprises);
		return SUCCESS;
	}
	
	public String invalid_enterprise(){
		List<Enterprise> enterprises = adminService.enterprise_invalidate();
		result = new HashMap<String,Object>();
		result.put("result", enterprises);
		return SUCCESS;
	}
	
	public String delete_enterprise(){
		adminService.delete_enterprise(id);
		return SUCCESS;
	}
	
	public String agree_enterprise(){
		adminService.set_enterprise(id);
		return SUCCESS;
	}
	
	public String add_school() throws IOException{
		String url = ServletActionContext.getServletContext().getRealPath("/school");
		String iname = schoolid+getTimeStamp()+"."+getExt();
		File icon = new File(url,iname);
		FileUtils.copyFile(file, icon);
		adminService.save_school(schoolid, name, description, iname);
		return "add_school";
	}
	
	public String list_school(){
		List<School> schools = adminService.list_school();
		result = new HashMap<String,Object>();
		result.put("result", schools);
		return SUCCESS;
	}
	
	public String delete_school(){
		adminService.delete_school(schoolid);
		return SUCCESS;
	}
	
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
		
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmploymentid() {
		return employmentid;
	}
	public void setEmploymentid(int employmentid) {
		this.employmentid = employmentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}

	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getEnterpriseemail() {
		return enterpriseemail;
	}

	public void setEnterpriseemail(String enterpriseemail) {
		this.enterpriseemail = enterpriseemail;
	}

	private String getTimeStamp(){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		return sdf.format(new Date()); 
	}
//	public Boolean getIsaccepted() {
//		return isaccepted;
//	}
//	public void setIsaccepted(Boolean isaccepted) {
//		this.isaccepted = isaccepted;
//	}
//	
	private String getExt(){
		String[] sfile = fileFileName.split("\\.");
		return sfile[sfile.length-1];
	}
}
