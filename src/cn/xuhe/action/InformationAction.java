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

import cn.xuhe.entity.Information;
import cn.xuhe.service.InformationService;
import cn.xuhe.service.TypeService;

import com.opensymphony.xwork2.ActionSupport;

public class InformationAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Boolean top;
	private String link;
	private Integer id;
	private String title;
	private String content;
	private int type;
	private File file;
	private String ts;
	private String fileFileName;
	private String fileContentType;
	private Map<String,Object> result;
	private Map<String,Object> session;
	private InformationService informationService;
	private TypeService typeService;
	private Information information;
	private List<Information> lists;
	
	
	public String upload() throws Exception{	
		System.out.println(fileFileName);
		if(fileFileName!=null&&!fileFileName.equals("")){
			String url = ServletActionContext.getServletContext().getRealPath("/information");
			String iname = type+getTimeStamp()+"."+getExt();
			File image = new File(url,iname);
			
			FileUtils.copyFile(file, image);			
			informationService.saveinformation(type, title+";"+link, content, iname, false);
		}else{
			if(type != 17)
				informationService.saveinformation(type, title+";"+link, content,"" , false);
			else
				informationService.saveNotice(type, title, content,"" , false);
		}
		
		return "here";		
	}
	
	public String showNotice() throws Exception{
		System.out.println("showNotice");
		List<Information> informations = informationService.list_information(17);
		result = new HashMap<String,Object>();
		result.put("result", informations);
		return SUCCESS;
	}
	
	public String update() throws IOException{
		if(fileFileName!=null&&!fileFileName.equals("")){
			String url = ServletActionContext.getServletContext().getRealPath("/information");
			String iname = type+getTimeStamp()+"."+getExt();
			File image = new File(url,iname);
			
			FileUtils.copyFile(file, image);		
			informationService.update_information(id, title+";"+link, content, iname);
		}
		else{
			informationService.update_information(id, title+";"+link,content,"" );
		}
		return "edit";
	}
	
	public String update_video_interface() throws IOException{

			String url = ServletActionContext.getServletContext().getRealPath("/information");
			String iname = 5+getTimeStamp()+"."+getExt();
			File image = new File(url,iname);
			
			FileUtils.copyFile(file, image);			
//			informationService.saveinformation(5, "首页视频"+";"+"", "视频", iname, false);
			result = new HashMap<String,Object>();
			result.put("result", url+"\\"+iname);
		
		return SUCCESS;
	}
	
	public String upload_headnews() throws Exception{
		String url = ServletActionContext.getServletContext().getRealPath("/information");
		String iname = type+getTimeStamp()+"."+getExt();
		System.out.println(fileFileName);
		File image = new File(url,iname);
		FileUtils.copyFile(file, image);
		informationService.saveinformation(16, "n", "n", iname, false);
		return "here";
	}
	public String more(){
		ts = typeService.getType(type);
		lists = informationService.list_information(type);
		return SUCCESS;
	}
	public String list() {
		List<Information> informations = informationService.list_information(type);
		result = new HashMap<String,Object>();
		result.put("result", informations);
		return SUCCESS;
	}
	public String get() {
		information = informationService.getInfoById(id);
		result = new HashMap<String,Object>();
		result.put("result", information);
		return SUCCESS;
	}
	
	public String delete() {
		informationService.delete_information(id);
		return "edit";
	}
	public String all(){
		result = new HashMap<String,Object>();
		List<Information> infos = informationService.getAllInfo();
		result.put("result", infos);
		return SUCCESS;
	}
	public String top(){
		informationService.set_top(id, type);
		return "edit";
	}
	public String get_tops(){
		result = new HashMap<String,Object>();
		List<Information> infos = informationService.get_tops();
		System.out.println(infos.size());
		result.put("result", infos);
		return SUCCESS;
	}
	public String id(){
		information = informationService.getInfoById(id);
		if(information.getType()!=5)return SUCCESS;
		else return "vedio";
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public InformationService getInformationService() {
		return informationService;
	}

	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public List<Information> getLists() {
		return lists;
	}

	public void setLists(List<Information> lists) {
		this.lists = lists;
	}
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public Boolean getTop() {
		return top;
	}

	public void setTop(Boolean top) {
		this.top = top;
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
