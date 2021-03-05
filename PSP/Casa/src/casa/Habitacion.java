package casa;

public class Habitacion {

	private double m2;
	private TipoHabitacion TipoHabitacion;
	
	public double getM2() {
		return m2;
	}
	public void setM2(double m2) {
		this.m2 = m2;
	}
	public TipoHabitacion getTipoHabitacion() {
		return TipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacion tipoH) {
		TipoHabitacion = tipoH;
	}
	@Override
	public String toString() {
		return "Habitacion [m2=" + m2 + ", TipoHabitacion=" + TipoHabitacion + "]";
	}
	
	
}
