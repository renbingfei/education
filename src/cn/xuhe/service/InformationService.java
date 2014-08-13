package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.InformationDAO;
import cn.xuhe.entity.Information;
import cn.xuhe.util.CurrentTime;

public class InformationService {

	private InformationDAO informationDAO;
	
	public void saveinformation(int type, String title, String content, String fileName, Boolean top) {
		Information information = new Information();
		information.setType(type);
		information.setTitle(title);
		information.setContent(content);
		information.setPic("information/"+fileName);
		information.setDate(CurrentTime.getCurrentTime());
		information.setTop(top);
		informationDAO.save(information);
	}
	
	public void saveNotice(int type, String title, String content, String fileName, Boolean top) {
		List old = informationDAO.findByType(17);
		if(old.size() != 0){
			informationDAO.delete((Information)old.get(0));
		}
		
		
		Information information = new Information();
		information.setType(type);
		information.setTitle(title);
		information.setContent(content);
		information.setPic("information/"+fileName);
		information.setDate(CurrentTime.getCurrentTime());
		information.setTop(top);
		informationDAO.save(information);
	}
	
	@SuppressWarnings("unchecked")
	public List<Information> list_information(int type){
		return informationDAO.findByType(type);				
	}
	@SuppressWarnings("unchecked")
	public List<Information> getAllInfo(){
		return informationDAO.findAll();				
	}
	public Information getInfoById(int id){
		return informationDAO.findById(id);				
	}
	@SuppressWarnings("unchecked")
	public List<Information> list_title(int type){
		return informationDAO.findByType(type);
	}
	
	public boolean delete_information(int id){
		Information information = informationDAO.findById(id);
		if(information==null)
			return false;
		else{
			informationDAO.delete(information);
			return true;
		}
	}
	
	public void update_information(int id,  String title, String content, String fileName){
		Information information = informationDAO.findById(id);
		information.setTitle(title);
		information.setContent(content);
		information.setPic("information/"+fileName);
		information.setDate(CurrentTime.getCurrentTime());
		informationDAO.update(information);
	}
	
	public void update_text(int id, String title, String content){
		Information information = informationDAO.findById(id);
		information.setTitle(title);
		information.setContent(content);
		information.setDate(CurrentTime.getCurrentTime());
		informationDAO.update(information);
	}
	
	public void set_top(int id, int type){
		@SuppressWarnings("unused")
		List<Information> informations = informationDAO.findByTop(true);
		for(int i=0; i<informations.size();i++){
			if(informations.get(i).getType()==type){
				informations.get(i).setTop(false);
				informationDAO.update(informations.get(i));
			}
		}
		Information information = informationDAO.findById(id);
		information.setTop(true);
		informationDAO.update(information);
	}
	
	@SuppressWarnings("unchecked")
	public List<Information> get_tops(){
		return informationDAO.findByTop(true);
	}

	public InformationDAO getInformationDAO() {
		return informationDAO;
	}

	public void setInformationDAO(InformationDAO informationDAO) {
		this.informationDAO = informationDAO;
	}

}
