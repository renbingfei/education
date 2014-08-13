package cn.xuhe.entity;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */

public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentid;
	private String url;
	private String date;
	private String statement;
	private Boolean isvideo;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** minimal constructor */
	public Photo(String studentid, String url, String date, Boolean isvideo) {
		this.studentid = studentid;
		this.url = url;
		this.date = date;
		this.isvideo = isvideo;
	}
	/** full constructor */
	public Photo(String studentid, String url, String date, String statement,
			Boolean isvideo) {
		this.studentid = studentid;
		this.url = url;
		this.date = date;
		this.statement = statement;
		this.isvideo = isvideo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Boolean getIsvideo() {
		return this.isvideo;
	}

	public void setIsvideo(Boolean isvideo) {
		this.isvideo = isvideo;
	}

}