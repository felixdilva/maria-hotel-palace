package pi.palace.hotel.maria.models.quartos;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import pi.palace.hotel.maria.models.Quarto;
import pi.palace.hotel.maria.models.User;

@Entity
public class QuartoLuxo extends Quarto {

    @OneToOne
    private User hospede;

    public QuartoLuxo(Double preco) {
        super(preco);
    }

    

    public QuartoLuxo() {
    }



    public User getHospede() {
        return hospede;
    }

    public void setHospede(User hospede) {
        this.hospede = hospede;
    }
}
