package uniandes.dpoo.taller7.interfaz3.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;

import javax.swing.JPanel;

import uniandes.dpoo.taller7.interfaz3.LightsOut;

public class Game extends JPanel implements MouseListener, MouseMotionListener {
	private int e80;

	private int square;
	private int space = 2;
	private int mx = -100;
	private int my = -100;
	private boolean pause = false;
	
	private LightsOut parent;
	
	public Game(LightsOut parent, int size) {
		this.parent = parent;
		this.square = size;
		
		setBorder(null);
		setPreferredSize(new Dimension(500, 500));
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public Game(LightsOut parent) {
		this(parent, 1);
	}
	
	private int[] getCellByCoord(int cX, int cY) {
		for (int i = 0; i < square; i++) {
			for (int j = 0; j < square; j++) {
				if (space + i * e80 <= cX && cX < space + i * e80 + e80 - 2 * space) {
					if (space + j * e80 <= cY && cY < space + j * e80 + e80 - 2 * space) {
						return new int[] { i, j };
					}
				}
			}
		}
		return new int[] { -1, -1 };
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int[] cellClicked = getCellByCoord(x,y);
		if (!Arrays.equals(cellClicked, new int[] {-1, -1})) {
			parent.play(cellClicked);
		}
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics gB) {
		Graphics2D g = (Graphics2D) gB;
		g.fillRect(0, 0, getSize().width, getSize().height);

		e80 = Math.min(getSize().width, getSize().height) / square;
		for (int i = 0; i < square && !pause; i++) {
			for (int j = 0; j < square; j++) {
				g.setColor(Color.DARK_GRAY);
				if (parent.isOn(i, j))
					g.setColor(Color.yellow);
				if (space + i * e80 <= mx && mx < space + i * e80 + e80 - 2 * space) {
					if (space + j * e80 <= my && my < space + j * e80 + e80 - 2 * space) {
						g.setColor(Color.white);
					}
				}
				g.fillRect(space + i * e80, space + j * e80, e80 - 2 * space, e80 - 2 * space);
			}
		}
	}
	
	/** Hovering effect*/
	@Override
	public void mouseMoved(MouseEvent e) {
		this.mx = e.getX();
		this.my = e.getY();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}
	
	public int getSquare() {return square;}

	public void setSquare(int value) {square = value;}

}
