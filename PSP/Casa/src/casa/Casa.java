package casa;


import java.util.ArrayList;

public class Casa {
	private double precio;
	private Persona persona;
	private Direccion direccion;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Persona> listaPersonas;
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Persona getpersona() {
		return persona;
	}
	public void setpersona(Persona persona) {
		this.persona = persona;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}
	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}
	public ArrayList<Persona> getListaPersona() {
		return listaPersonas;
	}
	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	@Override
	public String toString() {
		return "Casa [precio=" + precio + ", persona=" + persona + ", direccion=" + direccion
				+ ", listaHabitaciones=" + listaHabitaciones + ", listaPersona=" + listaPersonas + "]";
	}
	
	public void calcM2() {
			
			double m2 = 0;
			Habitacion habitacion1 = new Habitacion();
			
			for (int i = 0; i < listaHabitaciones.size(); i++) {
				
				habitacion1 = listaHabitaciones.get(i);
				
				m2 = habitacion1.getM2() + m2;
				
			}
			
			System.out.println("La casa tiene " + m2 + " metros cuadrados");
			
		}
	
	public double calcularM2() {
		int m2Totales = 0;
		for(Habitacion h : listaHabitaciones) {
			m2Totales += h.getM2();
			}
		return m2Totales;
	}
	
}
