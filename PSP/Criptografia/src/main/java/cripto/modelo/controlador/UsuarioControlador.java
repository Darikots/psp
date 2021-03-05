package cripto.modelo.controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cripto.modelo.entidad.Usuario;
import cripto.modelo.gestor.GestorUsuario;

@Controller
public class UsuarioControlador {
	@Autowired
    private GestorUsuario gestorUsuario;

    @GetMapping("sign_user")
    private String registrarUsuario() {
        return "signin";
    }

    @GetMapping("login")
    private String login() {
        return "login";
    }
    
    @GetMapping("exit")
    private String cerrarSesion() {
        return "../static/home";
    }

    @GetMapping("back_login")
    private String volverLogin() {
        return "login";
    }
    @GetMapping("back_sign_in")
    private String volverSignIn() {
        return "signin";
    }

    @PostMapping("signin")
    private String registrar(@RequestParam("user_name") String userName, @RequestParam("pass") String pass,
            Model model) throws NoSuchAlgorithmException {

        String passHash = hashPassword(pass);
        
        Usuario user = new Usuario();
        user.setUser(userName);
        user.setPass(passHash);
        boolean validado = gestorUsuario.validarUsuario(user);

        if (!validado) {
        	gestorUsuario.addUsuario(user);
        	System.out.println(user);
        	return "login";
        } else {
            return "error_sign_in";
        }        
    }

    @PostMapping("login")
    private String loginUsuario(@RequestParam("user_name") String userName, @RequestParam("pass") String pass,
            Model model) throws NoSuchAlgorithmException {

        String passHash = hashPassword(pass);

        Usuario user = new Usuario();
        user.setUser(userName);
        user.setPass(passHash);

        boolean validado = gestorUsuario.validarUsuario(user);

        if (validado) {
            return "main";

        } else {
            return "error_login";
        }
    }

    

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        byte[] pass = password.getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(pass);

        byte[] resumen = md.digest();
        String mensage = new String(resumen);
        return mensage;
    }
}
