package cn.xuhe.action;

import java.io.File;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import jxl.read.biff.BiffException;
import cn.xuhe.xls.*;

public class ImportAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String schoolid;
	
	public String upload() throws ClassNotFoundException, SQLException{
		ReadExcel readExcel = null;
		try {
			readExcel = new ReadExcel(file);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyThread myThread = new MyThread(schoolid, readExcel.sheet);
		return myThread.run();
		
	}

	public String getSchoolname() {
		return schoolid;
	}

	public String getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	public void setSchoolname(String schoolname) {
		this.schoolid = schoolname;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
