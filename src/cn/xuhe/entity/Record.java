package cn.xuhe.entity;

/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private Integer id;
	private String studentid;
	private Integer employid;
	private String resume;
	private String date;
	private String sname;
	private String ename;
	private Integer resumeid;
	private Integer enid;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** full constructor */
	public Record(String studentid, Integer employid, String resume,
			String date, String sname, String ename, Integer resumeid,
			Integer enid) {
		this.studentid = studentid;
		this.employid = employid;
		this.resume = resume;
		this.date = date;
		this.sname = sname;
		this.ename = ename;
		this.resumeid = resumeid;
		this.enid = enid;
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

	public Integer getEmployid() {
		return this.employid;
	}

	public void setEmployid(Integer employid) {
		this.employid = employid;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getResumeid() {
		return this.resumeid;
	}

	public void setResumeid(Integer resumeid) {
		this.resumeid = resumeid;
	}

	public Integer getEnid() {
		return this.enid;
	}

	public void setEnid(Integer enid) {
		this.enid = enid;
	}

}