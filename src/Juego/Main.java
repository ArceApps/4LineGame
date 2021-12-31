package Juego;

public class Main {
	public static void main(String[] args) {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		Controlador controla = new Controlador(vista, modelo);
		//modelo.PonerAleatorias();
		//vista.mostrarBolas();
		vista.mostrarVentana();
		vista.Controladores(controla);
	}
}
