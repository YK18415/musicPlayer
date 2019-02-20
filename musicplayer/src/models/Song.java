package models;

import lombok.Data;

@Data
public class Song {
	
	private String title;
	private String singer;
	private int year;
	
	public Song(String title, String singer, int released) {
		this.setTitle(title);
		this.setSinger(singer);
		this.setReleased(released);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getReleased() {
		return year;
	}

	public void setReleased(int year) {
		this.year = year;
	}

}
