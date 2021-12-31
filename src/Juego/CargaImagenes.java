package Juego;

import java.awt.Image;

import javax.swing.ImageIcon;

public class CargaImagenes {
	
	//Colores de las bolas
	private ImageIcon imageIconBlue = new ImageIcon("src/images/blue.png");
	private Image imagenBlue = imageIconBlue.getImage();
	private Image blueImagen = imagenBlue.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon blueBola = new ImageIcon(blueImagen);
	
	private ImageIcon imageIconYellow = new ImageIcon("src/images/yellow.png");
	private Image imagenYellow = imageIconYellow.getImage();
	private Image yellowImagen = imagenYellow.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon yellowBola = new ImageIcon(yellowImagen);
	
	private ImageIcon imageIconGreen = new ImageIcon("src/images/green.png");
	private Image imagenGreen = imageIconGreen.getImage();
	private Image greenImagen = imagenGreen.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon greenBola = new ImageIcon(greenImagen);
	
	private ImageIcon imageIconPink = new ImageIcon("src/images/pink.png");
	private Image imagenPink = imageIconPink.getImage();
	private Image pinkImagen = imagenPink.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon pinkBola = new ImageIcon(pinkImagen);
	
	private ImageIcon imageIconOrange = new ImageIcon("src/images/orange.png");
	private Image imagenOrange = imageIconOrange.getImage();
	private Image orangeImagen = imagenOrange.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon orangeBola = new ImageIcon(orangeImagen);
	
	private ImageIcon imageIconRed = new ImageIcon("src/images/red.png");
	private Image imagenRed = imageIconRed.getImage();
	private Image redImagen = imagenRed.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon redBola = new ImageIcon(redImagen);
	
	private ImageIcon imageIconCyan = new ImageIcon("src/images/cyan.png");
	private Image imagenCyan = imageIconCyan.getImage();
	private Image cyanImagen = imagenCyan.getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private ImageIcon cyanBola = new ImageIcon(cyanImagen);
	
	//fondos
	private ImageIcon imageIconFondo1 = new ImageIcon("src/images/fondo1.jpg");
	private Image imagenFondo1 = imageIconFondo1.getImage();
	private Image fondo1Imagen = imagenFondo1.getScaledInstance(470, 430, Image.SCALE_SMOOTH);
	private ImageIcon fondo1 = new ImageIcon(fondo1Imagen);

	public ImageIcon getBlueBola() {
		return blueBola;
	}
	
	public ImageIcon proximaBlue() {
		ImageIcon kk = new ImageIcon("src/images/blue.png");
		Image kk2 = kk.getImage();
		Image kk3 = kk2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon blue = new ImageIcon(kk3);
		return blue;
	}
	public ImageIcon proximaCyan() {
		ImageIcon imageIconCyan = new ImageIcon("src/images/cyan.png");
		Image imagenCyan = imageIconCyan.getImage();
		Image cyanImagen = imagenCyan.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cyanBola = new ImageIcon(cyanImagen);
		return cyanBola;
	}
	public ImageIcon proximaGreen() {
		ImageIcon imageIconCyan = new ImageIcon("src/images/green.png");
		Image imagenCyan = imageIconCyan.getImage();
		Image cyanImagen = imagenCyan.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cyanBola = new ImageIcon(cyanImagen);
		return cyanBola;
	}
	public ImageIcon proximaOrange() {
		ImageIcon imageIconCyan = new ImageIcon("src/images/Orange.png");
		Image imagenCyan = imageIconCyan.getImage();
		Image cyanImagen = imagenCyan.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cyanBola = new ImageIcon(cyanImagen);
		return cyanBola;
	}
	public ImageIcon proximaPink() {
		ImageIcon imageIconCyan = new ImageIcon("src/images/pink.png");
		Image imagenCyan = imageIconCyan.getImage();
		Image cyanImagen = imagenCyan.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cyanBola = new ImageIcon(cyanImagen);
		return cyanBola;
	}
	public ImageIcon proximaRed() {
		ImageIcon imageIconCyan = new ImageIcon("src/images/red.png");
		Image imagenCyan = imageIconCyan.getImage();
		Image cyanImagen = imagenCyan.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cyanBola = new ImageIcon(cyanImagen);
		return cyanBola;
	}
	public ImageIcon proximaYellow() {
		ImageIcon imageIconCyan = new ImageIcon("src/images/yellow.png");
		Image imagenCyan = imageIconCyan.getImage();
		Image cyanImagen = imagenCyan.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon cyanBola = new ImageIcon(cyanImagen);
		return cyanBola;
	}

	public ImageIcon getFondo1() {
		return fondo1;
	}

	public void setFondo1(ImageIcon fondo1) {
		this.fondo1 = fondo1;
	}

	public void setBlueBola(ImageIcon blueBola) {
		this.blueBola = blueBola;
	}

	public ImageIcon getYellowBola() {
		return yellowBola;
	}

	public void setYellowBola(ImageIcon yellowBola) {
		this.yellowBola = yellowBola;
	}

	public ImageIcon getGreenBola() {
		return greenBola;
	}

	public void setGreenBola(ImageIcon greenBola) {
		this.greenBola = greenBola;
	}

	public ImageIcon getPinkBola() {
		return pinkBola;
	}

	public void setPinkBola(ImageIcon pinkBola) {
		this.pinkBola = pinkBola;
	}

	public ImageIcon getOrangeBola() {
		return orangeBola;
	}

	public void setOrangeBola(ImageIcon orangeBola) {
		this.orangeBola = orangeBola;
	}

	public ImageIcon getRedBola() {
		return redBola;
	}

	public void setRedBola(ImageIcon redBola) {
		this.redBola = redBola;
	}

	public ImageIcon getCyanBola() {
		return cyanBola;
	}

	public void setCyanBola(ImageIcon cyanBola) {
		this.cyanBola = cyanBola;
	}
}

