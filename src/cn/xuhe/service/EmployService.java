package cn.xuhe.service;

import java.util.ArrayList;
import java.util.List;

import cn.xuhe.dao.EmploymentDAO;
import cn.xuhe.entity.Employment;
import cn.xuhe.util.CurrentTime;

public class EmployService {
	private EmploymentDAO employmentDAO;
	public void saveEmployment(String title,String content,int id,String deadline,String ename){
		Employment e = new Employment();
		e.setContent(content);
		e.setDate(CurrentTime.getCurrentTime());
		e.setDeadline(deadline);
		e.setEnterpriseid(id);
		e.setIsaccepted(false);
		e.setTitle(title);
		e.setEname(ename);
		System.out.print(ename);
		employmentDAO.save(e);
	}
	@SuppressWarnings("unchecked")
	public List<Employment> getAllEmployments(){
		List<Employment> es = employmentDAO.findAll();
		List<Employment> ems = new ArrayList<Employment>();
		for(Employment e:es){
			if(e.getIsaccepted())
				ems.add(e);
		}
		return ems;
	}
	public List<Employment> getOneEmployments(int enterpriseid){
		List<Employment> es = employmentDAO.findByEnterpriseid(enterpriseid);
		List<Employment> ems = new ArrayList<Employment>();
		for(Employment e:es){
			if(e.getIsaccepted())
				ems.add(e);
		}
		return ems;
	}
	public Employment getOneInfo(int id){
		return employmentDAO.findById(id);
	}
	public List<Employment> getEmploymentByEid(int eid){
		return employmentDAO.findByEnterpriseid(eid);
	}
	public EmploymentDAO getEmploymentDAO() {
		return employmentDAO;
	}

	public void setEmploymentDAO(EmploymentDAO employmentDAO) {
		this.employmentDAO = employmentDAO;
	}
	
	
}
