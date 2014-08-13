package cn.xuhe.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import cn.xuhe.entity.Ppqa;
import cn.xuhe.service.FindPasswordService;
import cn.xuhe.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;

public class FindPasswordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private FindPasswordService findPasswordService;
	private StudentService studentService;
	
	private String username;
	private Map<String,Object> result;
	private String password;
	private Ppqa pp;
	private int type;
	private String answer1;
	private String answer2;
	private String answer3;
	
	public String question(){
		result = new HashMap<String,Object>();
		System.out.println(username);
		pp = findPasswordService.getQuestionByUsername(username);
		result.put("result",pp);
		return SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	public String check() throws UnsupportedEncodingException{
		result = new HashMap<String,Object>();
		boolean b = findPasswordService.isAnswerMatch(username, java.net.URLDecoder.decode(answer1,"UTF-8"), java.net.URLDecoder.decode(answer2,"UTF-8"), java.net.URLDecoder.decode(answer3,"UTF-8"));
		System.out.println(answer1);
		result.put("result",b);
		return SUCCESS;
	}
	
	public String set(){
		result = new HashMap<String,Object>();
		boolean b = findPasswordService.setPassword(username, type, password);
		result.put("result",b);
		return SUCCESS;
	}
	
	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public Ppqa getPp() {
		return pp;
	}

	public void setPp(Ppqa pp) {
		this.pp = pp;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public FindPasswordService getFindPasswordService() {
		return findPasswordService;
	}

	public void setFindPasswordService(FindPasswordService findPasswordService) {
		this.findPasswordService = findPasswordService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	
}