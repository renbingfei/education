package cn.xuhe.entity;

/**
 * Enterprise entity. @author MyEclipse Persistence Tools
 */

public class Enterprise implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String info;
	private String contact;
	private String address;
	private Boolean validation;
	private String password;
	private String email;
	private String material;
	private String url;
	private Boolean top;
	private Boolean recommend;

	// Constructors

	/** default constructor */
	public Enterprise() {
	}

	/** minimal constructor */
	public Enterprise(String name, String info, String contact, String address,
			Boolean validation, String password, String email, String material,
			Boolean top, Boolean recommend) {
		this.name = name;
		this.info = info;
		this.contact = contact;
		this.address = address;
		this.validation = validation;
		this.password = password;
		this.email = email;
		this.material = material;
		this.top = top;
		this.recommend = recommend;
	}

	/** full constructor */
	public Enterprise(String name, String info, String contact, String address,
			Boolean validation, String password, String email, String material,
			String url, Boolean top, Boolean recommend) {
		this.name = name;
		this.info = info;
		this.contact = contact;
		this.address = address;
		this.validation = validation;
		this.password = password;
		this.email = email;
		this.material = material;
		this.url = url;
		this.top = top;
		this.recommend = recommend;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getValidation() {
		return this.validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getTop() {
		return this.top;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

	public Boolean getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}

}