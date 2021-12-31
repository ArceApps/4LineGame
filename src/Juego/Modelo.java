package Juego;

import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Modelo {
	private int filas = 9;
	private int columnas = 9;
	private JButton[][] botones = new JButton[filas][columnas];
	private Random random1 = new Random();
	private Random random2 = new Random();
	private Random randomColor = new Random();
	private int colorAleatorio = 7;
	private int bolasAleatorias = 0;
	private Color[] colores = { Color.blue, Color.cyan, Color.green, Color.pink, Color.orange, Color.yellow,
			Color.red };
	private Color colorBolaAnterior;
	private boolean turno = false;
	private boolean turnoAleatorias = false;
	private int iAnterior;
	private int jAnterior;
	private int puntuacion = 0;
	private int contadorCeros = 0;
	private Color[] coloresAleatorios = new Color[3];

	public Color[] getColoresAleatorios() {
		return coloresAleatorios;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public Color[] getColores() {
		return colores;
	}

	public void setColores(Color[] colores) {
		this.colores = colores;
	}

	public JButton[][] getBotones() {
		return botones;
	}

	public void setBotones(JButton[][] botones) {
		this.botones = botones;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public Modelo() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				botones[i][j] = new JButton();
			}
		}
	}

	public void reiniciarModelo() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				botones[i][j].setBackground(Color.white);
				botones[i][j].setBorder(null);
			}
		}
	}

	public void ponerColoresAleatorios() {
		int numColor = randomColor.nextInt(colorAleatorio);
		coloresAleatorios[0] = colores[numColor];
		numColor = randomColor.nextInt(colorAleatorio);
		coloresAleatorios[1] = colores[numColor];
		numColor = randomColor.nextInt(colorAleatorio);
		coloresAleatorios[2] = colores[numColor];
		
	}

	public void PonerAleatorias() {
		if (turnoAleatorias == false) {
			while (bolasAleatorias < 3) {
				int num1 = random1.nextInt(filas);
				int num2 = random2.nextInt(columnas);
				if (botones[num1][num2].getBackground().equals(Color.white)) {
					botones[num1][num2].setBackground(coloresAleatorios[bolasAleatorias]);
					bolasAleatorias++;
				}
			}
			bolasAleatorias = 0;
		}
	}

	public void moverBolasQuitar(int i, int j) {
		iAnterior = i;
		jAnterior = j;
		colorBolaAnterior = botones[i][j].getBackground();
		botones[i][j].setBackground(Color.white);
		turno = true;
	}

	public void moverBolasPoner(int i, int j) {
		puntuacion += 10;
		botones[i][j].setBackground(colorBolaAnterior);
		turnoAleatorias = false;
		turno = false;

	}

	public void marcarBolas() {
		// comprueba los colores iguales en horizontal
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas - 3; j++) {
				if (botones[i][j].getBackground().equals(botones[i][j + 1].getBackground())
						&& botones[i][j].getBackground().equals(botones[i][j + 2].getBackground())
						&& botones[i][j].getBackground().equals(botones[i][j + 3].getBackground())
						&& !botones[i][j].getBackground().equals(Color.white)) {
					botones[i][j].setText("0");
					botones[i][j + 1].setText("0");
					botones[i][j + 2].setText("0");
					botones[i][j + 3].setText("0");
					turnoAleatorias = true;
				}

			}
		}
		// comprueba los colores en vertical
		for (int i = 0; i < filas - 3; i++) {
			for (int j = 0; j < columnas; j++) {
				if (botones[i][j].getBackground().equals(botones[i + 1][j].getBackground())
						&& botones[i][j].getBackground().equals(botones[i + 2][j].getBackground())
						&& botones[i][j].getBackground().equals(botones[i + 3][j].getBackground())
						&& !botones[i][j].getBackground().equals(Color.white)) {
					botones[i][j].setText("0");
					botones[i + 1][j].setText("0");
					botones[i + 2][j].setText("0");
					botones[i + 3][j].setText("0");
					turnoAleatorias = true;
				}

			}
		}
		// comprueba los colores en diagonal izquierda
		for (int i = 0; i < filas - 3; i++) {
			for (int j = 0; j < columnas - 3; j++) {
				if (botones[i][j].getBackground().equals(botones[i + 1][j + 1].getBackground())
						&& botones[i][j].getBackground().equals(botones[i + 2][j + 2].getBackground())
						&& botones[i][j].getBackground().equals(botones[i + 3][j + 3].getBackground())
						&& !botones[i][j].getBackground().equals(Color.white)) {
					botones[i][j].setText("0");
					botones[i + 1][j + 1].setText("0");
					botones[i + 2][j + 2].setText("0");
					botones[i + 3][j + 3].setText("0");
					turnoAleatorias = true;
				}

			}
		}
		// comprueba los colores en diagonal derecha
		for (int i = 0; i < filas - 3; i++) {
			for (int j = columnas - 1; j >= 3; j--) {
				if (botones[i][j].getBackground().equals(botones[i + 1][j - 1].getBackground())
						&& botones[i][j].getBackground().equals(botones[i + 2][j - 2].getBackground())
						&& botones[i][j].getBackground().equals(botones[i + 3][j - 3].getBackground())
						&& !botones[i][j].getBackground().equals(Color.white)) {
					botones[i][j].setText("0");
					botones[i + 1][j - 1].setText("0");
					botones[i + 2][j - 2].setText("0");
					botones[i + 3][j - 3].setText("0");
					turnoAleatorias = true;
				}

			}
		}
	}

	public void borrarBolas() {
		// comprueba todos los botones y borra los colores iguales
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (botones[i][j].getText().equals("0")) {
					contadorCeros++;
					botones[i][j].setBackground(Color.white);
					botones[i][j].setText("");
				}

			}
		}
	}

	public int puntuaciones() {
		switch (contadorCeros) {
		case 0:
			puntuacion = puntuacion + 0;
			break;
		case 1:
			puntuacion = puntuacion + 0;
			break;
		case 2:
			puntuacion = puntuacion + 0;
			break;
		case 3:
			puntuacion = puntuacion + 0;
			break;
		case 4:
			puntuacion = puntuacion + (contadorCeros * 15);
			break;
		case 5:
			puntuacion = puntuacion + (contadorCeros * 20);
			break;
		case 6:
			puntuacion = puntuacion + (contadorCeros * 25);
			break;
		case 7:
			puntuacion = puntuacion + (contadorCeros * 30);
			break;
		case 8:
			puntuacion = puntuacion + (contadorCeros * 50);
			break;
		default:
			puntuacion = puntuacion + (contadorCeros * 60);
			break;
		}
		return puntuacion;
	}

	public void contadoresACero() {
		puntuacion = 0;
		contadorCeros = 0;
	}
}
