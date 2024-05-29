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

import Lógica.Movimiento;

public class Visual extends JFrame {
	private Movimiento movimiento;
	private JPanel pElementos;
	private PCuadricula pCuadricula;
	private JButton bNuevoJuego;
	private JLabel lMejor_puntaje;
	private JLabel lPuntos;
	private PCuadricula2 pCuadricula2;

	public Visual() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700, 700);
		this.setTitle("Snake");
		this.setLayout(new BorderLayout());

		// Panel de elementos
		this.bNuevoJuego = new JButton("Nuevo Juego");
		this.lMejor_puntaje = new JLabel("Mejor puntaje: 0");
		this.lPuntos = new JLabel("Puntos: 0");
		this.pElementos = new JPanel();
		this.pElementos.setLayout(new GridLayout(1, 3, 10, 10));
		this.pElementos.add(this.bNuevoJuego);
		this.pElementos.add(this.lMejor_puntaje);
		this.pElementos.add(this.lPuntos);
		this.bNuevoJuego.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nuevoJuego();
			}
		});

		this.add(this.pElementos, BorderLayout.NORTH);

		// Panel de la cuadricula del juego
		this.pCuadricula2 = new PCuadricula2(500, 16);
		this.pCuadricula = new PCuadricula(500, 16);

		// Panel de fondo
		JPanel fondoPanel = new JPanel(null); // Usar null layout para posicionar los paneles manualmente
		fondoPanel.add(this.pCuadricula2);
		fondoPanel.add(this.pCuadricula);

		this.pCuadricula2.setBounds(10, 10, 600, 600);
		this.pCuadricula2.setOpaque(false);
		this.pCuadricula.setBounds(10, 10, 600, 600);

		this.add(fondoPanel, BorderLayout.CENTER);

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
		this.pCuadricula.setFocusable(true);
		this.pCuadricula.requestFocusInWindow();
	}

	protected void teclaOprimida(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	protected void nuevoJuego() {
		this.movimiento = new Movimiento();
		//this.pCuadricula.setJ2048(this.movimiento);
		this.pCuadricula.repaint();
		this.pCuadricula.setFocusable(true);
		this.pCuadricula.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new Visual();
	}
}
