package abraham.hernandez.gato;

import abraham.hernandez.constantes.ValorCasilla;

public class FuncionalidadGato {

	/**
	 * Funcion para cubrir ataques adversarios del humano
	 * 
	 * @return
	 */
	public static int Evadir() {
		int valor = 0;
		if (Gato.tablero[1][1].getVal() == ValorCasilla.VACIO.getVal()) {
			valor = 4;
		} else if (Gato.tablero[0][0].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[1][2].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[2][1].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 8;
		} else if (Gato.tablero[0][1].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[1][0].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 6;
		} else if (Gato.tablero[1][1].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[2][2].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 6;
		} else if (Gato.tablero[1][0].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[2][1].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 8;
		} else if (Gato.tablero[1][2].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[2][1].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 2;
		} else if (Gato.tablero[0][1].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[1][2].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 0;
		} else if (Gato.tablero[0][0].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[2][1].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 3;
		} else if (Gato.tablero[0][2].getVal() == ValorCasilla.CRUZ.getVal()
				&& Gato.tablero[2][1].getVal() == ValorCasilla.CRUZ.getVal()) {
			valor = 5;
		} else if (Gato.tablero[0][1].getVal() == ValorCasilla.VACIO.getVal()) {
			valor = 1;
		} else if (Gato.tablero[1][0].getVal() == ValorCasilla.VACIO.getVal()) {
			valor = 3;
		} else if (Gato.tablero[1][2].getVal() == ValorCasilla.VACIO.getVal()) {
			valor = 5;
		} else if (Gato.tablero[2][1].getVal() == ValorCasilla.VACIO.getVal()) {
			valor = 7;
		}
		return valor;
	}

