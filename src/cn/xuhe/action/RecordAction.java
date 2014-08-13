package cn.xuhe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Record;
import cn.xuhe.entity.Student;
import cn.xuhe.service.RecordService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private RecordService recordService;
	private Map<String,Object> result;
	private int employid;
	
	public String student() throws Exception{
		String sid = ((Student)ActionContext.getContext().getSession().get("user")).getStudentid();
		List<Record> records = recordService.getStudentRecord(sid);
		result = new HashMap<String,Object>();
		result.put("result", records);
		return SUCCESS;
	}
	public String enterprise() throws Exception{
		int eid = ((Enterprise)ActionContext.getContext().getSession().get("user")).getId();
		List<Record> records = recordService.getEnterpriseRecord(eid);
		result = new HashMap<String,Object>();
		result.put("result", records);
		return SUCCESS;
	}
	public String add() throws Exception{
		Student s =(Student)ActionContext.getContext().getSession().get("user");
		boolean flag = recordService.saveRecord(s.getStudentid(),s.getName(),employid);
		result = new HashMap<String,Object>();
		result.put("result", flag);
		return SUCCESS;
	}
	public RecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public int getEmployid() {
		return employid;
	}
	public void setEmployid(int employid) {
		this.employid = employid;
	}
}
