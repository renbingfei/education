package cn.xuhe.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Blog;
import cn.xuhe.entity.Student;
import cn.xuhe.service.BlogService;
import cn.xuhe.service.WordService;
import cn.xuhe.service.FriendService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActiveAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private FriendService friendService;
	private BlogService blogService;
	private Map<String,Object> result;
	public String friend() throws Exception{
		Student student = (Student)ActionContext.getContext().getSession().get("user");
		String fs = friendService.listFriendString(student.getStudentid());
		result = new HashMap<String,Object>();
		List<Blog> blogs = new ArrayList<Blog>();
		String[] fl = fs.split(";");
		for(int i=1;i<fl.length;i++){
			blogs.addAll(blogService.getAllBlog(fl[i]));
			System.out.println(fl[i]);
		}
		result.put("result", blogs);
		return SUCCESS;
	}
	public String my() throws Exception{
		Student student = (Student)ActionContext.getContext().getSession().get("user");
		System.out.print(student.getStudentid());
		String sid = student.getStudentid();
		result = new HashMap<String,Object>();
		List<Blog> blogs = blogService.getAllBlog(sid);
		result.put("result", blogs);
		return SUCCESS;
	}
	public FriendService getFriendService() {
		return friendService;
	}
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
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
}
