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
	private JPanel pFondo;
	private PCuadricula pCuadricula;
	private JButton bNuevoJuego;
	private JLabel lMejor_puntaje;
	private JLabel lPuntos;
	private PCuadricula2 pCuadricula2;
	
	public final static int IZQ = 37;
	public final static int ARR = 38;
	public final static int DER = 39;
	public final static int ABA = 40;
	
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
		this.movimiento = new Movimiento(500, 16);
		this.pCuadricula2 = new PCuadricula2(550, 16, movimiento);
		this.pCuadricula = new PCuadricula(550, 16);

		// Panel de fondo
		this.pFondo = new JPanel(null);
		this.pFondo.add(this.pCuadricula2);
		this.pFondo.add(this.pCuadricula);

		this.pCuadricula2.setBounds(10, 10, 600, 600);
		this.pCuadricula2.setOpaque(false);
		this.pCuadricula.setBounds(10, 10, 600, 600);
		
		this.pCuadricula2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				try {
					teclaOprimida(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		this.add(pFondo, BorderLayout.CENTER);

		this.setVisible(true);
		this.pCuadricula.setFocusable(true);
		this.pCuadricula.requestFocusInWindow();
	}

	protected void teclaOprimida(KeyEvent e) throws Exception {
		if(e.getKeyCode() == DER) {
			movimiento.cambioDireccion("Der");
		}else if(e.getKeyCode() == IZQ) {
			movimiento.cambioDireccion("Izq");
		}else if(e.getKeyCode() == ARR) {
			movimiento.cambioDireccion("Arr");
		}else if(e.getKeyCode() == ABA) {
			movimiento.cambioDireccion("aba");
		}
		movimiento.mover();
		pCuadricula2.repaint();
	}

	protected void nuevoJuego() {
		this.movimiento = new Movimiento(500, 16);
		this.pCuadricula2 = new PCuadricula2(550, 16, movimiento);
		this.pCuadricula2.setFocusable(true);
		this.pCuadricula2.requestFocusInWindow();

		// Limpiar el panel de fondo y agregar las nuevas instancias
		this.pFondo.removeAll();
		this.pFondo.add(this.pCuadricula2);
		this.pFondo.add(this.pCuadricula);

		this.pCuadricula2.setBounds(10, 10, 600, 600);
		this.pCuadricula2.setOpaque(false);
		this.pCuadricula.setBounds(10, 10, 600, 600);

		this.pFondo.revalidate();
		this.pFondo.repaint();
	}

	public static void main(String[] args) {
		new Visual();
	}
}
