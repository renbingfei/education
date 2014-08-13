package cn.xuhe.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.xuhe.entity.Student;
import cn.xuhe.service.ResumeService;

public class ResumeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private File resume;
	private String resumeFileName;
	private String resumeContentType;
	private ResumeService resumeService;
	
	public String execute() throws Exception{

		Student student = (Student)ActionContext.getContext().getSession().get("user");
		String sid = student.getStudentid();
		String fileType = resumeFileName.substring(resumeFileName.lastIndexOf("."));

		if(student==null){
			return "login";
		}
		String url = ServletActionContext.getServletContext().getRealPath("/resume");
		File path = new File(url,sid+fileType);
		FileUtils.copyFile(resume, path);
		
		resumeService.saveResume(sid,"resume/"+sid+fileType);
		return SUCCESS;
	}

	public File getResume() {
		return resume;
	}

	public void setResume(File resume) {
		this.resume = resume;
	}

	public String getResumeFileName() {
		return resumeFileName;
	}

	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}

	public String getResumeContentType() {
		return resumeContentType;
	}

	public void setResumeContentType(String resumeContentType) {
		this.resumeContentType = resumeContentType;
	}

	public ResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
}
