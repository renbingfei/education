package cn.xuhe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Record;
import cn.xuhe.entity.School;
import cn.xuhe.service.RecordService;
import cn.xuhe.service.SchoolService;

import com.opensymphony.xwork2.ActionSupport;

public class SchoolAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private SchoolService schoolService;
	private RecordService recordService;
	
	private Map<String, Object> result;
	private int enterpriseId;
	private int schoolId;
	
	@SuppressWarnings("unchecked")
	public String getInfo(){
		result = new HashMap<String,Object>();
		List<School> school = schoolService.getAllSchool();		
		result.put("result", school);
		System.out.println(result.get("result"));
		return SUCCESS;
	}
	
	public String getEnterpriseSchoolRecord(){
		System.out.println("getting EnterpriseSchoolRecord......");
		result = new HashMap<String,Object>();
		List<Record> record = recordService.getEnterpriseSchoolRecord(enterpriseId, schoolId);		
		result.put("result", record);
		return SUCCESS;
	}

	public RecordService getRecordService() {
		return recordService;
	}

	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}

	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public SchoolService getSchoolService() {
		return schoolService;
	}

	public void setSchoolService(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
}
