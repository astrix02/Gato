package abraham.hernandez.gato;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import abraham.hernandez.constantes.Constantes;
import abraham.hernandez.constantes.EstadoActual;
import abraham.hernandez.constantes.ValorCasilla;
import abraham.hernandez.grafico.TableroCanvas;

public class Gato extends JFrame {
	public static int turno = 1;

	public static EstadoActual estadoActual; // El estado actual del juego
	public static ValorCasilla jugadorActual; // El jugador Actual

	public static ValorCasilla[][] tablero; // Tablero de juego
	private static TableroCanvas canvas; //Jpanel que pinta el tablero

	/**
	 * Constructor que se encarga de inicializar Ventana, tablero y evento
	 */
	public Gato() {

		canvas = new TableroCanvas();
		canvas.setPreferredSize(new Dimension(Constantes.CANVAS_ANCHO,
				Constantes.CANVAS_ALTO));

		// Evento de mouse Click
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (estadoActual == EstadoActual.JUGANDO) {
					if (jugadorActual == ValorCasilla.CRUZ) {
						int mouseX = e.getX();
						int mouseY = e.getY();
						// Obtiene las coordenadas del click
						int fila = mouseY / Constantes.CELDA_TAM;
						int columna = mouseX / Constantes.CELDA_TAM;
						if (fila >= 0 && fila < Constantes.FIL && columna >= 0
								&& columna < Constantes.COL
								&& tablero[fila][columna] == ValorCasilla.VACIO) {
							go(fila, columna);
						}
					}
					if (jugadorActual == ValorCasilla.CIRCULO) {
						FuncionalidadGato.jugarMaquina();
					}

				} else { // Cuando temina el juego se ejecuta este else
					iniciarJuego(); // reinicia el juego
				}

				repaint(); // repinta el tablero
			}
		});

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setTitle("Gato");
		setVisible(true);

		tablero = new ValorCasilla[Constantes.FIL][Constantes.COL];
		iniciarJuego(); // inicia el juego la primera vez
	}

	/**
	 * Metodo que inicializa el tablero vacio, turno y elige al jugador
	 */
	public void iniciarJuego() {
		for (int fila = 0; fila < Constantes.FIL; ++fila) {
			for (int col = 0; col < Constantes.COL; ++col) {
				tablero[fila][col] = ValorCasilla.VACIO;
			}
		}

		turno = 1;
		estadoActual = EstadoActual.JUGANDO; // Setea el estado inicial del
												// juego
		jugadorActual = ValorCasilla.CRUZ;
		if (jugadorActual == ValorCasilla.CIRCULO) {
			FuncionalidadGato.jugarMaquina();
			repaint();
		}
	}

	public static void actualizarEstado(ValorCasilla casilla, int filaSel,
			int colSel) {
		if (haGanado(casilla, filaSel, colSel)) {
			estadoActual = (casilla == ValorCasilla.CRUZ) ? estadoActual.CRUZ_GANO
					: estadoActual.CIRCULO_GANO;
		} else if (esEmpate()) {
			estadoActual = estadoActual.EMPATE;
		}

	}

	/**
	 * verifica si hubo empate
	 * 
	 * @return
	 */
	public static boolean esEmpate() {
		for (int row = 0; row < Constantes.FIL; ++row) {
			for (int col = 0; col < Constantes.COL; ++col) {
				if (tablero[row][col] == ValorCasilla.VACIO) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Cada turno verifica si ha ganado el jugador
	 */
	public static boolean haGanado(ValorCasilla casilla, int filaSel, int colSel) {
		return (tablero[filaSel][0] == casilla
				&& tablero[filaSel][1] == casilla
				&& tablero[filaSel][2] == casilla
				|| tablero[0][colSel] == casilla
				&& tablero[1][colSel] == casilla
				&& tablero[2][colSel] == casilla || filaSel == colSel
				&& tablero[0][0] == casilla && tablero[1][1] == casilla
				&& tablero[2][2] == casilla || filaSel + colSel == 2
				&& tablero[0][2] == casilla && tablero[1][1] == casilla
				&& tablero[2][0] == casilla);
	}

	/**
	 * Metodo que hace un movimiento en el tablero y actualiza el estado del
	 * juego
	 * 
	 * @param x
	 * @param y
	 */
	public static void go(int x, int y) {
		tablero[x][y] = jugadorActual;
		turno++;
		actualizarEstado(jugadorActual, x, y);
		jugadorActual = (jugadorActual == ValorCasilla.CIRCULO) ? ValorCasilla.CRUZ
				: ValorCasilla.CIRCULO;

	}

	public static void main(String[] args) {
		new Gato();
	}
}
