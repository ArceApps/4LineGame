package Juego;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CronometroThread implements Runnable {
    private Thread hiloCronometro;
    private boolean go,live;
    private int segundos;
    private Vista tiempo;
    private Font fuente = new Font("Arial", Font.PLAIN, 16);
	private Font fuenteBotones = new Font("Arial", Font.BOLD, 22);

    public CronometroThread(Vista v) {
    	tiempo = v;
    }

	public void run() {
        try {
            while (isLive()) {
                synchronized(this) {
                    while (!isGo())
                        wait();
                }
                Thread.sleep(1000);
                segundos++;
                actualizarThread();
            }
        } catch (InterruptedException e) {}
    }

    public void createThread() {
        hiloCronometro = new Thread(this);
        hiloCronometro.start();
    }

    private void actualizarThread() {
        if (isLive() == true) {
            int hr= segundos/3600;
            int min =(segundos-hr*3600)/60;
            int seg = segundos-hr*3600-min*60;
            tiempo.getLabelTiempo().setText(""+hr+" : "+min+" : "+seg);
            //tiempo.setText(""+hr+" : "+min+" : "+seg);
        } else {
            segundos = 0;
            tiempo.getLabelTiempo().setText("0 : 0 : 0");
            //tiempo.setText("0 : 0 : 0");
        }
    }

    public void suspenderThread() {
        setGo(false);
    }

    public synchronized void continuarThread() {
        setGo(true);
        notify();
    }

    //********** M?TODOS SET Y GET DE LAS VARIABLES DE TIPO BOOLEAN e INT ************
    /**
     * @return the live
     */
    public boolean isLive() {
        return live;
    }

    /**
     * @param live the live to set
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * @return the go
     */
    public boolean isGo() {
        return go;
    }

    /**
     * @param go the go to set
     */
    public void setGo(boolean go) {
        this.go = go;
    }

    /**
     * @return the segundos
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * @param segundos the segundos to set
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
        System.out.println("Valor de SEgundos:" + this.segundos);
    }
}
