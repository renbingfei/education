package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.InfotempDAO;
import cn.xuhe.entity.Infotemp;


public class InfotempService {
	private InfotempDAO infotempDAO;
	
	public void del(Infotemp infotemp){
		infotempDAO.delete(infotemp);
	}
	
	public void sav(String infotag,String detail){
		Infotemp infotemp = new Infotemp();
		infotemp.setDetail(detail);
		infotemp.setInfotag(infotag);
//		System.out.println(infotemp.getDetail()+infotemp.getInfotag());
		infotempDAO.save(infotemp);
	}
	
	public InfotempDAO getInfotempDAO() {
		return infotempDAO;
	}

	public void setInfotempDAO(InfotempDAO infotempDAO) {
		this.infotempDAO = infotempDAO;
	}

	@SuppressWarnings("unchecked")
	public List<Infotemp> get(String infotag){
		return infotempDAO.findByInfotag(infotag);
	}
}
