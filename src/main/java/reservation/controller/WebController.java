package reservation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        return "index"; // Renders index.html template
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin"; // Renders admin.html template
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        return "settings"; // Renders settings.html template
    }
}


