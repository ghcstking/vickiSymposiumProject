package calendarBack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import calendarFront.CalendarScreen;

public class CellRenderer extends DefaultTableCellRenderer {
	private JScrollPane scroller;
	private int width;
	private Dimension screenSize;
	private Component cellComponent;
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
			boolean hasFocus, int row, int column) {
		cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		scroller = new JScrollPane(cellComponent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth()/7;
//		if (table.getMouseListeners().) {
//			System.out.println("YE");
//			JLabel newLabel = new JLabel();
//			String original = table.getModel().getValueAt(row, column).toString();
//			//newLabel.setText("<html><p>" + original + "AAA" + "</p></html>");
//			((JLabel) cellComponent).setText("<html><p>" + original + "AAA" + "</p></html>");
//		}
		((JLabel) cellComponent).setHorizontalAlignment(JLabel.LEFT);
		((JLabel) cellComponent).setVerticalAlignment(JLabel.TOP);
//		((JLabel) cellComponent).setText("<html><p style=\"width:" + width+ "px\"></p></html>");
		if (value != null && (column == 0 || column == 6)){
			cellComponent.setBackground(new Color(173, 190, 219));
		}
		else {
			cellComponent.setBackground(Color.WHITE);
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
