package cn.xuhe.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.xuhe.entity.Photo;
import cn.xuhe.entity.Student;
import cn.xuhe.service.PhotoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PhotoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private File file;
	private String text;
	private String fileFileName;
	private String fileContentType;
	private Map<String,Object> session;
	private PhotoService photoService;
	private Map<String,Object> result;
	private int id;//photoid
	private String video_url;
	public String upload() throws Exception{
		session = ActionContext.getContext().getSession();
		if(file==null){
			return "fail";
		}
		Student student = (Student)session.get("user");
		String url = ServletActionContext.getServletContext().getRealPath("/photo");
		String filename = getTimeStamp()+"."+getExt();
		System.out.println(url + fileFileName + "    " + text);
		File image = new File(url,filename);
		FileUtils.copyFile(file, image);
		photoService.savePhoto(filename, student.getStudentid(),text);
        return SUCCESS;
	}
	
	//upload video
	public String upload_video() throws Exception{
		session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("user");
		
		photoService.saveVideo(video_url, student.getStudentid());
        return SUCCESS;
	}
	
	public String list() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		List<Photo> photos = photoService.listAllPhotos(sid);
		result = new HashMap<String,Object>();
		result.put("result", photos);
		return SUCCESS;
	}
	
	public String listVideo() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		List<Photo> videos = photoService.listAllVideos(sid);
		result = new HashMap<String,Object>();
		result.put("result", videos);
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		result = new HashMap<String,Object>();
		boolean flag = photoService.deleteOnePhoto(id);
		result.put("result", flag);
		return SUCCESS;
	}
	
	public String listfour(){
		result = new HashMap<String,Object>();
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		Vector<Photo> photos = photoService.getfour(sid);
		if(photos.size()==0)
			result.put("result", "null");
		else
			result.put("result", photos);
		return SUCCESS;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	private String getTimeStamp(){ 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		return sdf.format(new Date()); 
	} 
	
	private String getExt(){
		String[] sfile = fileFileName.split("\\.");
		return sfile[sfile.length-1];
	}
	
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String videoUrl) {
		video_url = videoUrl;
	}
}
