package uniandes.dpoo.taller7.interfaz3.stats;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Stats extends JPanel {
	
	JLabel userName = new JLabel("");
	JLabel step = new JLabel("0");
	
	public Stats() {
		//setBackground(BASECOL);
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
