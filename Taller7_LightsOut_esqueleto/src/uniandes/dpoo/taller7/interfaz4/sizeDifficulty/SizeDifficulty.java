package uniandes.dpoo.taller7.interfaz4.sizeDifficulty;

import static uniandes.dpoo.taller7.interfaz4.LightsOut.BASECOL;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SizeDifficulty extends JPanel {
	private JComboBox<String> size = new JComboBox<>();
	private ButtonGroup difficulty = new ButtonGroup();
	
	
	public SizeDifficulty() {
		setBackground(BASECOL);
		add(new JLabel("Tamanio"));
		size.setModel(
				new DefaultComboBoxModel<String>(
							new String[] { "5x5", "7x7", "9x9", "11x11", "13x13", "15x15" }
					)
			);
		add(size);
		
		add(new JLabel("Dificultad"));
		String[] labels = { "Facil", "Medio", "Dificil", "Muy dificil" };
		JRadioButton btn;
		for (int i = 0; i < labels.length; i++) {
			btn = new JRadioButton(labels[i]);
			btn.setBackground(BASECOL);
			btn.setActionCommand(""+i);
			difficulty.add(btn);
			add(btn);
		}
	}
	
	public int getSelectedSize() {
		return 2 * size.getSelectedIndex() + 5;
	}
	
	public int getDifficulty() {
		int dif = Integer.parseInt(difficulty.getSelection().getActionCommand()) + 1;
		return dif * 10 << dif;
	}
}
