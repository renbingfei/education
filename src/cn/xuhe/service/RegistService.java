package cn.xuhe.service;

import cn.xuhe.dao.EnterpriseDAO;
import cn.xuhe.dao.PpqaDAO;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Ppqa;

public class RegistService {
	private EnterpriseDAO enterpriseDAO;
	private PpqaDAO ppqaDAO;
	
	public void saveEnterprise(Enterprise e){
		enterpriseDAO.save(e);
	}
	
	public void savePpqa(Ppqa e){
		System.out.println("username:"+e.getUsername());
		System.out.println("q1:"+e.getQuestion1());
		System.out.println("a1:"+e.getAnswer1());
		System.out.println("q2:"+e.getQuestion2());
		System.out.println("a2:"+e.getAnswer2());
		System.out.println("q3:"+e.getQuestion3());
		System.out.println("a3:"+e.getAnswer3());
		ppqaDAO.save(e);
	}
	
	public PpqaDAO getPpqaDAO() {
		return ppqaDAO;
	}

	public void setPpqaDAO(PpqaDAO ppqaDAO) {
		this.ppqaDAO = ppqaDAO;
	}

	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}

	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	
}
