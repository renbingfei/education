package cn.xuhe.service;

import cn.xuhe.dao.TypeDAO;
import cn.xuhe.entity.Type;

public class TypeService {
	private TypeDAO typeDAO;
	public String getType(int id){
		Type type = typeDAO.findById(id);
		return type.getType();
	}
	public TypeDAO getTypeDAO() {
		return typeDAO;
	}
	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
}
