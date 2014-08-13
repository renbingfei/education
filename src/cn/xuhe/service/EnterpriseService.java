package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.EmploymentDAO;
import cn.xuhe.dao.EnterpriseDAO;
import cn.xuhe.dao.RecordDAO;
import cn.xuhe.entity.Enterprise;

public class EnterpriseService{
	private EnterpriseDAO enterpriseDAO;
	private RecordDAO recordDAO;
	private EmploymentDAO employmentDAO;
	@SuppressWarnings("unchecked")
	public Enterprise isValidEnterprise(String email,String password) {
		List list= enterpriseDAO.findByEmail(email);
		if(list.size()==0)
			return null;
		Enterprise en = (Enterprise)list.get(0);
		if(en!=null&&password.equals(en.getPassword())&&en.getValidation())
			return en;
		else
			return null;
	}
	
	public void setRec(int eid , boolean rec){
		
		
		Enterprise enterprise = enterpriseDAO.findById(eid);
		enterprise.setRecommend(rec);
		if (rec) {
			enterprise.setTop(false);
		}
		enterpriseDAO.merge(enterprise);
		
		
	}
	
	public void setTop(int eid){
		List enters = enterpriseDAO.findByTop(true);
		for (int i = 0; i < enters.size(); i++) {
			((Enterprise)enters.get(i)).setTop(false);
			enterpriseDAO.merge((Enterprise)enters.get(i));
		}
		
		Enterprise enterprise = enterpriseDAO.findById(eid);
		enterprise.setTop(true);
		enterprise.setRecommend(false);
		enterpriseDAO.merge(enterprise);
		
		
	}
	
	public List listAllEnterprise(){
		return enterpriseDAO.findAll();
		
	}
	
	public List getTopEnterprise(boolean top){
		return enterpriseDAO.findByTop(top);
	}
	
	public List getRecEnterprise(boolean rec){
		return enterpriseDAO.findByRecommend(rec);
	}
	
	public List getTopRecFalse(){
		Enterprise example = new Enterprise();
		example.setTop(false);
		example.setRecommend(false);
		return enterpriseDAO.findByExample(example);
	}
	
	 public void savePassword(int id,String password){
	    	Enterprise enterprise = enterpriseDAO.findById(id);
	    	enterprise.setPassword(password);
	    	enterpriseDAO.merge(enterprise);
//	    	System.out.println(password);
	    }
	 public boolean savePassword(String enterpriseEmail,String password){
		 List result = enterpriseDAO.findByEmail(enterpriseEmail);
		 if(result.size()==0)
			 return false;
		 
	    	Enterprise enterprise = (Enterprise) result.get(0);
	    	enterprise.setPassword(password);
	    	enterpriseDAO.merge(enterprise);
	    	return true;
//	    	System.out.println(password);
	    }
	 
	public String getEnPhotos(int id){
		Enterprise en= enterpriseDAO.findById(id);
		return en.getUrl();
	}
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
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
	
}
