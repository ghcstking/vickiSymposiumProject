package calendarBack;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JLabel implements TableCellRenderer {
	
	private JButton button;
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (value != null) {
			button = new JButton(value + "");
			button.setFont(new Font("Helvetica", Font.BOLD, 20));
			button.setVerticalAlignment(SwingConstants.TOP);
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("EE");
				}
			});
			return button; 	
		}
		return null;
	}

}
