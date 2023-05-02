package com.sapient.vo;

import java.util.Date;
import java.util.List;

public class ShowTimeRequestVo {
	
	String theatreId;
	List<Date> showTiming;
	
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public List<Date> getShowTiming() {
		return showTiming;
	}
	public void setShowTiming(List<Date> showTiming) {
		this.showTiming = showTiming;
	}
	
	
	
	
}
