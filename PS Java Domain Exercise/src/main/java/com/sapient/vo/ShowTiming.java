package com.sapient.vo;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "showTimings")
//@CompoundIndex(name="showtime_theatreid_idx",def = "{'showtiming' :1, 'theatreId' :1}", unique = true)
public class ShowTiming {
	
	@Id
	String id;
	
	Date showTiming;
	
	String theatreId;



	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public Date getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(Date showTiming) {
		this.showTiming = showTiming;
	}

	public ShowTiming(Date showTiming, String theatreId) {
		super();
		this.showTiming = showTiming;
		this.theatreId = theatreId;
	}

	
	
	
	
	

}
