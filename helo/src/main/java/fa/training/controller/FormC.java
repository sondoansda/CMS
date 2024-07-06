    package fa.training.controller;
    import java.time.LocalDate;


    import fa.training.entity.Content;
    import fa.training.entity.User;
    import fa.training.repository.ContentRepository;
    import fa.training.repository.UserRepository;
    import lombok.RequiredArgsConstructor;
    import org.hibernate.Hibernate;
    import org.springframework.stereotype.Controller;
    import org.springframework.transaction.annotation.Transactional;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    @Controller
    @RequestMapping("/formC")
    @RequiredArgsConstructor
    @SessionAttributes({"userLogin","contentPost"})

    public class FormC {
        private final UserRepository userRepository;
        private final ContentRepository contentRepository;

        @ModelAttribute("userLogin")
        public User getUser() {
            return new User();
        }

        @ModelAttribute("contentPost")
        public Content getContent() {
            return new Content();
        }

        @GetMapping
        public String formC(@ModelAttribute("contentPost")Content contentPost, Model model){

            model.addAttribute("contentPost", new Content());
            return "FormContent";
        }

        @PostMapping
        @Transactional
        public String formC(@ModelAttribute("contentPost") Content content,@ModelAttribute("userLogin")User userLogin){
            Hibernate.initialize(userLogin.getContents());

            Content existingContent = contentRepository.findByTitle(content.getTitle());
            if (existingContent == null) {
                userLogin.getContents().add(content);
                content.setCreateDate(LocalDate.now());
                content.setAuthorId(userLogin);
                contentRepository.save(content);
            }
            else{
                content.setUpdateTime(LocalDate.now());
                contentRepository.save(content);
            }

            return "redirect:/viewC";
        }

        @GetMapping("/{id}")
        public String editContent(@ModelAttribute("contentPost")Content contentPost, @PathVariable("id")Long id, Model model){
            var contentShow= contentRepository.findById(contentPost.getId());
            model.addAttribute("contentPost",contentShow);
            return "FormContent";
        }



    }
