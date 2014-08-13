package cn.xuhe.entity;

/**
 * Ephoto entity. @author MyEclipse Persistence Tools
 */

public class Ephoto implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer enterpriseid;
	private String date;
	private String url;

	// Constructors

	/** default constructor */
	public Ephoto() {
	}

	/** full constructor */
	public Ephoto(Integer enterpriseid, String date, String url) {
		this.enterpriseid = enterpriseid;
		this.date = date;
		this.url = url;
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

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}