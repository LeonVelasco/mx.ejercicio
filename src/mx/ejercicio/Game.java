package mx.ejercicio;

public class Game {
	
	Laberinto board = new Laberinto();
	Corredor runner = new Corredor();
	boolean corredorLlegoMeta = false;

	public void realizaJuego() {

		board.crearTablero();
		runner.seleccionarPersonaje();
		board.getTablero()[runner.getPosX()][runner.getPosY()] = runner.getTipoCorredor();
		board.imprimirTablero();

		int vecesQueSeImprimeTablero = 0;
		while (corredorLlegoMeta != true) {

			if (sePuedeMover(1)) {
				moverPersonaje(1);
			} else if (sePuedeMover(2)) {
				moverPersonaje(2);
			} else if (sePuedeMover(3)) {
				moverPersonaje(3);
			} else if (sePuedeMover(4)) {
				moverPersonaje(4);
			} else if (sePuedeMover(5)) {
				moverPersonaje(5);
			}

			board.imprimirTablero();
			vecesQueSeImprimeTablero++;
			if (vecesQueSeImprimeTablero == 15) {
				System.out.println("No llegaste a la meta en " + vecesQueSeImprimeTablero + " movimientos.");
				break;
			}

			corredorLlegoMeta = llegarALaMeta();
			if (corredorLlegoMeta == true) {
				System.out.println("Llegaste a la meta!");
				break;
			}
		}
	}

	boolean sePuedeMover(int direccion) {
		
		if (direccion == 1 && runner.getPosX() < board.getTablero().length - 1
				&& runner.getPosY() < board.getTablero().length - 1) {
			if (board.getTablero()[runner.getPosX() + 1][runner.getPosY() + 1] == 'O') {
				return true;
			}
		}
		if (direccion == 2 && runner.getPosX() < board.getTablero().length - 1) {
			if (board.getTablero()[runner.getPosX()+1][runner.getPosY()]=='O') {
				return true;
			}
		}
		if (direccion == 3 && runner.getPosY() < board.getTablero().length - 1) {
			if (board.getTablero()[runner.getPosX()][runner.getPosY() + 1] == 'O') {
				return true;
			}
		}
		if (direccion == 4 && runner.getPosX() < board.getTablero().length
				&& runner.getPosY() < board.getTablero().length - 1 && runner.getPosX() > 0) {
			if (board.getTablero()[runner.getPosX() - 1][runner.getPosY() + 1] == 'O') {
				return true;
			}
		}

		if (direccion == 5 && runner.getPosX() < board.getTablero().length - 1 && runner.getPosY() > 0) {
			if (board.getTablero()[runner.getPosX() + 1][runner.getPosY() - 1] == 'O') {
				return true;
			}
		}
		return false;
	}

	void moverPersonaje(int direccion) {

		board.getTablero()[runner.getPosX()][runner.getPosY()] = 'O';

		if (direccion == 1) {
			runner.setPosX(runner.getPosX() + 1);
			runner.setPosY(runner.getPosY() + 1);

			System.out.println("Dirección 1");
		}
		if (direccion == 2) {
			runner.setPosX(runner.getPosX() + 1);

			System.out.println("Dirección 2");
		}
		if (direccion == 3) {
			runner.setPosY(runner.getPosY() + 1);

			System.out.println("Dirección 3");
		}
		if (direccion == 4) {
			runner.setPosX(runner.getPosX() - 1);
			runner.setPosY(runner.getPosY() + 1);

			System.out.println("Dirección 4");
		}
		if (direccion == 5) {
			runner.setPosX(runner.getPosX()+1);
			runner.setPosY(runner.getPosY()-1);
			
			System.out.println("Dirección 5");
		}
		
	
		board.getTablero()[runner.getPosX()][runner.getPosY()] = runner.getTipoCorredor();
	}

	boolean llegarALaMeta() {
		if (runner.getPosX() == board.getRow()- 1 && runner.getPosY() == board.getCol() - 1) {
			return true;
		}
		return false;
	}

}
