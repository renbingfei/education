package cn.xuhe.service;

import cn.xuhe.dao.EnterpriseDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Student;

public class CardService {
	private EnterpriseDAO enterpriseDAO;
	private StudentDAO studentDAO;
	public Enterprise getEnterpriseInfo(int id){
		return enterpriseDAO.findById(id);
	}
	public Student getStudentInfo(String id){
		return studentDAO.findById(id);
	}
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
