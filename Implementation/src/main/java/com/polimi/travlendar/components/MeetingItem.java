package com.polimi.travlendar.components;

import java.time.ZonedDateTime;

import org.vaadin.addon.calendar.item.BasicItem;

import com.vaadin.icons.VaadinIcons;
@SuppressWarnings("serial")
public class MeetingItem extends BasicItem {

	private final Meeting meeting;
	private String location;


	/**
	 * constructor
	 * 
	 * @param meeting
	 *            An event
	 */

	public MeetingItem(Meeting meeting) {
		super(meeting.getDetails(), meeting.getName(), meeting.getStart(), meeting.getEnd());
		this.location = meeting.getLocation();
		this.meeting = meeting;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof MeetingItem)) {
			return false;
		}
		MeetingItem that = (MeetingItem) o;
		return getMeeting().equals(that.getMeeting());
	}

	public Meeting getMeeting() {
		return meeting;
	}

	@Override
	public int hashCode() {
		return getMeeting().hashCode();
	}

	@Override
	public boolean isMoveable() {
		return meeting.isEditable();
	}

	@Override
	public boolean isResizeable() {
		return meeting.isEditable();
	}

	@Override
	public void setEnd(ZonedDateTime end) {
		meeting.setEnd(end);
		super.setEnd(end);
	}

	@Override
	public void setStart(ZonedDateTime start) {
		meeting.setStart(start);
		super.setStart(start);
	}

	@Override
	public String getDateCaptionFormat() {
		return VaadinIcons.CLOCK.getHtml() + " %s<br>" + VaadinIcons.ARROW_CIRCLE_RIGHT_O.getHtml() + " %s";
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
