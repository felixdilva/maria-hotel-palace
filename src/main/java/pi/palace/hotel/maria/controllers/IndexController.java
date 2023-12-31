package pi.palace.hotel.maria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "redirect:/hotel/login";
    }
    @GetMapping("/hotel")
    public String home() {
        return "home";
    }
    

}
