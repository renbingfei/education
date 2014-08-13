package cn.xuhe.service;

import java.util.List;
import java.util.Vector;

import cn.xuhe.dao.EphotoDAO;
import cn.xuhe.dao.PhotoDAO;
import cn.xuhe.entity.Ephoto;
import cn.xuhe.entity.Photo;
import cn.xuhe.util.CurrentTime;

public class PhotoService {
	private PhotoDAO photoDAO;
	private EphotoDAO ephotoDAO;
	public void savePhoto(String fileName,String studentid,String statement){
		System.out.print("Save photo.....");
		Photo photo = new Photo();
		photo.setStudentid(studentid);
		photo.setDate(CurrentTime.getCurrentTime());
		photo.setUrl("photo/"+fileName);
		photo.setStatement(statement);
		photo.setIsvideo(false);
		System.out.print("Save photo.....");
		photoDAO.save(photo);
	}
	public void saveEPhoto(String fileName,int enterpriseid){
		System.out.print("Save photo.....");
		Ephoto ephoto = new Ephoto();
		ephoto.setEnterpriseid(enterpriseid);
		ephoto.setDate(CurrentTime.getCurrentTime());
		ephoto.setUrl("ephoto/"+fileName);
		System.out.print("Save photo.....");
		ephotoDAO.save(ephoto);
	}
	
	//video
	public void saveVideo(String fileName,String studentid){
		System.out.print("Save video.....");
		Photo video = new Photo();
		video.setStudentid(studentid);
		video.setDate(CurrentTime.getCurrentTime());
		video.setUrl(fileName);
		video.setIsvideo(true);
		System.out.print("Save video.....");
		photoDAO.save(video);
	}
	
	@SuppressWarnings("unchecked")
	public List<Photo> listAllPhotos(String studentid){
		return photoDAO.findByStudentid(studentid);
	}@SuppressWarnings("unchecked")
	public List<Photo> listAllVideos(String studentid){
		//return photoDAO.findByStudentid(studentid);
		
		Photo video = new Photo();
		video.setStudentid(studentid);
		video.setIsvideo(true);
		List<Photo> videos = photoDAO.findByExample(video);
		return videos;
//		List<String> urls = new ArrayList();
//		int amount = videos.size();
//		for(int i=0;i<amount;i++)
//		{
//			urls.add(videos.get(i).getUrl());
//		}
//		
//		return  urls;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<Ephoto> listAllEPhotos(int enterpriseid){
		return ephotoDAO.findByEnterpriseid(enterpriseid);
	}
	public boolean deleteOnePhoto(int id){
		Photo photo = photoDAO.findById(id);
		if(photo==null)
			return false;
		else{
			photoDAO.delete(photo);
			return true;
		}	
	}
	public boolean deleteOneEPhoto(int id){
		Ephoto ephoto = ephotoDAO.findById(id);
		if(ephoto==null)
			return false;
		else{
			ephotoDAO.delete(ephoto);
			return true;
		}	
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Photo> getfour(String studentid){
		List<Photo> photos = photoDAO.findByStudentid(studentid);
		Vector<Photo> photofour = new Vector<Photo>();
		for(int i=(photos.size()-1); i >= (photos.size()-4);i--){
			if(i<0)break;
			photofour.add(photos.get(i));
		}
		return photofour;
	}
	
	@SuppressWarnings("unchecked")
	public Vector<Ephoto> engetfour(int enterpriseid){
		List<Ephoto> ephotos = ephotoDAO.findByEnterpriseid(enterpriseid);
		Vector<Ephoto> ephotofour = new Vector<Ephoto>();
		for(int i=(ephotos.size()-1); i >= (ephotos.size()-4);i--){
			if(i<0)break;
			ephotofour.add(ephotos.get(i));
		}
		return ephotofour;
	}
	
	public PhotoDAO getPhotoDAO() {
		return photoDAO;
	}
	public void setPhotoDAO(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}
	public EphotoDAO getEphotoDAO() {
		return ephotoDAO;
	}
	public void setEphotoDAO(EphotoDAO ephotoDAO) {
		this.ephotoDAO = ephotoDAO;
	}
}
