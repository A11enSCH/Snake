package Presentación;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Lógica.Juego;

public class Cuadricula extends JPanel{
	private Juego juego;

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public void pCuadricula() {

	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;		
		g2d.setColor(Color.green);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.lightGray);
		g2d.setStroke(new BasicStroke(2));
		for(int i=0; i<=this.getWidth(); i+=this.getWidth()/17) {
			g2d.drawLine(i, 0, i, this.getHeight());	
		}
		for(int i=0; i<=this.getHeight(); i+=this.getHeight()/15) {
			g2d.drawLine(0, i, this.getWidth(), i);	
		}
		if(this.juego != null) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(this.juego.getMatriz()[i][j] != 0) {
						g2d.drawString(String.valueOf(this.juego.getMatriz()[i][j]), j*this.getWidth()/4+this.getWidth()/8, i*this.getHeight()/4+this.getHeight()/8);
					}
				}
			}
		}
	}
}
