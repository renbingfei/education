package cn.xuhe.entity;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */

public class Information implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private String pic;
	private Integer type;
	private String date;
	private Boolean top;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** minimal constructor */
	public Information(String title, String content, Integer type, String date,
			Boolean top) {
		this.title = title;
		this.content = content;
		this.type = type;
		this.date = date;
		this.top = top;
	}

	/** full constructor */
	public Information(String title, String content, String pic, Integer type,
			String date, Boolean top) {
		this.title = title;
		this.content = content;
		this.pic = pic;
		this.type = type;
		this.date = date;
		this.top = top;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getTop() {
		return this.top;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

}