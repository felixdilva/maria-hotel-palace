package pi.palace.hotel.maria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pi.palace.hotel.maria.enums.Status;
import pi.palace.hotel.maria.services.QuartoService;


@Controller
@RequestMapping("/hotel/quartos")
public class QuartoController {

    @Autowired
    QuartoService qr;

    @GetMapping()
    public ModelAndView quartos() {
        ModelAndView mv = new ModelAndView("quartos");
        mv.addObject("quartosSimples", qr.buscarQuartosSimples());
        mv.addObject("quartosMaster", qr.buscarQuartosMaster());
        mv.addObject("quartosLuxo", qr.buscarQuartosLuxo());
        return mv;
    }

    @GetMapping("/form")
    public String formQuarto() {
        return "formQuarto";
    }

    @PostMapping("/salvar")
    public String salvarQuarto(Double preco, String tipoQuarto) {
        System.out.println(preco);
        System.out.println(tipoQuarto);
        switch (tipoQuarto) {
            case "simples":
                qr.criarQuartoSimples(preco);
                break;
            case "master":
                qr.criarQuartoMaster(preco);
                break;
            case "luxo":
                qr.criarQuartoLuxo(preco);
                break;
        }
        return "redirect:/hotel/quartos/form";
    }

    @GetMapping("/quartoMaster/{id}/deletar")
    public String deletarQuartoMaster(@PathVariable Long id) {

        qr.deletarQuartoMaster(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoLuxo/{id}/deletar")
    public String deletarQuartoLuxo(@PathVariable Long id) {

        qr.deletarQuartoLuxo(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoSimples/{id}/deletar")
    public String deletarQuartoSimples(@PathVariable Long id) {

        qr.deletarQuartoSimples(id);
        return "redirect:/hotel/quartos";
    }

    @GetMapping("/quartoMaster/{id}/liberar")
    public String liberarQuartoMaster(@PathVariable Long id) {

        qr.liberarQuartoMaster(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoLuxo/{id}/liberar")
    public String liberarQuartoLuxo(@PathVariable Long id) {

        qr.liberarQuartoLuxo(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoSimples/{id}/liberar")
    public String liberarQuartoSimples(@PathVariable Long id) {

        qr.liberarQuartoSimples(id);
        return "redirect:/hotel/quartos";
    }

    @GetMapping("/reservas")
    public ModelAndView areaReservas() {
        
        ModelAndView mv = new ModelAndView("reserva");
        mv.addObject("quartosSimples", qr.buscarQuartosSimplesPorStatus(Status.VAGO));
        mv.addObject("quartosMaster", qr.buscarQuartosMasterPorStatus(Status.VAGO));
        mv.addObject("quartosLuxo", qr.buscarQuartosLuxoPorStatus(Status.VAGO));
        return mv;
        
    }
    

    @GetMapping("/quartoMaster/{id}/solicitar")
    public String solicitarQuartoMaster(@PathVariable Long id) {

        qr.solicitarQuartoMaster(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoLuxo/{id}/solicitar")
    public String solicitarQuartoLuxo(@PathVariable Long id) {

        qr.solicitarQuartoLuxo(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoSimples/{id}/solicitar")
    public String solicitarQuartoSimples(@PathVariable Long id) {

        qr.solicitarQuartoSimples(id);
        return "redirect:/hotel/quartos";
    }
    @GetMapping("/quartoMaster/{id}/reservar")
    public String reservarQuartoMaster(@PathVariable Long id) {

        qr.reservarQuartoMaster(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoLuxo/{id}/reservar")
    public String reservarQuartoLuxo(@PathVariable Long id) {

        qr.reservarQuartoLuxo(id);
        return "redirect:/hotel/quartos";

    }

    @GetMapping("/quartoSimples/{id}/reservar")
    public String reservarQuartoSimples(@PathVariable Long id) {

        qr.reservarQuartoSimples(id);
        return "redirect:/hotel/quartos";
    }

}
