package cn.xuhe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.dao.BlogDAO;
import cn.xuhe.dao.FriendDAO;
import cn.xuhe.dao.PhotoDAO;
import cn.xuhe.dao.SchoolDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.School;
import cn.xuhe.entity.Student;

public class SchoolService{

	private SchoolDAO schoolDAO;

	@SuppressWarnings("unchecked")
	public List getAllSchool()
	{
		List<School> school = schoolDAO.findAll();
		return school;
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}
	
	
	
}
