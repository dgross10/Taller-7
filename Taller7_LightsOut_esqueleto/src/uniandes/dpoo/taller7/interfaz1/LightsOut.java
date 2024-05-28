package uniandes.dpoo.taller7.interfaz1;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LightsOut extends JFrame {	
	public static final Color BASECOL = new Color(0, 102, 255);
	
	private JPanel contentPane = new JPanel();
	
	LightsOut() {
		super("Light Out");
		setBackground(BASECOL);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 0, 5, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setSize(500, 500);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		LightsOut frame = new LightsOut();
		frame.setVisible(true);
	}
}
