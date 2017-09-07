package com.iteso.model;

import java.util.Calendar;

public class DateTime extends Date {
	
	public String a1 = "Soy feliz. Saqué " + super.a1;
	
	private int seconds = 0, minutes = 0, hours = 0;

//	Asigna hora recibida y fecha recibida
	public DateTime(int hh, int mi, int ss, int dd, int mm, int yy) {
		super(dd, mm, yy);
		setHours(hh);
		setMinutes(mi);
		setSeconds(ss);
	}

//	Asigna hora recibida y fecha actual
	public DateTime(int hh, int mi, int ss) {
		super();
		setHours(hh);
		setMinutes(mi);
		setSeconds(ss);
	}

//	Asigna hora actual   y fecha actual
	public DateTime() {
		super();
		toLocalTime();
	}

//	Asigna hora actual   y fecha recibida
	public DateTime(Date d) {
		super(d.getDay(), d.getMonth(), d.getYear());
		toLocalTime();
	}
	
	private void toLocalTime() {
		Calendar c = Calendar.getInstance();
		this.seconds = c.get(Calendar.SECOND);
		this.minutes = c.get(Calendar.MINUTE);
		this.hours   = c.get(Calendar.HOUR_OF_DAY);
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		if(seconds >= 0 && seconds <= 59) this.seconds = seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if(minutes >= 0 && minutes <= 59) this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if(hours >= 0 && hours <= 23) this.hours = hours;
	}
	
	public String toString() {
//		0: [0:28:05] 29/06/17
//		1: [12:28:05 AM] 29-Jun-2017
//		2: [12:28:05 AM] 29 de junio de 2017
		if(getFormat() == 0) {
			return String.format("[%d:%02d:%02d] %s", this.hours,   this.minutes, 
					                                  this.seconds, super.toString());
		} else {
			String ampm = this.hours < 12? "AM" : "PM";
//			int hours   = this.hours > 12? this.hours - 12 : this.hours;
			int hours   = this.hours % 12;
			if(hours == 0) hours = 12;
			return String.format("[%d:%02d:%02d %s] %s", hours,  this.minutes, this.seconds, 
					                                     ampm,   super.toString());
		}
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof DateTime)) return false;
		DateTime t = (DateTime) o;
		return this.hours   == t.hours   && this.minutes == t.minutes && 
			   this.seconds == t.seconds && super.equals(t);
	}
	
	public DateTime clone() { 
		return new DateTime(this.hours, this.minutes, this.seconds, 
				            getDay(),   getMonth(),   getYear()); 
	}
	
	public void next() {
		this.seconds ++;
		if(this.seconds > 59) {
			this.seconds = 0;
			this.minutes ++;
			if(this.minutes > 59) {
				this.minutes = 0;
				this.hours ++;
				if(this.hours > 23) {
					this.hours = 0;
					super.next();
				}
			}
		}
	}
	
	public Date toDate() { 
		return new Date(getDay(),   getMonth(),   getYear());
//		return super.clone();
	}

	@Override
//	Este método cancela todas las llamadas internas y externas a m()
//	que se producen desde un objeto de tipo DateTime, tomando su lugar
	public void m() {
		System.out.println("m() de DateTime");
	}
	
}
