package calendarBack;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import calendarFront.CalendarScreen;

public class CellRenderer extends DefaultTableCellRenderer {
	
	 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        if (column == 0 || column == 6){
	        	cellComponent.setBackground(new Color(173, 190, 219));
	    	}
	        if (value != null) {
	        	if (Integer.parseInt(value.toString()) == CalendarScreen.returnDay() && 
	        			CalendarScreen.returnCurrentMonth() == CalendarScreen.returnMonth() && 
	        			CalendarScreen.returnCurrentYear() == CalendarScreen.returnYear()) {
	        		cellComponent.setBackground(new Color(219, 187, 173));
	        	}
	        }
	        return cellComponent;
	    }
}
