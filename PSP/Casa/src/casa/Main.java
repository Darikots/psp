package casa;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Casa c1= new Casa();
		Persona p1 = new Persona();
		double precio1 = 450000.0;
		c1.setPrecio(precio1);
		
		p1.setNombre("Francisco");
		p1.setDni("451851256T");
		p1.setEdad(48);
		c1.setpersona(p1);
		
		Direccion direccion1 = new Direccion();
		direccion1.setCp("28011");
		direccion1.setNombreVia("Juan Anton");
		direccion1.setTipoVia(TipoVia.Calle);
		c1.setDireccion(direccion1);
		
		ArrayList<Habitacion> listaHabitacion = new ArrayList<Habitacion>();
		
		Habitacion baño = new Habitacion();
		baño.setM2(210.0);
		baño.setTipoHabitacion(TipoHabitacion.Baño);
		
		Habitacion dormitorio1 = new Habitacion();
		dormitorio1.setM2(32.2);
		dormitorio1.setTipoHabitacion(TipoHabitacion.Dormitorio);
		Habitacion dormitorio2 = new Habitacion();
		dormitorio2.setM2(45.6);
		dormitorio2.setTipoHabitacion(TipoHabitacion.Dormitorio);
		
		Habitacion comedor = new Habitacion();
		comedor.setM2(100.0);
		comedor.setTipoHabitacion(TipoHabitacion.Comedor);
		
		listaHabitacion.add(comedor);
		listaHabitacion.add(baño);
		listaHabitacion.add(dormitorio1);
		listaHabitacion.add(dormitorio2);
		
		c1.setListaHabitaciones(listaHabitacion);
		
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		
		Persona persona1 = new Persona();		
		persona1.setDni("123456798S");
		persona1.setEdad(25);
		persona1.setNombre("Ernesto");
		
		Persona persona2 = new Persona();		
		persona2.setDni("365256965F");
		persona2.setEdad(35);
		persona2.setNombre("Santiago");
		
		listaPersonas.add(persona1);
		listaPersonas.add(persona2);
		 
		c1.setListaPersonas(listaPersonas);
		
		 System.out.println(c1);
		 
		 c1.calcM2();
		 
		 System.out.println(c1.calcularM2());
		
	}

}
