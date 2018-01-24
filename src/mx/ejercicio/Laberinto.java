package mx.ejercicio;

import java.util.Scanner;

public class Laberinto {
	private int row;	
	private int col;
	private char[][] tablero = new char[row][col];
	
	
	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int pideFila() {
		System.out.println("Cuantas filas?");
		Scanner fila = new Scanner(System.in);
		setRow(fila.nextInt());

		return getRow();
	}

	public int pideCol() {
		System.out.println("Cuantas columnas?");
		Scanner columna = new Scanner(System.in);
		setCol(columna.nextInt());
		return getCol();
	}

	public char[][] crearTablero() {
		row = pideFila();
		col = pideCol();
		tablero = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tablero[i][j] = 'O';
			}
		}
		colocaObstaculos(tablero);
		return tablero;
	}

	char[][] colocaObstaculos(char[][] tablero) {
		for (int i = 0; i < row +  20; i++) {
			double obstaculo = Math.random();
			obstaculo = obstaculo * row;
			int randomInt = (int) obstaculo;
			double obstaculo2 = Math.random();
			obstaculo2 = obstaculo2 * row;
			int randomInt2 = (int) obstaculo2;
			tablero[randomInt][randomInt2] = '#';
		}
		
		tablero[0][0] = 'O';
		tablero[row - 1][col - 1] = 'O';
		
		return tablero;
	}
	
	void imprimirTablero() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println();
		}
		System.out.println("===========");
	}

}
