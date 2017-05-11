package main;

import calendarFront.WelcomeScreen;
import gui6.GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.*;

public class VickiSymposium {
	
	private static String name;
	private static JFrame introScreen;
	private static JTextField enter;
	private static JButton save;
	private static JPanel calendar;
	private static JLabel year;

	public VickiSymposium() {
		
	}
	
	public static void main(String[] args) {
		createIntroScreen();
	}
	
	public static void createIntroScreen() {
		introScreen = new JFrame();
		enter = new JTextField("Enter your name.");
		save = new JButton("SAVE");

		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = enter.getText();
				switchToCalScreen();
			}
			
		});
		introScreen.getContentPane().setLayout(null);
		//screen.getContentPane().setBackground(Color.BLACK);
		
		// SIZING
		introScreen.setSize(1200, 1000);
		save.setBounds(600, 535, 100, 30);
		enter.setBounds(550, 500, 200, 30);
		
		// VISIBILITY
		introScreen.add(save);
		introScreen.add(enter);
		introScreen.setVisible(true);
	}
	
	public static void switchToCalScreen() {
		calendar = new JPanel();
		
		year = new JLabel("LAAAAAAAAAA");
		introScreen.getContentPane().add(year);
		
		save.setVisible(false);
		enter.setVisible(false);
		
		//introScreen.add(calendar);
	}

}
