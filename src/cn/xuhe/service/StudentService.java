package cn.xuhe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.dao.BlogDAO;
import cn.xuhe.dao.FriendDAO;
import cn.xuhe.dao.PhotoDAO;
import cn.xuhe.dao.RecordDAO;
import cn.xuhe.dao.SchoolDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.School;
import cn.xuhe.entity.Student;

public class StudentService{
	private StudentDAO studentDAO;
	private PhotoDAO photoDAO;
	private FriendDAO friendDAO;
	private BlogDAO blogDAO;
	private SchoolDAO schoolDAO;
	private RecordDAO recordDAO;
	
	
	public void saveAvatar(String avatar_url, Student stu){
		System.out.print("Save photo.....");
		//Student newone = new Student();
    	//newone.setAvatar(avatar_url);
		stu.setAvatar(avatar_url);
    	studentDAO.merge(stu);
		System.out.print("Save avatar.....");
	}
	public Student isValidStudent(String studentid,String password) {
		System.out.println("isValidStudent  start...");
		Student student = studentDAO.findById(studentid);
		System.out.println("isValidStudent  find...");
		if(student!=null&&password.equals(student.getPassword()))
			return student;
		else
			return null;
	}
    public Map<String,Object> getStudentInfo(String studentid){
    	School school = schoolDAO.findById(studentid.split("@")[1]);
    	int photo_amount = photoDAO.findByStudentid(studentid).size();
    	int blog_amount = blogDAO.findByStudentid(studentid).size();
    	int friend_amount = friendDAO.findById(studentid).getFriendlist().split(";").length-1;
    	int record_amount = recordDAO.findByStudentid(studentid).size();
    	Map<String,Object> info = new HashMap<String,Object>();
    	info.put("photo", photo_amount);
    	info.put("blog", blog_amount);
    	info.put("friend", friend_amount);
    	info.put("school", school.getName());
    	info.put("record", record_amount);
    	//get friendlist
//    	System.out.print("+++++++++friendList:"+friendDAO.findById(studentid).getFriendlist()+"\n");
    	String[] friends = friendDAO.findById(studentid).getFriendlist().split(";");
//    	System.out.print("------------------------------\n");
//    	System.out.print("amount:"+friend_amount+"\n");
    	List friendlist = new ArrayList<Student>();;
    	for(int i = 1;i<=friend_amount;i++)
    	{
//    		System.out.println(i+"     "+friends[i]);
//    		System.out.println("++++++++++++++++++++++++++");
    		Student s = studentDAO.findById(friends[i]);
//    		System.out.println("+**************");
    		friendlist.add(s);
//    		System.out.println("+*^^^^^^^^^^^^^^^^^^^^^^^");
    	}
    	//end get friendlist
    	//get friendlist
    	info.put("friendlist", friendlist);
    	//end get friendlist
    	return info;
    }
    public boolean savePassword(String studentid,String password){
    	Student student = studentDAO.findById(studentid);
    	if(student == null)
    		return false;
    	student.setPassword(password);
    	studentDAO.update(student);
    	return true;
    }
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	public PhotoDAO getPhotoDAO() {
		return photoDAO;
	}
	public void setPhotoDAO(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}
	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}
	public BlogDAO getBlogDAO() {
		return blogDAO;
	}
	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
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
}
