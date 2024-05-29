package Presentación;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Lógica.Movimiento;

public class PCuadricula2 extends JPanel{
	Color cSnake = Color.green;
	Color cManzana = Color.red;
	private Movimiento movimiento;
	List<int[]>Snake = new ArrayList<int[]>();
	int[]comida;
	int tam_max,tam,cant,res;

	public PCuadricula2(int tam_max, int cant, Movimiento movimiento) {
		this.tam_max = tam_max;
		this.cant = cant;
		this.tam = tam_max/cant;
		this.res = tam_max%cant;
		this.movimiento = movimiento;
		int a[] = {cant/2-1, cant/2-1};
		int b[] = {cant/2,cant/2-1};
		Snake.add(a);
		Snake.add(b);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(cSnake);
		for(int[] i : Snake) {
			g.fillRect(res/2+i[0]*tam, res/2+i[1]*tam, tam-1, tam-1);	
		}
		g.setColor(cManzana);
        int[] comida = movimiento.getComida();
        g.fillRect(res / 2 + comida[0] * tam, res / 2 + comida[1] * tam, tam - 1, tam - 1);
	}
	
	public void actualizar() throws Exception {
        movimiento.mover();
        repaint();
    }
}

