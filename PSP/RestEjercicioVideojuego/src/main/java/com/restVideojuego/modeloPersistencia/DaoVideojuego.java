package com.restVideojuego.modeloPersistencia;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restVideojuego.entidad.Videojuego;

@Component
public class DaoVideojuego {
	
	private List<Videojuego> listaVideojuego;
	private int cont = 0;
	
	public DaoVideojuego() {
		Videojuego v1 = new Videojuego();
		v1.setId(cont++);
		v1.setNombre("Skyrim");
		v1.setCompania("Bethesda");
		v1.setPrecio(45.95);
		v1.setPuntuacion(8.9);
		Videojuego v2 = new Videojuego();
		v2.setId(cont++);
		v2.setNombre("FF VII");
		v2.setCompania("Square Enix");
		v2.setPrecio(35.95);
		v2.setPuntuacion(7.8);
		Videojuego v3 = new Videojuego();
		v3.setId(cont++);
		v3.setNombre("Persona5 Royal");
		v3.setCompa-nia("Atlus");
		v3.setPrecio(69.95);
		v3.setPuntuacion(9.3);
		
		
		listaVideojuego = new ArrayList<Videojuego>();
		listaVideojuego.add(v1);
		listaVideojuego.add(v2);
		listaVideojuego.add(v3);
	} 
	
	public List<Videojuego> listado() {
        return listaVideojuego;
    }

    public Videojuego buscar(int id) {
        Videojuego v = null;
        for (Videojuego videojuego : listaVideojuego) {
            if (videojuego.getId() == id) {
                v = videojuego;
                break;
            }
        }
        return v;
    }

    public Videojuego alta(Videojuego v) {
        v.setId(cont++);
        listaVideojuego.add(v);
        return v;
    }

    public Videojuego modificar(Videojuego vModif) {
        Videojuego v = buscar(vModif.getId());
        if (v != null) {
            v.setNombre(vModif.getNombre());
            v.setCompania(vModif.getCompania());
            v.setPrecio(vModif.getPrecio());
            v.setPuntuacion(vModif.getPuntuacion());
        }
        return v;
    }

    public Videojuego borrar(int id) {
        Videojuego v = buscar(id);
        if (v != null) {
            listaVideojuego.remove(id);
        }
        return v;
    }
	

}
