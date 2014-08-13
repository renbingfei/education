package cn.xuhe.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Ephoto;
import cn.xuhe.entity.Photo;
import cn.xuhe.entity.Student;
import cn.xuhe.service.PhotoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EPhotoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private Map<String,Object> session;
	private PhotoService photoService;
	private Map<String,Object> result;
	private int id;//photoid
	private int enterpriseid;
	public String upload() throws Exception{
		session = ActionContext.getContext().getSession();
		Enterprise enterprise = (Enterprise)session.get("user");
		String url = ServletActionContext.getServletContext().getRealPath("/ephoto");
		System.out.println(url + fileContentType);
		File image = new File(url,enterprise.getId()+fileFileName);
		FileUtils.copyFile(file, image);
		photoService.saveEPhoto(enterprise.getId()+fileFileName, enterprise.getId());
        return SUCCESS;
	}
	public String list() throws Exception{
		session = ActionContext.getContext().getSession();
		int id = ((Enterprise)session.get("user")).getId();
		List<Ephoto> photos = photoService.listAllEPhotos(id);
		result = new HashMap<String,Object>();
		result.put("result", photos);
		return SUCCESS;
	}
	public String list1() throws Exception{
		session = ActionContext.getContext().getSession();
		int id = ((Enterprise)session.get("enterprise")).getId();
		List<Ephoto> photos = photoService.listAllEPhotos(id);
		result = new HashMap<String,Object>();
		result.put("result", photos);
		return SUCCESS;
	}
	public String delete() throws Exception{
		result = new HashMap<String,Object>();
		boolean flag = photoService.deleteOneEPhoto(id);
		result.put("result", flag);
		return SUCCESS;
	}
	public File getFile() {
		return file;
	}
	
	public String listfour(){
		result = new HashMap<String,Object>();
		Vector<Ephoto> photos = photoService.engetfour(enterpriseid);
		if(photos.size()==0)
			result.put("result", "null");
		else
			result.put("result", photos);
		return SUCCESS;
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

	public PhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(int enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
}
