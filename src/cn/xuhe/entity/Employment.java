package cn.xuhe.entity;

/**
 * Employment entity. @author MyEclipse Persistence Tools
 */

public class Employment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer enterpriseid;
	private String title;
	private String content;
	private String date;
	private Boolean isaccepted;
	private String deadline;
	private String ename;

	// Constructors

	/** default constructor */
	public Employment() {
	}

	/** full constructor */
	public Employment(Integer enterpriseid, String title, String content,
			String date, Boolean isaccepted, String deadline, String ename) {
		this.enterpriseid = enterpriseid;
		this.title = title;
		this.content = content;
		this.date = date;
		this.isaccepted = isaccepted;
		this.deadline = deadline;
		this.ename = ename;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnterpriseid() {
		return this.enterpriseid;
	}

	public void setEnterpriseid(Integer enterpriseid) {
		this.enterpriseid = enterpriseid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getIsaccepted() {
		return this.isaccepted;
	}

	public void setIsaccepted(Boolean isaccepted) {
		this.isaccepted = isaccepted;
	}

	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}