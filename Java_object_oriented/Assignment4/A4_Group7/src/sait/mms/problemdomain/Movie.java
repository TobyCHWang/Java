package sait.mms.problemdomain;

/**
 * 
 * @author  Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version August 08, 2021
 * this class is for movie class getter and setter
 * 
 */

public class Movie {
	private int duration; 
	private String title;
	private int year;
	
	/** 
	 * default constructor 
	 */
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param duration
	 * @param title
	 * @param year
	 */

	public Movie(int duration, String title, int year) {
		super();
		this.duration = duration;
		this.title = title;
		this.year = year;
	}
	

	/**
	 * @return the duration
	 */

	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title
	 */

	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Movie [duration=" + duration + ", title=" + title + ", year=" + year + "]";
	} 
	
	
}
