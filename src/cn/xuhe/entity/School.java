package cn.xuhe.entity;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String icon;
	private String descs;

	// Constructors

	/** default constructor */
	public School() {
	}

	/** full constructor */
	public School(String name, String icon, String descs) {
		this.name = name;
		this.icon = icon;
		this.descs = descs;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescs() {
		return this.descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

}