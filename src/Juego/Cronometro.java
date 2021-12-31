package Juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Cronometro extends JLabel implements Runnable {
	private static int onoff = 0;
	private Font fuente = new Font("Arial", Font.PLAIN, 16);
	private Font fuenteBotones = new Font("Arial", Font.BOLD, 22);
	private JLabel tiempo;
	private Thread hilo;
	private boolean cronometroActivo = false;
	private boolean pausar;
	private boolean iniciarCronometro = false;
	//private Fuentes f = new Fuentes();

	public Cronometro() {
		tiempo = new JLabel("00:00:00");
		tiempo.setOpaque(true);
	}

	public JLabel cronometro() {
		tiempo = new JLabel("00:00:00");
		tiempo.setSize(100, 24);
		tiempo.setPreferredSize(tiempo.getSize());
		tiempo.setFont(fuenteBotones);
		tiempo.setForeground(Color.blue);
		tiempo.setBackground(Color.black);
		tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		return tiempo;

	}

	public static int getOnoff() {
		return onoff;
	}

	public JLabel getTiempo() {
		return tiempo;
	}

	@SuppressWarnings("deprecation")
	public void run() {
		Integer horas = 0, minutos = 0, segundos = 0, milesimas = 0;
		// min es minutos, seg es segundos y mil es milesimas de segundo
		String hor = "", min = "", seg = "", mil = "";
		try {
			while (pausar) {
				// Mientras cronometroActivo sea verdadero entonces seguira
				// aumentando el tiempo
				while (cronometroActivo) {
					Thread.sleep(200);
					// Incrementamos 4 milesimas de segundo
					milesimas += 200;
					// Cuando llega a 1000 osea 1 segundo aumenta 1 segundo
					// y las milesimas de segundo de nuevo a 0
					if (milesimas == 1000) {
						milesimas = 0;
						segundos += 1;
						// Si los segundos llegan a 60 entonces aumenta 1 los minutos
						// y los segundos vuelven a 0
						if (segundos == 60) {
							segundos = 0;
							minutos++;
						}
						if (minutos == 60) {
							minutos = 0;
							horas++;
						}
					}
					// Esto solamente es estetica para que siempre este en formato
					// 00:00:00
					if (horas < 10)
						hor = "0" + horas;
					else
						hor = horas.toString();
					if (minutos < 10)
						min = "0" + minutos;
					else
						min = minutos.toString();
					if (segundos < 10)
						seg = "0" + segundos;
					else
						seg = segundos.toString();

				/*	if (milesimas < 10)
						mil = "00" + milesimas;
					else if (milesimas < 100)
						mil = "0" + milesimas;
					else
						mil = milesimas.toString();*/

					// Colocamos en la etiqueta la informacion
					tiempo.setText(hor + ":" + min + ":" + seg);
					//System.out.println(hor + ":" + min + ":" + seg);
					
					 //while(pausar){ tiempo.setText(hor + ":" + min + ":" + seg); }
					 
				}
				tiempo.setText(hor + ":" + min + ":" + seg);
			}
		} catch (Exception e) {
			//System.out.println("Ya vali� :P, error en el run");
		}
		// Cuando se reincie se coloca nuevamente en 00:00:00
		tiempo.setText("00:00:00");
	}

	// Iniciar el cronometro poniendo cronometroActivo
	// en verdadero para que entre en el while
	public void iniciarCronometro() {
		if(iniciarCronometro) {
			hilo.interrupt();
		}
		cronometroActivo = true;
		pausar = true;
		hilo = new Thread(this);
		hilo.start();
	}

	// Esto es para parar el cronometro
	public void pararCronometro() {
		cronometroActivo = false;
		pausar = true;
		iniciarCronometro = true;
	}

	public void reiniciarCronometro() {
		cronometroActivo = false;
		pausar = false;
	}
	
	public void continuarCronometro() {
		cronometroActivo = true;
		pausar = true;
	}
}