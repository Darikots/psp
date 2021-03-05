package casa;

public class Persona {
	
	private String nombre;
	private int edad;
	private String dni;
	private boolean prop;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isProp() {
		return prop;
	}
	public void setProp(boolean prop) {
		this.prop = prop;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + ", prop=" + prop + "]";
	}
	
	
}
