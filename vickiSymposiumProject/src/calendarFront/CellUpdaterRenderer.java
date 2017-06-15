package calendarFront;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import calendarBack.AnEvent;

public class CellUpdaterRenderer extends DefaultTableCellRenderer {
	private Component cellComponent;
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean 
			hasFocus, int row, int column) {
		cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (isSelected && value != null) {
			((JLabel) cellComponent).setHorizontalAlignment(JLabel.LEFT);
			((JLabel) cellComponent).setVerticalAlignment(JLabel.TOP);
			String original = value.toString();
			((JLabel) cellComponent).setText(original + "\n" + AnEvent.eventName());
			return cellComponent;
		}
		return null;
	}
}
