package com.p3.java.mouse;

import java.awt.Robot;

public class KeyPress {
	
	 
	 public static final int SLEEP_SECONDS = 15000;

	    public static void main(String args[]) throws Exception {
	        Robot robot = new Robot();
	        
	        while (true) {
	        	
	        	robot.keyPress(45);				//make a key in keyboard press using each key keycode
	     
	     		Thread.sleep(SLEEP_SECONDS);
	        }
	    }
	
	

}


