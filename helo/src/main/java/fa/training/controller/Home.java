package fa.training.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@RequiredArgsConstructor
public class Home {
    @GetMapping
    public String goHome() {
       return "redirect:/login";
    }
}
