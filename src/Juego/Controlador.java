package Juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Controlador implements ActionListener, MouseListener{
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Jugar")) {
			modelo.reiniciarModelo();
			modelo.ponerColoresAleatorios();
			//vista.ponerBolasAleatorias(modelo.getColoresAleatorios());
			modelo.PonerAleatorias();
			vista.ponerBolas(modelo.getBotones());
			modelo.ponerColoresAleatorios();
			vista.ponerBolasAleatorias(modelo.getColoresAleatorios());
			vista.iniciarCronometro();
		}else if(e.getActionCommand().equals("Pausar")) {
			vista.pararCronometro();
		}else if(e.getActionCommand().equals("Reiniciar")) {
			vista.reiniciarCronometro();
		}else if(e.getActionCommand().equals("Salir")) {
			vista.continuarCronometro();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {		
		for (int i = 0; i < modelo.getFilas(); i++) {
				for (int j = 0; j < modelo.getColumnas(); j++) {
					if(vista.getBotones()[i][j].equals((JButton)e.getSource())) {
						if(!modelo.getBotones()[i][j].getBackground().equals(Color.white) && !modelo.isTurno()) {
							modelo.moverBolasQuitar(i,j);
							vista.ponerBolas(modelo.getBotones());
						}else if(modelo.getBotones()[i][j].getBackground().equals(Color.white) && modelo.isTurno()) {
							modelo.moverBolasPoner(i,j);
							modelo.marcarBolas();
							modelo.PonerAleatorias();
							modelo.marcarBolas();
							modelo.borrarBolas();
							modelo.ponerColoresAleatorios();
							vista.ponerBolasAleatorias(modelo.getColoresAleatorios());
							vista.ponerBolas(modelo.getBotones());
							vista.mostrarPuntuacion(modelo.puntuaciones());
							modelo.contadoresACero();
						}
					}
				}
			}
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/*if (e.getButton() == MouseEvent.BUTTON1) {
			for (int i = 0; i < modelo.getFilas(); i++) {
				for (int j = 0; j < modelo.getColumnas(); j++) {
					if(vista.getBotones()[i][j].equals((JButton)e.getSource())) {
						if(!modelo.getBotones()[i][j].getBackground().equals(Color.white) && !modelo.isTurno()) {
							modelo.moverBolasQuitar(i,j, modelo.getBotones()[i][j].getBackground());
							vista.ponerBolas(modelo.getBotones());
						}else if(modelo.getBotones()[i][j].getBackground().equals(Color.white) && modelo.isTurno()) {
							modelo.moverBolasPoner(i,j);
							modelo.marcarBolas();
							modelo.PonerAleatorias();
							modelo.marcarBolas();
							modelo.borrarBolas();
							vista.ponerBolas(modelo.getBotones());
							vista.mostrarPuntuacion(modelo.puntuaciones());
							modelo.contadoresACero();
						}
					}
				}
			}
		}
		else if (e.getButton() == MouseEvent.BUTTON3) {
			for (int i = 0; i < modelo.getFilas(); i++) {
				for (int j = 0; j < modelo.getColumnas(); j++) {
					
				}
			}
		}*/
		
	}
}
