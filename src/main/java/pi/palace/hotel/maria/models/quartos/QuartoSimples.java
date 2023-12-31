package pi.palace.hotel.maria.models.quartos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import pi.palace.hotel.maria.models.Quarto;
import pi.palace.hotel.maria.models.User;

@Entity
public class QuartoSimples extends Quarto {
    @OneToMany
    private List<User> hospedes;


    public QuartoSimples() {
    }

    public QuartoSimples(Double preco) {
        super(preco);
    }

    public List<User> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<User> hospedes) {
        this.hospedes = hospedes;
    }
    

    
}
