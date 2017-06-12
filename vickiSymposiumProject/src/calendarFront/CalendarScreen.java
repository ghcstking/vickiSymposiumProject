package calendarFront;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import calendarBack.AnEvent;
import calendarBack.CellRenderer;
import calendarFront.WelcomeScreen;
 
public class CalendarScreen extends JFrame {
 
	private static JFrame frame;
	private static int width;
	private static int height;
	private static JScrollPane scroll;
	private static JTable cal;
	private static DefaultTableModel model;
	private static CellRenderer colorize;
	private static CellUpdaterRenderer update;
	private static JTextField enter;
	private static JButton save;
	private static JLabel mth;
	private static JLabel welcome;
	private static JLabel prev;
	private static JLabel next;
	private static JComboBox years;
	private static int currentMonth;
	private static int currentYear;
	private static int thisYear;
	private static int thisMonth;
	private static int thisDay;
	private static int numDays;
	private static int startDay;
	private static int row;
	private static int column;
	private static boolean backDisabled;
	private static boolean nextDisabled;
	private static GregorianCalendar greg;
	private static GregorianCalendar greg2;
	private static String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private static String[] months = {"JANUARY", "FEBRUARY", " MARCH ", "APRIL ", "MAY", 
			"JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	public static ArrayList<EventItem> item;
	
	public static void main(String[] args) {
		//SCREEN
		item = new ArrayList<EventItem>();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(width, height);
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		
		//RENDERERS + EDITORS
		colorize = new CellRenderer();
		
		//CALENDAR
		model = new DefaultTableModel(weekdays, 6) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		cal = new JTable(model);
		scroll = new JScrollPane(cal);
		cal.setRowHeight(100);
		model.setRowCount(6);
		cal.getTableHeader().setFont(new Font("Helvetica", Font.BOLD, 30));
		cal.setFont(new Font("Helvetica", Font.BOLD, 20));
		cal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && 
						cal.getModel().getValueAt(cal.getSelectedRow(), cal.getSelectedColumn()) != null) {
					AnEvent.getRowCol(cal.getSelectedRow(), cal.getSelectedColumn());
					AnEvent.main(args);
				}
			}
		});
				
		//JSTUFF
		mth = new JLabel ("January");
		save = new JButton("Save event");
		enter = new JTextField("Enter your event");
		welcome = new JLabel ("Welcome " + WelcomeScreen.retName());
		years = new JComboBox();
		prev = new JLabel();
		next = new JLabel();
		save.setBounds(width/2 -50, height-100, 100, 30);
		enter.setBounds((width/2)-100, height-150, 200, 30);
		years.setBounds(width - 300, 35, 200, 30);
		mth.setFont(new Font("Helvetica", Font.BOLD, 40));
		welcome.setFont(new Font("Helvetica", Font.BOLD + Font.ITALIC, 50));
		mth.setBounds(width/2 - mth.getPreferredSize().width/2, 100, 250, 100);
		welcome.setBounds(25, 25, welcome.getPreferredSize().width, 40);
		prev.setIcon(new ImageIcon("resources/left.png"));
		prev.setBounds(100, 120, 50, 50);
		next.setIcon(new ImageIcon("resources/right.png"));
		next.setBounds(1100, 120, 50, 50);
		scroll.setBounds(1, 200, width, height);
		addActions();
		
		//GET INFO
		greg = new GregorianCalendar();
		thisDay = greg.get(GregorianCalendar.DATE);
		thisMonth = greg.get(GregorianCalendar.MONTH);
		thisYear = greg.get(GregorianCalendar.YEAR);
		currentMonth = thisMonth;
		currentYear = thisYear;
	
		//COMBOBOX
		for (int i=thisYear - 10; i <= thisYear + 10; i++){
			years.addItem(String.valueOf(i));
		}
		
		//SELECT
		cal.setColumnSelectionAllowed(true);
		cal.setRowSelectionAllowed(true);
		cal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//VISIBILITY
		frame.add(mth);
		frame.add(welcome);
		frame.add(years);
		frame.add(prev);
		frame.add(next);
		frame.add(save);
		frame.add(enter);
		frame.add(scroll);
		frame.setVisible(true);
		
		reDraw(thisMonth, thisYear);
	}
	
	public static void updateCal(int r, int c) {
		JLabel newLabel = new JLabel();
		String original = cal.getModel().getValueAt(r, c).toString();
		String separator = "\n";
//		newLabel.setText("<html><p>" + original + "AAA" + "</p></html>");
//		model.setValueAt(newLabel, r, c);
		//cal.setDefaultRenderer(cal.getColumnClass(0), update);
		cal.setDefaultRenderer(cal.getColumnClass(0), renderer);
	}
	
	public static void addActions() {
		prev.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (backDisabled) {
					return;
				}
				if (currentMonth == 0) {
					currentMonth = 11;
					currentYear -= 1;
				}
				else {
					currentMonth -= 1;
				}
				reDraw(currentMonth, currentYear);
			}
		});
		next.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(nextDisabled) {
					return;
				}
				if (currentMonth == 11) {
					currentMonth = 0;
					currentYear += 1;
				}
				else {
					currentMonth += 1;
				}
				reDraw(currentMonth, currentYear);
			}
		});
		years.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (years.getSelectedItem() != null) {
					currentYear = Integer.parseInt(years.getSelectedItem().toString());
				}
				reDraw(currentMonth, currentYear);
			}
		});
	}
	
	public static void reDraw(int month, int yr) {
		//UPDATE
		mth.setText(months[month]);
		years.setSelectedItem(String.valueOf(yr));
		
		//EMPTY OUT TABLE
		for (int i=0; i<6; i++){
			for (int j=0; j<7; j++){
				model.setValueAt(null, i, j);
			}
		}
		
		//DISABLE MOUSELISTENERS IF OUT OF RANGE
		if(month == 0 && yr <= thisYear - 10) {
			backDisabled = true;
		}
		else {
			backDisabled = false;
		}
		if(month == 11 && yr >= thisYear + 10) {
			nextDisabled = true;
		}
		else {
			nextDisabled = false;
		}
		
		//REDRAW
		greg2 = new GregorianCalendar(yr, month, 1);
		numDays = greg2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startDay = greg2.get(GregorianCalendar.DAY_OF_WEEK);
		for (int i=1; i<=numDays; i++){
			row = new Integer((i+startDay-2)/7);
			column = (i+startDay-2)%7;
			model.setValueAt(i, row, column);
		}
		//COLOR WEEKEND + CURRENT DAY
		cal.setDefaultRenderer(cal.getColumnClass(0), colorize);
	}
	
	public static int returnDay() {
		return thisDay;
	}
	public static int returnMonth() {
		return thisMonth;
	}
	public static int returnYear() {
		return thisYear;
	}
	public static int returnCurrentMonth() {
		return currentMonth;
	}
	public static int returnCurrentYear() {
		return currentYear;
	}
	public static ArrayList<Integer> values() {
		return null;
	}
}