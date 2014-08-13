package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.EnterpriseDAO;
import cn.xuhe.dao.PpqaDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Ppqa;
import cn.xuhe.entity.Student;

public class FindPasswordService{
	private StudentDAO studentDAO;
	private EnterpriseDAO enterpriseDAO;
	private PpqaDAO ppqaDAO;
	@SuppressWarnings("unchecked")
	public Ppqa getQuestionByUsername(String username){
		List<Ppqa> pps = ppqaDAO.findByUsername(username);
		if(pps.size()==0)
			return null;
		else
			return pps.get(0);
	}
	
	public boolean isAnswerMatch(String username, String answer1, String answer2, String answer3){
		List<Ppqa> pps = ppqaDAO.findByUsername(username);
		if(pps.size()==0){
//			System.out.println("isAnswerMatch's result size is 0");
			return false;
		}
		else{
			Ppqa pp = pps.get(0);
			System.out.println(answer1);
			System.out.println(answer2);
			System.out.println(answer3);
			if(pp.getAnswer1().equals(answer1) && pp.getAnswer2().equals(answer2) 
					&& pp.getAnswer3().equals(answer3)){
//				System.out.println("isAnswerMatch's result is true");
				return true;
			}
			else{
//				System.out.println("isAnswerMatch's result is false");
				return false;
			}
		}
	}
	public boolean setPassword(String username,int type,String password){
		System.out.println(type);
		if(type==0){
			System.out.println(0);
			Student s = studentDAO.findById(username);
//			System.out.println(s);
			s.setPassword(password);
			studentDAO.update(s);
			return true;
		}else{
			Enterprise e = (Enterprise) enterpriseDAO.findByEmail(username).get(0);
			e.setPassword(password);
			enterpriseDAO.merge(e);
			return true;
		}
	}
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	public PpqaDAO getPpqaDAO() {
		return ppqaDAO;
	}
	public void setPpqaDAO(PpqaDAO ppqaDAO) {
		this.ppqaDAO = ppqaDAO;
	}
	
	
//	public Ppqa getPpqa(String username) {
//		System.out.println("getPpqa  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getPpqa  find...");
//		if(list!=null)
//			return (Ppqa) list.get(0);
//		else
//			return null;
//	}
//	
//	public String getQuestrion1(String username) {
//		System.out.println("getQuestrion1  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getQuestrion1  find...");
//		if(list!=null)
//			return ((Ppqa) list.get(0)).getQuestion1();
//		else
//			return null;
//	}
//    
//	public String getQuestrion2(String username) {
//		System.out.println("getQuestrion2  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getQuestrion2  find...");
//		if(list!=null)
//			return ((Ppqa) list.get(0)).getQuestion2();
//		else
//			return null;
//	}
//	
//	public String getQuestrion3(String username) {
//		System.out.println("getQuestrion3  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getQuestrion3  find...");
//		if(list!=null)
//			return ((Ppqa) list.get(0)).getQuestion3();
//		else
//			return null;
//	}
//	
//	public String getAnswer1(String username) {
//		System.out.println("getAnswer1  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getAnswer1  find...");
//		if(list!=null)
//			return ((Ppqa) list.get(0)).getAnswer1();
//		else
//			return null;
//	}
//	
//	public String getAnswer2(String username) {
//		System.out.println("getAnswer2  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getAnswer2  find...");
//		if(list!=null)
//			return ((Ppqa) list.get(0)).getAnswer2();
//		else
//			return null;
//	}
//	
//	public String getAnswer3(String username) {
//		System.out.println("getAnswer3  start...");
//		List list = ppqaDAO.findByUsername(username);
//		System.out.println("getAnswer3  find...");
//		if(list!=null)
//			return ((Ppqa) list.get(0)).getAnswer3();
//		else
//			return null;
//	}
	
}
