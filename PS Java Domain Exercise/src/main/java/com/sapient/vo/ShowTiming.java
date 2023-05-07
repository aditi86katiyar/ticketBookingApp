package com.sapient.vo;


import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "showTimings")
//@CompoundIndex(name="showtime_theatreid_idx",def = "{'showtiming' :1, 'theatreId' :1}", unique = true)
public class ShowTiming {
	
	@Id
	String id;
	
	ZonedDateTime showTiming;
	
	String theatreId;



	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public ZonedDateTime getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(ZonedDateTime showTiming) {
		this.showTiming = showTiming;
	}

	public ShowTiming(ZonedDateTime showTiming, String theatreId) {
		super();
		this.showTiming = showTiming;
		this.theatreId = theatreId;
	}

	
	
	
	
	

}
