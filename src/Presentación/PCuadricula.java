package Presentación;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class PCuadricula extends JPanel{
	Color cFondo = Color.LIGHT_GRAY;
	int tam_max,tam,cant,res;

	public PCuadricula(int tam_max, int cant) {
		this.tam_max = tam_max;
		this.cant = cant;
		this.tam = tam_max/cant;
		this.res = tam_max%cant;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(cFondo);
		for(int i = 0; i<cant; i++) {
			for(int j = 0; j<cant; j++) {
				g.fillRect(res/2+i*tam, res/2+j*tam, tam-1, tam-1);
			}
		}
	}
}
