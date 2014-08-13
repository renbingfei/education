package cn.xuhe.action;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Ppqa;
import cn.xuhe.service.RegistService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String name;
	private String info;
	private String email;
	private String contact;
	private String address;
	private String password;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private String question3;
	private String answer3;
	private File material;
	private String materialFileName;
	private String materialContentType;
	private RegistService registService;
	
	public String execute() throws Exception{
		System.out.println(name);
		String url = ServletActionContext.getServletContext().getRealPath("/material");
		System.out.println(url + materialContentType);
		File path = new File(url,name+materialFileName);
		FileUtils.copyFile(material, path);
		
		Enterprise e = new Enterprise();
		e.setAddress(address);
		e.setContact(contact);
		e.setEmail(email);
		e.setInfo(info);
		e.setMaterial("material/"+name+materialFileName);
		e.setName(name);
		e.setPassword(password);
		e.setUrl("image/en.jpg");
		e.setValidation(false);
		e.setTop(false);
		e.setRecommend(false);
		registService.saveEnterprise(e);
		
		Ppqa pp = new Ppqa();
		pp.setUsername(email);
		pp.setQuestion1(question1);
		pp.setAnswer1(answer1);
		pp.setQuestion2(question2);
		pp.setAnswer2(answer2);
		pp.setQuestion3(question3);
		pp.setAnswer3(answer3);
		System.out.println("username:"+pp.getUsername());
		System.out.println(email);
		System.out.println(question1);
		System.out.println(answer1);
		System.out.println(question2);
		System.out.println(answer2);
		System.out.println(question3);
		registService.savePpqa(pp);
		return SUCCESS;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion1() {
		return question1;
	}

	public void setQuestion1(String question1) {
		this.question1 = question1;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getQuestion2() {
		return question2;
	}

	public void setQuestion2(String question2) {
		this.question2 = question2;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getQuestion3() {
		return question3;
	}

	public void setQuestion3(String question3) {
		this.question3 = question3;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public File getMaterial() {
		return material;
	}
	public void setMaterial(File material) {
		this.material = material;
	}
	public String getMaterialFileName() {
		return materialFileName;
	}
	public void setMaterialFileName(String materialFileName) {
		this.materialFileName = materialFileName;
	}
	public String getMaterialContentType() {
		return materialContentType;
	}
	public void setMaterialContentType(String materialContentType) {
		this.materialContentType = materialContentType;
	}
	public RegistService getRegistService() {
		return registService;
	}
	public void setRegistService(RegistService registService) {
		this.registService = registService;
	}
	
}
