package uniandes.dpoo.taller7.interfaz4.stats;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import static uniandes.dpoo.taller7.interfaz4.LightsOut.BASECOL;

public class Stats extends JPanel {
	
	JLabel userName = new JLabel("");
	JLabel step = new JLabel("0");
	
	public Stats() {
		setBackground(BASECOL);
		setBorder(new EmptyBorder(0, 7, 0, 7));
		setLayout(new GridLayout(1, 0, 10, 0));
		
		add(new JLabel("Jugadas"));
		add(step);
		add(new JLabel("Jugador:"));
		add(userName);
	}
	
	public void setUserName(String name) {
		userName.setText(name);
	}
	
	public void setStep(int step) {
		this.step.setText("" + step);
	}
}