	/**
	 * Descubre posicion ganadora antes de tirar y elige la mejor Este Impementa
	 * la logica de jugar Maquina
	 * 
	 * @param j
	 * @return
	 */
	public static int posicionG(int j) {
		int valor = -1;
		if ((Gato.tablero[0][0].getVal() * Gato.tablero[0][1].getVal() * Gato.tablero[0][2]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			for (int i = 0; i < 3; i++) {
				if (Gato.tablero[0][i].getVal() == ValorCasilla.VACIO.getVal()) {
					valor = i;
				}
			}
		} else if ((Gato.tablero[1][0].getVal() * Gato.tablero[1][1].getVal() * Gato.tablero[1][2]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			for (int i = 0; i < 3; i++) {
				if (Gato.tablero[1][i].getVal() == ValorCasilla.VACIO.getVal()) {
					valor = i + 3;
				}
			}
		} else if ((Gato.tablero[2][0].getVal() * Gato.tablero[2][1].getVal() * Gato.tablero[2][2]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			for (int i = 0; i < 3; i++) {
				if (Gato.tablero[2][i].getVal() == ValorCasilla.VACIO.getVal()) {
					valor = i + 6;
				}
			}
		} else if ((Gato.tablero[0][0].getVal() * Gato.tablero[1][0].getVal() * Gato.tablero[2][0]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			for (int i = 0; i < 3; i++) {
				if (Gato.tablero[i][0].getVal() == ValorCasilla.VACIO.getVal()) {
					if (i == 0)
						valor = 0;
					if (i == 1)
						valor = 3;
					if (i == 2)
						valor = 6;
				}
			}
		} else if ((Gato.tablero[0][1].getVal() * Gato.tablero[1][1].getVal() * Gato.tablero[2][1]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			for (int i = 0; i < 3; i++) {
				if (Gato.tablero[i][1].getVal() == ValorCasilla.VACIO.getVal()) {
					if (i == 0)
						valor = 1;
					if (i == 1)
						valor = 4;
					if (i == 2)
						valor = 7;
				}
			}
		} else if ((Gato.tablero[0][2].getVal() * Gato.tablero[1][2].getVal() * Gato.tablero[2][2]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			for (int i = 0; i < 3; i++) {
				if (Gato.tablero[i][2].getVal() == ValorCasilla.VACIO.getVal()) {
					if (i == 0)
						valor = 2;
					if (i == 1)
						valor = 5;
					if (i == 2)
						valor = 8;
				}
			}
		} else if ((Gato.tablero[0][2].getVal() * Gato.tablero[1][1].getVal() * Gato.tablero[2][0]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			if (Gato.tablero[0][2].getVal() == ValorCasilla.VACIO.getVal())
				valor = 2;
			if (Gato.tablero[1][1].getVal() == ValorCasilla.VACIO.getVal())
				valor = 4;
			if (Gato.tablero[2][0].getVal() == ValorCasilla.VACIO.getVal())
				valor = 6;

		} else if ((Gato.tablero[0][0].getVal() * Gato.tablero[1][1].getVal() * Gato.tablero[2][2]
				.getVal()) == (j * j * ValorCasilla.VACIO.getVal())) {
			if (Gato.tablero[0][0].getVal() == ValorCasilla.VACIO.getVal())
				valor = 0;
			if (Gato.tablero[1][1].getVal() == ValorCasilla.VACIO.getVal())
				valor = 4;
			if (Gato.tablero[2][2].getVal() == ValorCasilla.VACIO.getVal())
				valor = 8;
		}
		return valor;
	}

	/**
	 * Funcion que mapea una casilla a coordenadas en el tablero
	 * 
	 * @param num
	 *            Numero de casilla
	 * @return Arreglo con coordenadas
	 */
	public static int[] mapearCasilla(int num) {
		int[] pmat = new int[2];
		switch (num) {
		case 0:
			pmat[0] = 0;
			pmat[1] = 0;
			break;
		case 1:
			pmat[0] = 0;
			pmat[1] = 1;
			break;
		case 2:
			pmat[0] = 0;
			pmat[1] = 2;
			break;
		case 3:
			pmat[0] = 1;
			pmat[1] = 0;
			break;
		case 4:
			pmat[0] = 1;
			pmat[1] = 1;
			break;
		case 5:
			pmat[0] = 1;
			pmat[1] = 2;
			break;
		case 6:
			pmat[0] = 2;
			pmat[1] = 0;
			break;
		case 7:
			pmat[0] = 2;
			pmat[1] = 1;
			break;
		case 8:
			pmat[0] = 2;
			pmat[1] = 2;
			break;
		}
		return pmat;
	}

	/**
	 * Funcion que hace jugar a la maquina en cada turno
	 */
	public static void jugarMaquina() {
		if (Gato.turno == 1) {
			Gato.go(0, 0);
		} else if (Gato.turno == 2) {
			if (Gato.tablero[1][1].getVal() == ValorCasilla.VACIO.getVal()) {
				Gato.go(mapearCasilla(4)[0], mapearCasilla(4)[1]);
			} else {
				Gato.go(mapearCasilla(0)[0], mapearCasilla(0)[1]);
			}
		} else if (Gato.turno == 3) {
			if (Gato.tablero[2][2].getVal() == ValorCasilla.VACIO.getVal()) {
				Gato.go(2, 2);
			} else {
				Gato.go(0, 2);
			}
		} else if (Gato.turno == 4) {
			if (posicionG(ValorCasilla.CIRCULO.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[1]);
			} else if (posicionG(ValorCasilla.CRUZ.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[1]);
			} else {
				Gato.go(mapearCasilla(Evadir())[0], mapearCasilla(Evadir())[1]);
			}
		} else if (Gato.turno == 5) {
			if (posicionG(ValorCasilla.CIRCULO.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[1]);
			} else if (posicionG(ValorCasilla.CRUZ.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[1]);
			} else if (Gato.tablero[2][0].getVal() == ValorCasilla.VACIO
					.getVal()) {
				Gato.go(2, 0);
			} else {
				Gato.go(0, 2);
			}

		} else if (Gato.turno == 6) {
			if (posicionG(ValorCasilla.CIRCULO.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[1]);
			} else if (posicionG(ValorCasilla.CRUZ.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[1]);
			} else {
				Gato.go(mapearCasilla(Evadir())[0], mapearCasilla(Evadir())[1]);
			}
		} else if (Gato.turno == 7) {
			if (posicionG(ValorCasilla.CIRCULO.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[1]);
			} else if (posicionG(ValorCasilla.CRUZ.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[1]);
			} else {
				for (int i = 0; i < Gato.tablero.length; i++) {
					for (int j = 0; j < Gato.tablero.length; j++) {
						if (Gato.tablero[i][j].getVal() == ValorCasilla.VACIO
								.getVal()) {
							Gato.go(i, j);
							break;
						}
					}
				}
			}
		} else if (Gato.turno == 8) {
			if (posicionG(ValorCasilla.CIRCULO.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[1]);
			} else if (posicionG(ValorCasilla.CRUZ.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[1]);
			} else {
				for (int i = 0; i < Gato.tablero.length; i++) {
					for (int j = 0; j < Gato.tablero.length; j++) {
						if (Gato.tablero[i][j].getVal() == ValorCasilla.VACIO
								.getVal()) {
							Gato.go(i, j);
							break;
						}
					}
				}
			}
		} else if (Gato.turno == 9) {
			if (posicionG(ValorCasilla.CIRCULO.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CIRCULO.getVal()))[1]);
			} else if (posicionG(ValorCasilla.CRUZ.getVal()) != -1) {
				Gato.go(mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[0],
						mapearCasilla(posicionG(ValorCasilla.CRUZ.getVal()))[1]);
			} else {
				for (int i = 0; i < Gato.tablero.length; i++) {
					for (int j = 0; j < Gato.tablero.length; j++) {
						if (Gato.tablero[i][j].getVal() == ValorCasilla.VACIO
								.getVal()) {
							Gato.go(i, j);
							break;
						}
					}
				}
			}
		}
	}
}
