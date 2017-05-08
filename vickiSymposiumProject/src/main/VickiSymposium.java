package main;

import gui6.GUIApplication;

public class VickiSymposium extends GUIApplication {
	
	public static VickiSymposium game;

	public VickiSymposium(int width, int height) {
		super(width, height);
	}
	
	public static void main(String[] args) {
		game = new VickiSymposium(1400, 1000);
		Thread app = new Thread(game);
		app.start();
	}

	public void initScreen() {
//		mainScreen = new CalendarView(getWidth(), getHeight());
//		setScreen(mainScreen);
	}

}
