package calendarBack;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import calendarFront.CalendarScreen;
import calendarFront.EventItem;

public class AnEvent {
	
	private static JFrame panel;
	private static JLabel sTime;
	private static JLabel eTime;
	private static JLabel eName;
	private static JTextField eventName;
	private static JSpinner.DateEditor sEditor;
	private static JSpinner startTime;
	private static JSpinner endTime;
	private static int date;
	private static JSpinner.DateEditor eEditor;
	private static int width;
	private static int height;
	private static Calendar cal;
	private static Date val;
	private static JButton submit;
	private static int row;
	private static int col;
	

	public AnEvent(int valueAt) {
		this.date = valueAt;
	}

	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		
		panel = new JFrame("Schedule your event");
		panel.setLayout(null);
		panel.setBounds(width/3, height/10, 500, 500);
		
		cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		val = cal.getTime();
		
		submit = new JButton("Save");
		submit.setBounds(width/7, height/3 + 50, 100, 20);
		submit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				EventItem newE = new EventItem();
				newE.setName(eventName.getText());
				newE.setStartTime((Date)startTime.getValue());
				newE.setEndTime((Date)endTime.getValue());
				CalendarScreen.item.add(newE);
				row = CalendarScreen.retRow();
				col = CalendarScreen.retCol();
//				CalendarScreen.updateCal();
				panel.dispose();
			}
		});
		
		eventName = new JTextField();
		eName = new JLabel("Event name: ");
		sTime = new JLabel("Event starts at: ");
		eTime = new JLabel("Event ends at: ");
		
		startTime = new JSpinner(new SpinnerDateModel());
		endTime = new JSpinner(new SpinnerDateModel());
		sEditor = new JSpinner.DateEditor(startTime, "HH:mm");
		eEditor = new JSpinner.DateEditor(endTime, "HH:mm");
		
		startTime.setValue(val);
		endTime.setValue(val);
		
		sTime.setBounds(width/100, height/20, 150, 50);
		eTime.setBounds(width/100, height/20 + 50, 150, 50);
		eName.setBounds(width/100, height/20 - 50, 200, 50);
		
		startTime.setEditor(sEditor);
		endTime.setEditor(eEditor);
		
		startTime.setBounds(width/10, height/15, 150, 20);
		endTime.setBounds(width/10, height/15 + 50, 150, 20);
		eventName.setBounds(width/10, height/15 - 50, 200, 20);
		
		panel.add(eName);
		panel.add(sTime);
		panel.add(eTime);
		panel.add(startTime);
		panel.add(endTime);
		panel.add(eventName);
		panel.add(submit);
		panel.setVisible(true);
	}
	
	public static String eventName() {
		return eventName.getText();
	}
	
	public static Date saveStart() {
		return (Date) startTime.getValue();
	}
	
	public static Date saveEnd() {
		return (Date) endTime.getValue();
	}
	
	public static int row() {
		return row;
	}
	
	public static int col() {
		return col;
	}
}
