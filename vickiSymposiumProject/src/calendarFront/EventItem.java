package calendarFront;

import java.util.Date;

public class EventItem {
	// no static
	private String name;
	private Date startTime;
	private Date endTime;
	public EventItem() {
		
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date date) {
		this.startTime = date;
	}
	public Object getEndTime() {
		return endTime;
	}
	public void setEndTime(Date date) {
		this.endTime = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
