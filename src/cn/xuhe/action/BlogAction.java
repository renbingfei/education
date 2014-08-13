package cn.xuhe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Blog;
import cn.xuhe.entity.Student;
import cn.xuhe.service.BlogService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BlogAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Map<String,Object> session;
	private BlogService blogService;
	private Map<String,Object> result;
	private int id;
	private String title;
	private String content;
	
	public String list() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		List<Blog> blogs = blogService.getAllBlog(sid);
		result = new HashMap<String,Object>();
		result.put("result", blogs);
		return SUCCESS;
	}
	public String delete() throws Exception{
		boolean flag = blogService.deleteOneBlog(id);
		result = new HashMap<String,Object>();
		result.put("result", flag);
		return SUCCESS;
	}
	public String upload() throws Exception{
		session = ActionContext.getContext().getSession();
		String sid = ((Student)session.get("user")).getStudentid();
		blogService.uploadBlog(content, title, sid);
		result = new HashMap<String,Object>();
		result.put("result", true);
		System.out.print(title+content);
		return SUCCESS;		
	}
	public BlogService getBlogService() {
		return blogService;
	}
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
