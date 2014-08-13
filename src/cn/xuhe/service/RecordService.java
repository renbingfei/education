package cn.xuhe.service;

import java.util.ArrayList;
import java.util.List;

import cn.xuhe.dao.EmploymentDAO;
import cn.xuhe.dao.EnterpriseDAO;
import cn.xuhe.dao.RecordDAO;
import cn.xuhe.dao.ResumeDAO;
import cn.xuhe.entity.Employment;
import cn.xuhe.entity.Record;
import cn.xuhe.entity.Resume;
import cn.xuhe.util.CurrentTime;

public class RecordService {
	private RecordDAO recordDAO;
	private EmploymentDAO employmentDAO;
	private EnterpriseDAO enterpriseDAO;
	private ResumeDAO resumeDAO;
	@SuppressWarnings("unchecked")
	public List<Record> getStudentRecord(String id){
		return recordDAO.findByStudentid(id);	
	}
	@SuppressWarnings("unchecked")
	public List<Record> getEnterpriseRecord(int id){
		List<Record> results = new ArrayList<Record>();
		List<Employment> es = employmentDAO.findByEnterpriseid(id);
		for(Employment e:es){
			results.addAll(recordDAO.findByEmployid(e.getId()));
		}
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<Record> getEnterpriseSchoolRecord(int enterpriseId, int schoolId){
		List<Record> results = new ArrayList<Record>();
		List<Record> search = recordDAO.findByEnid(enterpriseId);
		int size = search.size();
		for(int i=0;i<size;i++)
		{
			Record rec = search.get(i);
			if(rec.getStudentid().split("@")[1].equals(schoolId + ""))
			{
				results.add(rec);
			}
		}
		
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public boolean saveRecord(String sid,String sname,int employid){
		System.out.print(employid);
		List<Record> rs = recordDAO.findByStudentid(sid);
		System.out.print("size is" + rs.size());
		for(Record re:rs){
			System.out.print("employid" + re.getEmployid());
			if(re.getEmployid()==employid){
				System.out.print("!!!!!!!");
				return false;
			}
		}
		Record r = new Record();
		r.setDate(CurrentTime.getCurrentTime());
		r.setEmployid(employid);
		System.out.println("!!!"+employid+"!!!!");
		System.out.println(employmentDAO.findById(employid));
		r.setEname(employmentDAO.findById(employid).getEname());
		Resume re = (Resume) resumeDAO.findByStudentid(sid).get(0);
		r.setResume(re.getUrl());
		r.setResumeid(re.getId());
		r.setSname(sname);
		r.setEnid(employmentDAO.findById(employid).getEnterpriseid());
		r.setStudentid(sid);
		recordDAO.save(r);
		return true;
	}
	public RecordDAO getRecordDAO() {
		return recordDAO;
	}
	public void setRecordDAO(RecordDAO recordDAO) {
		this.recordDAO = recordDAO;
	}
	public EmploymentDAO getEmploymentDAO() {
		return employmentDAO;
	}
	public void setEmploymentDAO(EmploymentDAO employmentDAO) {
		this.employmentDAO = employmentDAO;
	}
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	public ResumeDAO getResumeDAO() {
		return resumeDAO;
	}
	public void setResumeDAO(ResumeDAO resumeDAO) {
		this.resumeDAO = resumeDAO;
	}
}
