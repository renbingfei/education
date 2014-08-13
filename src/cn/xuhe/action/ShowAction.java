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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private int id;
//	private String userid;
//	private String password;
	private String schoolid;
	private String name;
	private String description;
//	private File file;
//	private String fileFileName;
//	private String fileContentType;
//	private Map<String,Object> result;
//	private Map<String,Object> session;
	private School temp_school;
	private Enterprise temp_enterprise;
	
//	public String login() throws Exception{
//		session = ActionContext.getContext().getSession();
//		session.put("user", "admin");
//		result = new HashMap<String,Object>();
//		result.put("success", true);
//		return SUCCESS;
//	}
	
	public School getTemp_school() {
		return temp_school;
	}
	public void setTemp_school(School tempSchool) {
		temp_school = tempSchool;
	}
	public Enterprise getTemp_enterprise() {
		return temp_enterprise;
	}
	public void setTemp_enterprise(Enterprise tempEnterprise) {
		temp_enterprise = tempEnterprise;
	}
	public String sch_get(){
		temp_school = adminService.sch_get(schoolid);
		return "schdetail";
	}
	public String en_get(){
		temp_enterprise = adminService.en_get(id);
		System.out.println(temp_enterprise.getName());
		return "endetail";
	}
//	public String exit(){
//		session = ActionContext.getContext().getSession();
//		session.clear();
//		return "login";
//	}
	
	
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

//	public File getFile() {
//		return file;
//	}
//
//	public void setFile(File file) {
//		this.file = file;
//	}
//
//	public String getFileFileName() {
//		return fileFileName;
//	}
//
//	public void setFileFileName(String fileFileName) {
//		this.fileFileName = fileFileName;
//	}
//
//	public String getFileContentType() {
//		return fileContentType;
//	}
//
//	public void setFileContentType(String fileContentType) {
//		this.fileContentType = fileContentType;
//	}

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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
//	private String getTimeStamp(){ 
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
//		return sdf.format(new Date()); 
//	} 
//	
//	private String getExt(){
//		String[] sfile = fileFileName.split("\\.");
//		return sfile[sfile.length-1];
//	}
}
