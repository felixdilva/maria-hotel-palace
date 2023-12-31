package pi.palace.hotel.maria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.palace.hotel.maria.enums.Papel;
import pi.palace.hotel.maria.models.User;
import pi.palace.hotel.maria.repositories.UserRepository;

@Service
public class LoginService {

    @Autowired
    UserRepository ur;

    public void verificarAdm(){
        List<User> adm = ur.findByPapel(Papel.ADMIN);

        if(adm.isEmpty()){
            criarAdm();
        }
    }

    private void criarAdm() {
        ur.save(new User("ADM","adm@gmail.com","admin",Papel.ADMIN));
    }

    public void criarCliente(User cliente){
        System.out.println(cliente.getNome());
        cliente.setPapel(Papel.CLIENTE);
        ur.save(cliente);
    }

    public void criarFuncionario(User funcionario){
        System.out.println(funcionario.getNome());
        funcionario.setPapel(Papel.FUNCIONARIO);
        ur.save(funcionario);
    }

}
