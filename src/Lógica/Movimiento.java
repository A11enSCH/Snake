package Lógica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Movimiento {
	private List<int[]> Snake;
	private int[] comida;
	private int tamMax;
	private int cant;
	private String direccion = "De";
	private String prox_direccion = "Izq";
	int agregar_x =0;
	int agregar_y =0;

	public Movimiento(int tamMax, int cant) {
		this.tamMax = tamMax;
		this.cant = cant;
		this.direccion = new String();
		this.Snake = new ArrayList();
		int[] a = {cant / 2 - 1, cant / 2 - 1};
		int[] b = {cant / 2, cant / 2 - 1};
		this.Snake.add(a);
		this.Snake.add(b);
		generarComida();
	}
	
	public int[] getComida() {
		return comida;
	}

	public void mover() throws Exception {
		igualar();
		int[] ultimo = Snake.get(Snake.size()-1);
		switch (direccion) {
		case "De": agregar_x=1;
		break;
		case "Iz": agregar_x=-1;
		break;
		case "Arr": agregar_y=1;
		break;
		case "Aba": agregar_y=-1;
		break;
		}
		int[] nuevo = {Math.floorMod(ultimo[0]+agregar_x, cant), Math.floorMod(ultimo[1]+agregar_y, cant)};
		boolean existeM = false;
		for(int i =0; i<Snake.size(); i++) {
			if (nuevo[0] == Snake.get(i)[0] && nuevo[1] == Snake.get(i)[1]) {
				existeM = true;
			}
		}
		if(existeM) {
			throw new Exception("has perdido");
		}else if(nuevo[0] == comida[0] && nuevo[1] == comida[1]) {
			Snake.add(nuevo);
		}else {
			Snake.add(nuevo);
			Snake.remove(0);
		}
	}
	
	public void cambioDireccion(String dir) {
		this.prox_direccion = dir;
	}
	
	public void igualar() {
		this.direccion = this.prox_direccion;
	}

	private void generarComida() {
		this.comida = new int[] {(int)(Math.random() * cant), (int)(Math.random() * cant)};
	}
}
