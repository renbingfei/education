package cn.xuhe.action;

import java.util.Map;

import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Student;
import cn.xuhe.service.CardService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CardAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int eid;
	private String sid;
	private CardService cardService;
	private Enterprise enterprise;
	private Map<String,Object> session;
	private Student student;
	public String student() throws Exception{
		System.out.print(sid);
		student = cardService.getStudentInfo(sid);
		if(student==null)
			return ERROR;
		else
			return "student";
	}
	public String enterprise() throws Exception{
		System.out.print(eid);
		enterprise = cardService.getEnterpriseInfo(eid);
		session = ActionContext.getContext().getSession();
		session.put("enterprise", enterprise);
		if(enterprise==null)
			return ERROR;
		else
			return "enterprise";
	}
	public String enphoto() throws Exception {
		enterprise = cardService.getEnterpriseInfo(eid);
		return "en-photolist";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public CardService getCardService() {
		return cardService;
	}
	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
