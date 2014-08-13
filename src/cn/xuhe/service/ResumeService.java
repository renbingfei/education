package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.ResumeDAO;
import cn.xuhe.entity.Resume;
import cn.xuhe.util.CurrentTime;

public class ResumeService {
	private ResumeDAO resumeDAO;

	public void saveResume(String id,String url){
		Resume resume = new Resume();
		resume.setDate(CurrentTime.getCurrentTime());
		resume.setStudentid(id);
		resume.setUrl(url);
		
		List old = resumeDAO.findByStudentid(id);
		
		for(int i=0;i<old.size();i++){
			
			resumeDAO.delete((Resume)(old.get(i)));
		}
		resumeDAO.save(resume);
	}
	public ResumeDAO getResumeDAO() {
		return resumeDAO;
	}

	public void setResumeDAO(ResumeDAO resumeDAO) {
		this.resumeDAO = resumeDAO;
	}
	
	
}
