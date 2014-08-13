package cn.xuhe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.dao.FriendDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.Friend;
import cn.xuhe.entity.Student;

public class FriendService {
	private FriendDAO friendDAO;
	private StudentDAO studentDAO;
	public List<Student> listFriend(String studentid){
		List <Student>students = new ArrayList<Student>();
		Friend friend = friendDAO.findById(studentid);
		String friends[] = friend.getFriendlist().split(";");
		for(int i=1;i<friends.length;i++){
			students.add(studentDAO.findById(friends[i]));
		}
		return students;
	}
	public Map<String,Object> findOneStudent(String studentid, String friendid){
		System.out.print(friendid);
		System.out.print(studentid);
		Student student = studentDAO.findById(friendid);
		Map<String,Object> re = new HashMap<String,Object>();
		re.put("student", student);
		if(student==null){
			re.put("status", -1);
			return re;
		}
		if(studentid.equals(friendid)){
			re.put("status", 0);
			return re;
		}
		String[] list = friendDAO.findById(studentid).getFriendlist().split(";");
		for(int i=1;i<list.length;i++){
			if(list[i].equals(friendid)){
				re.put("status", 0);
				return re;
			}
		}
		re.put("status", 1);
		return re;
	}
	public Student findOneFriend(String studentid, String friendid){
		Student student = studentDAO.findById(studentid);
		String[] list = friendDAO.findById(studentid).getFriendlist().split(";");
		for(int i=1;i<list.length;i++){
			if(list[i].equals(friendid)){
				return student;
			}
		}
		return null;
	}
	public String listFriendString(String studentid){
		Friend friend = friendDAO.findById(studentid);
		if(friend==null)
			return null;
		else
			return friend.getFriendlist();
	}
	public void InitialFriend(String studentid){
		Friend friend = friendDAO.findById(studentid);
		if(friend==null){
	    	Friend f = new Friend();
	    	f.setFriendlist("");
	    	f.setStudentid(studentid);
	    	friendDAO.save(f);
		}
    }
	public void addFriend(String studentid1,String studentid2){
		
		Friend friend1 = friendDAO.findById(studentid1);
		InitialFriend(studentid2);
		Friend friend2 = friendDAO.findById(studentid2);
		
		String[] flist = friend1.getFriendlist().split(";");
		for(String s : flist){
			if(s.equals(studentid2))
				return;
		}
		
		//String[] list = friend1.getFriendlist().split(";");
		//for(int i=1;i<list.length;i++)
			//if(list[i].equals(studentid2))
				//return flase
		friend1.setFriendlist(friend1.getFriendlist()+";"+studentid2);
		friend2.setFriendlist(friend2.getFriendlist()+";"+studentid1);
		friendDAO.update(friend1);
		friendDAO.update(friend2);
	}
	public FriendDAO getFriendDAO() {
		return friendDAO;
	}
	public void setFriendDAO(FriendDAO friendDAO) {
		this.friendDAO = friendDAO;
	}
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
}
