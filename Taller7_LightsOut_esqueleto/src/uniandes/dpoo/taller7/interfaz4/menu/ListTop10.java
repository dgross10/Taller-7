package uniandes.dpoo.taller7.interfaz4.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class ListTop10 extends JDialog {

	public ListTop10(RegistroTop10[] array) {
		setBackground(Color.white);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.white);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JList<RegistroTop10> list = new JList<RegistroTop10>();
		list.setBackground(Color.LIGHT_GRAY);
		list.setListData(array);
		list.setCellRenderer(new ModelRender(array));
		scrollPane.setViewportView(list);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private static class ModelRender extends DefaultListCellRenderer {
		RegistroTop10[] registroTop10s;
		
		ModelRender(RegistroTop10[] array){
			registroTop10s = array;
		}
		
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			if (value instanceof RegistroTop10) {
				RegistroTop10 nextTop = (RegistroTop10) value;
				for (int i = 0; i < registroTop10s.length; i++) {
					if (registroTop10s[i].equals(nextTop)) {
						setText(String.format("%3d) %5s ==> %04d", i + 1, nextTop.darNombre(), nextTop.darPuntos()));
						if (i == 0) {
							setForeground(new Color(255, 215, 0));
							setBackground(Color.BLACK);
						} else if (i == 1) {
							setForeground(new Color(192, 192, 192));
							setBackground(Color.BLACK);
						} else if (i == 2) {
							setForeground(new Color(176, 141, 87));
							setBackground(Color.BLACK);
						} else if (i == 3 || i == 4) {
							setForeground(Color.WHITE);
							setBackground(Color.DARK_GRAY);
						} else {
							setForeground(Color.BLACK);
							setBackground(Color.GRAY);
						}
					}
				}
			}
			return c;
		}
	}
}