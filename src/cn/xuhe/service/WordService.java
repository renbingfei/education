package cn.xuhe.service;

import java.util.List;

import cn.xuhe.dao.WordDAO;
import cn.xuhe.entity.Word;

public class WordService {
	private WordDAO wordDAO;
	
	@SuppressWarnings("unchecked")
	public List<Word> getWordsByBlogId(int id){
		return wordDAO.findByBlogid(id);
	}

	public WordDAO getWordDAO() {
		return wordDAO;
	}

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}
	
}
