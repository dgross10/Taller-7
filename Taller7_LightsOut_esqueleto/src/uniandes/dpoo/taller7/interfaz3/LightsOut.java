package uniandes.dpoo.taller7.interfaz3;

import static uniandes.dpoo.taller7.interfaz3.menu.Menu.KEYS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniandes.dpoo.taller7.interfaz3.game.Game;
import uniandes.dpoo.taller7.interfaz3.menu.Menu;
import uniandes.dpoo.taller7.interfaz3.sizeDifficulty.SizeDifficulty;
import uniandes.dpoo.taller7.interfaz3.stats.Stats;
import uniandes.dpoo.taller7.interfaz4.menu.ListTop10;
import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class LightsOut extends JFrame implements ActionListener {
	public static final Color BASECOL = new Color(0, 102, 255);
	private String playerName;
	private JPanel contentPane = new JPanel();
	
	private SizeDifficulty header;
	private Game game;
	private Menu buttons;
	private Stats footer;
	
	private Tablero model;
	private Top10 top10 = new Top10();
	
	private static final File DATA = new File("data/top10.csv");
	
	LightsOut() {
		super("Light Out");
		//setBackground(BASECOL);
		top10.cargarRecords(DATA);
		
		playerName = askUser();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		header = new SizeDifficulty();
		contentPane.add(header, BorderLayout.NORTH);
		
		buttons = new Menu(this);
		contentPane.add(buttons, BorderLayout.EAST);
		
		footer = new Stats();
		footer.setUserName(playerName);
		contentPane.add(footer, BorderLayout.SOUTH);
		
		game = new Game(this);
		contentPane.add(game, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					top10.salvarRecords(DATA);
				} catch (Exception ignored) {}
			}
		});
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public String askUser() {
		String t = JOptionPane.showInputDialog(null, "Ingrese su nickname", "Lights Out Nickname",
				JOptionPane.PLAIN_MESSAGE);

		return t == null || t.isBlank() ? "Gross" : t.replaceAll("\\s", "");
	}
	
	public boolean isOn(int i, int j) {
		if (game.getSquare() == 1)
			return true;
		return model.darTablero()[i][j];
	}
	
	public void play(int[] cell) {
		if (model != null) {
			model.jugar(cell[0], cell[1]);
			footer.setStep(model.darJugadas());
			if (model.tableroIluminado()) {
				int score = model.calcularPuntaje();
				String label = "GANASTE CON " + score;
				if (top10.esTop10(score)) {
					label += "\nADEMAS PERTENECES AL TOP 10";
					top10.agregarRegistro(playerName, score);
				}
				JOptionPane.showMessageDialog(null, label);
			}
		}
	}
	
	private void newGame() {
		int square = header.getSelectedSize();
		int difficulty = header.getDifficulty();
		
		model = new Tablero(square);
		game.setSquare(square);
		
		model.desordenar(difficulty);
		game.repaint();
	}
	
	private void restart() {
		model.reiniciar();
		game.repaint();
	}
	
	private void top10() {
		new ListTop10(top10.darRegistros().toArray(new RegistroTop10[10]));
	}

	private void changePlayer() {
		footer.setStep(0);
		footer.setUserName(getUser());
		newGame();
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
