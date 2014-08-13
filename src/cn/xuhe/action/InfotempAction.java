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

import com.opensymphony.xwork2.ActionSupport;

import cn.xuhe.entity.Infotemp;
import cn.xuhe.service.InfotempService;

public class InfotempAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String infotag;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private Map<String,Object> result;
	
	private InfotempService infotempService;
	
	public String save() throws IOException{
		String url = ServletActionContext.getServletContext().getRealPath("/information");
		String iname = getTimeStamp()+"."+getExt();
		File image = new File(url,iname);
		
		FileUtils.copyFile(file, image);
//		System.out.println(iname+infotag);
		infotempService.sav(infotag,"information/"+iname);
		return SUCCESS;
	}
	public String getInfotag() {
		return infotag;
	}
	public void setInfotag(String infotag) {
		this.infotag = infotag;
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
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public InfotempService getInfotempService() {
		return infotempService;
	}
	public void setInfotempService(InfotempService infotempService) {
		this.infotempService = infotempService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String get(){
		List<Infotemp> infotemp = infotempService.get(infotag);
		result = new HashMap<String,Object>();
		result.put("result", infotemp);
		System.out.println(infotemp.get(0).getDetail());
		infotempService.del(infotemp.get(0));
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
}
