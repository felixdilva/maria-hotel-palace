package pi.palace.hotel.maria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pi.palace.hotel.maria.enums.Papel;
import pi.palace.hotel.maria.models.User;
import pi.palace.hotel.maria.repositories.UserRepository;
import pi.palace.hotel.maria.services.LoginService;

@Controller
@RequestMapping("/hotel")
public class LoginController {

    @Autowired
    LoginService ls;

    @GetMapping("/login")
    public String formLogin() {
        ls.verificarAdm();
        return "login";
    }

    @GetMapping("/logar")
    public String logar() {
        return "redirect:/hotel";
    }
    

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastroCliente";
    }

    @PostMapping("/cadastrarCliente")
    public String cadastrarCliente(User user) {
        ls.criarCliente(user);
        return "redirect:/hotel/login";
    }

    @GetMapping("/cadastroFuncionario")
    public String cadastroFuncionario() {
        return "cadastroFuncionario";
    }

    @PostMapping("/cadastrarFuncionario")
    public String cadastrarFuncionario(User user) {
        ls.criarFuncionario(user);
        return "redirect:/hotel";
    }

}
