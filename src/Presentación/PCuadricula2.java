package Presentación;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class PCuadricula2 extends JPanel{
	Color cSnake = Color.green;
	Color cManzana = Color.red;
	List<int[]>Snake = new ArrayList<int[]>();
	int[]comida;
	int tam_max,tam,cant,res;

	public PCuadricula2(int tam_max, int cant) {
		this.tam_max = tam_max;
		this.cant = cant;
		this.tam = tam_max/cant;
		this.res = tam_max%cant;
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
	}
}
