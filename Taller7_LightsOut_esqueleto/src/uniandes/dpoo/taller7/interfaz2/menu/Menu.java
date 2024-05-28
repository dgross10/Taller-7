package uniandes.dpoo.taller7.interfaz2.menu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.interfaz2.LightsOut;

public class Menu extends JPanel {
	public static final String[] KEYS = { "NUEVO", "REINICIAR", "TOP 10", "CAMBIAR JUGADOR" };
	
	public Menu(LightsOut parent) {
		//setBackground(BASECOL);
		
		setLayout(new GridLayout(KEYS.length, 1, 5, 20));
		for (int i = 0; i < KEYS.length; i++) {
			JButton btn = new JButton(KEYS[i]);
			btn.setBackground(Color.WHITE);
			btn.addActionListener(parent);
			add(btn);
		}
	}
}
