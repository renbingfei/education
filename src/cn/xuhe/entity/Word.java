package cn.xuhe.entity;

/**
 * Word entity. @author MyEclipse Persistence Tools
 */

public class Word implements java.io.Serializable {

	// Fields

	private Integer id;
	private String date;
	private String studentid;
	private Integer blogid;
	private String content;
	private String name;
	private String avatar;

	// Constructors

	/** default constructor */
	public Word() {
	}

	/** full constructor */
	public Word(String date, String studentid, Integer blogid, String content,
			String name, String avatar) {
		this.date = date;
		this.studentid = studentid;
		this.blogid = blogid;
		this.content = content;
		this.name = name;
		this.avatar = avatar;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public Integer getBlogid() {
		return this.blogid;
	}

	public void setBlogid(Integer blogid) {
		this.blogid = blogid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}