package cn.xuhe.entity;

/**
 * Infotemp entity. @author MyEclipse Persistence Tools
 */

public class Infotemp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String detail;
	private String infotag;

	// Constructors

	/** default constructor */
	public Infotemp() {
	}

	/** full constructor */
	public Infotemp(String detail, String infotag) {
		this.detail = detail;
		this.infotag = infotag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getInfotag() {
		return this.infotag;
	}

	public void setInfotag(String infotag) {
		this.infotag = infotag;
	}

}