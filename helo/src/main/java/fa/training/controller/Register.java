package fa.training.controller;

import fa.training.entity.User;
import fa.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class Register {
    private final UserRepository userRepository;

    @Autowired
    public Register(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public String register(Model model) {
        model.addAttribute("userRegister", new User());
        return "Register";
    }
    @PostMapping
    public String registerSubmit(@ModelAttribute("userRegister") User user) {
        userRepository.save(user);
        return "Login";
    }

}
