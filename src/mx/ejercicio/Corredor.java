package mx.ejercicio;

import java.util.Scanner;

public class Corredor {
	private int posX = 0;
	private int posY = 0;
	private char tipoCorredor;
	
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public char seleccionarPersonaje() {

		System.out.println("Ingresa un corredor");
		Scanner runner = new Scanner(System.in);
		setTipoCorredor(runner.next().charAt(0));
		return getTipoCorredor();
	}
	
	

	public char getTipoCorredor() {
		return tipoCorredor;
	}

	public void setTipoCorredor(char tipoCorredor) {
		this.tipoCorredor = tipoCorredor;
	}

}
