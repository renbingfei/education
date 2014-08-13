package cn.xuhe.action;

import java.util.HashMap;
import java.util.Map;

import cn.xuhe.entity.Student;
import cn.xuhe.service.FriendService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FriendAction extends ActionSupport{
	public static final long serialVersionUID = 1L;
	private FriendService friendService;
	private Map<String,Object> result;
	private String studentid;
	private Map<String,Object> session;
	public String list() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		result = new HashMap<String,Object>();
		result.put("result",friendService.listFriend(sid));
		return SUCCESS;
	}
	public String findS() throws Exception{
		result = new HashMap<String,Object>();
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		result = friendService.findOneStudent(sid, studentid);
		return SUCCESS;
			
	}
	public String findF() throws Exception{
		result = new HashMap<String,Object>();
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		Student student = friendService.findOneFriend(sid, studentid);
		result.put("result", student);
		return SUCCESS;
			
	}
	public String add() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		result = new HashMap<String,Object>();
		if(friendService.findOneFriend(sid, studentid)==null){
//			result.put("result", value);
		}
		friendService.addFriend(sid, studentid);
		
		result.put("result", true);
		return SUCCESS;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
}
