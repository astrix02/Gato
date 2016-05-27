package abraham.hernandez.grafico;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import abraham.hernandez.constantes.Constantes;
import abraham.hernandez.constantes.EstadoActual;
import abraham.hernandez.constantes.ValorCasilla;
import abraham.hernandez.gato.Gato;

/**
 * Clase que pinta el tablero en cada turno
 * 
 * @author Abraham
 * 
 */
public class TableroCanvas extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		setBackground(Color.WHITE);

		// Dibuja las lineas del tablero
		g.setColor(Color.LIGHT_GRAY);
		for (int row = 1; row < Constantes.FIL; ++row) {
			g.fillRoundRect(0, Constantes.CELDA_TAM * row
					- Constantes.TAB_MITAD, Constantes.CANVAS_ANCHO - 1,
					Constantes.TAB_TAM, Constantes.TAB_TAM,
					Constantes.TAB_TAM);
		}
		for (int col = 1; col < Constantes.COL; ++col) {
			g.fillRoundRect(Constantes.CELDA_TAM * col - Constantes.TAB_MITAD,
					0, Constantes.TAB_TAM, Constantes.CANVAS_ALTO - 1,
					Constantes.TAB_TAM, Constantes.TAB_TAM);
		}

		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(Constantes.GROSOR_SIMBOLO,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); 
																	
		for (int row = 0; row < Constantes.FIL; ++row) {
			for (int col = 0; col < Constantes.COL; ++col) {
				int x1 = col * Constantes.CELDA_TAM + Constantes.SIMBOLO_ESP;
				int y1 = row * Constantes.CELDA_TAM + Constantes.SIMBOLO_ESP;
				if (Gato.tablero[row][col] == ValorCasilla.CRUZ) {
					g2d.setColor(Color.RED);
					int x2 = (col + 1) * Constantes.CELDA_TAM
							- Constantes.SIMBOLO_ESP;
					int y2 = (row + 1) * Constantes.CELDA_TAM
							- Constantes.SIMBOLO_ESP;
					g2d.drawLine(x1, y1, x2, y2);
					g2d.drawLine(x2, y1, x1, y2);
				} else if (Gato.tablero[row][col] == ValorCasilla.CIRCULO) {
					g2d.setColor(Color.BLUE);
					g2d.drawOval(x1, y1, Constantes.SIMBOLO_TAM,
							Constantes.SIMBOLO_TAM);
				}
			}
		}
	}

}
