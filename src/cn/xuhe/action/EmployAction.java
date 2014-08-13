package cn.xuhe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Employment;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Student;
import cn.xuhe.service.EmployService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String deadline;
	private String title;
	private String content;
	private String ename;
	private int id;
	private int enterpriseid;
	private EmployService employService;
	private Map<String,Object> result;
	public String establish() throws Exception{
		System.out.print(0);
		int id = ((Enterprise)ActionContext.getContext().getSession().get("user")).getId();
		employService.saveEmployment(title, content, id, deadline, ename);
		return SUCCESS;
	}
	public String find() throws Exception{
		System.out.print("123456");
		result = new HashMap<String,Object>();
		List<Employment> es = employService.getAllEmployments();
		result.put("result", es);
		return SUCCESS;
	}
	public String findEmploymentById(){
		System.out.print("++++++++++++++++++++++++++++++++++id=================="+id);
		Employment employments = employService.getOneInfo(id);
		result = new HashMap<String,Object>();
		result.put("result", employments);
		return SUCCESS;
	}
	public String get_pub_resume(){
		int eid = ((Enterprise)ActionContext.getContext().getSession().get("user")).getId();
		List<Employment> employments = employService.getEmploymentByEid(eid);
		System.out.println("======================================>");
		result = new HashMap<String,Object>();
		result.put("result", employments);
		return SUCCESS;
	}
	public String info() throws Exception{
		result = new HashMap<String,Object>();
		Employment e = employService.getOneInfo(id);
		result.put("result", e);
		return SUCCESS;
	}
	public String listEmployee() throws Exception{
		System.out.print("123456--------------------------------------------------------------------------------");
		result = new HashMap<String,Object>();
		List<Employment> es = employService.getOneEmployments(enterpriseid);
		result.put("result", es);
		return SUCCESS;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
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
	public EmployService getEmployService() {
		return employService;
	}
	public void setEmployService(EmployService employService) {
		this.employService = employService;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(int enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
