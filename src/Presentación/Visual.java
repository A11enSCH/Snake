package Presentación;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Lógica.Juego;

public class Visual extends JFrame{
	private Juego juego;
	private JPanel pElementos;
	private JButton bNjuego;
	private JLabel lPuntaje;
	private JLabel lBscore;
	private Cuadricula pCuadricula;
	
	public Visual() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700, 500);
		this.setTitle("Snake");
		this.setLayout(new BorderLayout());
		this.bNjuego = new JButton("Nuevo juego");
		this.lPuntaje = new JLabel("Score: ");
		this.lBscore = new JLabel("Best score: ");
		this.pElementos = new JPanel();
		this.pElementos.setLayout(new GridLayout(1, 3, 10, 10));
		this.pElementos.add(bNjuego);
		this.pElementos.add(lPuntaje);
		this.pElementos.add(lBscore);
		this.bNjuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		
		this.pCuadricula = new Cuadricula();
		this.add(this.pElementos, BorderLayout.NORTH);
		this.add(this.pCuadricula, BorderLayout.CENTER);
		this.pCuadricula.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				teclaOprimida(e);
			}
		});
		this.setVisible(true);
	}
	
	protected void teclaOprimida(KeyEvent e) {
		this.juego.hacerJugada(e.getKeyCode());
		this.lPuntaje.setText("Score: " + this.juego.getPuntaje());
		this.lBscore.setText("Best score: " + this.juego.getBscore());
		this.pCuadricula.repaint();
	}

	protected void newGame() {
		this.juego = new Juego();
		this.pCuadricula.setJuego(juego);
		this.pCuadricula.repaint();
		this.pCuadricula.setFocusable(true);
		this.pCuadricula.requestFocusInWindow();		
	}
	
	public static void main(String[] args) {
		new Visual();
	}
}
