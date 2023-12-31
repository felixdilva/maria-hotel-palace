package pi.palace.hotel.maria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pi.palace.hotel.maria.enums.Status;
import pi.palace.hotel.maria.models.Quarto;
import pi.palace.hotel.maria.models.User;
import pi.palace.hotel.maria.models.quartos.QuartoLuxo;
import pi.palace.hotel.maria.models.quartos.QuartoMaster;
import pi.palace.hotel.maria.models.quartos.QuartoSimples;
import pi.palace.hotel.maria.repositories.QuartoLuxoRepository;
import pi.palace.hotel.maria.repositories.QuartoMasterRepository;
import pi.palace.hotel.maria.repositories.QuartoSimplesRepository;
import pi.palace.hotel.maria.repositories.UserRepository;

@Service
public class QuartoService {

    @Autowired
    QuartoSimplesRepository qsr;

    @Autowired
    QuartoMasterRepository qmr;

    @Autowired
    QuartoLuxoRepository qlr;

    @Autowired
    UserRepository ur;

    public void criarQuartoSimples(Double preco) {
        QuartoSimples quarto = new QuartoSimples(preco);
        System.out.println(preco);
        quarto.setStatus(Status.VAGO);
        qsr.save(quarto);
    }

    public void criarQuartoMaster(Double preco) {
        QuartoMaster quarto = new QuartoMaster(preco);
        quarto.setStatus(Status.VAGO);
        qmr.save(quarto);
    }

    public void criarQuartoLuxo(Double preco) {
        QuartoLuxo quarto = new QuartoLuxo(preco);
        quarto.setStatus(Status.VAGO);
        qlr.save(quarto);
    }

    public List<QuartoSimples> buscarQuartosSimples() {
        return qsr.findAll();
    }

    public List<QuartoMaster> buscarQuartosMaster() {
        return qmr.findAll();
    }

    public List<QuartoLuxo> buscarQuartosLuxo() {
        return qlr.findAll();
    }

    public List<QuartoSimples> buscarQuartosSimplesPorStatus(Status status) {
        return qsr.findByStatus(status);
    }

    public List<QuartoMaster> buscarQuartosMasterPorStatus(Status status) {
        return qmr.findByStatus(status);
    }

    public List<QuartoLuxo> buscarQuartosLuxoPorStatus(Status status) {
        return qlr.findByStatus(status);
    }

    public void deletarQuartoMaster(Long id) {
        Optional<QuartoMaster> opt = qmr.findById(id);
        if (opt.isPresent()) {
            if (opt.get().getHospede() == null) {
                qmr.deleteById(id);

            } else {
                liberarQuartoMaster(id);
                qmr.delete(opt.get());
            }
        } else {
            System.out.println("Quarto não existe, não pode ser apagado.");
        }

    }

    public void deletarQuartoSimples(Long id) {
        Optional<QuartoSimples> opt = qsr.findById(id);
        if (opt.isPresent()) {
            if (opt.get().getHospedes() == null) {
                qsr.deleteById(id);

            } else {
                liberarQuartoSimples(id);
                qsr.delete(opt.get());
            }
        } else {
            System.out.println("Quarto não existe, não pode ser apagado.");
        }

    }

    public void deletarQuartoLuxo(Long id) {
        Optional<QuartoLuxo> opt = qlr.findById(id);
        if (opt.isPresent()) {
            if (opt.get().getHospede() == null) {
                qlr.deleteById(id);

            } else {
                liberarQuartoLuxo(id);
                qlr.delete(opt.get());
            }
        } else {
            System.out.println("Quarto não existe, não pode ser liberado.");
        }

    }

    public void liberarQuartoMaster(Long id) {
        Optional<QuartoMaster> opt = qmr.findById(id);
        if (opt.isPresent()) {
            opt.get().setHospede(null);
            opt.get().setStatus(Status.VAGO);
            qmr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser liberado.");
        }

    }

    public void liberarQuartoSimples(Long id) {
        Optional<QuartoSimples> opt = qsr.findById(id);
        if (opt.isPresent()) {
            opt.get().setHospedes(null);
            opt.get().setStatus(Status.VAGO);

            qsr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser apagado.");
        }

    }

    public void liberarQuartoLuxo(Long id) {
        Optional<QuartoLuxo> opt = qlr.findById(id);
        if (opt.isPresent()) {
            opt.get().setHospede(null);
            opt.get().setStatus(Status.VAGO);
            qlr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser liberado.");
        }

    }

    public void solicitarQuartoMaster(Long id) {
        Optional<QuartoMaster> opt = qmr.findById(id);
        if (opt.isPresent()) {
            User adm = ur.findById((long) 1).get();
            opt.get().setHospede(adm);
            opt.get().setStatus(Status.SOLICITADO);
            qmr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser reservado.");
        }

    }

    public void solicitarQuartoSimples(Long id) {
        Optional<QuartoSimples> opt = qsr.findById(id);
        if (opt.isPresent()) {
            User adm = ur.findById((long) 1).get();
            opt.get().getHospedes().add(adm);
            opt.get().setStatus(Status.SOLICITADO);
            qsr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser reservado.");
        }

    }

    public void solicitarQuartoLuxo(Long id) {
        Optional<QuartoLuxo> opt = qlr.findById(id);
        if (opt.isPresent()) {
            User adm = ur.findById((long) 1).get();
            opt.get().setHospede(adm);
            opt.get().setStatus(Status.SOLICITADO);
            qlr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser reservado.");
        }

    }

    public void reservarQuartoMaster(Long id) {
        Optional<QuartoMaster> opt = qmr.findById(id);
        if (opt.isPresent()) {
            User adm = ur.findById((long) 1).get();
            opt.get().setHospede(adm);
            opt.get().setStatus(Status.OCUPADO);
            qmr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser reservado.");
        }

    }

    public void reservarQuartoSimples(Long id) {
        Optional<QuartoSimples> opt = qsr.findById(id);
        if (opt.isPresent()) {
            User adm = ur.findById((long) 1).get();
            opt.get().getHospedes().add(adm);
            opt.get().setStatus(Status.OCUPADO);
            qsr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser reservado.");
        }

    }

    public void reservarQuartoLuxo(Long id) {
        Optional<QuartoLuxo> opt = qlr.findById(id);
        if (opt.isPresent()) {
            User adm = ur.findById((long) 1).get();
            opt.get().setHospede(adm);
            opt.get().setStatus(Status.OCUPADO);
            qlr.save(opt.get());
        } else {
            System.out.println("Quarto não existe, não pode ser reservado.");
        }

    }

}
