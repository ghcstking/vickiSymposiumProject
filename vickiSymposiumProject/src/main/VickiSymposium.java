package main;

import calendarFront.WelcomeScreen;
import gui6.GUIApplication;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.*;

public class VickiSymposium {
	
	private static VickiSymposium cal;
	//private static WelcomeScreen mainScreen;

	public VickiSymposium() {
		
	}
	
	public static void main(String[] args) {
		JFrame screen = new JFrame();
		JTextField enter = new JTextField();
		
		screen.setSize(1200, 1000);
		enter.setBounds(0, 100, 10, 20);
		
		screen.add(enter);
		screen.setVisible(true);
	}

	public void initScreen() {
		//mainScreen = new WelcomeScreen(getWidth(), getHeight());
		//setScreen(mainScreen);
	}

}
