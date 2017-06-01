package calendarBack;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class AnEvent {
	
	private static JPanel panel;
	private static JOptionPane popup;
	private static JLabel sTime;
	private static JLabel eTime;
	private static JTextField eventName;
	private static JSpinner.DateEditor time;
	private static JSpinner startTime;
	private static JSpinner endTime;
	
	public static void main(String[] args) {
		panel = new JPanel(new GridLayout(0, 1));
		sTime = new JLabel("Event starts at: ");
		eTime = new JLabel("Event ends at: ");
		startTime = new JSpinner(new SpinnerDateModel());
		time = new JSpinner.DateEditor(startTime, "HH:mm:ss");
		startTime.setEditor(time);
		
		panel.add(sTime);
		panel.add(eTime);
		panel.add(startTime);
		panel.add(endTime);
		panel.setVisible(true);
	}
}
