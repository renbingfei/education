package cn.xuhe.entity;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */

public class Friend implements java.io.Serializable {

	// Fields

	private String studentid;
	private String friendlist;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** full constructor */
	public Friend(String friendlist) {
		this.friendlist = friendlist;
	}

	// Property accessors

	public String getStudentid() {
		return this.studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFriendlist() {
		return this.friendlist;
	}

	public void setFriendlist(String friendlist) {
		this.friendlist = friendlist;
	}

}