package main;

import calendarFront.WelcomeScreen;
import gui6.GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.*;

public class VickiSymposium {
	
	private static String name;
	private static JFrame introScreen;
	private static JTable cal;
	private static DefaultTableModel model;
	private static JTextField enter;
	private static JButton save;
	private static JPanel calendar;
	private static JLabel mth;
	private static JLabel yr;
	private static JLabel prev;
	private static JLabel next;
	private static JComboBox years;
	private static int thisYear;
	private static int thisMonth;
	private static int thisDay;
	private static GregorianCalendar greg;
	private static String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private static String[] months = {"January", "February", "March", "April", "May", 
			"June", "July", "August", "September", "October", "November", "December"};

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
				introScreen.repaint();
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
		calendar.setLayout(null);
		calendar.setSize(1200, 1000);
		
		model = new DefaultTableModel(6, 7);
		for (int i = 0; i < weekdays.length; i++) {
			model.addColumn(weekdays[i]);
		}
//		for (int i = thisYear-10; i < thisYear+10; i++) {
//			years.addItem(String.valueOf(i));
//		}
		cal = new JTable(model);
		//years.setBounds(200, 200, 200, 200);
		calendar.add(cal);
		//calendar.add(years);
		
		mth = new JLabel("JANUARY");
		yr = new JLabel("2017");
		mth.setFont(new Font("Helvetica", Font.ITALIC, 20));
		yr.setFont(new Font("Helvetica", Font.BOLD, 50));
		mth.setBounds(300, 300, 100, 100);
		yr.setBounds(590, 25, 200, 40);
		
		prev = new JLabel();
		next = new JLabel();
		prev.setIcon(new ImageIcon("resources/left.png"));
		prev.setBounds(100, 25, 50, 50);
		next.setIcon(new ImageIcon("resources/right.png"));
		next.setBounds(1100, 25, 50, 50);
		
		calendar.add(prev);
		calendar.add(next);
		calendar.add(yr);
		//calendar.add(mth);
		introScreen.add(calendar);
		
		save.setVisible(false);
		enter.setVisible(false);	
	}
	
	public static void info() {
		thisMonth = greg.get(GregorianCalendar.MONTH);
		thisYear = greg.get(GregorianCalendar.YEAR);
		thisDay = greg.get(GregorianCalendar.DAY_OF_MONTH);
	}
	
	public static void drawCal(int month, int yr) {
	}
}
