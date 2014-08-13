package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.BlogDAO;
import cn.xuhe.dao.StudentDAO;
import cn.xuhe.entity.Blog;
import cn.xuhe.entity.Student;
import cn.xuhe.util.CurrentTime;

public class BlogService {
	private BlogDAO blogDAO;
	private StudentDAO studentDAO;
	@SuppressWarnings("unchecked")
	public List<Blog> getAllBlog(String studentid){
		return blogDAO.findByStudentid(studentid);
	}
	public boolean deleteOneBlog(int id){
		Blog blog = blogDAO.findById(id);
		if(blog==null)
			return false;
		else{
			blogDAO.delete(blog);
			return true;
		}
	}
	public void uploadBlog(String content,String title,String studentid){
		Blog blog = new Blog();
		blog.setContent(content);
		blog.setStudentid(studentid);
		blog.setTitle(title);
		blog.setDate(CurrentTime.getCurrentTime());
		Student student = studentDAO.findById(studentid);
		blog.setUrl(student.getAvatar());
		blog.setName(student.getName());
		blogDAO.save(blog);
	}
	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
}
