package uniandes.dpoo.taller7.interfaz2;

import static uniandes.dpoo.taller7.interfaz2.menu.Menu.KEYS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniandes.dpoo.taller7.interfaz2.menu.Menu;
import uniandes.dpoo.taller7.interfaz2.sizeDifficulty.SizeDifficulty;
import uniandes.dpoo.taller7.interfaz2.stats.Stats;

public class LightsOut extends JFrame implements ActionListener {
	public static final Color BASECOL = new Color(0, 102, 255);
	
	private String playerName;
	private JPanel contentPane = new JPanel();
	private Menu buttons;
	private SizeDifficulty header;
	private Stats footer;
	
	LightsOut() {
		super("Light Out");
		//setBackground(BASECOL);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		header = new SizeDifficulty();
		contentPane.add(header, BorderLayout.NORTH);
		
		buttons = new Menu(this);
		contentPane.add(buttons, BorderLayout.EAST);
		
		footer = new Stats();
		contentPane.add(footer, BorderLayout.SOUTH);
		
		JPanel game = new JPanel();
		contentPane.add(game, BorderLayout.CENTER);
		
		setSize(500, 500);
		
	}
	
	
	
	
	
	
	
	
	private void newGame() {
		// TODO Auto-generated method stub
		
	}
	
	private void restart() {
		// TODO Auto-generated method stub
		
	}
	
	private void top10() {
		// TODO Auto-generated method stub
		
	}

	private void changePlayer() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (KEYS[0].equals(action)) {
			newGame();
		} else if (KEYS[1].equals(action)) {
			restart();
		} else if (KEYS[2].equals(action)) {
			top10();
		} else if (KEYS[3].equals(action)) {
			changePlayer();
		}
	}

	public static void main(String[] args) {
		LightsOut frame = new LightsOut();
		frame.setVisible(true);
	}
	
	public String getUser() {return playerName;}
}
