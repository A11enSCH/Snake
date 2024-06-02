package Presentación;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PCuadricula2 extends JPanel {
	Color cSnake = Color.green;
	Color cManzana = Color.red;
	public List<int[]> Snake = new ArrayList<int[]>();
	int[] comida;
	int tam_max, tam, cant, res;
	public String movimiento = "ARR";
	public boolean juegoActivo = true;
	private int puntos = 0;
	private int bpuntos = 0;

	public PCuadricula2(int tam_max, int cant) {
		this.tam_max = tam_max;
		this.cant = cant;
		this.tam = tam_max / cant;
		this.res = tam_max % cant;
		int a[] = {cant / 2 - 1, cant / 2 - 1};
		int b[] = {cant / 2, cant / 2 - 1};
		Snake.add(a);
		Snake.add(b);

		generarComida();

		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					teclaOprimida(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void generarComida() {
		comida = new int[]{(int) (Math.random() * cant), (int) (Math.random() * cant)};
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(cSnake);
		for (int[] i : Snake) {
			g.fillRect(res / 2 + i[0] * tam, res / 2 + i[1] * tam, tam - 1, tam - 1);
		}
		g.setColor(cManzana);
		g.fillRect(res / 2 + comida[0] * tam, res / 2 + comida[1] * tam, tam - 1, tam - 1);
	}

	public void actualizar() throws Exception {
		if (juegoActivo) {
			moverSerpiente();
			repaint();
		}
	}

	private void moverSerpiente() {
		int[] cabeza = Snake.get(0).clone();
		if (movimiento.equals("ARR")) {
			cabeza[1]--;
		} else if (movimiento.equals("ABA")) {
			cabeza[1]++;
		} else if (movimiento.equals("IZQ")) {
			cabeza[0]--;
		} else if (movimiento.equals("DER")) {
			cabeza[0]++;
		}
		Snake.add(0, cabeza);
		if (cabeza[0] == comida[0] && cabeza[1] == comida[1]) {
			generarComida();
			puntos ++;
		} else {
			Snake.remove(Snake.size() - 1);
		}
		perder(cabeza);
	}

	private boolean chocaCuerpo(int[] cabeza) {
		for (int i = 1; i < Snake.size(); i++) {
			if (Snake.get(i)[0] == cabeza[0] && Snake.get(i)[1] == cabeza[1]) {
				return true;
			}
		}
		return false;
	}

	public void perder(int[] cabeza) {
		if (cabeza[0] < 0 || cabeza[0] >= cant || cabeza[1] < 0 || cabeza[1] >= cant || chocaCuerpo(cabeza)) {
			juegoActivo = false;
			if(puntos > bpuntos) {
				bpuntos = puntos;
			}
			JOptionPane.showMessageDialog(this, "Perdiste");
		}
	}

	private void teclaOprimida(KeyEvent e) throws Exception {
		if (!juegoActivo) {
			return;
		}
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT && !movimiento.equals("DER")) {
			movimiento = "IZQ";
		} else if (keyCode == KeyEvent.VK_UP && !movimiento.equals("ABA")) {
			movimiento = "ARR";
		} else if (keyCode == KeyEvent.VK_RIGHT && !movimiento.equals("IZQ")) {
			movimiento = "DER";
		} else if (keyCode == KeyEvent.VK_DOWN && !movimiento.equals("ARR")) {
			movimiento = "ABA";
		}
	}

	public int getPuntos() {
		return puntos;
	}

	public int getBpuntos() {
		return bpuntos;
	}
}
