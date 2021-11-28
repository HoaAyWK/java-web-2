package fp.business;

import java.io.Serializable;

public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String description;
	private String imgPath;
	private String bannerPath;
	private double rate;
	private int runningTime;
	private String genre;
	private String release;
	private boolean nowShowing;
	
	public Movie() {};
	public Movie(String id, String title, String description, String imgPath, String bannerPath, double rate,
			int runningTime, String genre, String release, boolean nowShowing) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.imgPath = imgPath;
		this.bannerPath = bannerPath;
		this.rate = rate;
		this.genre = genre;
		this.runningTime = runningTime;
		this.release = release;
		this.nowShowing = nowShowing;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	
	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}
	
	public String getBannerPath() {
		return bannerPath;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	
	public int getRunningTime() {
		return runningTime;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}
	
	public String getRelease() {
		return release;
	}
	
	public void setNowShowing(boolean nowShowing) {
		this.nowShowing = nowShowing;
	}
	
	public boolean getNowShowing() {
		return nowShowing;
	}
	
}
