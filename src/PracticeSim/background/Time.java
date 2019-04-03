package PracticeSim.background;

import java.awt.Color;
import java.awt.Graphics;

public class Time {
	private int sec;
	private int Tenthsec;
	private int min;
	private int tenthmin;
	private int hour2;
	public Time() {
	//	this.hour = 0;
		this.min = 0;
		this.Tenthsec = 0;
		this.tenthmin = 5;
		this.hour2 =00;
	}
	public void addMin(int sec) {
		sec += sec;
		if(sec % 10 == 0) {
			Tenthsec += 1;
			sec=0;
		}
		if(Tenthsec % 6 == 0) {
			min++;
			Tenthsec = 0;
		}
		if(min % 10 == 0) {
			min=0;
			tenthmin++;
			
			if(tenthmin%6 ==0) {
				tenthmin =0;
				hour2++;
				
			}
		}
		
	}
	public String getTimer() {
		String format = String.format("%02d", hour2);
		String time = "Time: " + format + ":"+tenthmin+min;
		return time;
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString(getTimer(), 10, 25);
		
	}
	public int getHour() {
		return hour2;
	}
	public int getMin() {
		return min;
	}
	public int getTenth() {
		return tenthmin;
	}
	public int getSec() {
		return sec;
	}
	 
	
}
