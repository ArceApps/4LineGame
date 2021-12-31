package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Vista extends JFrame {
	private int filas = 9;
	private int columnas = 9;
	private GridLayout layoutBotones = new GridLayout(filas, columnas, 0, 0);
	private BorderLayout layoutPrincipal = new BorderLayout();
	private JButton[][] botones = new JButton[filas][columnas];
	private JPanel panelBolas = new JPanel();
	private JPanel panelInferior = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JPanel panelInicial = new JPanel();
	private JPanel panelContadores = new JPanel();
	private JPanel panelProximas = new JPanel();
	private JLabel labelProximaTexto = new JLabel("Próximas:");
	private JLabel labelProxima1 = new JLabel();
	private JLabel labelProxima2 = new JLabel();
	private JLabel labelProxima3 = new JLabel();
	private JLabel labelTiempo = new JLabel("00:00:00");
	private JLabel labelPuntuacion = new JLabel("0");
	private JLabel labelInicial = new JLabel();
	//private JButton btnSalir = new JButton("Salir");
	private JButton btnJugar = new JButton("Jugar");
	private JButton btnPausar = new JButton("Pausar");
	private JButton btnReiniciar = new JButton("Reiniciar");
	// private Border border = LineBorder.createGrayLineBorder();
	private Font fuente = new Font("Arial", Font.BOLD, 24);
	private int puntos;
	Cronometro crono = new Cronometro();
	CargaImagenes iconos = new CargaImagenes();

	// INICIO DE LOS GETTERS y SETTERS
	public JLabel getLabelTiempo() {
		return labelTiempo;
	}

	public void setLabelTiempo(JLabel labelTiempo) {
		this.labelTiempo = labelTiempo;
	}

	public JLabel getLabelPuntuacion() {
		return labelPuntuacion;
	}

	public void setLabelPuntuacion(JLabel labelPuntuacion) {
		this.labelPuntuacion = labelPuntuacion;
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
	// Fin de los GETTERS y SETTERS

	public Vista() {
		super("Cuatro en línea");
		setLayout(null);
		this.add(mostrarContadores());
		this.add(mostrarBolas());
		this.add(mostrarPanelInicial());
		this.add(mostrarPanelInferior());
	}

	public void mostrarVentana() {
		this.setSize(500, 580);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void Controladores(Controlador c) {
		btnJugar.addActionListener(c);
		btnPausar.addActionListener(c);
		btnReiniciar.addActionListener(c);
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				botones[i][j].addMouseListener(c);
			}
		}
	}

	public JPanel mostrarBolas() {
		panelBolas.setLayout(layoutBotones);
		panelBolas.setBounds(12, 40, 470, 470);
		panelBolas.setVisible(false);
		UIManager.put("Button.select", Color.white);
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				botones[i][j] = new JButton();
				panelBolas.add(botones[i][j]);
				
				botones[i][j].setMargin(new Insets(0, 0, 0, 0));
				botones[i][j].setFocusPainted(false);
				botones[i][j].setEnabled(true);
				botones[i][j].setBorder(null);
				botones[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				botones[i][j].setHorizontalAlignment(JLabel.CENTER);
				botones[i][j].setVerticalAlignment(JLabel.CENTER);
				botones[i][j].setFont(fuente);
			}
		}
		return panelBolas;
	}

	public JPanel mostrarPanelInferior() {
		panelInferior.setLayout(new BorderLayout());
		panelInferior.setBounds(12, 518, 470, 25);
		panelInferior.add(mostrarBotones(), BorderLayout.WEST);
		panelInferior.add(mostrarProximasBolas(), BorderLayout.EAST);
		return panelInferior;
	}
	
	public JPanel mostrarBotones() {
		panelBotones.setLayout(new GridLayout());
		panelBotones.add(btnPausar, BorderLayout.WEST);
		//panelBotones.add(btnSalir);
		panelBotones.add(btnReiniciar, BorderLayout.CENTER);
		return panelBotones;
	}
	
	public JPanel mostrarProximasBolas() {
		panelProximas.setLayout(new FlowLayout());
		panelProximas.add(labelProximaTexto);
		panelProximas.add(labelProxima1);
		panelProximas.add(labelProxima2);
		panelProximas.add(labelProxima3);
		panelProximas.setAlignmentX(RIGHT_ALIGNMENT);
		labelProxima1.setIcon(iconos.proximaCyan());
		labelProxima2.setIcon(iconos.proximaCyan());
		labelProxima3.setIcon(iconos.proximaCyan());
		return panelProximas;
	}
	
	

	public JPanel mostrarPanelInicial() {
		panelInicial.setLayout(new BorderLayout());
		panelInicial.setBounds(12, 40, 470, 470);
		panelInicial.add(labelInicial, BorderLayout.CENTER);
		panelInicial.add(btnJugar, BorderLayout.SOUTH);
		labelInicial.setIcon(iconos.getFondo1());
		panelInicial.setVisible(true);
		return panelInicial;
	}

	public JPanel mostrarContadores() {
		panelContadores.setLayout(new BorderLayout());
		panelContadores.setBounds(15, 12, 460, 25);
		panelContadores.add(crono.cronometro(), BorderLayout.WEST);
		panelContadores.add(labelPuntuacion, BorderLayout.EAST);
		labelTiempo.setFont(fuente);
		labelPuntuacion.setFont(fuente);
		labelPuntuacion.setSize(90, 24);
		return panelContadores;
	}

	public void ponerBolas(JButton[][] casillas) {

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				botones[i][j].setIcon(null);
				botones[i][j].setFocusPainted(false);
				botones[i][j].setBorder(null);
				//botones[i][j].setBorder(BorderFactory.createDashedBorder(Color.lightGray));
				botones[i][j].setBorder(BorderFactory.createRaisedSoftBevelBorder());
				if (casillas[i][j].getBackground().equals(Color.blue)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getBlueBola());
				} else if (casillas[i][j].getBackground().equals(Color.pink)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getPinkBola());
				} else if (casillas[i][j].getBackground().equals(Color.cyan)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getCyanBola());
				} else if (casillas[i][j].getBackground().equals(Color.green)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getGreenBola());
				} else if (casillas[i][j].getBackground().equals(Color.red)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getRedBola());
				} else if (casillas[i][j].getBackground().equals(Color.orange)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getOrangeBola());
				} else if (casillas[i][j].getBackground().equals(Color.yellow)) {
					botones[i][j].setBackground(Color.white);
					botones[i][j].setIcon(iconos.getYellowBola());
				} else if (casillas[i][j].getBackground().equals(Color.white)) {
					botones[i][j].setBackground(Color.white);
				}

			}
		}
	}
	
	public void ponerBolasAleatorias(Color[] color) {
		if(color[0] == Color.blue) {
			labelProxima1.setIcon(iconos.proximaBlue());
		}else if(color[0] == Color.red) {
			labelProxima1.setIcon(iconos.proximaRed());
		}else if(color[0] == Color.green) {
			labelProxima1.setIcon(iconos.proximaGreen());
		}else if(color[0] == Color.orange) {
			labelProxima1.setIcon(iconos.proximaOrange());
		}else if(color[0] == Color.yellow) {
			labelProxima1.setIcon(iconos.proximaYellow());
		}else if(color[0] == Color.cyan) {
			labelProxima1.setIcon(iconos.proximaCyan());
		}else if(color[0] == Color.pink) {
			labelProxima1.setIcon(iconos.proximaPink());
		}
		if(color[1] == Color.blue) {
			labelProxima2.setIcon(iconos.proximaBlue());
		}else if(color[1] == Color.red) {
			labelProxima2.setIcon(iconos.proximaRed());
		}else if(color[1] == Color.green) {
			labelProxima2.setIcon(iconos.proximaGreen());
		}else if(color[1] == Color.orange) {
			labelProxima2.setIcon(iconos.proximaOrange());
		}else if(color[1] == Color.yellow) {
			labelProxima2.setIcon(iconos.proximaYellow());
		}else if(color[1] == Color.cyan) {
			labelProxima2.setIcon(iconos.proximaCyan());
		}else if(color[1] == Color.pink) {
			labelProxima2.setIcon(iconos.proximaPink());
		}
		if(color[2] == Color.blue) {
			labelProxima3.setIcon(iconos.proximaBlue());
		}else if(color[2] == Color.red) {
			labelProxima3.setIcon(iconos.proximaRed());
		}else if(color[2] == Color.green) {
			labelProxima3.setIcon(iconos.proximaGreen());
		}else if(color[2] == Color.orange) {
			labelProxima3.setIcon(iconos.proximaOrange());
		}else if(color[2] == Color.yellow) {
			labelProxima3.setIcon(iconos.proximaYellow());
		}else if(color[2] == Color.cyan) {
			labelProxima3.setIcon(iconos.proximaCyan());
		}else if(color[2] == Color.pink) {
			labelProxima3.setIcon(iconos.proximaPink());
		}
	}

	public void mostrarPuntuacion(int puntuacion) {
		puntos += puntuacion;
		labelPuntuacion.setText(String.valueOf(String.format("%2d", puntos)));
	}

	public void iniciarCronometro() {
		panelInicial.setVisible(false);
		panelBolas.setVisible(true);
		crono.iniciarCronometro();
	}

	public void pararCronometro() {
		crono.pararCronometro();
	}

	public void reiniciarCronometro() {
		panelBolas.setVisible(false);
		panelInicial.setVisible(true);
		crono.reiniciarCronometro();
	}

	public void continuarCronometro() {
		crono.continuarCronometro();
	}

	public void botonSalir() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
}
