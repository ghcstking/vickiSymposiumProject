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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.*;

public class VickiSymposium {
	
	private static String name;

	public VickiSymposium() {
		
	}
	
	public static void main(String[] args) {
		createScreen();
	}
	
	public static void createScreen() {
		JFrame screen = new JFrame();
		JTextField enter = new JTextField("Enter your name.");
		JButton save = new JButton("SAVE");
		
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = enter.getText();
				System.out.println(name);
			}
			
		});
		
		screen.getContentPane().setLayout(null);
		//screen.getContentPane().setBackground(Color.BLACK);
		
		// SIZING
		screen.setSize(1200, 1000);
		save.setBounds(600, 535, 100, 30);
		enter.setBounds(550, 500, 200, 30);
		
		// VISIBILITY
		screen.add(save);
		screen.add(enter);
		screen.setVisible(true);
	}

}
