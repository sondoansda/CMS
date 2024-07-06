package fa.training.controller;




import fa.training.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/login")
@SessionAttributes("userLogin")
@RequiredArgsConstructor
public class LoginController {
     private final UserRepository userRepository;

     @GetMapping
     public String loginPage() {
         return "Login";
     }

     @PostMapping
     public String login(@RequestParam String email, @RequestParam String password, Model model){

         var userLogin= userRepository.findByEmailAndPassword(email, password);

      if(userLogin != null){
          model.addAttribute("userLogin", userLogin);
          return "redirect:/profile";
      }
         return "Login";
     }
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/login";
    }


}

