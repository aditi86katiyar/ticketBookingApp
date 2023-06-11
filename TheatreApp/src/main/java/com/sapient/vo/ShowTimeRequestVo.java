package com.sapient.vo;

import java.util.Date;
import java.util.List;

public class ShowTimeRequestVo {
	
	String theatreId;
	List<String> showTiming;
	
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public List<String> getShowTiming() {
		return showTiming;
	}
	public void setShowTiming(List<String> showTiming) {
		this.showTiming = showTiming;
	}
	
	
	
	
}
