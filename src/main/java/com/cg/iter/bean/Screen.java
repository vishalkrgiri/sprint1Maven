package com.cg.iter.bean;

import java.time.LocalDate;
import java.util.List;

public class Screen {

	private int screenId;
	private int theatreId;
	private String screenName;
	private LocalDate movieEndDate; 
	private List<Show> show;
	private int rows;
	private int columns;
	
	//parameterized constructor for Screen class
	public Screen(int screenId, int theatreId, String screenName, LocalDate movieEndDate,List<Show> show, int rows, int columns) {
		super();
		this.screenId = screenId;
		this.theatreId = theatreId;
		this.screenName = screenName;
		this.movieEndDate = movieEndDate;
		this.show = show;
		this.rows = rows;
		this.columns = columns;
	}
	
	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(LocalDate movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

}
