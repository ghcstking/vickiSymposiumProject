package calendarBack;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CalDraw extends DefaultTableCellRenderer {
	private static int day;
	private static int month;
	private static int yr;
	public CalDraw(int day, int month, int yr) {
		this.day = day;
		this.month = month;
		this.yr = yr;
	}
	public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
		super.getTableCellRendererComponent(table, value, selected, focused, row, column);
		if (column == 0 || column == 6){ //Week-end
			setBackground(new Color(255, 220, 220));
		}
		else{ //Week
			setBackground(new Color(255, 255, 255));
		}
		if (value != null){
			if (Integer.parseInt(value.toString()) == day){ //Today
				setBackground(new Color(220, 220, 255));
			}
		}
		setBorder(null);
		setForeground(Color.black);
		return this;  
	}
}
