package calendarFront;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WelcomeScreen extends JFrame {

	private static int width;
	private static int height;
	private static JFrame introScreen;
	private static JTextField enter;
	private static JButton save;
	private static String name;
	private static Dimension screenSize;
	
	public static void main(String[] args) {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		introScreen = new JFrame();
		introScreen.getContentPane().setLayout(null);
		enter = new JTextField("Enter your name.");
		save = new JButton("SAVE");
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = enter.getText();
				save.setVisible(false);
				enter.setVisible(false);
				CalendarScreen.main(args);
				introScreen.dispose();
			}
			
		});
		
		// SIZING
		introScreen.setSize(width, height);
		save.setBounds(width/2+50, height/2 - 30, 100, 30);
		enter.setBounds(width/2 - 150, height/2 - 30, 200, 30);
		
		// VISIBILITY
		introScreen.add(save);
		introScreen.add(enter);
		introScreen.setVisible(true);
	}
	
	public static String retName() {
		return name;
	}
}
