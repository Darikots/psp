package entidad;

import utils.Aleatorio;

public class Rezo extends Arma{
	
	@Override
	public int usar() {
		int daño = Aleatorio.calcularNumero(getDañoMinimo(), getDañoMaximo());
		int padreNuestro = Aleatorio.calcularNumero(1, 100);
		if(padreNuestro <= 50) {
			System.out.println("PADRE NUESTRO QUE ESTAS EN LOS CIELOS...!!!!");
			int curacion = daño / 2;
			System.out.println(getPersonaje().getNombre() + " Me curo " + curacion);
			int puntosVidaActuales = this.getPersonaje().getPuntosVida();
			this.getPersonaje().setPuntosVida(puntosVidaActuales + curacion); 
		}
		return daño;
	}

}
