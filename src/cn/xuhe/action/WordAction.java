package cn.xuhe.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.xuhe.entity.Word;
import cn.xuhe.service.WordService;

import com.opensymphony.xwork2.ActionSupport;

public class WordAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private WordService wordService;
	private Map<String,Object> result;

	public String list() throws Exception{
		System.out.print(id);
		result = new HashMap<String,Object>();
		List<Word> comments = new WordService().getWordsByBlogId(id);
		result.put("result", comments);
		return SUCCESS;
	}
	
	public WordService getWordService() {
		return wordService;
	}

	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
