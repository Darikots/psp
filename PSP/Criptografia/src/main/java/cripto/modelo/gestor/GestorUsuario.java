package cripto.modelo.gestor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cripto.modelo.entidad.Usuario;
import cripto.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {

	    @Autowired
	    private DaoUsuario daoUsuario;

	    public boolean validarUsuario(Usuario usuario) {
	        Usuario aux = daoUsuario.findByUserAndPass(usuario.getUser(), usuario.getPass());

	        if (aux != null) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public void addUsuario(Usuario user) {
	        daoUsuario.save(user);
	    }


		

	

}
