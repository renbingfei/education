package cn.xuhe.service;

import java.util.List;
import java.util.Vector;

import cn.xuhe.dao.AdminDAO;
import cn.xuhe.dao.EmploymentDAO;
import cn.xuhe.dao.EnterpriseDAO;
import cn.xuhe.dao.ResumeDAO;
import cn.xuhe.dao.SchoolDAO;
import cn.xuhe.dao.RecordDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.Admin;
import cn.xuhe.entity.Employment;
import cn.xuhe.entity.Enterprise;
import cn.xuhe.entity.Resume;
import cn.xuhe.entity.School;
import cn.xuhe.entity.Record;
import cn.xuhe.entity.Student;

public class AdminService {
	private EnterpriseDAO enterpriseDAO;
	private EmploymentDAO employmentDAO;
	private StudentDAO studentDAO;
	private RecordDAO recordDAO;
	private AdminDAO adminDAO;
	

	private SchoolDAO schoolDAO;
	private ResumeDAO resumeDAO;
	
	public String getAdminPsw(String adminName){
		System.out.println(adminName);
		Admin example = new Admin();
		//example.setAdminName(adminName);
		Admin admin = adminDAO.findById(adminName);//此id为adminname字段（主键）
		//Admin admin = (Admin)adminDAO.findByExample(example).get(0);
		System.out.println(admin);
		if(admin != null){
			return admin.getPassword();
		}
		else{
			return null;
		}
	}
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Student> list_students(){
		return studentDAO.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<Resume> get_resume(){
		return resumeDAO.findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Employment> not_accepted(){
		return employmentDAO.findByIsaccepted(false);		
	}
		
	@SuppressWarnings("unchecked")
	public List<Employment> accepted(){
		return employmentDAO.findByIsaccepted(true);
	}
	
	public void set_isaccepted(int id){
		Employment employment = employmentDAO.findById(id);
		employment.setIsaccepted(true);
		employmentDAO.update(employment);
	}
	
	public void delete_employment(int id){
		Employment employment = employmentDAO.findById(id);
		employmentDAO.delete(employment);
	}
	
	@SuppressWarnings("unchecked")
	public Vector<String> enlist(){
		Vector<String> enterprise_list = new Vector<String>();
		List<Enterprise> enterprises = enterpriseDAO.findAll();
		for(int i=0; i<enterprises.size(); i++){
			enterprise_list.add(enterprises.get(i).getName()+"@"+enterprises.get(i).getId());
		}
		return enterprise_list;
	}
	
	@SuppressWarnings("unchecked")
	public Vector<String> emnum(Boolean isaccepted){
		Vector<String> employment_num = new Vector<String>();
		List<Enterprise> enterprises = enterpriseDAO.findAll();
		Employment em = new Employment();
		
		for(int i=0; i<enterprises.size(); i++){
			em.setEnterpriseid(enterprises.get(i).getId());
			em.setIsaccepted(isaccepted);
			employment_num.add(""+employmentDAO.findByExample(em).size());
		}
		return employment_num;
	}
	
	@SuppressWarnings("unchecked")
	public List<Employment> emlist(int enterpriseid, Boolean isaccepted){
		Employment employment = new Employment();
		employment.setEnterpriseid(enterpriseid);
		employment.setIsaccepted(isaccepted);
		return employmentDAO.findByExample(employment);
	}
	
	@SuppressWarnings("unchecked")
	public List<Enterprise> enterprise_invalidate(){
		return enterpriseDAO.findByValidation(false);
	}
	
	@SuppressWarnings("unchecked")
	public List<Enterprise> enterprise_validate(){
		return enterpriseDAO.findByValidation(true);
	}
	
	public void set_enterprise(int id){
		Enterprise enterprise = enterpriseDAO.findById(id);
		enterprise.setValidation(true);
		enterpriseDAO.merge(enterprise);
	}
	
	public Enterprise en_get(int id){
		return enterpriseDAO.findById(id);
	}
	
	public void delete_enterprise(int id){
		Enterprise enterprise = enterpriseDAO.findById(id);
		if(enterprise==null)
			System.out.println("该公司不存在！");
		else
			enterpriseDAO.delete(enterprise);
	}
	
	@SuppressWarnings("unchecked")
	public List<Record> list_record(){
		return recordDAO.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public void delete_records(int employid){
		List<Record> records = recordDAO.findByEmployid(employid);
		for(int i=0;i<records.size();i++){
			recordDAO.delete(records.get(i));
		}
	}
	
	public void delete_record(int id){
		Record record = recordDAO.findById(id);
		recordDAO.delete(record);
	}
	
	public void save_school(String id,String name,String desc,String filename){
		School school = new School();
		school.setId(id);
		school.setName(name);
		school.setDescs(desc);
		school.setIcon("school/"+filename);
		schoolDAO.save(school);
	}
	
	@SuppressWarnings("unchecked")
	public List<School> list_school(){
		return schoolDAO.findAll();
	}
	
	public School sch_get(String id){
		return schoolDAO.findById(id);
	}
	
	public void delete_school(String id){
		System.out.println(id);
		School school = schoolDAO.findById(id);
		if(school==null)
			System.out.println("该学校不存在！");
		else
			schoolDAO.delete(school);
	}
	
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}

	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	public EmploymentDAO getEmploymentDAO() {
		return employmentDAO;
	}

	public void setEmploymentDAO(EmploymentDAO employmentDAO) {
		this.employmentDAO = employmentDAO;
	}

	public RecordDAO getStudentresumeDAO() {
		return recordDAO;
	}

	public void setStudentresumeDAO(RecordDAO recordDAO) {
		this.recordDAO = recordDAO;
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	public RecordDAO getRecordDAO() {
		return recordDAO;
	}


	public void setRecordDAO(RecordDAO recordDAO) {
		this.recordDAO = recordDAO;
	}
	
	public ResumeDAO getResumeDAO() {
		return resumeDAO;
	}

	public void setResumeDAO(ResumeDAO resumeDAO) {
		this.resumeDAO = resumeDAO;
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
