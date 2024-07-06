package fa.training.controller;

import fa.training.entity.User;
import fa.training.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.time.LocalDate;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
@SessionAttributes("userLogin")
public class EditProfile {
    private final UserRepository userRepository;

    @GetMapping
    public String profile(@ModelAttribute("userLogin") User userLogin) {
        return "EditProfile";
    }
    @PostMapping
    public String editProfile(@ModelAttribute("userLogin") User user, Model model) {
        user.setUpdateDate(LocalDate.now());
       userRepository.save(user);
        model.addAttribute("userLogin", user);
       return "redirect:/profile";
    }



}
